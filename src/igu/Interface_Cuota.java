package igu;

import logica.Cliente;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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

    // Referencia a Interface_Arriendo
    private Interface_Arriendo interfaceArriendo;

    public Interface_Cuota(Interface_Arriendo arriendo) {
        interfaceArriendo = arriendo;
        actualizarComboBoxClientes(); // Actualiza el JComboBox al crear la instancia de Interface_Cuota
    }
    private void actualizarComboBoxClientes() {
        // Obtén la lista de clientes desde Interface_Arriendo
        List<Cliente> clientes = interfaceArriendo.getListaClientes();

        // Limpia el JComboBox antes de agregar nuevos elementos
        lst_sel_cliente.removeAllItems();

        // Agrega los clientes al JComboBox
        for (Cliente cliente : clientes) {
            lst_sel_cliente.addItem(cliente.getNombre());
        }
    }
        public void mostrarMensajeInfo (String mensaje){
            JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        // Método para mostrar mensajes de error
        public void mostrarMensajeError (String mensaje){
            JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }

        private void createUIComponents () {
            // TODO: place custom component creation code here
        }

    }

