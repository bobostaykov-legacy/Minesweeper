import java.util.Random;

public class Board {

    public int[][] flags;


    int flagsCount = 0;


    private int[][] board;

    public Board (int maxRow, int maxColumn){
        board = new int[maxRow + 1][maxColumn + 1];
        flags = new int[maxRow + 1][maxColumn + 1];
    }


    public void setValue (int row, int column, int value){
        board[row][column] = value;
    }


    public int getValue (int row, int column){
        return board[row][column];
    }


    public int getMaxRow(){
        return this.board.length - 1;
    }


    public int getMaxColumn(){
        return this.board[0].length - 1;
    }


    public int getFlags() {
        return flagsCount;
    }


    public void flagsMinusOne(){
        flagsCount--;
    }


    public void flagsPlusOne(){
        flagsCount++;
    }


    public void drawBoard (int maxRow, int maxColumn, int state, int row, int column){

        System.out.print("\n");

        if (maxRow + 1 < 10 && maxColumn + 1 < 10) {

            for (int i = 0; i <= maxRow + 2; i++) {

                if (i != 0 && i != maxRow + 2) System.out.print(i + "   ");
                else System.out.print("    ");

                for (int j = 0; j <= maxColumn + 2; j++) {

                    if (i == maxRow + 2 && j == 0) System.out.print("\n    ");

                    if (j == maxColumn + 2 && i != 0 && i != maxRow + 2) System.out.print("  " + i);

                    if (i == 0 || i == maxRow + 2)
                        if (j != 0 && j != maxColumn + 2) System.out.print(j + " ");

                    if (i == 0 && j == maxColumn + 2) System.out.print("\n");


                    if (i != 0 && i != maxRow + 2 && j != 0 && j != maxColumn + 2) {

                        if (state == 0) {
                            if (this.getValue(i - 1, j - 1) == 2) {
                                if (this.touchingMines(i - 1, j - 1) > 0)
                                    System.out.print(this.touchingMines(i - 1, j - 1) + " ");
                                else System.out.print("  ");
                            } else if (this.getValue(i - 1, j - 1) == 1)
                                System.out.print(this.touchingMines(i - 1, j - 1) + " ");
                            else if (this.flags[i - 1][j - 1] == 1) System.out.print("F ");
                            else System.out.print("+ ");
                        }

                        if (state == 1) {
                            if (i - 1 == row && j - 1 == column) {
                                System.out.print(this.touchingMines(i - 1, j - 1) + " ");
                                this.setValue(i - 1, j - 1, 1);
                            } else {
                                if (this.getValue(i - 1, j - 1) == 2) {
                                    if (this.touchingMines(i - 1, j - 1) > 0)
                                        System.out.print(this.touchingMines(i - 1, j - 1) + " ");
                                    else System.out.print("  ");
                                } else if (this.getValue(i - 1, j - 1) == 1)
                                    System.out.print(this.touchingMines(i - 1, j - 1) + " ");
                                else if (this.flags[i - 1][j - 1] == 1) System.out.print("F ");
                                else System.out.print("+ ");
                            }
                        }

                        if (state == -1) {
                            if (this.getValue(i - 1, j - 1) == 2) {
                                if (this.touchingMines(i - 1, j - 1) > 0)
                                    System.out.print(this.touchingMines(i - 1, j - 1) + " ");
                                else System.out.print("  ");
                            } else if (this.getValue(i - 1, j - 1) == 1)
                                System.out.print(this.touchingMines(i - 1, j - 1) + " ");
                            else if (i - 1 == row && j - 1 == column) System.out.print("B ");
                            else if (this.getValue(i - 1, j - 1) == -1) System.out.print("b ");
                            else if (this.flags[i - 1][j - 1] == 1) System.out.print("F ");
                            else System.out.print("+ ");
                        }

                        if (state == 2) {
                            this.reveal(row, column);
                            if (this.getValue(i - 1, j - 1) == 2) {
                                if (this.touchingMines(i - 1, j - 1) > 0)
                                    System.out.print(this.touchingMines(i - 1, j - 1) + " ");
                                else System.out.print("  ");
                            } else if (this.getValue(i - 1, j - 1) == 1)
                                System.out.print(this.touchingMines(i - 1, j - 1) + " ");
                            else if (this.flags[i - 1][j - 1] == 1) System.out.print("F ");
                            else System.out.print("+ ");
                        }

                        if (state == 3) {
                            if (this.getValue(i - 1, j - 1) == 2) {
                                if (this.touchingMines(i - 1, j - 1) > 0)
                                    System.out.print(this.touchingMines(i - 1, j - 1) + " ");
                                else System.out.print("  ");
                            } else if (this.getValue(i - 1, j - 1) == 1)
                                System.out.print(this.touchingMines(i - 1, j - 1) + " ");
                            else if (this.flags[i - 1][j - 1] == 1) System.out.print("F ");
                            else System.out.print("+ ");
                        }
                    }
                }

                System.out.print("\n");
            }
        }




        if (maxRow + 1 > 9 || maxColumn + 1 > 9){

            for (int i = 0; i <= maxRow + 2; i++) {

                if (i != 0 && i != maxRow + 2){
                    if (i < 10) System.out.print(i + "    ");
                    else System.out.print(i + "   ");
                }
                else System.out.print("     ");

                for (int j = 0; j <= maxColumn + 2; j++) {

                    if (i == maxRow + 2 && j == 0) System.out.print("\n     ");

                    if (j == maxColumn + 2 && i != 0 && i != maxRow + 2) System.out.print(" " + i);

                    if (i == 0 || i == maxRow + 2)
                        if (j != 0 && j != maxColumn + 2) {
                            if (j < 10) System.out.print(j + "  ");
                            else System.out.print(j + " ");
                        }

                    if (i == 0 && j == maxColumn + 2) System.out.print("\n");


                    if (i != 0 && i != maxRow + 2 && j != 0 && j != maxColumn + 2) {

                        if (state == 0) {
                            if (this.getValue(i - 1, j - 1) == 2) {
                                if (this.touchingMines(i - 1, j - 1) > 0)
                                    System.out.print(this.touchingMines(i - 1, j - 1) + "  ");
                                else System.out.print("   ");
                            } else if (this.getValue(i - 1, j - 1) == 1)
                                System.out.print(this.touchingMines(i - 1, j - 1) + "  ");
                            else if (this.flags[i - 1][j - 1] == 1) System.out.print("F  ");
                            else System.out.print("+  ");
                        }

                        if (state == 1) {
                            if (i - 1 == row && j - 1 == column) {
                                System.out.print(this.touchingMines(i - 1, j - 1) + "  ");
                                this.setValue(i - 1, j - 1, 1);
                            } else {
                                if (this.getValue(i - 1, j - 1) == 2) {
                                    if (this.touchingMines(i - 1, j - 1) > 0)
                                        System.out.print(this.touchingMines(i - 1, j - 1) + "  ");
                                    else System.out.print("   ");
                                } else if (this.getValue(i - 1, j - 1) == 1)
                                    System.out.print(this.touchingMines(i - 1, j - 1) + "  ");
                                else if (this.flags[i - 1][j - 1] == 1) System.out.print("F  ");
                                else System.out.print("+  ");
                            }
                        }

                        if (state == -1) {
                            if (this.getValue(i - 1, j - 1) == 2) {
                                if (this.touchingMines(i - 1, j - 1) > 0)
                                    System.out.print(this.touchingMines(i - 1, j - 1) + "  ");
                                else System.out.print("   ");
                            } else if (this.getValue(i - 1, j - 1) == 1)
                                System.out.print(this.touchingMines(i - 1, j - 1) + "  ");
                            else if (i - 1 == row && j - 1 == column) System.out.print("B  ");
                            else if (this.getValue(i - 1, j - 1) == -1) System.out.print("b  ");
                            else if (this.flags[i - 1][j - 1] == 1) System.out.print("F  ");
                            else System.out.print("+  ");
                        }

                        if (state == 2) {
                            this.reveal(row, column);
                            if (this.getValue(i - 1, j - 1) == 2) {
                                if (this.touchingMines(i - 1, j - 1) > 0)
                                    System.out.print(this.touchingMines(i - 1, j - 1) + "  ");
                                else System.out.print("   ");
                            } else if (this.getValue(i - 1, j - 1) == 1)
                                System.out.print(this.touchingMines(i - 1, j - 1) + "  ");
                            else if (this.flags[i - 1][j - 1] == 1) System.out.print("F  ");
                            else System.out.print("+  ");
                        }

                        if (state == 3) {
                            if (this.getValue(i - 1, j - 1) == 2) {
                                if (this.touchingMines(i - 1, j - 1) > 0)
                                    System.out.print(this.touchingMines(i - 1, j - 1) + "  ");
                                else System.out.print("   ");
                            } else if (this.getValue(i - 1, j - 1) == 1)
                                System.out.print(this.touchingMines(i - 1, j - 1) + "  ");
                            else if (this.flags[i - 1][j - 1] == 1) System.out.print("F  ");
                            else System.out.print("+  ");
                        }
                    }
                }

                System.out.print("\n");
            }

        }
    }


