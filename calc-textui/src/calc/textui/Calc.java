/** @version $Id: Calc.java,v 1.16 2013-11-25 14:02:35 ist172992 Exp $ */
package calc.textui;

import static ist.po.ui.Dialog.IO;

import java.io.IOException;
import ist.po.ui.Menu; 
import ist.po.ui.Command; 
import calc.TableManager;
import calc.Table;
/**
 * Class that represents the spreadsheet's textual interface.
 */
public class Calc {
  /**
   * @param args
   */
  @SuppressWarnings("nls")
  public static void main(String[] args) throws IOException, ClassNotFoundException, NullPointerException, ArrayIndexOutOfBoundsException{
 
    TableManager TM = new TableManager();
    
    String datafile = System.getProperty("import");
    

    if (datafile != null) {
    
      TM.openImportFile(datafile);
      
      TM.getTable().update();
    }

  
    calc.textui.main.MenuBuilder.menuFor(TM);
    IO.closeDown();
  }
}




