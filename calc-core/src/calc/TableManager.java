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

public class TableManager{

 private TreeMap<String,Table> table_map=new TreeMap<String,Table>();
 private String name="";
 private int modifications = 0;
 private String savedin = "nothing";




  public TableManager(String n){
        name = n;
	
    }




/**********************************++GETTERS SETTERS +++ **********************/


public int getModificationsState(){
        return modifications;
    }
public String getSavedInFile(){
        return savedin;
    }
public boolean isNotFileAssociated(){
        return (savedin.equals("nothing"));
    }
public void modified(){
        modifications = 1;
    }



/***********************   MENU COMMANDS***********************/

  public void create(){
	TableManager aux = new TableManager("managAux");
       table_map=null;
        modifications = 0;
    }
	
 public void openFile(String filename) throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
        TableManager aux = (TableManager) in.readObject();
        
    }

 public void save() throws IOException, ClassNotFoundException{
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(savedin)));
        out.writeObject(this);
        out.close();
        modifications = 0;
    }


 public void saveAs(String filename) throws IOException, ClassNotFoundException{
        savedin = filename;
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(savedin)));
        out.writeObject(this);
        out.close();
        modifications = 0;
    }











}

