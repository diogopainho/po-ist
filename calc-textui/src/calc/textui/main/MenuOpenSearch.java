package calc.textui.main;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.Menu; 
import calc.TableManager;
import ist.po.ui.ValidityPredicate;
/**
 * Open search menu.
 */
public class MenuOpenSearch extends Command<TableManager>  {

	public MenuOpenSearch(TableManager TM) {
		super(MenuEntry.MENU_SEARCH, TM, new ValidityPredicate<TableManager>(TM){
		
		public boolean isValid(){
		return _receiver.hasTable();}}
		);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute()/* throws DialogException, IOException*/ {
		calc.textui.search.MenuBuilder.menuFor(_receiver);
	}

}
