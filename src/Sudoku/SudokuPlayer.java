package Sudoku;

public class SudokuPlayer {

    public static void main(String[] args) {
        SudokuNotADT sudokuNotADT = new SudokuNotADT(5);

        // rischio che l'utente modifichi gli argomenti direttamente
        sudokuNotADT.gameField[0][0] = 9;



        SudokuADTImmutable sudokuImmutable = new SudokuADTImmutable();
        sudokuImmutable = sudokuImmutable.inserNumber(0,0,9);

        //VANTAGGIO DI UNA CLASSE IMMUTABILE posso farli di fila
        sudokuImmutable = sudokuImmutable.inserNumber(5,5,9).inserNumber(4,5,9);
    }
}