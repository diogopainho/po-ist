package calc;
import java.io.Serializable;
public class Content implements Serializable{

private int _int;
private boolean invalid;

public Content(){
_int=-1;
invalid=false;
}

public void setInvalid(boolean b){
invalid = b;
}

public int getInt(){
return _int;
}

public void setInt(int i){
_int = i;
}

public String toString(){
if(invalid)
return "#VALUE";
else return "";
}

public boolean getInvalid(){
return invalid;
}
}