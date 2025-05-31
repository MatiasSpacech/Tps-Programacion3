import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            int piezasAProducir = 0;
            ArrayList<Maquina> maquinas = new ArrayList<>();
            List<String> lines = Files.readAllLines(Paths.get("src/entrada.txt"));// Guardo todas los renglones del
                                                                                  // archivo
            piezasAProducir = Integer.parseInt(lines.get(0));// Selecciono el primero (indice 0)

            for (int i = 1; i < lines.size(); i++) {// por cada linea a partir del la segunda (indice 1) creo una
                                                    // maquina
                String[] cadenas = lines.get(i).split(",");
                Maquina m1 = new Maquina(cadenas[0], Integer.parseInt(cadenas[1]));
                maquinas.add(m1);
            }
            Fabrica fabrica = new Fabrica(maquinas);
            Solucion solucionGreedy = fabrica.greedy(piezasAProducir);
            Solucion solucionBacktacking = fabrica.backtracking(piezasAProducir);
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
            System.out.print("Secuencia de Solucion con Greedy:");
            System.out.println(solucionGreedy.getSolucion());
            System.out.print("Cantidad de puestas en funcionamiento de procesadores con Greedy: ");
            System.out.println(solucionGreedy.getCantidadProcesadores());
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
