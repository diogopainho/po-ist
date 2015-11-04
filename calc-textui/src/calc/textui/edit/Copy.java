/** @version $Id: Copy.java,v 1.8 2013-11-29 00:58:51 ist172992 Exp $ */
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
 * Copy command.
 */
 
public class Copy extends Command<Table t>{

	
	public Copy(Table t) {
		super(false, MenuEntry.COPY, T);
	}

	/** 
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
        public final void execute() throws DialogException, IOException {
                
               String range = IO.readString(Message.adressRequest());
               
               if(_receiver.show(range) == "invalid_range"){
               
               InvalidCellRange in = new InvalidCellRange(range);
               IO.println("Copiar: Operação inválida" + in.getMessage());
               }
               else _receiver.copyCell(range);
        }

}
