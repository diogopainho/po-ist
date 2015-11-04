
/** @version $Id: Show.java,v 1.9 2013-12-01 12:08:52 ist172992 Exp $ */
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
 * Show cells command.
 */
public class Show extends Command<Table> /*FIXME: select superclass parameter */ {
	/**
	 * @param receiver
	 */
	public Show(Table T) {
		super(MenuEntry.SHOW, T);
	}
	
	@Override
        public final void execute() throws DialogException, IOException {

        
              String range = IO.readString(Message.addressRequest());

	   
	    
             if(_receiver.show(range)=="invalid_range"){
             
           
             InvalidCellRange in = new InvalidCellRange(range);
             
              
             IO.println("Visualizar: Operação inválida: " +  in.getMessage());
              }
            
              else IO.println(_receiver.show(range));


        }
        }


