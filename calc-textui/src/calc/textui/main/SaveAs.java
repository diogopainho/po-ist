

package calc.textui.main;

import java.io.IOException;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.Menu; 
import calc.TableManager;
import ist.po.ui.Menu; 
import ist.po.ui.ValidityPredicate;

/**
 * Command to save a file with a new name.
 */

public class SaveAs extends Command<TableManager> {

	public SaveAs(TableManager TM) {
		super(MenuEntry.SAVE_AS, TM, new ValidityPredicate<TableManager>(TM){
		
		public boolean isValid(){
		return _receiver.hasTable();}}
		);
	}
	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
	
	try {
	    
          
            String filename = IO.readString(Message.saveAs());
            _receiver.saveAs(filename);      
            
             }
	    
	    catch(ClassNotFoundException e) {
	      IO.println(e.getMessage());
	    }
        }
}
