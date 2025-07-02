
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Maquina> maquinas = LectorTxtMaquinas.getMaquinas("TpEspecialProg3/src/entrada.txt");
        int piezasAProducir = LectorTxtMaquinas.getPiezasAProducir("TpEspecialProg3/src/entrada.txt");

        FabricaBack fabricaBack = new FabricaBack(maquinas);
        Solucion solucionBacktacking = fabricaBack.backtracking(piezasAProducir);

        FabricaGreedy fabricaGreedy = new FabricaGreedy(maquinas);
        Solucion solucionGreedy = fabricaGreedy.greedy(piezasAProducir);

        System.out.println("******************************************************************************");
        System.out.println("PARAMETROS INICIALES:");
        System.out.print("Piezas a producir:");
        System.out.println(piezasAProducir);
        System.out.print("Maquinas disponibles: ");
        System.out.println(maquinas);
        System.out.println("******************************************************************************");
        System.out.println();
        System.out.println("***************************Solucion con Greedy********************************");
        System.out.print("Costo de Solucion con Greedy: ");
        System.out.println(solucionGreedy.getCostoSolucion());
        if (solucionGreedy.getSolucion().isEmpty()) {
            System.out.println("No hay solucion con Greedy");
        } else {
            System.out.print("Secuencia de Solucion con Greedy:");
            System.out.println(solucionGreedy.getSolucion());
        }
        System.out.print("Cantidad de puestas en funcionamiento de procesadores con Greedy: ");
        System.out.println(solucionGreedy.getSolucion().size());
        System.out.println("******************************************************************************");
        System.out.println();
        System.out.println("***********************Solucion con Backtracking******************************");
        System.out.print("Costo de Solucion con backtracking: ");
        System.out.println(solucionBacktacking.getCostoSolucion());
        System.out.print("Secuencia de Solucion con backtracking:");
        System.out.println(solucionBacktacking.getSolucion());
        System.out.print("Cantidad de puestas en funcionamiento de procesadores con Backtracking: ");
        System.out.println(solucionBacktacking.getCantidadProcesadores());
        System.out.println("******************************************************************************");

    }
}
