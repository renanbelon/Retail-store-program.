package CourseWork;

import java.util.List;
import javax.swing.table.AbstractTableModel;

class BasketTableModel extends AbstractTableModel {
    //variables that will be used in the switch statement.
    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int PRICE_COL = 2;
    private static final int QUANTITY_COL = 3;
    
    // String array which will be used to reprensent the table's column name
    private String[] columnNames = { "ID", "Product Name", "Price Per Unit",
    "Quantity"};
    // arraylist of Basket objects   
    private List<Basket> baskets;
    //constructor which takes an arrraylist of customer object 
    public BasketTableModel(List<Basket> theBaskets) {
        baskets = theBaskets;
    }
    
    // overide method getcolumncount/ counts values in the columnName Array
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    //counts howmany rows in in the array of baskets 
    @Override
    public int getRowCount() {
        return baskets.size();
    }
    
    //passes the column names
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    //get values in the Baskets object
    @Override
    public Object getValueAt(int row, int col) {
        Basket tempBasket = baskets.get(row);
        switch (col) {
        case ID_COL:
            return tempBasket.getProductID();
        case NAME_COL:
            return tempBasket.getProductName();
        case PRICE_COL:
            return tempBasket.getPricePerUnit();
        case QUANTITY_COL:
            return tempBasket.getQuantity();
        default:
            return tempBasket.getProductID();
        }
    }
    //returns the class of the data element
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}