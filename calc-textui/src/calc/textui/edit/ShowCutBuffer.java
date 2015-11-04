/** @version $Id: ShowCutBuffer.java,v 1.5 2013-11-26 17:01:39 ist172992 Exp $ */
package calc.textui.edit;

import java.io.IOException;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.Menu;
import calc.TableManager;
import calc.Table;


/**
 * Show cut buffer command.
 */
public class ShowCutBuffer extends Command<Table> {
	
	
	
	public ShowCutBuffer(Table T) {
		super(MenuEntry.SHOW_CUT_BUFFER, T);
		
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
        public final void execute() throws DialogException, IOException {
        
          
        IO.println(_receiver.ShowCutBuffer());
            
        }

}