    public void mineGenerator (){

        Random random = new Random();

//        if (this.getMaxRow() * this.getMaxColumn() < 17) {
//            for (int i = 0; i <= this.getMaxRow(); i++) {
//                for (int j = 0; j <= this.getMaxColumn(); j++) {
//                    if (random.nextInt(100) < 20){
//                        this.setValue(i, j, -1);
//                        flagsCount++;
//                    }
//                }
//            }
//        } else {
            for (int i = 0; i <= this.getMaxRow(); i++) {
                for (int j = 0; j <= this.getMaxColumn(); j++) {
                    if (random.nextInt(100) < 15){
                        this.setValue(i, j, -1);
                        flagsCount++;
                    }
                }
            }
        //}

    }


    public boolean pick (int row, int column){

        if (row > this.getMaxRow() || column > this.getMaxColumn() || row < 0 || column < 0){

            System.out.println("Not a valid input!");

            return true;
        }

        if (this.flags[row][column] == 1){

            this.drawBoard(this.getMaxRow(), this.getMaxColumn(), 3, row, column);

            return true;
        }

        if (this.getValue(row, column) == 0){

            if (this.touchingMines(row, column) == 0){

                this.drawBoard(this.getMaxRow(), this.getMaxColumn(), 2, row, column);

                if (this.win()){

                    System.out.println("\nYOU WIN!!!");

                    return false;
                }

                return true;
            } else {

                this.drawBoard(this.getMaxRow(), this.getMaxColumn(), 1, row, column);

                if (this.win()){

                    System.out.println("\nYOU WIN!!!");

                    return false;
                }

                return true;
            }
        }

        if (this.getValue(row,column) == -1){

            this.drawBoard(this.getMaxRow(), this.getMaxColumn(), -1, row, column);

            System.out.println("\nYOU LOSE!");

            return false;

        }

        if (this.getValue(row, column) == 1 || this.getValue(row, column) == 2){

            System.out.println("That cell has already been revealed!");

            return true;
        }

        return true;
    }


