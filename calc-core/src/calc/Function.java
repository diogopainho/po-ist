package calc;
import java.util.*;

public abstract class Function extends Content {

private String name;

public Function(){
super();
}

public Function(String n){
name = n;
}

public String getName(){
return name;
}

public void setName(String n){
name = n;
}

}