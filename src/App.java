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
            List<String> lines = Files.readAllLines(Paths.get("src/entrada.txt"));
            piezasAProducir = Integer.parseInt(lines.get(0));
            System.out.println(piezasAProducir);
            for (int i = 1; i < lines.size(); i++) {
                String[] cadenas = lines.get(i).split(",");
                Maquina m1 = new Maquina(cadenas[0], Integer.parseInt(cadenas[1]));
                maquinas.add(m1);
            }
            System.out.println(maquinas);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
