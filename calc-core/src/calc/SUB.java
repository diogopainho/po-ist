package calc; 
 import java.util.*;
 
public class SUB extends BynaryFunction{





public SUB(){
setName("SUB");
}

public SUB(String s1,String s2){
super(s1,s2);
setName("SUB");
}

public SUB(String s1, int i2){
super(s1,i2);
setName("SUB");
}

public SUB(int i1, String s2){
super(i1,s2);
setName("SUB");
}

public SUB(int i1, int i2){
super(i1,i2);
setName("SUB");
}


public int add(int i1, int i2){
return i1-i2;
}




public String toString(){
return super.toString();
}

}
