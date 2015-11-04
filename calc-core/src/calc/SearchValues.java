package calc;

public class SearchValues implements SearchPredicate{

private int value;

public SearchValues(int i){

value = i;
}

public String analyze(Cell c){
  if(c.gethasCont())
  if(c.getContent().getInt() ==value){
    return c.toString();
  } else return new String();
else return new String();
}

}