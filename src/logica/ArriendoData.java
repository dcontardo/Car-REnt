package logica;

import java.util.ArrayList;

public class ArriendoData {
    private String cliente;
    private String vehiculo;
    private String fecha;
    private int dias;
    private int precioDia;
    private ArrayList<CuotaArriendo> cuotas;

    // Constructor, getters y setters

    public ArriendoData(String cliente, String vehiculo, String fecha, int dias, int precioDia, ArrayList<CuotaArriendo> cuotas) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.dias = dias;
        this.precioDia = precioDia;
        this.cuotas = cuotas;
    }

    public ArriendoData() {

    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(int precioDia) {
        this.precioDia = precioDia;
    }

    public ArrayList<CuotaArriendo> getCuotas() {
        return cuotas;
    }

    public void setCuotas(ArrayList<CuotaArriendo> cuotas) {
        this.cuotas = cuotas;
    }
}
