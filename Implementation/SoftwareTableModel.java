package CourseWork;


import java.util.List;
import javax.swing.table.AbstractTableModel;

class SoftwareTableModel extends AbstractTableModel {
    //variables that will be used in the switch statement.
    private static final int ID_COL = 0;
    private static final int B_NAME_COL = 1;
    private static final int PRICE_COL = 2;
    private static final int YEAR_COL = 3;
    private static final int PUBLISHER_COL = 4;
    private static final int PROCESSOR_COL = 5;
    private static final int RAM_COL = 6;
    
    // String array which will be used to reprensent the table's column name
    private String[] columnNames = { "ID", "Name", "Price",
    "Year","Publisher","Processor","Ram" };
    // arraylist of Software objects   
    private List<Software> softwares;
    //constructor which takes an arrraylist of customer object 
    public SoftwareTableModel(List<Software> theSoftwares) {
        softwares = theSoftwares;
    }
    
    // overide method getcolumncount/ counts values in the columnName Array
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    //counts how many rows in in the array of softwares 
    @Override
    public int getRowCount() {
        return softwares.size();
    }
    
    //passes the column names
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    //get values in the Softwares object
    @Override
    public Object getValueAt(int row, int col) {
        Software tempSoftware = softwares.get(row);
        switch (col) {
        case ID_COL:
            return tempSoftware.getPID();
        case B_NAME_COL:
            return tempSoftware.getPName();
        case PRICE_COL:
            return tempSoftware.getCost();
        case YEAR_COL:
            return tempSoftware.getPYearOfPublication();
        case PUBLISHER_COL:
            return tempSoftware.getPPublicationHouse();
        case PROCESSOR_COL:
            return tempSoftware.getProcessor();
        case RAM_COL:
            return tempSoftware.getRam();
        default:
            return tempSoftware.getPID();
        }
    }
    //returns the class of the data element
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
