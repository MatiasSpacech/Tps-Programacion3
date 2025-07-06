import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FabricaGreedy {
    private ArrayList<Maquina> maquinas;
    private ArrayList<Maquina> solucion;
    private Integer costoSolucion;
    private HashMap<Maquina, Integer> maquinasUsadas;

    public FabricaGreedy(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
        this.solucion = new ArrayList<>();
        this.costoSolucion = 0;
        this.maquinasUsadas = new HashMap<>();
    }

    public Solucion greedy(int piezas) {
        this.costoSolucion = 0;
        this.solucion.clear();
        Collections.sort(maquinas, Collections.reverseOrder()); // ordenamos las maquinas de mayor a menor
        AsignarMaquinasGreedy(maquinas, piezas);
        // aca solo "desempaqueto" el hashmap para agregarlo a la lista solucion y
        // seguir usando mi clase solucion
        // como uso esa clase solucion tanto en el greedy como en el back, o lo
        // "desempaqueto" aca o lo "empaqueto" en el back.
        for (Map.Entry<Maquina, Integer> entry : maquinasUsadas.entrySet()) {
            Maquina maquina = entry.getKey();
            Integer cantidad = entry.getValue();
            for (int i = 0; i < cantidad; i++) {
                solucion.add(maquina);
            }
        }
        return new Solucion(solucion, costoSolucion);
    }

    private void AsignarMaquinasGreedy(ArrayList<Maquina> candidatos, int piezas) {
        ArrayList<Maquina> candidato = new ArrayList<>(candidatos);
        int piezasRestantes = piezas;

        while (!candidato.isEmpty() && piezasRestantes > 0) {
            Maquina maquinaActual = seleccionar(candidato, piezasRestantes);
            if (maquinaActual != null) {
                candidato.remove(maquinaActual);
                int piezasDelmismoTipo = piezasRestantes / maquinaActual.getPiezas();
                maquinasUsadas.put(maquinaActual, piezasDelmismoTipo); // agrego a un hashmap la maquina y la cantidad
                                                                       // de veces que se usa
                piezasRestantes -= maquinaActual.getPiezas() * piezasDelmismoTipo;
                /*
                 * for (int i = 0; i < piezasDelmismoTipo; i++) {
                 * solucion.add(maquinaActual);
                 * piezasRestantes -= maquinaActual.getPiezas();
                 * }
                 */
            }
        }
        if (piezasRestantes > 0) { // cuando quedan piezas restantes no llego a solucion
            solucion.clear();
        }
    }

    private Maquina seleccionar(ArrayList<Maquina> candidatos, int piezasRestantes) {
        Iterator<Maquina> candidatoit = candidatos.iterator();
        while (candidatoit.hasNext()) {
            costoSolucion += 1;
            Maquina actual = candidatoit.next();
            if (actual.getPiezas() <= piezasRestantes) {
                return actual;
            } else {
                candidatoit.remove();
            }
        }
        return null;
    }

}
