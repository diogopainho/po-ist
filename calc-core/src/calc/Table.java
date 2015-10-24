package calc;
import java.util.*;

public class Table{

private Cell[][] table;
private String name;
private int columns;
private int lines;


public Table(){
table=null;
name=null;
columns=0;
lines=0;
}


public Table(String n, int l, int c){
name=n;
lines=l;
columns=c;
Cell[][] table = new Cell[l][c] ; 
}


/******************* INSERT  ******************/
public void insertCell(String adress, Content cont){
int row, col;
String delims=";";
String[] tokens= adress.split(delims);
row=Integer.parseInt(tokens[0]);
col=Integer.parseInt(tokens[1]);
table[row][col].setContent(cont);


}

/******************** DELETE *********************/
public void deleteCell(String adress){


int row, col;
String delims=";";
String[] tokens= adress.split(delims);
row=Integer.parseInt(tokens[0]);
col=Integer.parseInt(tokens[1]);

table[row][col].deleteContent();

}


/***********************  CUT ************************/
public Content cutCell(String adress){

Content c;
int row, col;
String delims=";";
String[] tokens= adress.split(delims);
row=Integer.parseInt(tokens[0]);
col=Integer.parseInt(tokens[1]);
c = table[row][col].getContent();
table[row][col].deleteContent();
return c;
}

/************************* OTHER************************/

public Cell getCell(int lin, int col){
return table[lin][col];
}


public Cell[][] getTable(){
return table;
}










}