    public int touchingMines (int row, int column){
        int mineCount = 0;

        if (this.getMaxRow() == 0 && this.getMaxColumn() == 0) return 0;

        if (this.getMaxRow() == 0){

            if (column == 0)
                if (this.getValue(row, column + 1) == -1) mineCount++;

            if (column == this.getMaxColumn())
                if (this.getValue(row, column - 1) == -1) mineCount++;

            if (column > 0 && column < this.getMaxColumn()){
                if (this.getValue(row, column + 1) == -1) mineCount++;
                if (this.getValue(row, column - 1) == -1) mineCount++;
            }

            return mineCount;
        }

        if (this.getMaxColumn() == 0){

            if (row == 0)
                if (this.getValue(row + 1, column) == -1) mineCount++;

            if (row == this.getMaxRow())
                if (this.getValue(row - 1, column) == -1) mineCount++;

            if (row > 0 && row < this.getMaxRow()){
                if (this.getValue(row + 1, column) == -1) mineCount++;
                if (this.getValue(row - 1, column) == -1) mineCount++;
            }

            return mineCount;
        }

        if (row == 0 && column == 0){
            if (this.getValue(row, column + 1) == -1) mineCount++;
            if (this.getValue(row + 1, column) == -1) mineCount++;
            if (this.getValue(row + 1, column + 1) == -1) mineCount++;
        }

        if (row == 0 && column > 0 && column < this.getMaxColumn()){
            if (this.getValue(row, column - 1) == -1) mineCount++;
            if (this.getValue(row, column + 1) == -1) mineCount++;
            if (this.getValue(row + 1, column - 1) == -1) mineCount++;
            if (this.getValue(row + 1, column) == -1) mineCount++;
            if (this.getValue(row + 1, column + 1) == -1) mineCount++;
        }

        if (row == 0 && column == this.getMaxColumn()){
            if (this.getValue(row, column - 1) == -1) mineCount++;
            if (this.getValue(row + 1, column - 1) == -1) mineCount++;
            if (this.getValue(row + 1, column) == -1) mineCount++;
        }

        if (row > 0 && row < this.getMaxRow() && column == 0){
            if (this.getValue(row - 1, column) == -1) mineCount++;
            if (this.getValue(row - 1, column + 1) == -1) mineCount++;
            if (this.getValue(row, column + 1) == -1) mineCount++;
            if (this.getValue(row + 1, column) == -1) mineCount++;
            if (this.getValue(row + 1, column + 1) == -1) mineCount++;
        }

        if (row > 0 && row < this.getMaxRow() && column == this.getMaxColumn()){
            if (this.getValue(row - 1, column - 1) == -1) mineCount++;
            if (this.getValue(row - 1, column) == -1) mineCount++;
            if (this.getValue(row, column - 1) == -1) mineCount++;
            if (this.getValue(row + 1, column - 1) == -1) mineCount++;
            if (this.getValue(row + 1, column) == -1) mineCount++;
        }

        if (row == this.getMaxRow() && column == 0){
            if (this.getValue(row - 1, column) == -1) mineCount++;
            if (this.getValue(row - 1, column + 1) == -1) mineCount++;
            if (this.getValue(row, column + 1) == -1) mineCount++;
        }

        if (row == this.getMaxRow() && column > 0 && column < this.getMaxColumn()){
            if (this.getValue(row - 1, column - 1) == -1) mineCount++;
            if (this.getValue(row - 1, column) == -1) mineCount++;
            if (this.getValue(row - 1, column + 1) == -1) mineCount++;
            if (this.getValue(row, column - 1) == -1) mineCount++;
            if (this.getValue(row, column + 1) == -1) mineCount++;
        }

        if (row == this.getMaxRow() && column == this.getMaxColumn()){
            if (this.getValue(row - 1, column - 1) == -1) mineCount++;
            if (this.getValue(row - 1, column) == -1) mineCount++;
            if (this.getValue(row, column - 1) == -1) mineCount++;
        }

        if (row > 0 && row < this.getMaxRow() && column > 0 && column < this.getMaxColumn()) {
            if (this.getValue(row - 1, column - 1) == -1) mineCount++;
            if (this.getValue(row - 1, column) == -1) mineCount++;
            if (this.getValue(row - 1, column + 1) == -1) mineCount++;
            if (this.getValue(row, column - 1) == -1) mineCount++;
            if (this.getValue(row, column + 1) == -1) mineCount++;
            if (this.getValue(row + 1, column - 1) == -1) mineCount++;
            if (this.getValue(row + 1, column) == -1) mineCount++;
            if (this.getValue(row + 1, column + 1) == -1) mineCount++;
        }

        return mineCount;
    }


