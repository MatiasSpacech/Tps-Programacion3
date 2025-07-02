import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class FabricaGreedy {
    private ArrayList<Maquina> maquinas;
    private ArrayList<Maquina> solucion;
    private Integer costoSolucion;

    public FabricaGreedy(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
        this.solucion = new ArrayList<>();
        this.costoSolucion = 0;
    }

    public Solucion greedy(int piezas) {
        this.costoSolucion = 0;
        this.solucion.clear();
        Collections.sort(maquinas, Collections.reverseOrder()); // ordenamos las maquinas de mayor a menor
        AsignarMaquinasGreedy(maquinas, piezas);
        return new Solucion(solucion, costoSolucion);
    }

    private void AsignarMaquinasGreedy(ArrayList<Maquina> candidatos, int piezas) {
        ArrayList<Maquina> candidato = new ArrayList<>(candidatos);
        int piezasRestantes = piezas;

        while (!candidato.isEmpty() && piezasRestantes > 0) {
            Maquina maquinaActual = seleccionar(candidato, piezasRestantes);
            if (maquinaActual == null) {
                break;
            }
            candidato.remove(maquinaActual);
            int piezasDelmismoTipo = piezasRestantes / maquinaActual.getPiezas();
            for (int i = 0; i < piezasDelmismoTipo; i++) {
                solucion.add(maquinaActual);
                piezasRestantes -= maquinaActual.getPiezas();
            }
        }
        if (piezasRestantes > 0) {
            solucion.clear();
        }
    }

    private Maquina seleccionar(ArrayList<Maquina> candidatos, int piezas) {
        Iterator<Maquina> candidatoit = candidatos.iterator();
        while (candidatoit.hasNext()) {
            costoSolucion += 1;
            Maquina eleccion = candidatoit.next();
            if (eleccion.getPiezas() <= piezas) {
                return eleccion;
            }
        }
        return null;
    }
}
