/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.views;

import com.lang.UserFormLang;
import com.models.User;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author forsell
 */
public class UserForm extends JDialog{
    JLabel lblUserName;
    JLabel lblEmail;
    JLabel lblPassword;
    JLabel lblStatus;
    JTextField txtUserName;
    JTextField txtEmail;
    JTextField txtPassword;
    JCheckBox chkStatus;
    JButton btnSave;
    JButton btnCancel;
    public UserForm()
    {
        setTitle(UserFormLang.FORM_TITLE);
         setSize(230,250);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        initComponents();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setLocation(x, y);
        setModal(true);
        setVisible(true);
    }

    private void initComponents()
    {
        lblUserName=new JLabel(UserFormLang.USER_NAME);
        txtUserName=new JTextField(10);
        lblEmail=new JLabel(UserFormLang.EMAIL);
        txtEmail=new JTextField(10);
        lblPassword=new JLabel(UserFormLang.PASSWORD);
        txtPassword=new JTextField(10);

        lblStatus=new JLabel(UserFormLang.STATUS);
        chkStatus=new JCheckBox();

        btnSave=new JButton("Save");
        btnSave.addActionListener(new SaveButtonListener());

        btnCancel=new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int dialog=JOptionPane.showConfirmDialog(null,"Are you sure to Cancel?","Confirm",JOptionPane.YES_NO_OPTION);
                if(dialog==JOptionPane.YES_OPTION)
                {
                    dispose();
                }
                //if()
            }
        });
        getContentPane().add(lblUserName);
        getContentPane().add(txtUserName);
        getContentPane().add(lblEmail);
        getContentPane().add(txtEmail);
        getContentPane().add(lblPassword);
        getContentPane().add(txtPassword);
        getContentPane().add(lblStatus);
        getContentPane().add(chkStatus);
        getContentPane().add(btnSave);
        getContentPane().add(btnCancel);


    }

    class SaveButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            User user=new User();
            user.setEmail(txtEmail.getText());
            user.setUserName(txtUserName.getText());
            user.setPassword(txtPassword.getText());
            user.setStatus((chkStatus.isSelected())?1:0 );
            
            user.save();
        }

    }

}
