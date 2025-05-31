import java.util.ArrayList;

public class Fabrica {

    private ArrayList<Maquina> maquinas;
    private ArrayList<Maquina> solucion;
    private Integer costoSolucion;

    public Fabrica(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
        this.solucion = new ArrayList<>();
        this.costoSolucion = 0;
    }

    public ArrayList<Maquina> AsignarMaquinas(int piezas) {

        AsignarMaquinasBack(piezas, new ArrayList<Maquina>());
        return solucion;
    }

    private void AsignarMaquinasBack(int piezasRestantes, ArrayList<Maquina> solucionActual) {
        costoSolucion += 1;
        if (piezasRestantes == 0) {
            if ((solucionActual.size() < solucion.size()) || solucion.isEmpty()) {
                solucion.clear();
                solucion.addAll(solucionActual);
            }
        } else {
            for (Maquina maquina : maquinas) {
                solucionActual.add(maquina);
                piezasRestantes -= maquina.getPiezas();
                /*
                 * if (solucionActual.size()>= solucion.size()) {
                 * 
                 * }
                 */
                if (piezasRestantes >= 0) {
                    AsignarMaquinasBack(piezasRestantes, solucionActual);
                }
                piezasRestantes += maquina.getPiezas();
                solucionActual.removeLast();
            }
        } /// evitar soluciones permutadas verificar size
    }

    private int calcularPiezas(ArrayList<Maquina> coleccion) {
        int sumador = 0;
        for (Maquina maquina : coleccion) {
            sumador += maquina.getPiezas();
        }
        return sumador;
    }
}
