package com.exie.domainview;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import com.exie.domain.User;
import com.exie.remotehandler.HessianUserHandler;

/**
 *
 * @author mikael
 */
public class UserTableModel extends AbstractTableModel {
    List<User> users;

    public UserTableModel() {
        System.out.println("Pinging service: " + HessianUserHandler.getService().ping());
    }



    public List<User> getUsers() {
        if(users == null)
            users = new ArrayList<User>();

        return users;
    }

    public int getRowCount() {
        return getUsers().size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return "Value";
    }
}
