package GUI;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SudokuGUI extends JFrame {

    char[][] sudoku16x16 = {
        {'1', '2', '0', '4', '5', '6', '7', '8', '9', '0', 'B', 'C', '0', 'E', 'F', 'G'},
        {'5', '6', '7', '0', '9', 'A', '0', 'C', 'D', 'E', '0', 'G', '1', '2', '3', '4'},
        {'9', 'A', '0', 'C', '0', 'E', 'F', 'G', '1', '0', '3', '4', '5', '6', '0', '8'},
        {'0', 'E', 'F', 'G', '1', '0', '3', '4', '0', '6', '7', '8', '9', 'A', 'B', '0'},
        {'2', '1', '4', '0', '6', '5', '8', '0', 'A', '9', 'C', '0', 'E', '0', 'G', 'F'},
        {'6', '0', '8', '7', 'A', '9', 'C', 'B', '0', '0', 'G', 'F', '2', '1', '4', '3'},
        {'A', '9', 'C', 'B', '0', '0', 'G', 'F', '2', '1', '4', '3', '6', '0', '8', '7'},
        {'E', 'D', '0', 'F', '2', '1', '0', '3', '6', '5', '8', '0', 'A', '9', 'C', 'B'},
        {'3', '4', '1', '2', '7', '0', '5', '6', 'B', 'C', '9', '0', 'F', 'G', 'D', '0'},
        {'0', '8', '5', '6', 'B', 'C', '9', 'A', '0', 'G', '0', 'E', '3', '4', '1', '2'},
        {'B', 'C', '9', '0', 'F', '0', 'D', 'E', '3', '4', '1', '0', '7', '0', '5', '6'},
        {'F', '0', 'D', 'E', '3', '4', '1', '2', '0', '8', '5', '6', '0', 'C', '9', 'A'},
        {'4', '3', '2', '1', '0', '7', '0', '5', 'C', '0', 'A', '9', 'G', '0', 'E', 'D'},
        {'8', '0', '6', '0', 'C', 'B', '0', '9', 'G', 'F', 'E', '0', '4', '3', '2', '1'},
        {'C', 'B', '0', '9', 'G', 'F', 'E', '0', '4', '3', '2', '1', '8', '7', '6', '0'},
        {'G', 'F', 'E', 'D', '4', '3', '0', '1', '0', '7', '6', '5', 'C', '0', 'A', '9'}
    };

    char[][] sudoku9x9 = {
        {'5', '3', '0', '0', '7', '0', '0', '0', '0'},
        {'6', '0', '0', '1', '9', '5', '0', '0', '0'},
        {'0', '9', '8', '0', '0', '0', '0', '6', '0'},
        {'8', '0', '0', '0', '6', '0', '0', '0', '3'},
        {'4', '0', '0', '8', '0', '3', '0', '0', '1'},
        {'7', '0', '0', '0', '2', '0', '0', '0', '6'},
        {'0', '6', '0', '0', '0', '0', '2', '8', '0'},
        {'0', '0', '0', '4', '1', '9', '0', '0', '5'},
        {'0', '0', '0', '0', '8', '0', '0', '7', '9'}
    };
    

    char[][] sudoku4x4 = {
        {'1', '0', '3', '4'},
        {'0', '4', '0', '2'},
        {'4', '0', '2', '1'},
        {'0', '1', '0', '0'}
    };
    

    private JTextField[][] cells;

    public void SudokuGUIMatriz(int value) {
        char[][] sudoku;
        getContentPane().removeAll(); //* Esto elimina las cosas del panel, si de pronto hay una matriz antigüa ahí */

        setTitle("Sudoku" + value + "X" + value); //*titulo */
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //* Se tiene de esta forma porque si se se tiene EXIT_ON_CLOSE cierra el servidor */
        setSize(400, 400);
        setLayout(new GridLayout(value, value)); //* Se Crea el Grid (Matriz) */

        cells = new JTextField[value][value]; //* Hace que cada espacio de la matriz pueda ser modificable */

        //!For que corrobora el comentario anterior
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                cells[i][j] = new JTextField();
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setFont(new Font("Arial", Font.BOLD, 20));
                cells[i][j].setEditable(true);  // Desactivar edición para que el usuario no modifique los números
                add(cells[i][j]);
            }
        }

        //*Condicionales de que cual matriz se va a crear */
        if (value == 4) {
            sudoku = sudoku4x4;
        } else {
            if (value == 9) {
                sudoku = sudoku9x9;
            } else {
                sudoku = sudoku16x16;
            }
        }

        //* La cargamos en el metodo que se encuentra abajo */
        cargarSudokuEnLaGUI(sudoku, value);

        setVisible(true);

        SwingUtilities.invokeLater(SudokuGUI::new);

    }

    //*lo que hacemos despues de generar la matriz en la memoria (datos quemados), pasamos los datos en cada espacio correspondiente en el TextField inicializado anteriormente */
    private void cargarSudokuEnLaGUI(char[][] sudoku, int value) {
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                if (sudoku[i][j] != '0') {
                    cells[i][j].setText(String.valueOf(sudoku[i][j]));
                }
            }
        }
    }

}
