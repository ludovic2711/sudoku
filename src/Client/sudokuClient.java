package Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import Interface.sudokuInterface;

public class sudokuClient {

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099); //* Obtenemos el servidor */
            sudokuInterface generator = (sudokuInterface) registry.lookup("sudokuInterface"); //*Aquí lo localizamos */


            Scanner scanner = new Scanner(System.in);
            int opcion = 0;

            //* Menú */
            while (opcion != 4) {

                mostrarMenu();
                opcion = scanner.nextInt();
                int[][] matriz = null;

                switch (opcion) {

                    //* Esto se llama rule switch, la verdad está bastante interesante */
                    case 1 -> matriz = generator.generarMatriz4x4();
                    case 2 -> matriz = generator.generarMatriz9x9();
                    case 3 -> matriz = generator.generarMatriz16x16();
                    case 4 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }

                if (matriz != null) {
                    visualizarMatriz(matriz);
                }

            }


            
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.toString());
        }
        

    }


 //*Opciones del menú */
    private static void mostrarMenu() {
        System.out.println("GENERADOR SUDOKU");
        System.out.println("1. Matriz 4x4");
        System.out.println("2. Matriz 9x9");
        System.out.println("3. Matriz 16x16");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

 //*Visualización de la matriz (TEMPORAL) */
    private static void visualizarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int num : fila) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
