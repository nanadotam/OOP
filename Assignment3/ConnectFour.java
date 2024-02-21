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

// Actual game class
public class ConnectFour {
    private static final byte NO_ROWS = 6;
    private static final byte NO_COLUMNS = 7;
    private static final byte NO_DIRS = 4;

    private static final byte[][] directions = {
            {-1, 1}, // NW
            {0, 1},  // N
            {1, 1},  // NE
            {1, 0}   // E
    };

    // 2D Array to represent board
    private Color[][] board;

    // possible directions of finding a match at each grid square
    private ArrayList<Byte[]> dirLists[][];

    // scanner object for console
    private Scanner input;

    // constructor
    public ConnectFour(Scanner input) {
        this.input = input;
    }

    public void init() {
        // create instances
        board = new Color[NO_ROWS][NO_COLUMNS];
        dirLists = new ArrayList[NO_ROWS][NO_COLUMNS];

        // loop through each spot
        for (byte r = 0; r < NO_ROWS; r++) {
            for (byte c = 0; c < NO_COLUMNS; c++) {
                // set space as empty on board
                board[r][c] = Color.EMPTY;

                // set up directions
                dirLists[r][c] = new ArrayList<>();
                for (byte i = 0; i < NO_DIRS; i++) {
                    if (c + 3 * directions[i][0] >= 0 && c + 3 * directions[i][0] <= 6 && r + 3 * directions[i][1] >= 0 && r + 3 * directions[i][1] <= 5) {
                        dirLists[r][c].add(new Byte[]{directions[i][0], directions[i][1]});
                    }
                }
            }
        }
    }


    // print board
    public void printBoard() {
        String columnDivider = "|";
        String bottomRow= "——————————————";
        // String bottomRow= "——————————————\n0 1 2 3 4 5 6\n——————————————\n";    // for debugging purposes

        
        for (byte r = NO_ROWS - 1; r >= 0; r--) {
            // System.out.println("|");
            for (byte c = 0; c < NO_COLUMNS; c++) {
                System.out.print(board[r][c].getCode() + columnDivider);
            }
            System.out.println();
            // System.out.println("\n" + bottomRow);
        }
        System.out.println(bottomRow);
    }

    public void play() {
        byte playerTurn = 0;
        boolean isRunning = true;
        
        // ensuring both players can only play 42 turns
        while (playerTurn < NO_ROWS * NO_COLUMNS && isRunning) {
            // determining player based on odd/even 
            Color currColor = (playerTurn % 2 == 0 ? Color.RED : Color.YELLOW);
            byte col = 0;

            // chunck to insert piece on board
            while (true) {
                System.out.print("Drop a " + currColor + " disk at column (0-6): ");
                String in = input.next();

                // obtain value
                try {
                    col = Byte.parseByte(in);
                } catch (Exception e) {
                    System.out.println("Please input a valid digit from 0 - 6.");
                    continue;
                }

                if (insert(currColor, col)) {
                    break;
                }

                System.out.println("Please input a valid digit from 0 - 6.");
            }
            printBoard();

            // check for winner
            boolean checkWinner = false;
            for (byte r = 0; r < NO_ROWS; r++) {
                for (byte c = 0; c < NO_COLUMNS; c++) {
                    // don't check empty spot/other color if not turn
                    if (board[r][c] == currColor) {
                        // loop through possible directions
                        // for (byte i = 0; i < NO_DIRS; i++) {
                        for (byte i = 0; i < dirLists[r][c].size(); i++) {
                            if (count(r, c, i, currColor) >= 4) {
                                checkWinner = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (checkWinner) {
                System.out.println("The " + currColor + " player won. Congratulations! ;) ");
                isRunning = false;
                break;
            }
            playerTurn++;
        }
        if (isRunning) {
            System.out.println("Draw");
        }
    }

    public boolean insert(Color color, byte col) {
        if (col < 0 || col >= NO_COLUMNS) {
            return false;
        }

        byte r;
        // for (r = NO_ROWS - 1; r >= 0; r--) {
        //     if (board[r][col] == Color.EMPTY) {
        //         break;
        //     }
        // }

        // if (r == -1) {
        //     return false;
        // }

        // board[r][col] = color;
        // return true;

        for (r = 0; r < NO_ROWS; r++) {
            if (board[r][col] == Color.EMPTY) {
                board[r][col] = color;
                return true;
            }
        }
    
        return false; // Column is full
    }


    public byte count(byte r, byte c, byte dir, Color color) {
        if (r < 0 || r >= NO_ROWS || c < 0 || c >= NO_COLUMNS) {
            return 0;
        }

        if (board[r][c] != color) {
            return 0;
        }

        byte[] direction = directions[dir];
        return (byte)(1 + count((byte)(r + direction[0]), (byte)(c + direction[1]), dir, color));
    }

    public static void main(String[] args) {
        System.out.println("Hello, Welcome to Connect Four!");
        Scanner scanner = new Scanner(System.in);
        ConnectFour c4 = new ConnectFour(scanner);
        c4.init();
        c4.play();
        scanner.close();
    }
}
