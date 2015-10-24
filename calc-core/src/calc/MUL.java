package calc; 
 import java.util.*;
 
public class MUL extends BynaryFunction{





public MUL(){
setName("MUL");
}

public MUL(String s1,String s2){
super(s1,s2);
setName("MUL");
}

public MUL(String s1, int i2){
super(s1,i2);
setName("MUL");
}

public MUL(int i1, String s2){
super(i1,s2);
setName("MUL");
}

public MUL(int i1, int i2){
super(i1,i2);
setName("MUL");
}


public int add(int i1, int i2){
return i1*i2;
}




public String toString(){
return super.toString();
}

}
