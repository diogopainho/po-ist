package calc;
import java.util.*;

public class RangedFunction extends Function {

private String _range;
private ArrayList<Cell> arguments = new ArrayList<Cell>();

private int result;

public RangedFunction(){
_range = null;
}

public RangedFunction(String range, ArrayList<Cell> args){
_range = range;
arguments = args;
}

public ArrayList<Cell> getArgs(){
return arguments;
}

public int getResult(){
return result;
}

public void setResult(int i){
result = i;
}

public String toString(){
if(getInvalid())
return "#VALUE" + "=" + getName() + "(" + _range + ")";
else return "" + getResult() + "=" + getName() + "(" + _range + ")";
}
}