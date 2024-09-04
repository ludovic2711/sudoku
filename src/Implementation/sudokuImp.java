package Implementation;

import GUI.SudokuGUI;
import Interface.sudokuInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class sudokuImp extends UnicastRemoteObject implements sudokuInterface {

    SudokuGUI sudokuGUI = new SudokuGUI();
//*Constructor
//*Esta línea llama al constructor de la superclase (la clase de la que sudokuImp hereda). Es decir, se asegura de que cualquier inicialización definida en la superclase se ejecute antes de que se ejecute el código del constructor en sudokuImp. */
    public sudokuImp() throws RemoteException {
        super();
    }

    //*Implementacion del metodo (puente) */
    @Override
    public void generarMatriz(int value) throws RemoteException  {
        sudokuGUI.SudokuGUIMatriz(value);
    }
}
