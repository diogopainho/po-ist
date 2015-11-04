/** @version $Id: Delete.java,v 1.5 2013-11-29 00:58:51 ist172992 Exp $ */
package calc.textui.edit;

import java.io.IOException;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.Menu;
import calc.TableManager;
import calc.Table;
import calc.Cell;
import calc.Content;

/**
 * Delete command.
 */
public class Delete extends Command<Table> /*FIXME: select superclass parameter */ {
	/**
	 * @param receiver
	 */
	public Delete(Table T) {
		super(MenuEntry.DELETE, T);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
        public final void execute() throws DialogException, IOException {
        
           String range = IO.readString(Message.addressRequest());
                  
             if(_receiver.show(range)=="invalid_range"){
             
           
             InvalidCellRange in = new InvalidCellRange(range);
             
              
             IO.println("Apagaer: Operação inválida: " +  in.getMessage());
              }
            
              else _receiver.deleteCell(range);
        }

}
