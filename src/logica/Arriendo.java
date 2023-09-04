package logica;
import java.util.ArrayList;
public class Arriendo {
    private int numArriendo;
    private String fecArr;
    private int diasArriendo;
    private ArrayList<CuotaArriendo> cuotas;

    public Arriendo(int numArriendo, String fecArr, int diasArriendo) {
        this.numArriendo = numArriendo;
        this.fecArr = fecArr;
        this.diasArriendo = diasArriendo;
        this.cuotas = new ArrayList<>();
    }

    public int getNumArriendo() {
        return numArriendo;
    }

    public void setNumArriendo(int numArriendo) {
        this.numArriendo = numArriendo;
    }

    public String getFecArr() {
        return fecArr;
    }

    public void setFecArr(String fecArr) {
        this.fecArr = fecArr;
    }

    public int getDiasArriendo() {
        return diasArriendo;
    }

    public void setDiasArriendo(int diasArriendo) {
        this.diasArriendo = diasArriendo;
    }

    public int obtenerMontoApagar(int precioDia) {
        return precioDia * diasArriendo;
    }


    public boolean evaluarArriendo(Cliente cliente, Vehiculo vehiculo) {
        // Verifica si el cliente está vigente y si el vehículo tiene condición D (disponible).
        if (cliente.estaVigente() && vehiculo.getCondicion() == 'D') {
            return true; // El arriendo es válido.
        }
        return false; // El arriendo no es posible.
    }

    public ArrayList<CuotaArriendo> generarCuotas(int precioDia, int cantidadCuotas) {
        int montoTotal = obtenerMontoApagar(precioDia);
        int montoCuota = montoTotal / cantidadCuotas;
        ArrayList<CuotaArriendo> cuotasGeneradas = new ArrayList<>();

        for (int i = 1; i <= cantidadCuotas; i++) {
            CuotaArriendo cuota = new CuotaArriendo(i, montoCuota);
            cuotasGeneradas.add(cuota);
        }

        return cuotasGeneradas;
    }

    public boolean ingresarArriendoConCuotas(Cliente cliente, Vehiculo vehiculo, int precioDia, int cantidadCuotas) {
        if (evaluarArriendo(cliente, vehiculo)) {
            // Cambia la condición del vehículo a "A" (arrendado).
            vehiculo.setCondicion('A');

            // Genera las cuotas y las asigna al arriendo.
            cuotas = generarCuotas(precioDia, cantidadCuotas);

            return true;
        }

        return false;
    }

    public boolean pagarCuota(int numeroCuota) {
        for (CuotaArriendo cuota : cuotas) {
            if (cuota.getNumero() == numeroCuota) {
                cuota.setPagada(true);
                return true;
            }
        }
        return false;
    }
    public enum TipoMensaje {
        INFO,
        ERROR
    }

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

}
