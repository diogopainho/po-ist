

package calc.textui.edit;

import ist.po.ui.Command;
import ist.po.ui.Menu;

import calc.TableManager;
import calc.Table;



/**
 * Menu builder for edit operations.
 */
public class MenuBuilder {

	
	public static void menuFor(Table T) {
		Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {

			new Show(T);
			new Insert(T);
			new Copy(T);
			new Paste(T);
			new Cut(T);
			new Delete(T);
			new ShowCutBuffer(T);
				});
		menu.open();
	}

}
