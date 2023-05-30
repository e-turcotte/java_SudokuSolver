package sudokusolver;

import java.awt.event.*;
import javax.swing.*;

public class SudokuMain{

    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setSize(400,500);
        f.setLayout(null);

        JButton b = new JButton("click me uwu");
        b.setBounds(130,100,100,40);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("neat");
            }
        });
        f.add(b);

        f.setVisible(true);
    }
}