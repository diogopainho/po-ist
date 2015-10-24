package calc; 
 import java.util.*;
 
public class DIV extends BynaryFunction{





public DIV(){
setName("DIV");
}

public DIV(String s1,String s2){
super(s1,s2);
setName("DIV");
}

public DIV(String s1, int i2){
super(s1,i2);
setName("DIV");
}

public DIV(int i1, String s2){
super(i1,s2);
setName("DIV");
}

public DIV(int i1, int i2){
super(i1,i2);
setName("DIV");
}


public int add(int i1, int i2){
return i1/i2;
}




public String toString(){
return super.toString();
}

}
