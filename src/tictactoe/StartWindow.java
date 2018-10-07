/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 * GUI class that lets the user login or register into the game. 
 * 
 * @author John Rey Juele
 */
public class StartWindow extends JFrame implements ActionListener {
    
    private JTextField login_username, login_password;
    private JTextField name, username, surname,
            password, email;
    private JButton login_submit, register_submit;
    
    private JLabel outputStatus;
    
    private DatabaseHandler dbHandler;
    
    public StartWindow() {
        dbHandler = new DatabaseHandler("john", "John1234");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dbHandler.close();
            }
        });
        
        init_components();
        
        this.setTitle("Start");
        this.setSize(300, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void init_components() {
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel loginPanel = new JPanel(new GridBagLayout());
        JPanel registerPanel = new JPanel(new GridBagLayout());
        
        // login
        outputStatus = new JLabel();
        login_username = new JTextField(15);
        login_password = new JTextField(15);
        login_submit = new JButton("Login");
        login_submit.addActionListener(this);
        
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 10, 10, 10);
        
        gc.gridx = 0;
        gc.gridy = 0;
        loginPanel.add(new JLabel("username:"), gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        loginPanel.add(login_username, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        loginPanel.add(new JLabel("password:"), gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        loginPanel.add(login_password, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        loginPanel.add(login_submit, gc);
        
        gc.gridx = 1;
        gc.gridy = 3;
        loginPanel.add(outputStatus, gc);
        //
        
        // register
        name = new JTextField(15);
        username = new JTextField(15);
        surname = new JTextField(15);
        password = new JTextField(15);
        email = new JTextField(15);
        register_submit = new JButton("Submit");
        register_submit.addActionListener(this);
        
        gc.gridx = 0;
        gc.gridy = 0;
        registerPanel.add(new JLabel("username:"), gc);
        gc.gridx = 1;
        gc.gridy = 0;
        registerPanel.add(username, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        registerPanel.add(new JLabel("forename:"), gc);
        gc.gridx = 1;
        gc.gridy = 1;
        registerPanel.add(name, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        registerPanel.add(new JLabel("surname:"), gc);
        gc.gridx = 1;
        gc.gridy = 2;
        registerPanel.add(surname, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        registerPanel.add(new JLabel("email:"), gc);
        gc.gridx = 1;
        gc.gridy = 3;
        registerPanel.add(email, gc);
        gc.gridx = 0;
        gc.gridy = 4;
        registerPanel.add(new JLabel("password:"), gc);
        gc.gridx = 1;
        gc.gridy = 4;
        registerPanel.add(password, gc);
        gc.gridx = 1;
        gc.gridy = 5;
        registerPanel.add(register_submit, gc);
        //
        
        tabbedPane.addTab("Log-in", loginPanel);
        tabbedPane.addTab("Sign up", registerPanel);
        
        getContentPane().add(tabbedPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == login_submit) {
            String uName = login_username.getText();
            String pass = login_password.getText();
            
            if(dbHandler.checkLogin(uName, pass)) {
                dbHandler.close();
                new GameGUI(uName, pass);
                
                System.out.println("Closing StartWindow");
                this.dispose();
            } else {
                outputStatus.setText("User not found");
                outputStatus.setForeground(Color.RED);
                outputStatus.setVisible(true);
            }
            
        } else if(source == register_submit) {
            
        }
    }
    
    
}
