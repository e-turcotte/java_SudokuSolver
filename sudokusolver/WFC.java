package sudokusolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class WFC{
    private HashMap<Integer,ArrayList<String>> wavefunction;
    private ArrayList<Rule> collapse;

    public WFC(ArrayList<String> possibilities, String undecidedFlag, HashMap<Integer, String> field, ArrayList<Rule> rules){
        this.wavefunction = new HashMap<Integer,ArrayList<String>>();
        for(Map.Entry<Integer,String> fieldCell : field.entrySet()){
            if(fieldCell.getValue().equals(undecidedFlag)) wavefunction.put(fieldCell.getKey(), possibilities);
            else wavefunction.put(fieldCell.getKey(),new ArrayList<String>(Arrays.asList(fieldCell.getValue())));
        }
        
        this.collapse = rules;
    }

    public void stepNarrow(){
        for(Map.Entry<Integer,ArrayList<String>> cell : wavefunction.entrySet()){
            ArrayList<String> notPossible = new ArrayList<String>();
            for(String value : cell.getValue()){
                for(Rule r : collapse){
                    if(!r.check(cell.getKey(), value)) notPossible.add(value);
                }
            }
            cell.getValue().removeAll(notPossible);
        }
    }

    public void stepCollapse(){
        HashMap<Integer,String> newIteration = new HashMap<Integer,String>();
        for(Map.Entry<Integer,ArrayList<String>> cell : wavefunction.entrySet()){
            if(cell.getValue().size() == 1) newIteration.put(cell.getKey(), cell.getValue().get(0));
            else if(cell.getValue().size() == 0) throw new IllegalStateException("=ERROR:::[WFC_CELL_POSIBILITIES_ZERO]=");
        }
    }
}

