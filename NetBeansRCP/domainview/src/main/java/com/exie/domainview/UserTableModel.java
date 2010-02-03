package com.exie.domainview;

import com.exie.mjeedom.MyServiceRemote;
import com.exie.mjeedom.ServiceFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import com.exie.mjeedom.User;
import org.openide.util.Lookup;

/**
 *
 * @author mikael
 */
public class UserTableModel extends AbstractTableModel {
    List<User> users;

    public UserTableModel() {
        System.out.println("Looking for ServiceFactory");
        for (ServiceFactory factory : Lookup.getDefault().lookupAll(ServiceFactory.class)) {
            System.out.println("Ping: " + factory.create(MyServiceRemote.class).ping());
        }
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
