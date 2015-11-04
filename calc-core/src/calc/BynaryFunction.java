package calc;
import java.util.*;

public class BynaryFunction extends Function{

private Reference ref1=null;
private Reference ref2=null;
private int int1= -1;
private int int2= -2;
private int type=-1;
private int result; 

public BynaryFunction(){
ref1=null;
ref2=null;
int1=-1;
int2=-1;
}

public BynaryFunction(Reference r1, Reference r2){
type=1;
ref1=r1;
ref2=r2;
}

public BynaryFunction(Reference r1; int i2){
type=2;
ref1=r1;
int2 =i2;
}

public BynaryFunction(int i1, int i2){
type=3;
int1=i1;
int2=i2;
}

public BynaryFunction(int i1, Reference r2){
type=4;
int1=i1;
ref2=r2;
}

public Reference getRef1(){
return ref1;
}

public Reference getRef2(){
return ref2;
}

public void setRef1(Reference reference){
ref1 = reference;
}

public void setRef2(Reference reference){
ref2 = reference;
}

public int getInt1(){
return int1;
}

public int getInt2(){}
return int2;
}

public void setInt1(int integer){
int1=integer;
}

public void setInt2(int integer){
int2=integer;
}

public void getResult(){
return result;
}

public void setResult(int i){
result = i;
}

public int getType(){
return type;
}

public void setType(int i){
type = i;
}

public String toString(){
String toReturn="";
if(type==1){
if(ref1 !=null)
toReturn = ref1.getRef();
if(ref2 !=null)
toReturn += ","+ref2.getRef();
} else if(type == 2){
 if(ref1 != null)
 toReturn = ref1.getRef();
 if(int2 != -1)
 toReturn += ","+int2;
}else if(type==3){

if(int1!=-1)
toReturn = "" + int1;
if(int2!=-1)
toReturn+= "," + int2;
}
else if(type==4){
if(int1!=-1)
toReturn = "" + int1;
if(ref2 !=null)
toReturn += ","+ref2.getRef();
}
return "" + getResult() + "=" + getName() + "(" + toReturn + ")";
}
}