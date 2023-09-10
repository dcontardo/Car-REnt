package igu;

import logica.ArriendoData;
import logica.Cliente;
import logica.CuotaArriendo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JCheckBox checkBox9;
    private JCheckBox checkBox10;
    private JCheckBox checkBox11;
    private JCheckBox checkBox12;
    private JCheckBox selectAllCheckBox;

    private ArrayList<CuotaArriendo> cuotasSeleccionadas = new ArrayList<>();
    private ArrayList<CuotaArriendo> cuotasPendientes = new ArrayList<>();

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


        // BOTON REALIZAR PAGO CUOTA
        btn_ejec_pagoCuota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btn_ejec_pagoCuota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPagoCuotasSeleccionadas(); // Llama al método para realizar el pago de cuotas
            }
        });

    }

    private void realizarPagoCuotasSeleccionadas() {
        String vehiculoSeleccionado = lst_sel_arriendoCliente.getSelectedText();
        if (vehiculoSeleccionado == null) {
            mostrarMensajeError("Por favor, selecciona un arriendo.");
            return;
        }

        cuotasSeleccionadas.clear(); // Limpiar la lista de cuotas seleccionadas
        lst_sel_cuota_aPagar.setText("");

        for (ArriendoData arriendo : interfaceArriendo.listaArriendos) {
            if (arriendo.getVehiculo().equals(vehiculoSeleccionado)) {
                for (CuotaArriendo cuota : arriendo.getCuotas()) {
                    // Verificar si el checkbox correspondiente está marcado
                    boolean checkboxSeleccionado = false;

                    switch (cuota.getNumero()) {
                        case 1:
                            checkboxSeleccionado = checkBox1.isSelected();
                            break;
                        case 2:
                            checkboxSeleccionado = checkBox2.isSelected();
                            break;
                        case 3:
                            checkboxSeleccionado = checkBox3.isSelected();
                            break;
                        case 4:
                            checkboxSeleccionado = checkBox4.isSelected();
                            break;
                        case 5:
                            checkboxSeleccionado = checkBox5.isSelected();
                            break;
                        case 6:
                            checkboxSeleccionado = checkBox6.isSelected();
                            break;
                        case 7:
                            checkboxSeleccionado = checkBox7.isSelected();
                            break;
                        case 8:
                            checkboxSeleccionado = checkBox8.isSelected();
                            break;
                        case 9:
                            checkboxSeleccionado = checkBox9.isSelected();
                            break;
                        case 10:
                            checkboxSeleccionado = checkBox10.isSelected();
                            break;
                        case 11:
                            checkboxSeleccionado = checkBox11.isSelected();
                            break;
                        case 12:
                            checkboxSeleccionado = checkBox12.isSelected();
                            break;
                        default:
                            // Agregar más casos según sea necesario
                            break;
                    }

                    if (checkboxSeleccionado) {
                        cuotasSeleccionadas.add(cuota);
                        System.out.println("Cuota " + cuota.getNumero() + " agregada a cuotasSeleccionadas.");
                    }
                }
            }
        }

        if (cuotasSeleccionadas.isEmpty()) {
            mostrarMensajeError("No se han seleccionado cuotas para pagar.");
            return;
        }

        // Realizar el pago de las cuotas seleccionadas
        for (CuotaArriendo cuota : cuotasSeleccionadas) {
            if (!cuota.isPagada()) {
                boolean pagoExitoso = cuota.pagarCuota(); // Llamar al método pagarCuota de la clase CuotaArriendo
                if (pagoExitoso) {
                    mostrarMensajeInfo("Cuota " + cuota.getNumero() + " pagada con éxito.");
                    System.out.println("Cuota " + cuota.getNumero() + " pagada.");
                } else {
                    mostrarMensajeError("Error al pagar la cuota " + cuota.getNumero() + ".");
                    System.out.println("Error al pagar la cuota " + cuota.getNumero() + ".");
                }
            }
        }
        mostrarCuotasArriendoSeleccionado();
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
