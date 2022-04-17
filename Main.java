// Imporing Modules
import java.io.File;
import java.util.Scanner;

// Stage Class
public class Main {

    // Private Variables
    private static int n_cortinas, n_lamparas, n_c_cortinas, n_c_lamparas;

    // Static Main
    public static void main(String[] args) throws Exception {

        // Creando Cloud
        Cloud cloud = new Cloud();

        // Linea
        int linea = 1;

        // Escaneo de Archivo
        Scanner documento = new Scanner(new File(args[0]));

        // Leyendo Archivo
        do {

            // Seteo de Linea
            String[] datos = documento.nextLine().split("\t");

            // Linea 1 (Datos Generales)
            if (linea == 1) {

                // Seteo de datos
                n_cortinas = Integer.parseInt(datos[0]);
                n_lamparas = Integer.parseInt(datos[1]);
                n_c_cortinas = Integer.parseInt(datos[2]);
                n_c_lamparas = Integer.parseInt(datos[3]);
            };

            // Linea 2 (Roller Shade Datos)
            if (linea == 2) {
                int index = 0;
                for (int i=0; i<n_cortinas; i++) {
                    cloud.addRoller(new Roller(
                        Double.parseDouble(datos[index]),
                        Double.parseDouble(datos[index + 1]),
                        Integer.parseInt(datos[index + 2])
                    ));
                    index += 3;
                }
            };

            // Linea 3 (Lamparas Datos)
            if (linea == 3)
                for (int i=0; i<n_lamparas; i++)
                    cloud.addLamp(new Lamp(Integer.parseInt(datos[i])));

            // Linea 4 (Controles Roller Datos)
            if (linea == 4)
                for (int i=0; i<n_c_cortinas; i++)
                    cloud.addRollerControl(new DomoticControl(Integer.parseInt(datos[i])));

            // Linea 5 (Controles Lampara Datos)
            if (linea == 5)
                for (int i=0; i<n_c_lamparas; i++)
                    cloud.addLampControl(new DomoticControl(Integer.parseInt(datos[i])));

            // Agregando una linea
            linea += 1;
        } while (linea < 6);

        // Operator
        Operator operador = new Operator(cloud);
        operador.executeCommands(documento, System.out);
    };
};