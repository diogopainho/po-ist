/** @version $Id: MenuBuilder.java,v 1.2 2013-11-10 13:57:48 ist172992 Exp $ */
package calc.textui.search;

import ist.po.ui.Command;
import ist.po.ui.Menu;

import calc.TableManager;

/**
 * Menu builder for search operations.
 */
public class MenuBuilder {

	/**
	 * FIXME: commands may have one or more receivers
	 */
	public static void menuFor(TableManager TM) {
		Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
				new ShowValues(TM),
				new ShowFunctions(TM),
				});
		menu.open();
	}

}
