package view;
import org.nocrala.tools.texttablefmt.*;



public class StockHelp {
    public void displayHelp(){
        Table helpTable = new Table(1,BorderStyle.CLASSIC_COMPATIBLE_LIGHT_WIDE,ShownBorders.SURROUND);
        helpTable.addCell(" 1.  Press    * : Display All Records Of Products                        ");
        helpTable.addCell(" 2.  Press    w : Add New Product                                        ");
        helpTable.addCell("     Press    w ⟶#proname-unitprice-qty : shortcut for add new product   ");
        helpTable.addCell(" 3.  Press    r : Read Content Any content                               ");
        helpTable.addCell("     Press    r ⟶#proId : shortcut for read product by Id                  ");
        helpTable.addCell(" 4.  Press    u : Update Data                                            ");
        helpTable.addCell(" 5.  Press    d : Delete Data                                            ");
        helpTable.addCell("     Press    d ⟶#proId : shortcut for delete product by Id                ");
        helpTable.addCell(" 6.  Press    f : Display First Page                                     ");
        helpTable.addCell(" 7.  Press    p : Display Previous Page                                  ");
        helpTable.addCell(" 8.  Press    n : Display Next Page                                      ");
        helpTable.addCell(" 9.  Press    l : Display Last Page                                      ");
        helpTable.addCell(" 10. Press    s : Search Products By Name                                ");
        helpTable.addCell(" 11. Press    h : Help                                                   ");
        helpTable.addCell(" 12. Press    e : Exit                                                   ");
        System.out.println(helpTable.render());

    }

}
