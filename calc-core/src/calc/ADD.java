package calc; 
 import java.util.*;
 
public class ADD extends BynaryFunction{

// I doubt this can exist
public ADD(){
setName("ADD");
}



/******* Constructors **********************/

public ADD(String s1,String s2){
super(s1,s2);
setName("ADD");
setResult(getRef1().refGetCell().getContent().getInt()+getRef2().refGetCell().getContent().getInt());
}

public ADD(String s1, int i2){
super(s1,i2);
setName("ADD");
setResult(getRef1().refGetCell().getContent().getInt()+i2);
}

public ADD(int i1, String s2){
super(i1,s2);
setName("ADD");
setResult(i1+getRef2().refGetCell().getContent().getInt());
}

public ADD(int i1, int i2){
super(i1,i2);
setName("ADD");
setResult(i1+i2);
}



public String toString(){
return super.toString();
}

}
