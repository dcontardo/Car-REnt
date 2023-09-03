package logica;

import igu.Interface_Arriendo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Interface_Arriendo");
        frame.setContentPane(new Interface_Arriendo().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Para que abra al centro



        }
    }
