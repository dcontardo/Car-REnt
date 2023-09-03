package logica;

public class Vehiculo {
    private String patente;
    private char condicion;
    private String modelo;

    public Vehiculo(String patente, char condicion, String modelo) {
        this.patente = patente;
        this.condicion = condicion;
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public char getCondicion() {
        return condicion;
    }

    public void setCondicion(char condicion) {
        this.condicion = condicion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public enum TipoMensaje {
        INFO,
        ERROR
    }

    public void generarMensaje(String mensaje, Arriendo.TipoMensaje tipoMensaje) {
        switch (tipoMensaje) {
            case INFO:
                System.out.println("INFO: " + mensaje);
                break;
            case ERROR:
                System.err.println("ERROR: " + mensaje);
                break;
        }
    }

}
