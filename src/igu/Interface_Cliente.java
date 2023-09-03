package igu;

import javax.swing.*;
import java.awt.*;

public class Interface_Cliente extends Component {
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JButton agregarButton;
    public JPanel panel2;


    public void mostrarMensajeInfo(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para mostrar mensajes de error
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
