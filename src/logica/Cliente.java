package logica;

public class Cliente {
    private String cedula;
    private String nombre;
    private Boolean vigente;

    public Cliente(String cedula, String nombre, Boolean vigente) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.vigente = vigente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    // Método para verificar si el cliente está vigente
    public boolean estaVigente() {
        return vigente;
    }

    // Método para marcar al cliente como vigente
    public void marcarComoVigente() {
        vigente = true;
    }

    // Método para marcar al cliente como no vigente
    public void marcarComoNoVigente() {
        vigente = false;
    }

    //Se crea una enumeración con dos mensajes posibles

    public enum TipoMensaje {
        INFO,
        ERROR
    }

    //Se crea el método generar mensaje

    public void generarMensaje(String mensaje, TipoMensaje tipoMensaje) {
        switch (tipoMensaje) {
            case INFO:
                System.out.println("INFO: " + mensaje);
                break;
            case ERROR:
                System.err.println("ERROR: " + mensaje);
                break;
        }
    }


    //Se crea el Método validar cedula (RUT)

    public boolean validarCedula(String rut) {
        // Limpia el formato del RUT, eliminando puntos y guiones y dejando solo números y letra verificadora
        // rut = rut.replaceAll("[.\\-]", "").toUpperCase();

        // Verifica que el RUT tenga un formato válido (8 o 9 dígitos + guión + dígito verificador)
        if (!rut.matches("^[0-9]{7,8}-[0-9kK]$")) {
            generarMensaje("El RUT debe tener un formato válido", TipoMensaje.ERROR);
            return false;
        }

        // Separa el número y el dígito verificador
        String[] rutPartes = rut.split("-");
        String numero = rutPartes[0];
        String digitoVerificador = rutPartes[1];

        // Calcula el dígito verificador esperado
        int suma = 0;
        int multiplicador = 2;

        for (int i = numero.length() - 1; i >= 0; i--) {
            suma += Integer.parseInt(String.valueOf(numero.charAt(i))) * multiplicador;
            multiplicador = multiplicador == 7 ? 2 : multiplicador + 1;
        }

        int resto = suma % 11;
        char digitoEsperado = resto == 0 ? '0' : resto == 1 ? (digitoVerificador.equals("K") || digitoVerificador.equals("k") ? digitoVerificador.charAt(0) : 'K') : (char) (11 - resto + '0');


        // Compara el dígito verificador calculado con el proporcionado
        if (digitoVerificador.charAt(0) != digitoEsperado) {
            generarMensaje("El RUT no es válido", TipoMensaje.ERROR);
            return false;
        }

        // Si todas las validaciones pasan, el RUT se considera válido
        return true;
    }

    //Se crea el método validar nombre


    public boolean validarNombre(String nombre) {
        // Verifica que el nombre no sea nulo ni esté vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            generarMensaje("El nombre no puede estar vacío", TipoMensaje.ERROR);
            return false;
        }

        // Aquí puedes agregar más reglas de validación del nombre si es necesario

        // Si todas las validaciones pasan, el nombre se considera válido
        return true;
    }

}