package calc;
import java.util.*;
import java.io.Serializable;
import java.io.IOException;

public class Table implements Serializable{

private Cell[][] table;
private String name = "default";
private int columns;
private int lines;
private cutBuffer _cutBuffer = new cutBuffer();
private boolean initializaded = false;
private TreeMap<String, String> pointingTo_refAdress = new TreeMap<String, String>();
private TreeMap<String, String> bynFuncRefs = new TreeMap<String, String>();
private boolean modified = false;

public Table(){
table = null;
columns = 0;
lines = 0;
_cutBuffer = null;
initializaded = true;

}

public Table(String nam, int lin, int col){
name = nam;
lines = lin;
columns = col;
initializaded = true;
Cell[][] table = new Cell[lin + 1][col + 1];
}

public Table(int lin, int col){
lines = lin;
columns = col; 
initializaded = true;
table = new Cell[lin+1][col + 1];
}

/*********************************GETTERS***********************/
public Cell getCell(int lin, int col){
if(table != null)
return table[lin][col];
else return null;
}

public Cell[][] getTable(){
return table;
}

public String toString(){
return name;
}

public String getName(){
return name;
}

public boolean getInitialized(){
return initializaded;
}

public boolean getModified(){
return modified;
}

public int getCol(){
return columns;
}

public int getLin(){
return lines;
}

public TreeMap getTree(){
return pointingTo_refAdress;
}

public TreeMap getBynFuncTree(){
return bynFuncRefs;
}
/*********************************SETTERS***********************/
public void setCell(int lin, int col, Cell c){
if(getInitialized()){
  if(getCell(lin, col) != null){
  table[lin][col]=c;
  }
}
}

public void setName(String nam){
name = n;
}

public void modified(){
return modified;
}
/*********************************SHOW***********************/

public String show(String s) throws NullPointerExecption{

int a = s.indexOf(":");
if(a==-1){                           /* Se for um endereco*/
int line, col;
String toSplit=s;
String toPrint= "noCell";
} 
/* Check if one cell */
String[] parse;
String delims = "[;]";

parse = toSplit.split(delims);

line = Integer.parseInt(parse[0]);
col = Integer.parseInt(parse[1]);

if(this.getCell(line,col) != null){
  if(getCell(line, col).gethasCont() || getCell(line,col).getDeleted(){
    toPrint = s + "|" + getCell(line,col).toString();
  }else {
      toPrint = s + "|" + getCell(line,col).toString();
   }
   return toPrint; 
   }else return showRange(s);

}

/*********************************SHOWRANGE***********************/
public String showRange(String s) throws NullPointerExecption{
int lin1, lin2, col1, col2;

String toSplit = s;
String toPrint = "";

/* Check if one cell */

String[] parse;
String delims = "[:]";

parse = toSplit.split(delims);
lin1 = Integer.parseInt(parse[0]);
col1 = Integer.parseInt(parse[1]);
lin2 = Integer.parseInt(parse[2]);
col2 = Integer.parseInt(parse[3]);

if(lin1 > getLin() || lin2 > getLin() || col1 > getCol() || col2 > getCol()){
  String error = "invalid_range";
  return error;
  }else {
    if(getTable() !=null {
      if(lin1 == lin2){ /* HORIZONTAL */
	for(int i = col1; i <= col2; i++){
	  toPrint += "" + lin1 + ";"+ i + "|" + getCell(lin1, i).toString();
	  if(i != col2) to print += "\n";
	}
    return toPrint;
      } else if (col1 == col2) {
	  for(int j = lin1; j<=lin2; j++){
	    toPrint += "" + j + ";" + col1 + "|" + getCell(j, col1).toString();
	    if(j != lin2) toPrint += "\n";
	  }
      return toPrint;
      }
  }

} return "invalid_range";

}


/*********************************INSERT***********************/
public void insertCell(int lin; int col; Content cont) throws NullPointerExecption{
 Cell c = new Cell(cont);
 if(getInitialized()){
  this.setCell(lin, col, cont);
  update();
 }
modified();
}


public void insert(String position, String[] cont) throws IOException, ClassNotFoundException, NumberFormatException, NullPointerExecption{

int a = position.indexOf(":"); 
if(a != -1){                      /* Se nao tiver : o range está mal */
  insertRange(position,cont);
} else {

String[] parse = cont;
int content = -1;
String line = " ";
String[] local;
String delims = "[;]";
local = position.split(delims);
int one = Integer.parseInt(local[0]); /* Guarda a posicao 1 */
int two = Integer.parseInt(local[1]); /* Guarda a posicao 2 */

if(integer(parse[2]) && (parse.length == 3)){
  content = Integer.parseInt(parse[2]);
  Literal lit = new Literal(content);
  getCell(one, two).setContent(lit);

} else {
  int ref_line; ref_col;
  if(integer(parse[3]) && integer(parse[4]){
    ref_line = Integer.parseInt(parse[3]);
    ref_col = Integer.parseInt(parse[4]);
    String ref = parse[3] + ";" + parse[4];
    String adress = one + ";" + two;
    Cell c = getCell(ref_line, ref_col);
    Reference r = new Reference(c, ref);
    getTree().put(ref, adress);
    getCell(one, two).setContent(r);
  
  } else if (parse[3].equals("ADD") || parse[3].equals("DIV") || parse[3].equals("MUL") || parse[3].equals("SUB")) {
     insertCellBynaryFunction(one, two, parse);
  } else if (parse[3].equals("PRD") || parse[3].equals("AVG")){
      insertCellRangedFunction(one, two, parse);
  }
}
} update();
}

public void insertRange(String, range, String[] parse) throws IOException, ClassNotFoundException, NumberFormatException, NullPointerExecption{

String position = range;
String[] go = new String[parse.length-1];
String[] local;
String delims = "[:]";
local = position.split(delims);
int lin1 = Integer.parseInt(local[0]);
int col1 = Integer.parseInt(local[1]);
int lin2 = Integer.parseInt(local[2]);
int col2 = Integer.parseInt(local[3]);

if(lin1 == lin2){
  for(int i = col1; i<= col2; i++){
    String adr = lin1 + ";" + i;
    go[0]="" + lin1;
    go[1]="" + i;
    
    for(int m = 0; m<parse.length-1; m++){
      if(m>1){
	go[m]=parse[m+1];
      }
    }
    insert(adr, go);
  }

} else if(col1 == col2){
    for(int j = lin1; i<= lin2; i++){
    String adr = j + ";" + col1;
    go[0]="" + j;
    go[1]="" + col1;
    
    for(int m = 0; m<parse.length-1; m++){
      if(m>1){
	go[m]=parse[m+1];
      }
    }
    insert(adr, go);
  }

}
}

public void insertCellBynaryFunction(int one, int two, String[] parse) throws IOException, ClassNotFoundException, NumberFormatException, NullPointerExecption{

String function = parse[3];
int one1, two2, three3, four4; /* Opcoes ADD(1;1,1;2) ou ADD(1,1:2) ou ADD(1,2) */

if(parse.length==5){
  String[] virgula;
  String pls = parse[4];
  String delims2 = "[,]";
  virgula = pls.split(delims2);
  one1 = Integer.parseInt(virgula[0]);
  two2 = Integer.parseInt(virgula[1]);
  
  if(function.equals("ADD")){
    ADD add = new ADD(one1, two2);
    getCell(one, two).setContent(add);
  
  } else if(function.equals("MUL")){
    MUL mul = new MUL(one1, two2);
    getCell(one, two).setContent(mul);
  
  } else if(function.equals("DIV")){
    DIV div = new DIV(one1, two2);
    getCell(one, two).setContent(div);
  
  }else if(function.equals("SUB")){
    SUB sub = new SUB(one1, two2);
    getCell(one, two).setContent(sub);
  }
 } else if(parse.length == 6){
    int a = parse[4].indexOf(",");
    int b = parse[5].indexOf(",");
    
    if(a == -1 && b != -1){
      one1 = Integer.parseInt(parse[4]);
      String[] parse2;
      String pls = parse[5];
      String delims2 = "[,]";
      parse2 = pls.split(delims2);
      two2 = Integer.parseInt(parse2[0]);
      three3 = Integer.parseInt(parse2[1]);
      Cell c = getCell(one1, two2);
      Reference newRef = new Reference(c, one1 + ";" + two2);
      String pointing_to = one1 + ";" + two;
      
      if(function.equals("ADD")){
	ADD add = new ADD(newRef, three3);
	getCell(one, two).setContent(add);
	getBynFuncTree().put(pointing_to, local);
      
      }else if(function.equals("MUL")){
	MUL mul = new MUL(newRef, three3);
	getCell(one, two).setContent(mul);
	getBynFuncTree().put(pointing_to, local);
      
      }else if(function.equals("DIV")){
	DIV div = new DIV(newRef, three3);
	getCell(one, two).setContent(div);
	getBynFuncTree().put(pointing_to, local);
      
      }else if(function.equals("SUB")){
	SUB sub = new SUB(newRef, three3);
	getCell(one, two).setContent(sub);
	getBynFuncTree().put(pointing_to, local);
      }
    }else if(a != 1 && b == 1) { /* A virgula esta no parse[3] */
    
    three3 =  Integer.parseInt(parse[5]);
				  String[] parse2;
				  String pls = parse[4];
				  String delims2 = "[,]";
				  parse2 = pls.split(delims2);
				  one1 = Integer.parseInt(parse2[0]);
				  two2 = Integer.parseInt(parse2[1]);
				  Cell c = getCell(two2, three3);
				  Reference newRef = new Reference(c, two2 + ";" + three3);
				  String pointing_to = two2 + ";" + three3;
				  String local = one + ";" + two; 
				 
				  if(function.equals("ADD")){
				  ADD add = new ADD(one1, newRef);
				  //insertCell(one, two, add);
				   getCell(one, two).setContent(add);
				   getBynFuncTree().put(pointing_to,local);
				  } else 
				  if(function.equals("MUL")){
				  MUL func = new MUL(one1, newRef);
				 // insertCell(one, two, func);
				    getCell(one, two).setContent(func);
				  getBynFuncTree().put(pointing_to,local);
				  } else
				  if(function.equals("DIV")){
				  DIV func = new DIV(one1, newRef);
				  //insertCell(one, two, func);
				    getCell(one, two).setContent(func);
				  getBynFuncTree().put(pointing_to,local);
	  
				  } else 
				  if(function.equals("SUB")){
				  SUB func = new SUB(one1, newRef);
				//  insertCell(one, two, func);
				    getCell(one, two).setContent(func);
				  getBynFuncTree().put(pointing_to,local);
				  }
				 
				      
					  }} else if(parse.length==7){ /* tem 2 referencias */
					  
					  
					 
					  int l1, l2, c1, c2;
					    l1 =  Integer.parseInt(parse[4]);
					    c2 =  Integer.parseInt(parse[6]);
					    String[] parse2;
					    String pls = parse[5];
					    String delims2 = "[,]";
					    parse2 = pls.split(delims2);
					    c1 = Integer.parseInt(parse2[0]);
					    l2 = Integer.parseInt(parse2[1]);
					    Cell cell1 = getCell(l1, c1);
					    Cell cell2 = getCell(l2, c2);
					    Reference newRef1 = new Reference(cell1, l1 + ";" + c1);
					    Reference newRef2 = new Reference(cell2, l2 + ";" + c2);
					    String reference1 = l1 + ";" + c1;
					    String reference2 = l2 + ";" + c2;
					    String adress1 = one + ";" + two;
					
					    
					      if(function.equals("ADD")){
					     
					    ADD add = new ADD(newRef1, newRef2);
					    insertCell(one, two, add);
					    getBynFuncTree().put(reference1,adress1);
					    getBynFuncTree().put(reference2,adress1);
					    
					    } else 
					    if(function.equals("MUL")){
					  
					    MUL func = new MUL(newRef1, newRef2);
					    insertCell(one, two, func);
					     getBynFuncTree().put(reference1,adress1);
					    getBynFuncTree().put(reference2,adress1);
					    
					    } else
					    if(function.equals("DIV")){
					    DIV func = new DIV(newRef1, newRef2);
					    insertCell(one, two, func);
					      getBynFuncTree().put(reference1,adress1);
					    getBynFuncTree().put(reference2,adress1);
	  
					    } else 
					    if(function.equals("SUB")){
					    SUB func = new SUB(newRef1, newRef2);
					    insertCell(one, two, func);
					     getBynFuncTree().put(reference1,adress1);
					    getBynFuncTree().put(reference2,adress1);
					    }
				 
					  
					  }}
	
						  
public void insertCellRangedFunction(int one, int two, String[] parse) throws IOException, ClassNotFoundException, NumberFormatException, NullPointerException{



/* AVG(1;2:1;19); */

String function = parse[3];

String[] s;
String delims = "[:]";

s = parse[5].split(delims);

/* parse: 3/(4 ; 5 ; 6) */

int lin1 = Integer.parseInt(parse[4]);
int col1 = Integer.parseInt(s[0]);
int lin2 = Integer.parseInt(s[1]);
int col2 = Integer.parseInt(parse[6]);

String range = lin1 + ";" + col1 + ":" + lin2 + ";" + col2;
/* Assume range possible, verification is made before */

/*RangedFunction(String range, ArrayList<Cell> args)*/

ArrayList<Cell> args = new ArrayList<Cell>();


    if(lin1==lin2){ /* HORIZONTAL */

	for(int i = col1; i <= col2 ; i++){

	  args.add(getCell(lin1,i));
 
 } 
 
 
 
 }  else if (col1==col2){ /* VERTICAL */

	for(int j = lin1; j <= lin2 ; j++){
	
	  args.add(getCell(j,col1));
   
 } }
 
 if(function.equals("AVG")){
 AVG avg = new AVG(range, args);
 insertCell(one, two, avg);
 
 } else if(function.equals("PRD")){
 PRD prd = new PRD(range, args);
 insertCell(one, two, prd);


}}

    } 
 
 
 }

}

/*************************DELETE*********************/
public void deleteCell(String adress){

int a = adress.indexOf(":");
if(a == -1){
  int row, col;
  String delims=";";
  String[] tokens = adress.split(delims);
  row = Integer.parseInt(tokens[0]);
  col = Integer.parseInt(tokens[1]);
  table[row][col].deleteContent();

  } else {
    String[] s;
    String delims = "[:;]";
    
    s = adress.split(delims);
    
    int lin1 = Integer.parseInt(s[0]);
    int col1 = Integer.parseInt(s[1]);
    int lin2 = Integer.parseInt(s[2]);
    int col2 = Integer.parseInt(s[3]);
    
    if(lin1==lin2){ /* HORIZONTAL */

	for(int i = col1; i <= col2 ; i++){
	
	String add = lin1 + ";" + i;

	 
	  deleteCell(add);
 
 } 
 }  else if (col1==col2){ /* VERTICAL */

	for(int j = lin1; j <= lin2 ; j++){
	
	  
	String add = j + ";" + col1;

	 
	  deleteCell(add);
   
 } 
 }
 }
 
}

/*************************CUT*********************/
public void cutCell(String adress){

int a = adress.indexOf(":");
if(a==-1){ 

copyCell(adress);


deleteCell(adress);

}
else {

String[] s;
String delims = "[:;]";

s = adress.split(delims);

/* parse: 3/(4 ; 5 ; 6) */

int lin1 = Integer.parseInt(s[0]);
int col1 = Integer.parseInt(s[1]);
int lin2 = Integer.parseInt(s[2]);
int col2 = Integer.parseInt(s[3]);


   if(lin1==lin2){ /* HORIZONTAL */

	for(int i = col1; i <= col2 ; i++){
	
	String add = lin1 + ";" + i;

	 copyCell(add);
	  deleteCell(add);
 
 } 
 
 
 
 }  else if (col1==col2){ /* VERTICAL */

	for(int j = lin1; j <= lin2 ; j++){
	
	  
	String add = j + ";" + col1;

	  copyCell(add);
	  deleteCell(add);
   
 } }
 }}
 
/***********************  COPY ************************/
public void copyCell(String adress){

int a = adress.indexOf(":");
if( a == -1){
  Cell c;
  int row, col;
  String delims = ";";
  String[] tokens = adress.split(delims);
  row=Integer.parseInt(tokens[0]);
  col=Integer.parseInt(tokens[1]);
  c = getCell(row,col);
  _cutBuffer.addCell(adress, c);
 
} else {
  Cell c;
  ArrayList<Cell> list = new ArrayList<Cell>();
  String[] s;
  String delims = "[:;]";
  
  s = adress.split(delims);
  
  int lin1 = Integer.parseInt(s[0]);
int col1 = Integer.parseInt(s[1]);
int lin2 = Integer.parseInt(s[2]);
int col2 = Integer.parseInt(s[3]);


   if(lin1==lin2){ /* HORIZONTAL */
   
  

	for(int i = col1; i <= col2 ; i++){
	
	
		
		String add = lin1 + ";" + i;
		c = getCell(lin1, i);
		list.add(c);
	}
 
 
 
 
 }  else if (col1==col2){ /* VERTICAL */
 


	for(int j = lin1; j <= lin2 ; j++){
	
	String add = j + ";" + col1;
		c = getCell(j, col1);
		list.add(c);
   
 }
 }_cutBuffer.addRange(adress,list);

}


}

public void pasteCell(String adress){

if(_cutBuffer != null){
  int a = adress.indexOf(":");
  if(a == -1){
  Cell c;
  int row, col;
  String delims = ";";
  String[] tokens = adress.split(delims);
  row = Integer.parseInt(tokens[0]);
  col = Integer.parseInt(tokens[1]);
  
  for(Map.Entry<String, Cell> entry: _cutBuffer.getMap().entrySet()){
  String ad = entry.getKey();
  Cell cell = entry.getValue();
  
  if(_cutBuffer.getType() == 0){
    setCell(row, col, cell);
    
    if(col >= columns)
    break;
    col++;
  } else {
    setCell(row, col, cell);
    if(row>=lines)
    break;
    row++
  }
  
  }
  
  } else {
  
  Cell c;
  ArrayList<Cell> list = new ArrayList<Cell>();
  String[] s;
  String delims = "[:;]";
  
  s=adress.split(delims);
  
  int lin1 = Integer.parseInt(s[0]);
  int col1 = Integer.parseInt(s[1]);
  int lin2 = Integer.parseInt(s[2]);
  int col2 = Integer.parseInt(s[3]);
  
  int pos = 0;
  int ppos2 = 0;
  
  if(lin1 == lin2){
  
  for(int i = col1; i<=col2; i++)
  ppos2 = 0;
    for(Map.Entry<String, Cell> entry : _cutBuffer.getMap().entrySet()){
      if(ppos2 == pos){
      Cell cell = entry.getValue();
      setCell(lin1, i, cell);
      break;
      }else ppos2++;
    } pos++;
  }
  } else if(col2 == col1){
      for(int j = lin1; j<=lin2; j++)
  ppos2 = 0;
    for(Map.Entry<String, Cell> entry : _cutBuffer.getMap().entrySet()){
      if(ppos2 == pos){
      Cell cell = entry.getValue();
      setCell(j, col1, cell);
      break;
      }else ppos2++;
    } pos++;
  }
  }
  }
  } modified();
  }
  
