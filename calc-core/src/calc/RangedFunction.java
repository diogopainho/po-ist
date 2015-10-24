package calc; 
 import java.util.*;
 
public class RangedFunction extends Function{

private String range;
private Reference ref1;
private Reference ref2;




public RangedFunction(){
range=null;}

public RangedFunction(String _range){
range=_range;
String delims=":";
String[] tokens= _range.split(delims);
ref1=new Reference(tokens[0]);
ref2=new Reference(tokens[1]);
}

public String toString(){


return super.toString() + ref1.toString() + ", " + ref2.toString();
}

public Reference getRef1(){

return ref1;
}

public Reference getRef2(){

return ref1;}

public void setRef1(Reference reference){

ref1=reference;}

public void setRef2(Reference reference){

ref2=reference;
}

}
