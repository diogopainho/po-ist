/** @version $Id: Insert.java,v 1.9 2013-11-29 00:58:52 ist172992 Exp $ */
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
 * Insert command.
 */
public class Insert extends Command<Table>{
	/**
	 * @param receiver
	 */
	public Insert(Table T) {
		super(MenuEntry.INSERT, T);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
        public final void execute() throws DialogException, IOException{
        try{
        String range = IO.readString(Message.adressRequest());
        String content = IO.readString(Message.contentsRequest());
        
        if(_receiver.show(range) == "invalid_range"){
        
        InvalidCellRange in = new InvalidCellRange(range);
        IO.println("Inserir: Operação inválida" + in.getMessage());
        }
        else{
	  String line= " ";
	  String[] parse;
	  String delims = "[(=;|)]"
	  String content = range + "|" + cont;
	  parse = content.split(delims);
	  
	  _receiver.insert(range, parse);
        
        }
        } catch(ClassNotFoundException e){}
        
        }
}
