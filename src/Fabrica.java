import java.util.ArrayList;
import java.util.Iterator;

public class Fabrica {

    private ArrayList<Maquina> maquinas;
    private ArrayList<Maquina> solucion;
    private Integer costoSolucion;

    public Fabrica(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
        this.solucion = new ArrayList<>();
        this.costoSolucion = 0;
    }

    public Solucion backtracking(int piezas) {
        this.costoSolucion = 0;
        this.solucion.clear();
        AsignarMaquinasBack(piezas, new ArrayList<Maquina>());
        return new Solucion(solucion, costoSolucion);
    }

    public Solucion greedy(int piezas) {
        this.costoSolucion = 0;
        this.solucion.clear();
        AsignarMaquinasGreedy(new ArrayList<Maquina>(maquinas), piezas);
        return new Solucion(solucion, costoSolucion);
    }

    private void AsignarMaquinasGreedy(ArrayList<Maquina> candidatos, int piezas) {
        int tempPiezas = piezas;
        while (!candidatos.isEmpty() && !solucion(solucion, piezas)) {
            costoSolucion += 1;// consultar si va aca o dentro del otro while
            Maquina maquinaActual = seleccionar(candidatos, tempPiezas);// mayor valor sin pasarme de total
            candidatos.remove(maquinaActual);
            while (factible(maquinaActual, tempPiezas)) {
                solucion.add(maquinaActual);
                tempPiezas -= maquinaActual.getPiezas();
            }

        }
    }

    private boolean factible(Maquina m, int piezas) {
        // f (m != null) {
        if (m.getPiezas() <= piezas) {
            return true;
            // }
        }
        return false;
    }

    private Maquina seleccionar(ArrayList<Maquina> candidatos, int piezas) {
        Iterator<Maquina> candidatoit = candidatos.iterator();
        boolean flag = false;
        while (candidatoit.hasNext() && !flag) {
            Maquina eleccion = candidatoit.next();
            if (eleccion.getPiezas() <= piezas) {
                return eleccion;
            }
        }
        return null;
    }

    private boolean solucion(ArrayList<Maquina> candidato, int piezas) {
        int sumador = 0;
        for (Maquina maquina : candidato) {
            sumador += maquina.getPiezas();
        }
        return sumador == piezas;
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
                if (solucionActual.size() >= solucion.size()) {
                    if (piezasRestantes >= 0) {
                        AsignarMaquinasBack(piezasRestantes, solucionActual);
                    }
                }
                piezasRestantes += maquina.getPiezas();
                solucionActual.removeLast();
            }
        } /// evitar soluciones permutadas verificar size
    }

}
