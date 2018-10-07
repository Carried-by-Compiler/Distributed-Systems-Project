/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author John Rey Juele
 */
public class GameGUI extends JFrame {
    
    private DatabaseHandler dbHandler;
    
    private JButton[] grid;
    private JLabel nameLabel, surnameLabel;
    
    public GameGUI(String username, String password) {
        dbHandler = new DatabaseHandler("john", "John1234");
        List<String> details = dbHandler.getNames(username, password);
        
        this.addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                dbHandler.close();
            }
        });
        
        initComponents(details);
        
        this.setTitle("TicTacToe");
        this.setSize(600, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    private void initComponents(List<String> names) {
        grid = new JButton[9];
        nameLabel = new JLabel(names.get(0));
        surnameLabel = new JLabel(names.get(1));
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        getContentPane().add(mainPanel);
        
        // West
        GridLayout gl = new GridLayout(3, 3);
        gl.setHgap(5);
        gl.setVgap(5);
        JPanel westPanel = new JPanel(gl);
        mainPanel.add(BorderLayout.WEST, westPanel);
        
        for(int i = 0; i < grid.length; i++) {
            grid[i] = new JButton(String.valueOf(i + 1));
            westPanel.add(grid[i]);
        }
        //
        
        // Center
        JPanel centerPanel = new JPanel();
        mainPanel.add(BorderLayout.CENTER, centerPanel);
        
        centerPanel.add(nameLabel);
        centerPanel.add(surnameLabel);
        //     
    }
    
}
