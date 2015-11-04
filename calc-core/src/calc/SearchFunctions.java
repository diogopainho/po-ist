package calc;

public class SearchFunction implements SearchPredicate{

private String name;

public SearchFunctions(String s){
name=s;
}

public String analyze(Cell c){

if(c.gethasCont()){
  if(c.getContent() instanceof BynaryFunction){
    BynaryFunction f = new BynaryFunction();
    f = (BynaryFunction) c.getContent();
      if(name.equals(f.getName()))
	return c.toString();
      else return new String();
  }else if(c.getContent() instanceof RangedFunction){
    RangedFunction f = new RangedFunction();
    f = (RangedFunction) c.getContent();
    if(name.equals(f.getName()))
      return c.toString();
      
      else return new String();
  } else return new String();
}else return new String();

}

}