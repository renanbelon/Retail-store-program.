package CourseWork;



import java.util.List;
import javax.swing.table.AbstractTableModel;

class CustomerTableModel extends AbstractTableModel {
    //variables that will be used in the switch statement.
    private static final int ID_COL = 0;
    private static final int FIRST_NAME_COL = 1;
    private static final int SECOND_NAME_COL = 2;
    private static final int DOB_COL = 3;
    private static final int ADDRESS_COL = 4;
    private static final int POSTCODE_COL = 5;
    private static final int PHONE_COL = 6;
    // String array which will be used to reprensent the table's column name
    private String[] columnNames = { "ID", "First Name", "Surname",
    "DOB" ,"Address","PostCode","Phone" };
    // arraylist of Customer objects   
    private List<Customer> customers;
    //constructor which takes an arrraylist of customer object 
    public CustomerTableModel(List<Customer> theCustomers) {
        customers = theCustomers;
    }
    
    // overide method getcolumncount/ counts values in the columnName Array
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    //counts howmany rows in in the array of customers 
    @Override
    public int getRowCount() {
        return customers.size();
    }
    
    //passes the column names
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    //get values in the Customers object
    @Override
    public Object getValueAt(int row, int col) {
        Customer tempCustomer = customers.get(row);
        switch (col) {
        case ID_COL:
            return tempCustomer.getCID();
        case FIRST_NAME_COL:
            return tempCustomer.getFName();
        case SECOND_NAME_COL:
            return tempCustomer.getSName();
        case DOB_COL:
            return tempCustomer.getDob();
        case ADDRESS_COL:
            return tempCustomer.getAdress();
        case POSTCODE_COL:
            return tempCustomer.getPostCode();
        case PHONE_COL:
            return tempCustomer.getPhone();
        default:
            return tempCustomer.getSName();
        }
    }
    //returns the class of the data element
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
