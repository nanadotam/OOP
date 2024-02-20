import java.util.*;

enum Color {
    EMPTY(0),
    RED(1),
    YELLOW(2);

    private byte value;
    Color(int value) {
        this.value = (byte)value;
    }

    public char getCode() {
        switch (this) {
            case RED:
                return 'R';
            case YELLOW:
                return 'Y';
            default:
                return ' ';
        }
    }
}

public class ConnectFour {
    // initializing the vonstants for the no. of rows, columns
    // 21 identical pieces for each player
    private static final byte NO_ROWS = 6;
    private static final byte NO_COLUMNS = 7;
    private static final byte NO_DIRS = 4;      // no. of directions

    // array of incremental values for each given direction
    private static byte directions[][] = {
        {-1, 1}, // NW
        {0, 1}, // N
        {1, 1}, // NE
        {1, 0}, // E
    };

    // 2D array of list of all possible directions
    private List<Byte[]> dirLists[][];
    
    // crating instance of scanner class to read input
    private Scanner input;

    // constructor
    public ConnectFour(Scanner input) {
        this.input = input;
    }

    // funtion to initialize private variables (board, possible directions)
    public void init() {
        // instantiate arrays
        board = new Color[NO_ROWS][NO_COLUMNS];
        dirLists = new List[NO_ROWS][NO_COLUMNS];

        // iterate through each spot
        for (byte r = 0; r < NO_ROWS; r++)
    }

    // funtion to print board
    public void printBoard() {

    }

    // funtion to play
    public void play() {
        byte board[][] = new byte[NO_ROWS][NO_COLUMNS];
    }

    // function to insert colors into the board
    public boolean insert(Color color, byte col) {
        return true;
    }

    public byte count(byte r, byte c, byte dir) {

    }


    public static void main(String[] args) {
        System.out.println("Hello, Welcome to Connect Four!");
    }
}
