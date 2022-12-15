package sudokusolver;

import java.lang.reflect.*;
import java.util.Scanner;

public class SudokuMain{

    public static Scanner user;
    private static Class<SudokuCmd> cmd = SudokuCmd.class;;

    public static void main(String[] args){
        System.out.println("[ERROR:::incorrect_argument_amount] => use cmd-help for list of instructions");
        user = new Scanner(System.in);
        while(true){
            String inp = user.nextLine();
            Object[] INP = inp.split(" ");
            
            try {
                cmd.getMethod((String)INP[0], Object[].class).invoke(null, new Object[]{INP});
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException |
                        IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}