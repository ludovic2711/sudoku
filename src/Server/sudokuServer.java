package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Implementation.sudokuImp;
import Interface.sudokuInterface;

public class sudokuServer {

    public static void main(String[] args) {

        try {
            //*Creamos el servidor */
            sudokuInterface generator = new sudokuImp();
            Registry registry = LocateRegistry.createRegistry(1099); //* Se encuentra corriendo en el servidor 1099
            registry.rebind("sudokuInterface", generator); //* le damos un nombre al servicio remoto para encontrarlo mas facil desde el cliente  */
            System.out.println("Servidor Sudoku listo.");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
        }
    }
}
