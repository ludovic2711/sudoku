package Implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

import Interface.sudokuInterface;


public class sudokuImp extends UnicastRemoteObject implements sudokuInterface {

//*Constructor
    public sudokuImp() throws RemoteException {
        super();
    }

    //? no entiendo porque me pide que los haga sobrecargador ¿ Será por el constructor?

    @Override
    public int[][] generarMatriz4x4() throws RemoteException{
        return generarMatriz(4);
    }

    @Override
    public int[][] generarMatriz9x9() throws RemoteException{
        return generarMatriz(9);
    }

    @Override
    public int[][] generarMatriz16x16() throws RemoteException{
        return generarMatriz(16);
    }


    private int[][] generarMatriz(int size) {
        int[][] matriz = new int[size][size];
        Random random = new Random();
        
        //* Llenado de la matriz con números aleatorios solo como ejemplo.

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matriz[i][j] = random.nextInt(size) + 1;
            }
        }
        return matriz;
    }
}
