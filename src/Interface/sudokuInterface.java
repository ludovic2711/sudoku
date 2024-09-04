package Interface;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface sudokuInterface extends Remote{
    
    //* Metodo para el cliente */

    void generarMatriz(int value) throws RemoteException;

}
