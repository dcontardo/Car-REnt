package igu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import igu.Interface_Cuota;
import logistica.Cliente;
import logistica.Vehiculo;

public class Interface_Arriendo extends Component {
    public JPanel panel1;
    private JComboBox lst_sel_cliente;
    private JButton btn_call_lcliente;
    private JComboBox lst_sel_veh;
    private JTextField text_dias;
    private JTextField text_precio_dia;
    private JTextField txts_fecha;
    private JTextArea text_aPagar;
    private JTextField text_cuotas;
    private JButton btn_guardar_cuota;
    private JTextArea text_numero_valor_paga;
    private JButton btn_call_pagarCuota;

    public Interface_Arriendo() {
        Cliente cliente1 = new Cliente("19427769-5", "David Contardo", true);
        Cliente cliente2 = new Cliente("17053692-4", "Jonathan Gutiérrez", true);
        Cliente cliente3 = new Cliente("17741187-6", "Roberto Oreste", true);

        lst_sel_cliente.addItem(cliente1.getNombre());
        lst_sel_cliente.addItem(cliente2.getNombre());
        lst_sel_cliente.addItem(cliente3.getNombre());

        Vehiculo vehiculo1 = new Vehiculo("PK4370",'D',"Mitusbishi Lancer");
        Vehiculo vehiculo2 = new Vehiculo("WD4040",'A',"Hyundai Elantra");
        Vehiculo vehiculo3 = new Vehiculo("KFCL92",'D',"Kia Morning");
        Vehiculo vehiculo4 = new Vehiculo("XY5678",'D',"Chevrolet Onix");
        Vehiculo vehiculo5 = new Vehiculo("CD9012",'A',"Kia Rio");
        Vehiculo vehiculo6 = new Vehiculo("EF3456",'D',"Fiat Strada");
        Vehiculo vehiculo7 = new Vehiculo("GH6789",'D',"Hyundai Tucson");
        Vehiculo vehiculo8 = new Vehiculo("KL7890",'D',"Renault Kwid");
        Vehiculo vehiculo9 = new Vehiculo("OP1234",'D',"Volkswagen Gol");
        Vehiculo vehiculo10 = new Vehiculo("ST9012",'D',"Nissan Sentra");


        // Agregar vehículos que no tengan condición 'A' al JComboBox lst_sel_veh
        if (vehiculo1.getCondicion() != 'A') {
            lst_sel_veh.addItem(vehiculo1.getModelo() + " | " + "Patente: " + vehiculo1.getPatente());
        }
        if (vehiculo2.getCondicion() != 'A') {
            lst_sel_veh.addItem(vehiculo2.getModelo() + " | " + "Patente: " + vehiculo2.getPatente());
        }
        if (vehiculo3.getCondicion() != 'A') {
            lst_sel_veh.addItem(vehiculo3.getModelo() + " | " + "Patente: " + vehiculo3.getPatente());
        }
        if (vehiculo4.getCondicion() != 'A') {
            lst_sel_veh.addItem(vehiculo4.getModelo() + " | " + "Patente: " + vehiculo4.getPatente());
        }
        if (vehiculo5.getCondicion() != 'A') {
            lst_sel_veh.addItem(vehiculo5.getModelo() + " | " + "Patente: " + vehiculo5.getPatente());
        }
        if (vehiculo6.getCondicion() != 'A') {
            lst_sel_veh.addItem(vehiculo6.getModelo() + " | " + "Patente: " + vehiculo6.getPatente());
        }
        if (vehiculo7.getCondicion() != 'A') {
            lst_sel_veh.addItem(vehiculo7.getModelo() + " | " + "Patente: " + vehiculo7.getPatente());
        }
        if (vehiculo8.getCondicion() != 'A') {
            lst_sel_veh.addItem(vehiculo8.getModelo() + " | " + "Patente: " + vehiculo8.getPatente());
        }
        if (vehiculo9.getCondicion() != 'A') {
            lst_sel_veh.addItem(vehiculo9.getModelo() + " | " + "Patente: " + vehiculo9.getPatente());
        }
        if (vehiculo10.getCondicion() != 'A') {
            lst_sel_veh.addItem(vehiculo10.getModelo() + " | " + "Patente: " + vehiculo10.getPatente());
        }


        btn_call_lcliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new JFrame("Interface_Cliente");
                frame.setContentPane(new Interface_Cliente().panel2);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null); //Para que abra al centro
            }
        });
        btn_call_pagarCuota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               // mostrarMensajeError("Este es un mensaje de error intencional");
                JFrame cuota = new JFrame("Interface_Cuota");
                cuota.setContentPane(new Interface_Cuota().panel3);
                //cuota.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cuota.pack();
                cuota.setVisible(true);
                cuota.setLocationRelativeTo(null); //Para que abra al centro
            }
        });
    }
    public void mostrarMensajeInfo(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para mostrar mensajes de error
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
