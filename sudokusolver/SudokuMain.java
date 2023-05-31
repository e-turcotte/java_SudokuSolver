package sudokusolver;

import java.awt.event.*;
import javax.swing.*;

public class SudokuMain{

    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setSize(400,500);
        f.setLayout(null);

        JButton b1 = new JButton("click me uwu");
        b1.setBounds(130,100,200,40);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("neat");
            }
        });
        f.add(b1);

        JButton b2 = new JButton("also me");
        b2.setBounds(0, 0, 150, 30);
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("cool");
            }
        });
        f.add(b2);

        JButton b3 = new JButton("helper");
        b3.setBounds(150, 30, 150, 30);
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SudokuCmd.help();
            }
        });
        f.add(b3);

        f.setVisible(true);
    }
}