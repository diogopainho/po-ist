/** @version $Id: ShowFunctions.java,v 1.5 2013-11-29 15:45:14 ist172992 Exp $ */
package calc.textui.search;

import java.io.IOException;


import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import calc.TableManager;
import calc.SearchFunctions;

/**
 * Class for searching functions.
 */
public class ShowFunctions extends Command<TableManager> /*FIXME: select superclass parameter */ {
	/**
	 * @param receiver
	 */
	public ShowFunctions(TableManager TM) {
		super(MenuEntry.SEARCH_FUNCTIONS, TM);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
        public final void execute() throws DialogException, IOException {
        
               String function = IO.readString(Message.searchFunction());
               
            for(String s: _receiver.searchCells(new SearchFunctions(function)))
            IO.println(s);
               
        }

}
