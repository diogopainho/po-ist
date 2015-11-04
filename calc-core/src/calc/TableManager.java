package calc;
import java.util.*;

import java.io.Serializable;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TableManager implements Serializable{

private String name = "def";
private Table table;
private boolean hasTable=false;
private int modifications = 0;

public TableManager(String n){
name = n;
table = new Table();

}

public TableManager(){
table = new Table();
}


/************************GETTERS SETTERS*****************/

public int getModificationsState(){
return modifications;
}

public boolean isNotFileAssociated(){
return table.getName().equals("default");
}

public void modified(){
modifications = 1;
}

public String getName(){
return name;
}

public void setName(String n){
name = n;
}

public Table getTable(){
return table;
}

public void setTable(Table t){
table=t;
hasTable=true;
}

public boolean hasTable(){
return hasTable;
}

/**************************OTHERS*******************/
public boolean isInteger(String s){
try{
  Integer.parseInt(s);
  } catch(NumberFormatException e){
      return false;
      } return true;
}
      
/*******************MENU COMMANDS******************/

public void creat(int ls, int cls){
table = new Table(ls, cls);
}
public void openFile(String filename) throws IOException, ClassNotFoundException{
  ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
  TableManager aux = (TableManager) in.readObject();
  table = aux.getTable();
  hasTable=true;
  in.close();
}

public void save() throws IOException, ClassNotFoundException{
  ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(table.getName())));
  out.writeObject(this);
  out.close();
  modifications = 0;
}

public void saveAs(String filename) throws IOException, ClassNotFoundException{
  ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
  out.writeObject(this);
  out.close();
  modifications = 0;
}

public void openImportFile(String in) throws IOException, ClassNotFoundException, NullPointerException{
  int cols = 0;
  int lines = 0;
  int one = 0;
  int two = 0;
  
  if(in != null){
  BufferedReader inReader = new BufferedReader(new FileReader(in));
  
  String line=" ";
  String[] parse;
  String delims = "[(=;|)]";
  
  while((line = inReader.readLine()) != null){
  parse = line.split(delims);
  
  if(parse[0].equals("linhas")){
  lines=Integer.parseInt(parse[1]);
  if(cols != 0){
   setTable(new Table(lines, cols));
   hasTable=true;
   }
  }else if(parse[0].equals("colunas")){
    cols = Integer.parseInt(parse[1]);
    if(lines != 0){
    setTable(new Table(lines, cols));
    hasTable=true;
    }
  }else if(isIntenger(parse[0])){
    one = Integer.parseInt(parse[0]);
    if(isInteger(parse[1])){
      two = Integer.parseInt(parse[1]);
      String adress = one + ";" + two;
      getTable().insert(adress, parse);}
  }
  } inReader.close();
  } modified();

}

public ArrayList<String> searchCells(SearchPredicate sp){

Cell c = new Cell();
String add="";

ArrayList<String> toReturn = new ArrayList<String>();

for(int i=0; i<=getTable().getLin(); i++){
  for(int j=0; j<=getTable().getCol(); j++){
    if(getTable() != null)
      if(getTable().getCell(i,j) != null)
	c=getTable().getCell(i,j);
	if((c.accept(sp)).lenght() != 0){
	  add=i+";"+j+"|"+c.accept(sp);
	  toReturn.add(add);
    }
  }
return toReturn;
}
}
}