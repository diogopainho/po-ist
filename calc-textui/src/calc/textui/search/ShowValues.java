/** @version $Id: ShowValues.java,v 1.5 2013-11-29 15:45:14 ist172992 Exp $ */
package calc.textui.search;

import java.io.IOException;


import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import calc.TableManager;
import calc.SearchValues;

/**
 * Class for searching values.
 */
public class ShowValues extends Command<TableManager> /*FIXME: select superclass parameter */ {
	/**
	 * @param receiver
	 */
	public ShowValues(TableManager TM) {
		super(MenuEntry.SEARCH_VALUES, TM);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
        public final void execute() throws DialogException, IOException {
               
               String value = IO.readString(Message.searchValue());

               int i = Integer.parseInt(value);
                
                for(String s: _receiver.searchCells(new SearchValues(i)))
		IO.println(s);
             
               
               
        }

}
