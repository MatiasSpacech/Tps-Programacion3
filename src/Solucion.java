import java.util.ArrayList;

public class Solucion {
    private ArrayList<Maquina> solucion;
    private int costoSolucion;
    private int cantidadProcesadores;

    public Solucion(ArrayList<Maquina> solucion, int costoSolucion) {
        this.solucion = solucion;
        this.costoSolucion = costoSolucion;
        this.cantidadProcesadores = this.solucion.size();
    }

    public int getCantidadProcesadores() {
        return cantidadProcesadores;
    }

    public ArrayList<Maquina> getSolucion() {
        return solucion;
    }

    public void setSolucion(ArrayList<Maquina> solucion) {
        this.solucion = solucion;
    }

    public int getCostoSolucion() {
        return costoSolucion;
    }

    public void setCostoSolucion(int costoSolucion) {
        this.costoSolucion = costoSolucion;
    }

}
