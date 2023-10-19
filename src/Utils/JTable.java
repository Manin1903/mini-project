package Utils;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class JTable {
    public void displayTable(){
        Table table = new Table(9, BorderStyle.UNICODE_DOUBLE_BOX_WIDE,ShownBorders.SURROUND);
        table.setColumnWidth(0,10,20);
        table.setColumnWidth(1, 10,20);
        table.setColumnWidth(2,10,20);
        table.setColumnWidth(3,10,20);
        table.setColumnWidth(4,10,20);
        table.setColumnWidth(5,10,20);
        table.setColumnWidth(6,10,20);
        table.setColumnWidth(7,10,20);
        table.setColumnWidth(8,10,20);
        table.setColumnWidth(0, 10,20);
        table.setColumnWidth(1,10,20);
        table.setColumnWidth(2,10,20);
        table.setColumnWidth(3,10,20);
        table.setColumnWidth(4,10,20);
        table.addCell("*)Display");
        table.addCell("| W)rite");
        table.addCell("| R)ead");
        table.addCell("| U)pdate");
        table.addCell("| D)elete");
        table.addCell("| F)irst");
        table.addCell("| P)revious");
        table.addCell("| N)ext");
        table.addCell("| L)ast");
        table.addCell("S)earch");
        table.addCell("| G)oto");
        table.addCell("| Se)t row");
        table.addCell("| H)elp");
        table.addCell("| E)xit");
        System.out.println(table.render());

    }
    public void displayExitTable(){
        Table tableExit = new Table(9, BorderStyle.DESIGN_CAFE);
        tableExit.addCell("               GOOD BYE!         ");
        System.out.println(tableExit.render());
    }

}
