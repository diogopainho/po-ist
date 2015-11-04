/** @version $Id: New.java,v 1.7 2013-11-29 14:36:03 ist172992 Exp $ */
package calc.textui.main;

import java.io.IOException;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.Menu; 
import calc.TableManager;

/**
 * Create a new spreadsheet.
 */
public class New extends Command<TableManager> {

	/**
	 * @param receiver
	 */
	public New(TableManager TM) {
		super(MenuEntry.NEW, TM);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
        public final void execute() throws DialogException, IOException {
               	
	    try{
             
             if(_receiver.getModificationsState()==1 || _receiver.getTable().getModified()){ //if the TableManager has been modified...
	
	       boolean decision = IO.readBoolean(Message.saveBeforeExit()); //... the user wants to save the changes 
	    
	       if(decision){  
	       
	         if ((_receiver.getTable().getName()).equals("default")){ // and if it hasn't been saved yet 
	       
		    String filename = IO.readString(Message.newSaveAs()); //the user gives the filename wanted
		    _receiver.saveAs(filename); //and the TableManager is saved
		  
	         } else { //if the TableManager already has been saved once(or more times), we already know he filename and we can save it
		    _receiver.save();
	       
	         }
	       }
	     }
              int lins = IO.readInteger(Message.linesRequest());

              int colns = IO.readInteger(Message.columnsRequest());
              
        
              _receiver.create(lins,colns);

        } 
	    
	    catch(ClassNotFoundException e) {
	      IO.println(e.getMessage());
	    }
	    
        }
        }


