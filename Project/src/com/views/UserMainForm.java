/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.views;

import com.lang.UserFormLang;
import com.models.User;
import com.models.UserList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;



/**
 *
 * @author forsell
 */
public class UserMainForm extends JDialog {


    JTable userTable;
    JButton btnAddUser;
    public UserMainForm()
    {
        setTitle(UserFormLang.FORM_TITLE);
         setSize(500,500);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        initComponents();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setLocation(x, y);
        setModal(true);
        setVisible(true);
    }

 
    public void initComponents()
    {
        btnAddUser =new JButton("New User");

        btnAddUser.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new UserForm();
            }
        });

        userTable=new JTable(new UserTableModel());

        userTable.setRowSelectionAllowed(true);
        userTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        

        JScrollPane scrollPane=new JScrollPane(userTable);

        getContentPane().add(btnAddUser);
        getContentPane().add(scrollPane);


       
        
    }

    class UserTableModel extends AbstractTableModel{
        UserList userList;
        String[] columnNames = {"","User Id", "User Name","Email"};
        public UserTableModel()
        {
            userList=User.getAll();
        }
        public int getRowCount() {
           return userList.size();
        }

        public int getColumnCount() {
            return columnNames.length;
        }
        
        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch(columnIndex){
                case 0:
                      return Boolean.class;
                default:
                    return Object.class;
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            //super.setValueAt(aValue, rowIndex, columnIndex);
           //userList.get(rowIndex)
             fireTableCellUpdated(rowIndex, columnIndex);  
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 0;  
        }







        public Object getValueAt(int rowIndex, int columnIndex) {
            User user=userList.get(rowIndex);
            switch(columnIndex)
            {
                
                case 1:
                      return user.getUserId();
                case 2:
                      return user.getUserName();
                case 3:
                    return user.getEmail();
                default:
                    return null;
            }

        }
        


    }


}

