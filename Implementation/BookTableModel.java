package CourseWork;
import java.util.List;
import javax.swing.table.AbstractTableModel;

class BookTableModel extends AbstractTableModel {
    //variables that will be used in the switch statement.
    private static final int ID_COL = 0;
    private static final int B_NAME_COL = 1;
    private static final int PRICE_COL = 2;
    private static final int YEAR_COL = 3;
    private static final int PUBLISHER_COL = 4;
    private static final int AUTHOR_COL = 5;
    private static final int PAGES_COL = 6;
    private static final int ISBN_COL = 7;
    // String array which will be used to reprensent the table's column name
    private String[] columnNames = { "ID", "Name", "Price",
    "Year","Publisher","Author","Pages","ISBN" };
    // arraylist of Book objects   
    private List<Book> books;
    //constructor which takes an arrraylist of customer object 
    public BookTableModel(List<Book> theBooks) {
        books = theBooks;
    }
    
    // overide method getcolumncount/ counts values in the columnName Array
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    //counts how many rows in in the array of books 
    @Override
    public int getRowCount() {
        return books.size();
    }
    
    //passes the column names
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    //get values in the Books object
    @Override
    public Object getValueAt(int row, int col) {
        Book tempBook = books.get(row);
        switch (col) {
        case ID_COL:
            return tempBook.getPID();
        case B_NAME_COL:
            return tempBook.getPName();
        case PRICE_COL:
            return tempBook.getCost();
        case YEAR_COL:
            return tempBook.getPYearOfPublication();
        case PUBLISHER_COL:
            return tempBook.getPPublicationHouse();
        case AUTHOR_COL:
            return tempBook.getAuthor();
        case PAGES_COL:
            return tempBook.getNpages();
        case ISBN_COL:
            return tempBook.getISBN();
        default:
            return tempBook.getPID();
        }
    }
    //returns the class of the data element
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}