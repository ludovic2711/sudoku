package Interface;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface sudokuInterface extends Remote{

 //*Se generan los  tres metodos
    int[][] generarMatriz4x4() throws RemoteException;
    int[][] generarMatriz9x9() throws RemoteException;
    int[][] generarMatriz16x16() throws RemoteException;

}
