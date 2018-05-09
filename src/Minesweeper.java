import java.util.InputMismatchException;
import java.util.Scanner;

public class Minesweeper {

    public static void main(String[] args) throws InputMismatchException {

        String gameRules = "\nThe purpose of the game is to open all the cells of the board which do not contain a mine.\n" +
                            "You lose if you set off a mine cell. Every non-mine cell you open will tell you the total number \n" +
                            "of mines in the eight neighboring cells. Once you are sure that a cell contains a mine, you can flag it as a reminder.\n";

        System.out.println("\nFor game rules type 'r'.");
        System.out.println("\nTo flag a cell type 'f'. To remove a flag type 'rf'.");
        System.out.println("\nTo start a new game type 'ng'.");
        System.out.println("\nTo end the game type 'eg'.\n");

        outerloop:
        while (true) {

            Scanner scan = new Scanner(System.in);

            int maxRow = 0;
            int maxColumn = 0;

            Board board;

            boolean a = true;
            while (a) {
                a = false;

                System.out.println("\nChoose a board size:");

                try {
                    maxRow = scan.nextInt();
                    maxColumn = scan.nextInt();

                    if (maxRow == 100 && maxColumn == 100){
                        System.out.println("Very funny!!! (Your screen is too small for this)");
                        a = true;
                    }

                    if (maxRow == 69 && maxColumn == 69){
                        System.out.println("Very funny!!! (Your screen is too small for this)");
                        a = true;
                    }

                    if (maxRow == 6 && maxColumn == 9) System.out.println("Very funny!!!");

                    if (maxRow - 1 < 0 || maxColumn - 1 < 0) {
                        System.out.println("\nNot a valid input!");
                        a = true;
                    }
                } catch (InputMismatchException ex){
                    System.out.println("\nNot a valid input!");
                    a = true;
                    scan.nextLine();
                }
            }
            board = new Board(maxRow - 1, maxColumn - 1);

            board.mineGenerator();
            board.drawBoard(maxRow - 1, maxColumn - 1, 0, 0, 0);

            System.out.println("\nFlags: " + board.getFlags());

            boolean c = true;

            boolean lost = false;
            while (!lost) {

                System.out.println("\nPick a cell (row column):");

                String line;

                if (c) scan.nextLine();

                try {

                    int row = scan.nextInt();
                    int column = scan.nextInt();

                    lost = !board.pick(row - 1, column - 1);

                } catch (InputMismatchException ex){

                    line = scan.nextLine();


                    switch (line){

                        case "f": {

                            if (board.getFlags() == 0){
                                System.out.println("\nYou are out of flags!");
                                break;
                            }

                            boolean b = true;
                            while (b) {
                                b = false;

                                System.out.println("\nPick a cell to flag (row column):");

                                int rowFlag = scan.nextInt();
                                int columnFlag = scan.nextInt();

                                if (rowFlag - 1 < 0 || rowFlag > board.flags.length || columnFlag - 1 < 0 || columnFlag > board.flags[0].length) {
                                    System.out.println("\nNot a valid input!");
                                    b = true;
                                    continue;
                                }

                                if (board.getValue(rowFlag - 1, columnFlag - 1) == 1 || board.getValue(rowFlag - 1, columnFlag - 1) == 2){
                                    System.out.println("That cell has already been revealed!");
                                    b = true;
                                    continue;
                                }

                                if (board.flags[rowFlag - 1][columnFlag - 1] == 1)
                                    System.out.println("\nThis cell is already flaged!");
                                else {
                                    board.flags[rowFlag - 1][columnFlag - 1] = 1;
                                    board.pick(rowFlag - 1, columnFlag - 1);

                                    board.flagsMinusOne();
                                    System.out.println("\nFlags: " + board.getFlags());
                                }
                            }

                            break;

                        }

                        case "rf": {

                            if (board.noFlags()){
                                System.out.println("\nNo cells are flaged!");
                                break;
                            }

                            boolean b = true;
                            while (b) {
                                b = false;
                                System.out.println("\nPick a cell to remove flag from (row column):");

                                int rowRemoveFlag = scan.nextInt();
                                int columnRemoveFlag = scan.nextInt();

                                if (rowRemoveFlag - 1 < 0 || rowRemoveFlag > board.flags.length || columnRemoveFlag - 1 < 0 || columnRemoveFlag > board.flags[0].length) {
                                    System.out.println("\nNot a valid input!");
                                    b = true;
                                    continue;
                                }

                                if (board.flags[rowRemoveFlag - 1][columnRemoveFlag - 1] != 1) {
                                    b = true;
                                    System.out.println("\nThis cell is already not flaged!");
                                }
                                else {
                                    board.flags[rowRemoveFlag - 1][columnRemoveFlag - 1] = 0;
                                    board.drawBoard(maxRow - 1, maxColumn - 1, 0, 0, 0);

                                    board.flagsPlusOne();
                                    System.out.println("\nFlags: " + board.getFlags());
                                }
                            }

                            break;

                        }

                        case "ng": continue outerloop;

                        case "eg": return;

                        case "r": {

                            System.out.println(gameRules);
                            c = false;
                            break;
                        }

                        default: System.out.println("\nNot a valid input!");

                    }

                }
            }

            boolean d = true;

            while (true) {

                if (!d) System.out.println("\nNew game? (y/n)");
                String newGame;
                newGame = scan.nextLine();

                switch (newGame){
                    case "y": continue outerloop;

                    case "n": return;

                    case "": {
                        d = false;
                        break;
                    }

                    default: System.out.println("\nNot a valid input!");
                }

            }

        }

    }
}
