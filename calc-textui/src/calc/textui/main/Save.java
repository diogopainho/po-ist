
package calc.textui.main;

import java.io.IOException;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import calc.TableManager;
import ist.po.ui.Menu; 
import calc.TableManager;
import ist.po.ui.Menu; 
import ist.po.ui.ValidityPredicate;
/**
 * Command to save a file.
 */
public class Save extends Command<TableManager>  {


	public Save(TableManager TM) {
		super(MenuEntry.SAVE, TM, new ValidityPredicate<TableManager>(TM){
		
		public boolean isValid(){
		return _receiver.hasTable();}}
		);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException, NumberFormatException{
		try{
		
		
		
	   if((_receiver.getTable().getName()).equals("default")){  // If the table hasn't been saved yet, a new name must be set 
	    
	       
		
		String filename = IO.readString(Message.newSaveAs());
		
		
		_receiver.saveAs(filename);
	  		
	    } else _receiver.save();
	    
	    }catch(ClassNotFoundException e){
	}
}
}
