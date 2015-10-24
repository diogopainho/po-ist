package calc; 
 import java.util.*;
 
public class BynaryFunction extends Function{

private Reference ref1;
private Reference ref2;
private int int1;
private int int2;

private int result;


public BynaryFunction(){

ref1=null;
ref2=null;
int1=0;
int2=0;
}



public BynaryFunction(String s1, String s2){

ref1=new Reference(s1);
ref2=new Reference(s2);
int1=0;
int2=0;
}

public BynaryFunction(String s1, int i2){

ref1=new Reference(s1);
ref2=null;
int1=0;
int2=i2;
}

public BynaryFunction(int i1, String s2){

ref1=null;
ref2=new Reference(s2);
int1=i1;
int2=0;
}

public BynaryFunction(int i1, int i2){

ref1=null;
ref2=null;
int1=i1;
int2=i2;
}





public String toString(){
String toReturn= "";
if(ref1!=null) toReturn+=ref1;
if(ref2!=null) toReturn+=", " + ref2;
if(int1!=0) toReturn+=int1;
if(int2!=0) toReturn+=", " + int2;

return super.toString() + toReturn;
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

public int getInt1(){

return int1;
}

public int getInt2(){

return int2;
}

public void setInt1(int inter){

int1=inter;
}

public void setInt2(int inter){

int2=inter;
}


public int getResult(){

return result;
}

public void setResult(int i){
result=i;
}
}
