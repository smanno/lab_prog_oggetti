package Sudoku;

/**
 * This class represents a sudoku game field that is immutable
 * @author AndreaBidinost
 *
 */
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SudokuADTImmutable {

    private Integer[][] gameField = new Integer[9][9];
    private int difficulty = 1;
    private boolean isSolveable;
    private boolean isSolved;

    /**
     * Creates a standard sudoku game field with 25 numbers
     */
    public SudokuADTImmutable() {
        //creates a sudoku field with standard difficulty
        //the fields will not be changed
        isSolveable = CheckIfSolvable();
        isSolved = CheckIfSolved();
    }

    /**
     * Creates a standard sudoku game field with 25 numbers
     */
    public SudokuADTImmutable(int diff) {
        //creates a sudoku field with standard difficulty
        //the fields will not be changed
        difficulty = diff;
        isSolveable = CheckIfSolvable();
        isSolved = CheckIfSolved();
    }

    /**
     * Creates a sudocu game field based on given difficulty
     * @param diff difficulty of the game
     */

    /**
     * OBSERVER
     * @return true if actual game field is resolveable, false otherwise
     */
    public boolean isSolveable() {
        return isSolveable;
    }

    /**
     * OBSERVER
     * @return true if actual game field is totally filled with right numbers, false otherwise
     */
    public boolean isSolved() {
        return isSolved;
    }

    private boolean CheckIfSolvable(){
        // controllo se il sudoku è risolvibile
    }

    private boolean CheckIfSolved(){
        // controllo se il sudoku è risolto
    }

    /**
     * PRODUCER non più Modificatore
     * Classe Immutabile -> il modificatore restituisce un nuovo oggetto della stessa classe
     * eccezione se c'è un oggetto
     */
    public SudokuADTImmutable inserNumber(int i, int j, int newValue){
        // controllo valore 1 <= newValue <= 9
        // indici siano validi 0 <= i,j <= 8
        // controllo che in [i][j] ci sia null
        SudokuADTImmutable newSudoku = new SudokuADTImmutable();
        newSudoku.difficulty = getDifficulty();
        newSudoku.isSolveable = this.isSolveable;
        newSudoku.isSolved = this.isSolved;
        /* Metodo di copia sbagliato
        newSudoku.gameField = this.gameField; // ho copiato il puntatore alla matrice, non ho fatto una copia
        */
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                newSudoku.gameField[r][c] = gameField[r][c];
            }
        }
        newSudoku.gameField[i][j] = newValue;
        return newSudoku;
    }
}