public String showCutBuffer(){

String toPrint = "";

for(Map.Entry<String, Cell> entry : _cutBuffer.getMap().entrySet()){
  String local = entry.getKey();
  Cell cell = entry.getValue();
  toPrint += local + "|" + cell.toString() + "\n";

}
toPrint = toPrint.trim();
return toPrint;
} 


/**************************UPDATE********************/
public void update(){
if(getTree() != null){
  for(Map.Entry<String, String> entry : pointingTo_refAdress.entrySet()){
  String pointing = entry.getKey();
  String adress = entry.getValue();
  
  Cell c;
  Reference ref;
  int row, col, row2, col2;
  String delims= ";";
  String[] tokens = pointing.split(delims);
  String[] tokens2 = adress.split(delims);
  row = Integer.parseInt(tokens[0]);
  col = Integer.parseInt(tokens[1]);
  row2 = Integer.parseInt(tokens2[0]);
  col2 = Integer.parseInt(tokens2[1]);
  c = getCell(row, col);
  if(getCell(row2, col2).getContent() instanceof Reference){
  ref = new Reference(c, poiting);
  Cell n = new Cell(ref);
  table[row2][col2]=n;
  }
  }
if(getBynFuncTree() != null){
  for(Map.Entry<String, String> entry : bynFuncRefs.entrySet()){
  String pointing = entry.getKey();
  String adress = entry.getValue();
  Cell c;
  Reference ref;
  int row, col, row2, col2;
  String delims = ";";
  String[] tokens = pointing.split(delims);
  String[] tokens2 = adress.split(delims);
  row = Integer.parseInt(tokens[0]);
  col = Integer.parseInt(tokens[1]);
  row2 = Integer.parseInt(tokens2[0]);
  col2 = Integer.parseInt(tokens2[0]);
  c = getCell(row, col);
  ref = new Reference(c, pointing);
  BynaryFunction b = new BynaryFunction();
  
  if(getCell(row2, col2).getContent() instanceof BynaryFunction){
    b = (BynaryFunction) getCell(row2,col2).getContent();
    if(b.getRef1().getRef().equals(pointing))
	b.setRef1(ref);
    if(b.getRef28).getRef().equals(pointing))
	b.setRef2(ref);
  }
}
}
}

public boolean integer(String s){
try{
  Integer.parseInt(s);

} catch(NumberFormatException e){
  return false;
}
return true;
}
}