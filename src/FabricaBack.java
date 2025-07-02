import java.util.ArrayList;

public class FabricaBack {
    private ArrayList<Maquina> maquinas;
    private ArrayList<Maquina> solucion;
    private Integer costoSolucion;

    public FabricaBack(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
        this.solucion = new ArrayList<>();
        this.costoSolucion = 0;
    }

    public Solucion backtracking(int piezas) {
        this.costoSolucion = 0;
        this.solucion.clear();
        AsignarMaquinasBack(piezas, new ArrayList<Maquina>(), 0);
        return new Solucion(solucion, costoSolucion);
    }

    private void AsignarMaquinasBack(int piezasRestantes, ArrayList<Maquina> solucionActual, int indice) {
        if (piezasRestantes == 0) {
            if ((solucionActual.size() < solucion.size()) || solucion.isEmpty()) {
                solucion.clear();
                solucion.addAll(solucionActual);
            }
        } else {
            for (int i = indice; i < maquinas.size(); i++) {
                costoSolucion += 1;
                Maquina maquina = maquinas.get(i);
                solucionActual.add(maquina);
                piezasRestantes -= maquina.getPiezas();
                if ((solucion.isEmpty() || solucionActual.size() < solucion.size()) && piezasRestantes >= 0) {
                    AsignarMaquinasBack(piezasRestantes, solucionActual, i);
                }
                piezasRestantes += maquina.getPiezas();
                solucionActual.removeLast();
            }
        }
    }
    /*
     * private void AsignarMaquinasBack(int piezasRestantes, ArrayList<Maquina>
     * solucionActual) {
     * if (piezasRestantes == 0) {
     * if ((solucionActual.size() < solucion.size()) || solucion.isEmpty()) {
     * solucion.clear();
     * solucion.addAll(solucionActual);
     * }
     * } else {
     * for (Maquina maquina : maquinas) {
     * costoSolucion += 1;
     * solucionActual.add(maquina);
     * piezasRestantes -= maquina.getPiezas();
     * if (solucion.isEmpty() || solucionActual.size() < solucion.size()) {
     * if (piezasRestantes >= 0) {
     * AsignarMaquinasBack(piezasRestantes, solucionActual);
     * }
     * }
     * piezasRestantes += maquina.getPiezas();
     * solucionActual.removeLast();
     * }
     * }
     * }
     */
}
