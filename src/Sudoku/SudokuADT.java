package Sudoku;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SudokuADT {

    private Integer[][] gameField = new Integer[9][9];
    private int difficulty = 1;
    private boolean isSolveable;
    private boolean isSolved;

    /**
     * Creates a standard sudoku game field with 25 numbers
     */
    public SudokuADT() {
        //creates a sudoku field with standard difficulty
        isSolveable = true;
        isSolved = false;
    }

    /**
     * Creates a sudocu game field based on given difficulty
     * @param diff difficulty of the game
     */
    public SudokuADT(int diff) {
        //creates a sudoku field with specified difficulty
        difficulty = diff;
        isSolveable = true;
        isSolved = false;
    }

    /**
     * OSSERVATORE
     * @return true if actual game field is resolveable, false otherwise
     */
    public boolean isSolveable() {
        //evaluate if is solveable and, change isSolveable value and...
        return isSolveable;
    }

    /**
     * OBSERVER
     * @return true if actual game field is totally filled with right numbers, false otherwise
     */
    public boolean isSolved() {
        //evaluate if is the gamefield is totally field and if the solution is the right one and...
        return isSolved;
    }

    /**
     * MUTUATOR
     * eccezione se c'è un oggetto
     */
    public void inserNumber(int i, int j, int newValue){
        // controllo valore 1 <= newValue <= 9
        // indici siano validi 0 <= i,j <= 8
        // controllo che in [i][j] ci sia null
        gameField[i][j] = newValue;
    }
}