    public void reveal (int row, int column){

        this.setValue(row, column, 2);

        if (this.getMaxColumn() == 0 && this.getMaxRow() == 0) return;

        if (this.getMaxRow() == 0){

            if (column == 0) {
                if (this.touchingMines(row, column + 1) == 0 && this.getValue(row, column + 1) != 2) {
                    this.setValue(row, column + 1, 2);
                    this.reveal(row, column + 1);
                }
                if (this.touchingMines(row, column + 1) != 0) this.setValue(row, column + 1, 2);
            }

            if (column == this.getMaxColumn()){
                if (this.touchingMines(row, column - 1) == 0 && this.getValue(row, column - 1) != 2) {
                    this.setValue(row, column - 1, 2);
                    this.reveal(row, column - 1);
                }
                if (this.touchingMines(row, column - 1) != 0) this.setValue(row, column - 1, 2);
            }

            if (column > 0 && column < this.getMaxColumn()){
                if (this.touchingMines(row, column + 1) == 0 && this.getValue(row, column + 1) != 2) {
                    this.setValue(row, column + 1, 2);
                    this.reveal(row, column + 1);
                }
                if (this.touchingMines(row, column + 1) != 0) this.setValue(row, column + 1, 2);

                if (this.touchingMines(row, column - 1) == 0 && this.getValue(row, column - 1) != 2) {
                    this.setValue(row, column - 1, 2);
                    this.reveal(row, column - 1);
                }
                if (this.touchingMines(row, column - 1) != 0) this.setValue(row, column - 1, 2);
            }

            return;
        }

        if (this.getMaxColumn() == 0){

            if (row == 0) {
                if (this.touchingMines(row + 1, column) == 0 && this.getValue(row + 1, column) != 2) {
                    this.setValue(row + 1, column, 2);
                    this.reveal(row + 1, column);
                }
                if (this.touchingMines(row + 1, column) != 0) this.setValue(row + 1, column, 2);
            }

            if (row == this.getMaxRow()){
                if (this.touchingMines(row - 1, column) == 0 && this.getValue(row - 1, column) != 2) {
                    this.setValue(row - 1, column, 2);
                    this.reveal(row - 1, column);
                }
                if (this.touchingMines(row - 1, column) != 0) this.setValue(row - 1, column, 2);
            }

            if (row > 0 && row < this.getMaxRow()){
                if (this.touchingMines(row + 1, column) == 0 && this.getValue(row + 1, column) != 2) {
                    this.setValue(row + 1, column, 2);
                    this.reveal(row + 1, column);
                }
                if (this.touchingMines(row + 1, column) != 0) this.setValue(row + 1, column, 2);

                if (this.touchingMines(row - 1, column) == 0 && this.getValue(row - 1, column) != 2) {
                    this.setValue(row - 1, column, 2);
                    this.reveal(row - 1, column);
                }
                if (this.touchingMines(row - 1, column) != 0) this.setValue(row - 1, column, 2);
            }

            return;
        }

        if (row == 0 && column == 0){

            if (this.touchingMines(row, column + 1) == 0 && this.getValue(row, column + 1) != 2) {this.setValue(row, column + 1, 2); this.reveal(row, column + 1);}
            if (this.touchingMines(row, column + 1) != 0) this.setValue(row, column + 1, 2);

            if (this.touchingMines(row + 1, column) == 0 && this.getValue(row + 1, column) != 2) {this.setValue(row + 1, column, 2); this.reveal(row + 1, column);}
            if (this.touchingMines(row + 1, column) != 0) this.setValue(row + 1, column, 2);

            if (this.touchingMines(row + 1, column + 1) == 0 && this.getValue(row + 1, column + 1) != 2) {this.setValue(row + 1, column + 1, 2); this.reveal(row + 1, column + 1);}
            if (this.touchingMines(row + 1, column + 1) != 0) this.setValue(row + 1, column + 1, 2);
        }

        if (row == 0 && column > 0 && column < this.getMaxColumn()){

            if (this.touchingMines(row, column - 1) == 0 && this.getValue(row, column - 1) != 2) {this.setValue(row, column - 1, 2); this.reveal(row, column - 1);}
            if (this.touchingMines(row, column - 1) != 0) this.setValue(row, column - 1, 2);

            if (this.touchingMines(row, column + 1) == 0 && this.getValue(row, column + 1) != 2) {this.setValue(row, column + 1, 2); this.reveal(row, column + 1);}
            if (this.touchingMines(row, column + 1) != 0) this.setValue(row, column + 1, 2);

            if (this.touchingMines(row + 1, column - 1) == 0 && this.getValue(row + 1, column - 1) != 2) {this.setValue(row + 1, column - 1, 2); this.reveal(row + 1, column - 1);}
            if (this.touchingMines(row + 1, column - 1) != 0) this.setValue(row + 1, column - 1, 2);

            if (this.touchingMines(row + 1, column) == 0 && this.getValue(row + 1, column) != 2) {this.setValue(row + 1, column, 2); this.reveal(row + 1, column);}
            if (this.touchingMines(row + 1, column) != 0) this.setValue(row + 1, column, 2);

            if (this.touchingMines(row + 1, column + 1) == 0 && this.getValue(row + 1, column + 1) != 2) {this.setValue(row + 1, column + 1, 2); this.reveal(row + 1, column + 1);}
            if (this.touchingMines(row + 1, column + 1) != 0) this.setValue(row + 1, column + 1, 2);
        }

        if (row == 0 && column == this.getMaxColumn()){

            if (this.touchingMines(row, column - 1) == 0 && this.getValue(row, column - 1) != 2) {this.setValue(row, column - 1, 2); this.reveal(row, column - 1);}
            if (this.touchingMines(row, column - 1) != 0) this.setValue(row, column - 1, 2);

            if (this.touchingMines(row + 1, column - 1) == 0 && this.getValue(row + 1, column - 1) != 2) {this.setValue(row + 1, column - 1, 2); this.reveal(row + 1, column - 1);}
            if (this.touchingMines(row + 1, column - 1) != 0) this.setValue(row + 1, column - 1, 2);

            if (this.touchingMines(row + 1, column) == 0 && this.getValue(row + 1, column) != 2) {this.setValue(row + 1, column, 2); this.reveal(row + 1, column);}
            if (this.touchingMines(row + 1, column) != 0) this.setValue(row + 1, column, 2);
        }

        if (row > 0 && row < this.getMaxRow() && column == 0){

            if (this.touchingMines(row - 1, column) == 0 && this.getValue(row - 1, column) != 2) {this.setValue(row - 1, column, 2); this.reveal(row - 1, column);}
            if (this.touchingMines(row - 1, column) != 0) this.setValue(row - 1, column, 2);

            if (this.touchingMines(row - 1, column + 1) == 0 && this.getValue(row - 1, column + 1) != 2) {this.setValue(row - 1, column + 1, 2); this.reveal(row - 1, column + 1);}
            if (this.touchingMines(row - 1, column + 1) != 0) this.setValue(row - 1, column + 1, 2);

            if (this.touchingMines(row, column + 1) == 0 && this.getValue(row, column + 1) != 2) {this.setValue(row, column + 1, 2); this.reveal(row, column + 1);}
            if (this.touchingMines(row, column + 1) != 0) this.setValue(row, column + 1, 2);

            if (this.touchingMines(row + 1, column) == 0 && this.getValue(row + 1, column) != 2) {this.setValue(row + 1, column, 2); this.reveal(row + 1, column);}
            if (this.touchingMines(row + 1, column) != 0) this.setValue(row + 1, column, 2);

            if (this.touchingMines(row + 1, column + 1) == 0 && this.getValue(row + 1, column + 1) != 2) {this.setValue(row + 1, column + 1, 2); this.reveal(row + 1, column + 1);}
            if (this.touchingMines(row + 1, column + 1) != 0) this.setValue(row + 1, column + 1, 2);
        }

        if (row > 0 && row < this.getMaxRow() && column == this.getMaxColumn()){

            if (this.touchingMines(row - 1, column - 1) == 0 && this.getValue(row - 1, column - 1) != 2) {this.setValue(row - 1, column - 1, 2); this.reveal(row - 1, column - 1);}
            if (this.touchingMines(row - 1, column - 1) != 0) this.setValue(row - 1, column - 1, 2);

            if (this.touchingMines(row - 1, column) == 0 && this.getValue(row - 1, column) != 2) {this.setValue(row - 1, column, 2); this.reveal(row - 1, column);}
            if (this.touchingMines(row - 1, column) != 0) this.setValue(row - 1, column, 2);

            if (this.touchingMines(row, column - 1) == 0 && this.getValue(row, column - 1) != 2) {this.setValue(row, column - 1, 2); this.reveal(row, column - 1);}
            if (this.touchingMines(row, column - 1) != 0) this.setValue(row, column - 1, 2);

            if (this.touchingMines(row + 1, column - 1) == 0 && this.getValue(row + 1, column - 1) != 2) {this.setValue(row + 1, column - 1, 2); this.reveal(row + 1, column - 1);}
            if (this.touchingMines(row + 1, column - 1) != 0) this.setValue(row + 1, column - 1, 2);

            if (this.touchingMines(row + 1, column) == 0 && this.getValue(row + 1, column) != 2) {this.setValue(row + 1, column, 2); this.reveal(row + 1, column);}
            if (this.touchingMines(row + 1, column) != 0) this.setValue(row + 1, column, 2);
        }

        if (row == this.getMaxRow() && column == 0){

            if (this.touchingMines(row - 1, column) == 0 && this.getValue(row - 1, column) != 2) {this.setValue(row - 1, column, 2); this.reveal(row - 1, column);}
            if (this.touchingMines(row - 1, column) != 0) this.setValue(row - 1, column, 2);

            if (this.touchingMines(row - 1, column + 1) == 0 && this.getValue(row - 1, column + 1) != 2) {this.setValue(row - 1, column + 1, 2); this.reveal(row - 1, column + 1);}
            if (this.touchingMines(row - 1, column + 1) != 0) this.setValue(row - 1, column + 1, 2);

            if (this.touchingMines(row, column + 1) == 0 && this.getValue(row, column + 1) != 2) {this.setValue(row, column + 1, 2); this.reveal(row, column + 1);}
            if (this.touchingMines(row, column + 1) != 0) this.setValue(row, column + 1, 2);
        }

        if (row == this.getMaxRow() && column > 0 && column < this.getMaxColumn()){

            if (this.touchingMines(row - 1, column - 1) == 0 && this.getValue(row - 1, column - 1) != 2) {this.setValue(row - 1, column - 1, 2); this.reveal(row - 1, column - 1);}
            if (this.touchingMines(row - 1, column - 1) != 0) this.setValue(row - 1, column - 1, 2);

            if (this.touchingMines(row - 1, column) == 0 && this.getValue(row - 1, column) != 2) {this.setValue(row - 1, column, 2); this.reveal(row - 1, column);}
            if (this.touchingMines(row - 1, column) != 0) this.setValue(row - 1, column, 2);

            if (this.touchingMines(row - 1, column + 1) == 0 && this.getValue(row - 1, column + 1) != 2) {this.setValue(row - 1, column + 1, 2); this.reveal(row - 1, column + 1);}
            if (this.touchingMines(row - 1, column + 1) != 0) this.setValue(row - 1, column + 1, 2);

            if (this.touchingMines(row, column - 1) == 0 && this.getValue(row, column - 1) != 2) {this.setValue(row, column - 1, 2); this.reveal(row, column - 1);}
            if (this.touchingMines(row, column - 1) != 0) this.setValue(row, column - 1, 2);

            if (this.touchingMines(row, column + 1) == 0 && this.getValue(row, column + 1) != 2) {this.setValue(row, column + 1, 2); this.reveal(row, column + 1);}
            if (this.touchingMines(row, column + 1) != 0) this.setValue(row, column + 1, 2);
        }

        if (row == this.getMaxRow() && column == this.getMaxColumn()){

            if (this.touchingMines(row - 1, column - 1) == 0 && this.getValue(row - 1, column - 1) != 2) {this.setValue(row - 1, column - 1, 2); this.reveal(row - 1, column - 1);}
            if (this.touchingMines(row - 1, column - 1) != 0) this.setValue(row - 1, column - 1, 2);

            if (this.touchingMines(row - 1, column) == 0 && this.getValue(row - 1, column) != 2) {this.setValue(row - 1, column, 2); this.reveal(row - 1, column);}
            if (this.touchingMines(row - 1, column) != 0) this.setValue(row - 1, column, 2);

            if (this.touchingMines(row, column - 1) == 0 && this.getValue(row, column - 1) != 2) {this.setValue(row, column - 1, 2); this.reveal(row, column - 1);}
            if (this.touchingMines(row, column - 1) != 0) this.setValue(row, column - 1, 2);
        }

        if (row > 0 && row < this.getMaxRow() && column > 0 && column < this.getMaxColumn()) {

            if (this.touchingMines(row - 1, column - 1) == 0 && this.getValue(row - 1, column - 1) != 2) {this.setValue(row - 1, column - 1, 2); this.reveal(row - 1, column - 1);}
            if (this.touchingMines(row - 1, column - 1) != 0) this.setValue(row - 1, column - 1, 2);

            if (this.touchingMines(row - 1, column) == 0 && this.getValue(row - 1, column) != 2) {this.setValue(row - 1, column, 2); this.reveal(row - 1, column);}
            if (this.touchingMines(row - 1, column) != 0) this.setValue(row - 1, column, 2);

            if (this.touchingMines(row - 1, column + 1) == 0 && this.getValue(row - 1, column + 1) != 2) {this.setValue(row - 1, column + 1, 2); this.reveal(row - 1, column + 1);}
            if (this.touchingMines(row - 1, column + 1) != 0) this.setValue(row - 1, column + 1, 2);

            if (this.touchingMines(row, column - 1) == 0 && this.getValue(row, column - 1) != 2) {this.setValue(row, column - 1, 2); this.reveal(row, column - 1);}
            if (this.touchingMines(row, column - 1) != 0) this.setValue(row, column - 1, 2);

            if (this.touchingMines(row, column + 1) == 0 && this.getValue(row, column + 1) != 2) {this.setValue(row, column + 1, 2); this.reveal(row, column + 1);}
            if (this.touchingMines(row, column + 1) != 0) this.setValue(row, column + 1, 2);

            if (this.touchingMines(row + 1, column - 1) == 0 && this.getValue(row + 1, column - 1) != 2) {this.setValue(row + 1, column - 1, 2); this.reveal(row + 1, column - 1);}
            if (this.touchingMines(row + 1, column - 1) != 0) this.setValue(row + 1, column - 1, 2);

            if (this.touchingMines(row + 1, column) == 0 && this.getValue(row + 1, column) != 2) {this.setValue(row + 1, column, 2); this.reveal(row + 1, column);}
            if (this.touchingMines(row + 1, column) != 0) this.setValue(row + 1, column, 2);

            if (this.touchingMines(row + 1, column + 1) == 0 && this.getValue(row + 1, column + 1) != 2) {this.setValue(row + 1, column + 1, 2); this.reveal(row + 1, column + 1);}
            if (this.touchingMines(row + 1, column + 1) != 0) this.setValue(row + 1, column + 1, 2);
        }
    }


    public boolean win (){
        for (int i = 0; i <= this.getMaxRow(); i++) {
            for (int j = 0; j <= this.getMaxColumn(); j++) {
                if (this.board[i][j] == 0) return false;
            }
        }
        return true;
    }


    public boolean noFlags(){
        for (int i = 0; i <= this.getMaxRow(); i++) {
            for (int j = 0; j <= this.getMaxColumn(); j++) {
                if (flags[i][j] == 1) return false;
            }
        }
        return true;
    }


}
