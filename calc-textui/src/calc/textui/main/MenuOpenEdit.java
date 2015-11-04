package calc.textui.main;
import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.Menu; 
import calc.TableManager;
import ist.po.ui.ValidityPredicate;
/**
 * Open edit menu.
 */
public class MenuOpenEdit extends Command<TableManager>  {

	public MenuOpenEdit(TableManager TM) {
		super(MenuEntry.MENU_CALC, TM, new ValidityPredicate<TableManager>(TM){
		
		public boolean isValid(){
		return _receiver.hasTable();}}
		);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() /*throws DialogException, IOException */{
	
		calc.textui.edit.MenuBuilder.menuFor(_receiver.getTable());
	}

}
