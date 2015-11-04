package calc;
import java.io.Serializable;
public class Cell implements Serializable{
private Content content;
private boolean hasCont = false;
private boolean deleted = false;

public Cell(){
content = new Content();
hasCont = false;
deleted = false;
}

public Cell(Content c){
content = c;
hasCont = true;
deleted = false;
}

public void setContent(Content cont){
content = cont;
hasCont = true;
deleted = false;
}

public boolean gethasCont(){
return hasCont;
}

public Content getContent(){
return content;
}

public void deleteConten(){
hasCont=false;
deleted=true;
content=null;
}

public boolean getDeleted(){
return deleted;
}
public String toString(){
if(content != null)
return getContent().toString();
else return " ";
}
public String accept(SearchPredicate sp){
return sp.analuze(this);
}
}