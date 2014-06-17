/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.views;

import com.lang.MainFormLang;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author forsell
 */
public class MainForm extends JFrame{
    private JMenuBar menuBar;
    private JMenu userMenu;
    public MainForm()
    {
        super(MainFormLang.FORM_TITLE);
        setLayout(new FlowLayout());
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initComponents()
    {
        menuBar=new JMenuBar();
        userMenu=new JMenu("Users");
        userMenu.setMnemonic(KeyEvent.VK_U);
        menuBar.add(userMenu);
        JMenuItem userNewMenuItem = new JMenuItem("New User");
        JMenuItem userListMenuItem = new JMenuItem("List Users");
        userMenu.add(userNewMenuItem);
        userMenu.add(userListMenuItem);
        userNewMenuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               
                new UserForm();
            }
        });
        
        userListMenuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new UserMainForm();
            }
        });

        setJMenuBar(menuBar);

    }
}
