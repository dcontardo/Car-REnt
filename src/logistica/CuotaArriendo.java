package logistica;

public class CuotaArriendo {
    private int numero;
    private int monto;
    private boolean pagada;

    public CuotaArriendo(int numero, int monto) {
        this.numero = numero;
        this.monto = monto;
        this.pagada = false; // Inicialmente, la cuota no está pagada.
    }

    public int getNumero() {
        return numero;
    }

    public int getMonto() {
        return monto;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
}
