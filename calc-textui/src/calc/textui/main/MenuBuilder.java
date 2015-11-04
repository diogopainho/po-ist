/** @version $Id: MenuBuilder.java,v 1.9 2013-11-14 23:51:00 ist172992 Exp $ */
package calc.textui.main;

import ist.po.ui.Command;
import ist.po.ui.Menu;
import calc.TableManager;
import calc.Table;

/**
 * Menu builder for the main menu.
 */
public abstract class MenuBuilder {

	/**
	 * FIXME: commands may have one or more receivers
	 */
	public static void menuFor(TableManager TM) {
	
	
		Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
				new New(TM),
				new Open(TM),
				new Save(TM),
				new SaveAs(TM),
				new MenuOpenEdit(TM),
				new MenuOpenSearch(TM),
                                });
                                
                                menu.open();
	/*	
	}else{ Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
				new New(TM),
				new Open(TM),});
				 
				menu.open();
	
	}*/


}
}
