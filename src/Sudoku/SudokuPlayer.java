package Sudoku;

public class SudokuPlayer {

    public static void main(String[] args) {
        SudokuNotADT sudokuNotADT = new SudokuNotADT(5);

        // rischio che l'utente modifichi gli argomenti direttamente
        sudokuNotADT.gameField[0][0] = 9;



        SudokuADTImmutable sudokuImmutable = new SudokuADTImmutable();
        sudokuImmutable = sudokuImmutable.inserNumber(0,0,9);
    }
}