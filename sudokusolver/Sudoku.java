package sudokusolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.StringBuilder;
import java.util.Arrays;

public class Sudoku{
    private int n;
    private int N;
    private ArrayList<String> palette;
    private String nullChar;
    private HashMap<Integer, String> board;
    private WFC wfc;

    public Sudoku(int n, String[] palette, String nullChar, String[][] board){
        this.n = n;
        this.N = n*n;
        this.palette = new ArrayList<String>(Arrays.asList(palette));
        this.nullChar = nullChar;
        this.board = new HashMap<Integer,String>();
        for(int i = 0; i < this.N; i++){
            for(int j = 0; j < this.N; j++){
                this.board.put(convertPosition(new int[]{i,j}),board[i][j]);
            }
        }
        this.wfc = null;
    }

    public void initializeWFC(){
        ArrayList<Rule> rules = new ArrayList<Rule>();

        //no duplicates in column
        rules.add((int position, String possibility) -> {
            int[] rowcol = convertPosition(position);
            boolean allClear = true;
            for(int i = 0; i < N; i++){
                if(i != rowcol[0]) allClear &= !board.get(convertPosition(new int[]{i, rowcol[1]})).equals(possibility);
            }
            return allClear;
        });

        //no duplicates in row
        rules.add((int position, String possibility) -> {
            int[] rowcol = convertPosition(position);
            boolean allClear = true;
            for(int i = 0; i < N; i++){
                if(i != rowcol[1]) allClear &= !board.get(convertPosition(new int[]{rowcol[0], i})).equals(possibility);
            }
            return allClear;
        });

        //no duplicates in cell
        rules.add((int position, String possibility) -> {
            int[] rowcol = convertPosition(position);
            int[] cell = {rowcol[0]/n, rowcol[1]/n};
            boolean allClear = true;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i+cell[0]*n != rowcol[0] && j+cell[1]*n != rowcol[1]) allClear &= !board.get(convertPosition(new int[]{i+cell[0]*n, j+cell[1]*n})).equals(possibility);
                }
            }
            return allClear;
        });        

        wfc = new WFC(palette, nullChar, board, rules);
    }

    public void solve(){
        wfc.stepNarrow();
        wfc.stepCollapse();
           
    }

    public int[] convertPosition(int pos){
        int row = pos%N;
        int col = pos/N;
        return new int[]{row, col};
    }

    public int convertPosition(int[] pos){
        return pos[1]*N + pos[0];
    }

    public String displayBoard(){
        StringBuilder disp = new StringBuilder("");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                disp.append(board.get(convertPosition(new int[]{i,j})));
            }
            disp.append("\n");
        }
        return disp.toString();
    }
}
