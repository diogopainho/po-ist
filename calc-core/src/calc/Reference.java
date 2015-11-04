package calc;

public class Reference extends Content {

private Cell ref_cell;
private String ref;

public Reference(Cell c, String r){
ref=r;
ref_cell = c;


if(c.gethasCont()==false || c.getContent().getInvalid())
super.setInvalid(true);
else this.setInt(ref_cell.getContent().getInt());
}

public void setRef(String s){
ref=s;
}

public String getRef(){
return ref;
}

public Cell getRefCell(){
return ref_cell;
}

public void setRefCell(Cell c){
ref_cell = c;
}

public String toString(){
if(super.getInvalid()){
return "#VALUE" + "=" + ref;
}else {
if (ref_cell.getContent() != null)
return "" + ref_cell.getContent().getInt() + "=" + ref;
else return ref_cell.toString();

}
}