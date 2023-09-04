package igu;

import logica.ArriendoData;
import logica.Cliente;
import logica.CuotaArriendo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        lst_sel_cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarArriendosCliente();
            }
        });

        btn_view_cuotasArrSel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mostrarCuotasArriendoSeleccionado();
            }
        });
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

    private void mostrarArriendosCliente() {
        String clienteSeleccionado = (String) lst_sel_cliente.getSelectedItem();
        lst_sel_arriendoCliente.setText(""); // Limpia el JTextArea

        for (ArriendoData arriendo : interfaceArriendo.listaArriendos) {
            if (arriendo.getCliente().equals(clienteSeleccionado)) {
                lst_sel_arriendoCliente.append(arriendo.getVehiculo() + "\n");
            }
        }
    }

    private void mostrarCuotasArriendoSeleccionado() {
        String vehiculoSeleccionado = lst_sel_arriendoCliente.getSelectedText();
        if (vehiculoSeleccionado == null) {
            mostrarMensajeError("Por favor, selecciona un arriendo.");
            return;
        }

        lst_sel_cuota_aPagar.setText(""); // Limpia el JTextArea
        lst_sel_cuota_aPagar.append("---------------------------------------------------------------------------\n");
        for (ArriendoData arriendo : interfaceArriendo.listaArriendos) {
            if (arriendo.getVehiculo().equals(vehiculoSeleccionado)) {
                for (CuotaArriendo cuota : arriendo.getCuotas()) {
                    lst_sel_cuota_aPagar.append("              " + cuota.getNumero() + "                        $" + cuota.getMonto() + "                     " + (cuota.isPagada() ? "Sí" : "No") + "\n");
                    lst_sel_cuota_aPagar.append("---------------------------------------------------------------------------\n");
                }
            }
        }
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
