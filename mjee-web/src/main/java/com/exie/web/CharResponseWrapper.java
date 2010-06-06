package com.exie.web;

import java.io.*;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

/**
 *
 * @author mikael
 */
public class CharResponseWrapper extends HttpServletResponseWrapper {
    private CharArrayWriter output;

    public CharResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new CharArrayWriter();
    }

    public PrintWriter getWriter() {
        return new PrintWriter(output);
    }


    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream() {
            public void write(int b) throws IOException {
                output.write(b);
            }
        };
    }


    public String toString() {
        return output.toString();
    }
}
