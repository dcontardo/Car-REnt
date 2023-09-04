package igu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import logica.Cliente;

public class Interface_Cliente extends Component {
    private JTextField text_cedula;
    private JTextField text_nombre;
    private JTextArea text_vigente;
    private JButton btn_ag;
    private JComboBox lst_sel_cliente;
    public JPanel panel2;

    // Lista para almacenar clientes
    public List<Cliente> listaClientes = new ArrayList<>();
    private Interface_Arriendo arriendo; // La referencia a Interface_Arriendo


    public Interface_Cliente(Interface_Arriendo arriendo) {

        this.arriendo = arriendo;

        // Agregar ActionListener al botón
        btn_ag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });


        listaClientes.add(new Cliente("19427769-5", "David Contardo", true));
        listaClientes.add(new Cliente("17053692-4", "Jonathan Gutiérrez", true));
        listaClientes.add(new Cliente("17741187-6", "Roberto Oreste", true));
    }

    private void agregarCliente() {
        String cedula = text_cedula.getText();
        String nombre = text_nombre.getText();

        Cliente cliente = new Cliente(cedula, nombre, true);

        boolean rutValido = cliente.validarCedula(cedula);
        boolean nombreValido = cliente.validarNombre(nombre);

        if (rutValido && nombreValido) {
            listaClientes.add(cliente);
            text_vigente.append(nombre + " ha sido agregado y está vigente.\n");
            mostrarMensajeInfo("El cliente ha sido agregado correctamente.");
            arriendo.actualizarComboBoxDesdeOtraClase();
        } else {
        // Mostrar mensajes de error específicos
        if (!rutValido) {
            mostrarMensajeError("El RUT no es válido. Revise si el campo RUT está bien ingresado.");
        }
        if (!nombreValido) {
            mostrarMensajeError("El nombre no es válido. Revise si el campo NOMBRE está bien ingresado.");
        }
    }


        /*
        // Validar cédula y nombre antes de agregar
        if (cliente.validarCedula(cedula) && cliente.validarNombre(nombre)) {
            listaClientes.add(cliente);
            text_vigente.append(nombre + " ha sido agregado y está vigente.\n");
            mostrarMensajeInfo("Cliente agregado correctamente.");
            arriendo.actualizarComboBoxDesdeOtraClase();
        } else {
            // Si la validación falla, muestra un mensaje de error o advertencia
            mostrarMensajeError("El cliente no se pudo agregar. ¡Revise si el campo RUT y NOMBRE están bien ingresados!");
        }
         */

    }


    public void mostrarMensajeInfo(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para mostrar mensajes de error
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
