package sudokusolver;

public class SudokuCmd{
    public static void help(Object[] param){
        System.out.println("helpd");
    }

    public static void input(Object[] param){
        String[][] s = new String[9][9];
        for(int i = 0; i < 9; i++){
            s[i] = SudokuMain.user.nextLine().split("");
        }
        Sudoku sud = new Sudoku( 3, new String[]{"1","2","3","4","5","6","7","8","9"}, "0", s);
        System.out.println("\n\n\n" + sud.displayBoard());

        sud.initializeWFC();
        sud.solve();
    }

    public static void solve(Object[] param){
        
    }

    public static void echo(Object[] param){
        for(Object word : param) System.out.println((String)word);
    }

    public static void quit(Object[] param){
        System.exit(1);
    }
}
