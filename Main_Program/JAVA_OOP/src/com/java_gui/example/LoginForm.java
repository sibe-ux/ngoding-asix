package com.java_gui.example;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm {

    public static boolean checkData(String username, String password) {
        if (username.equals("java") && password.equals("123")){
            return true;
        }
        return false;
    }

    public static void addComponentToPanel(JPanel panel){
        JLabel userLabel = new JLabel("User");
        JTextField userText = new JTextField();
        JLabel passwordLabel =  new JLabel("Password");
        JPasswordField passwordText = new JPasswordField();

        // buttons
        JButton cancelButton = new JButton("Cancel");
        JButton loginButton = new JButton("Login");

        // adding components to panel
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(cancelButton);
        panel.add(loginButton);

        // adding action to buttons
        loginButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkData(userText.getText(), String.valueOf(passwordText.getPassword()))){
                    JOptionPane.showMessageDialog(panel, "Hello " + userText.getText() +
                    " ! Welcome", "Login Message" , JOptionPane.INFORMATION_MESSAGE);
                } else{
                    JOptionPane.showMessageDialog(panel, "Invalid username or passowrd", 
                    "Login Message", JOptionPane.ERROR_MESSAGE);
                }    
            }
            
        });
        cancelButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
    }
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Login Form Demo");

        JPanel panel = new JPanel(new GridLayout(3, 2, 15, 15));
        
        // calling method
        addComponentToPanel(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300,150);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
