package igu;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import logica.*;

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

    private Interface_Cliente interfaceCliente; // Referencia a Interface_Cliente

    private ArrayList<ArriendoData> listaArriendos = new ArrayList<>();

    private List<Vehiculo> vehiculosDisponibles = new ArrayList<>();

    int x = 0;

    public Interface_Arriendo() {
        interfaceCliente = new Interface_Cliente(this);
        actualizarComboBoxClientes();

        if (x == 0){

            vehiculosDisponibles.add(new Vehiculo("PK4370",'D',"Mitusbishi Lancer"));
            vehiculosDisponibles.add(new Vehiculo("WD4040",'D',"Hyundai Elantra"));
            vehiculosDisponibles.add(new Vehiculo("KFCL92",'D',"Kia Morning"));
            vehiculosDisponibles.add(new Vehiculo("XY5678",'D',"Chevrolet Onix"));
            vehiculosDisponibles.add(new Vehiculo("CD9012",'D',"Kia Rio"));
            vehiculosDisponibles.add(new Vehiculo("EF3456",'D',"Fiat Strada"));
            vehiculosDisponibles.add(new Vehiculo("GH6789",'D',"Hyundai Tucson"));
            vehiculosDisponibles.add(new Vehiculo("KL7890",'D',"Renault Kwid"));
            vehiculosDisponibles.add(new Vehiculo("OP1234",'D',"Volkswagen Gol"));
            vehiculosDisponibles.add(new Vehiculo("ST9012",'D',"Nissan Sentra"));

            cargarVehiculosDisponibles();
            x = x + 1;
        }



        btn_call_lcliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new JFrame("Interface_Cliente");
                frame.setContentPane(interfaceCliente.panel2);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null); //Para que abra al centro


                // Actualizar el JComboBox después de agregar un nuevo cliente
                actualizarComboBoxClientes();


            }
        });
        btn_call_pagarCuota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame cuota = new JFrame("Interface_Cuota");
                Interface_Cuota interfaceCuota = new Interface_Cuota(Interface_Arriendo.this); // Pasa la referencia de Interface_Arriendo
                cuota.setContentPane(interfaceCuota.panel3);
                cuota.pack();
                cuota.setVisible(true);
                cuota.setLocationRelativeTo(null); //Para que abra al centro
            }
        });



        text_precio_dia.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                calcularMontoAPagar();
            }
            public void removeUpdate(DocumentEvent e) {
                calcularMontoAPagar();
            }
            public void insertUpdate(DocumentEvent e) {
                calcularMontoAPagar();
            }

            public void calcularMontoAPagar() {
                try {
                    int precioDia = Integer.parseInt(text_precio_dia.getText());
                    int dias = Integer.parseInt(text_dias.getText());
                    text_aPagar.setText(String.valueOf("$" + precioDia * dias));
                } catch (NumberFormatException e) {
                    // Manejar excepción si no se puede convertir a número
                }
            }
        });

        btn_guardar_cuota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                guardarArriendo();

                // Cambiar la condición del vehículo seleccionado a "A"
                int selectedIndex = lst_sel_veh.getSelectedIndex();
                if (selectedIndex != -1) {
                    Vehiculo vehiculoSeleccionado = vehiculosDisponibles.get(selectedIndex);
                    vehiculoSeleccionado.setCondicion('A');
                    System.out.println(vehiculoSeleccionado.getModelo());
                    System.out.println(vehiculoSeleccionado.getCondicion());

                    // Actualizar el JComboBox para reflejar el cambio
                    cargarVehiculosDisponibles();
                }
            }
        });


    }
    private void cargarVehiculosDisponibles() {
        lst_sel_veh.removeAllItems();
        for (Vehiculo vehiculo : vehiculosDisponibles) {
            if (vehiculo.getCondicion() != 'A') {
                lst_sel_veh.addItem(vehiculo.getModelo() + " | " + "Patente: " + vehiculo.getPatente());
            }
        }
    }
    private void guardarArriendo() {
        ArriendoData arriendo = new ArriendoData();
        arriendo.setCliente((String) lst_sel_cliente.getSelectedItem());
        arriendo.setVehiculo((String) lst_sel_veh.getSelectedItem());
        arriendo.setFecha(txts_fecha.getText());
        arriendo.setDias(Integer.parseInt(text_dias.getText()));
        arriendo.setPrecioDia(Integer.parseInt(text_precio_dia.getText()));

        int cantidadCuotas = Integer.parseInt(text_cuotas.getText());
        // Generar cuotas y asignarlas al arriendo
        Arriendo arriendoLogic = new Arriendo(0, arriendo.getFecha(), arriendo.getDias());
        ArrayList<CuotaArriendo> cuotas = arriendoLogic.generarCuotas(arriendo.getPrecioDia(), cantidadCuotas);
        arriendo.setCuotas(cuotas);

        // Agregar el arriendo a la lista
        listaArriendos.add(arriendo);

        // Actualizar la interfaz gráfica para mostrar las cuotas
        mostrarCuotas(cuotas);
    }

    private void mostrarCuotas(ArrayList<CuotaArriendo> cuotas) {
        // Limpiar el JTextArea antes de agregar las cuotas
        text_numero_valor_paga.setText("");

        // Agregar encabezado

        text_numero_valor_paga.append("---------------------------------------------------------------------------\n");

        // Iterar sobre las cuotas y agregarlas al JTextArea
        for (CuotaArriendo cuota : cuotas) {
            text_numero_valor_paga.append("              " + cuota.getNumero() + "                          " + "$" + cuota.getMonto() + "                     " + (cuota.isPagada() ? "Sí" : "No") + "\n");
            text_numero_valor_paga.append("---------------------------------------------------------------------------\n");
        }
        txts_fecha.setText(""); // Limpia el campo de fecha
        text_dias.setText("");  // Limpia el campo de días
        text_precio_dia.setText(""); // Limpia el campo de precio por día
        text_aPagar.setText(""); // Limpia el campo de total a pagar
        //Falta el cuadro de mensaje que se guardo el arriendo
    }



    private void actualizarComboBoxClientes() {
        List<Cliente> clientes = interfaceCliente.getListaClientes();

        // Limpiar el JComboBox antes de agregar nuevos elementos
        lst_sel_cliente.removeAllItems();

        for (Cliente cliente : clientes) {
            lst_sel_cliente.addItem(cliente.getNombre());

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

    public List<Cliente> getListaClientes() {
        return interfaceCliente.listaClientes;
    }

    public void actualizarComboBoxDesdeOtraClase() {
        actualizarComboBoxClientes();
    }
}