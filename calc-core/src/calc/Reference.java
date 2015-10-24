package calc; 
public class Reference extends Content{


private String ref;

private int col=-1;

private int line=-1;

private Cell[][] LaTable=null;

public Reference(String _ref){

super();
ref=_ref;
String delims=";";
String[] tokens= _ref.split(delims);
line=Integer.parseInt(tokens[0]);
col=Integer.parseInt(tokens[1]);
//LaTable=table;

}



public int getCol(){
return col;
}

public int getLine(){
return line;
}


public void setCol(int _col){
col=_col;
}

public void setLine(int _line){
line=_line;
}

public String getRef(){
return ref;
}

public void  setRef(String _ref){
ref=_ref;
}

public Cell refGetCell(){
Cell c=null;
return c;//getCell(getLine(), getCol());
}

public String toString(){
return " = "+ref;
}
public String properToString(){
return "Linha: "+ line + " Coluna " + col;
}

public Cell[][] getLaTable(){
return LaTable;
}

public void setLaTable(Cell[][] table){
LaTable=table;
}



}
