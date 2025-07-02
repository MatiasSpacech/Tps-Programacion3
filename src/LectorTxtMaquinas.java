import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectorTxtMaquinas {
    //static int piezasAProducir;

    public static ArrayList<Maquina> getMaquinas(String ruta) throws Exception {
        // int piezasAProducir = 0;
        ArrayList<Maquina> maquinas = new ArrayList<>();
        try {

            List<String> lines = Files.readAllLines(Paths.get(ruta));
            //piezasAProducir = Integer.parseInt(lines.get(0));

            for (int i = 1; i < lines.size(); i++) {
                String[] cadenas = lines.get(i).split(",");
                Maquina m1 = new Maquina(cadenas[0], Integer.parseInt(cadenas[1]));
                maquinas.add(m1);
            }

        } catch (Exception e) {
            throw new Exception("Error al cargar las maquinas desde el archivo: " + e.getMessage());
        }
        return maquinas;

    }

    public static int getPiezasAProducir(String ruta) throws Exception {
        try {
            List<String> lines = Files.readAllLines(Paths.get(ruta));
            return Integer.parseInt(lines.get(0));
        } catch (Exception e) {
            throw new Exception("Error al obtener las piezas a producir desde el archivo: ");
        }
    }

}
