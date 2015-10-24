
package calc;
 
public class Cell{

private Content content;

public Cell(){
content=null;
}


public void setContent(Content cont){
  content=cont;
}
  
  
  
public Content getContent(){

return content;
}

public void deleteContent(){

content=null;
}


public String toString(){

  return content.toString();

}


}
