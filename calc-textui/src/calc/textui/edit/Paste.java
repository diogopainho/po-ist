/** @version $Id: Paste.java,v 1.6 2013-11-29 00:58:52 ist172992 Exp $ */
package calc.textui.edit;

import java.io.IOException;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.Menu;
import ist.po.ui.DialogException;
import calc.TableManager;
import calc.Table;
import calc.Cell;
import calc.Content;



/**
 * Paste command.
 */

public class Paste extends Command<Table>  {

	public Paste(Table T) {
		super(MenuEntry.PASTE, T);
}

	/** 
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
        public final void execute() throws DialogException, IOException {
        
           String range = IO.readString(Message.addressRequest());
                  
             if(_receiver.show(range)=="invalid_range"){
             
           
             InvalidCellRange in = new InvalidCellRange(range);
             
              
             IO.println("Colar: Operação inválida: " +  in.getMessage());
              }
            
              else _receiver.pasteCell(range);
        }

}
