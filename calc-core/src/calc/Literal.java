package calc;

public class Literal extends Content{

public Literal(){
super();
}

public Literal(int i){
  super.setInt(i);
}

public String toString(){
return ""+super.getInt();
}

}