package igu;

import javax.swing.*;
import java.awt.*;

public class Interface_Cuota extends Component {
    private JComboBox lst_sel_cliente;
    private JButton btn_view_cuotasArrSel;
    private JButton btn_ejec_pagoCuota;
    private JTextArea lst_sel_cuota_aPagar;
    private JTextArea lst_sel_arriendoCliente;
    public JPanel panel3;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;

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
