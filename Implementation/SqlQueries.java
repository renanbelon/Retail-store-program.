package CourseWork;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.*;
import java.util.*;

public class SqlQueries
{
    private final String USERNAME ="dbuser";
    private final String PASSWORD = "dbpassword";
    private final String CONN ="jdbc:mysql://localhost/salesystem";
    Connection conn = null;
    Statement st=null;
    ResultSet myRs = null;
    PreparedStatement addBook= null;
    PreparedStatement addSoftware= null;
    PreparedStatement addCustomer=null;
    PreparedStatement addOrder= null;
    PreparedStatement addProductOrder= null;
    PreparedStatement getProductOrders = null;
    
   
  public void connect()throws SQLException
  {
    try
    {
        conn=DriverManager.getConnection(CONN,USERNAME,PASSWORD);
        st=conn.createStatement();
        addBook =conn.prepareStatement("insert into product (cat_id,Pname,cost,yearofpublication,publicationHouse,author,numofpages,isbn) values(3,?,?,?,?,?,?,?)");
        addSoftware = conn.prepareStatement("insert into product (cat_id,Pname,cost,yearofpublication,publicationHouse,Processor,ram) values(4,?,?,?,?,?,?)");
        addCustomer = conn.prepareStatement("insert into customer (fname,sname,dob,address,postcode,phone) values(?,?,?,?,?,?)");
        addOrder= conn.prepareStatement("insert into  orders(cid,orderdate,ordertime,price) value(?,?,?,?)");
        addProductOrder = conn.prepareStatement("insert into product_order (o_id, P_id, quantity) values(?,?,?)");
        getProductOrders = conn.prepareStatement("select * from product_order where o_id = ?");
     }
        catch(SQLException e)
        {
        System.out.println(e);
    }
  }
  public void disconnect()
    {
        try
        {
            conn.close();
        }
        catch(SQLException sqle)
        {
            JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);        
        }
    }
    
    public int insertbook(String pName,double cost, int pYearOfPublication,String pPublicationHouse,String author,int nPages, int ISBN){
        int insert=0;
        try
        {
            addBook.setString(1,pName);
            addBook.setDouble(2,cost);
            addBook.setInt(3,pYearOfPublication);
            addBook.setString(4,pPublicationHouse);
            addBook.setString(5,author);
            addBook.setInt(6,nPages);
            addBook.setInt(7,ISBN);
            insert=addBook.executeUpdate();
            if (insert ==1){JOptionPane.showMessageDialog(null, "Book has been sucessfuly inserted"  ," Books Insert", JOptionPane.PLAIN_MESSAGE); }
        }
        catch(SQLException sqle)
        {
            JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);        
        } 
        return insert;
    }
    
   public int insertSoftware(String sName,double cost, int pYearOfPublication,String pPublicationHouse,String processor,String ram){
         int insert1 =0;
         try{
         addSoftware.setString(1,sName);
         addSoftware.setDouble(2,cost);
         addSoftware.setInt(3,pYearOfPublication);
         addSoftware.setString(4,pPublicationHouse);
         addSoftware.setString(5,processor);
         addSoftware.setString(6,ram);
         insert1=addSoftware.executeUpdate();
         if(insert1==1){
            JOptionPane.showMessageDialog(null, "Software has been sucessfuly inserted"  ," Software Insert", JOptionPane.PLAIN_MESSAGE); }
        }
        catch(SQLException sqle)
        {
            JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);        
        } 
        return insert1;
    }
   public int insertCustomer(String fName,String sName,String dob,String address,String postCode,String phone){
       int insert2 = 0;
    
        try{
        addCustomer.setString(1,fName);
        addCustomer.setString(2,sName);
        addCustomer.setString(3,dob);
        addCustomer.setString(4,address);
        addCustomer.setString(5,postCode);
        addCustomer.setString(6,phone);
        insert2=addCustomer.executeUpdate();
        if(insert2 == 1){
        JOptionPane.showMessageDialog(null, "Customer Inserted"  ,"Insert", JOptionPane.PLAIN_MESSAGE);
        }
    
        }
        catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);     
        }
       return insert2;
    }
    
    public int insertOrder(int cid,String orderDate, String orderTime, double price){
    int insert3 = 0;
    try{
        addOrder.setInt(1,cid);
        addOrder.setString(2,orderDate);
        addOrder.setString(3,orderTime);
        addOrder.setDouble(4,price);
        insert3=addOrder.executeUpdate();
        if(insert3 == 1){
        JOptionPane.showMessageDialog(null, "Order Placed"  ,"User Information", JOptionPane.PLAIN_MESSAGE);
    }
    }
    catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);     
        }
    return insert3;
    }
    
    public int insertProductOrder(int oid, int pid, int quantity){
    int insert4 = 0;
    try{
    addProductOrder.setInt(1,oid);
    addProductOrder.setInt(2,pid);
    addProductOrder.setInt(3,quantity);
    insert4 =addProductOrder.executeUpdate();
    }
    catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);     
     }
    return insert4;
    }
  
    public void updateTableOrders(JTable tb)
    {
        ResultSet rs;
        String query="Select * from orders order by orderdate";
        try
        {
            rs=st.executeQuery(query);
            tb.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Book> getAllBook()throws Exception{
    ArrayList<Book> list = new ArrayList<>();
    Statement myStmt = null;
    ResultSet myRs = null;
    try{
       myStmt = conn.createStatement(); 
       myRs = myStmt.executeQuery("select P_id, Pname,cost,yearofpublication,publicationHouse,author,numofpages,isbn from product where cat_id = '3' order by p_id");
       while(myRs.next()){
           //variables that stores values from database
           int id = myRs.getInt("P_id");
           String sname= myRs.getString("Pname");
           double cost= myRs.getDouble("cost");
           int yearofpublication = myRs.getInt("yearofpublication");
           String publicationhouse = myRs.getString("publicationhouse");
           String author = myRs.getString("author");
           int numofpages = myRs.getInt("numofpages");
           int isbn = myRs.getInt("isbn");
           //passing database values to software object
           Book tempBook = new Book(author,numofpages,isbn,id,sname,cost,yearofpublication,publicationhouse);
           //adding object to arraylist
           list.add(tempBook);
        }
    }
        catch(SQLException sqle){
        System.out.println(sqle);
        }
     return list;
    }
    
    public int getOrderID(){
        int orderid = 0;
        Statement myStmt = null;
        ResultSet myRs = null;    
        try{
        myStmt = conn.createStatement(); 
        myRs = myStmt.executeQuery("select o_id from orders ORDER BY o_id DESC LIMIT 1;");
        while(myRs.next()){
        orderid = myRs.getInt("o_id");
       }
       }
       catch(SQLException sqle){
        System.out.println(sqle);
        }
        return orderid;
    }
    
     public ArrayList<Software> getAllSoftware()throws Exception{
    ArrayList<Software> list = new ArrayList<>();
    Statement myStmt = null;
    ResultSet myRs = null;
    try{
       myStmt = conn.createStatement(); 
       myRs = myStmt.executeQuery("select P_id, Pname,cost,yearofpublication,publicationHouse,processor,ram from product where cat_id = '4' order by p_id");
       while(myRs.next()){
           //variables that stores values from database
           int id = myRs.getInt("P_id");
           String sname= myRs.getString("Pname");
           double cost= myRs.getDouble("cost");
           int yearofpublication = myRs.getInt("yearofpublication");
           String publicationhouse = myRs.getString("publicationhouse");
           String processor = myRs.getString("processor");
           String ram = myRs.getString("ram");
           //passing database values to software object
           Software tempSoftware = new Software(processor,ram,id,sname,cost,yearofpublication,publicationhouse);
           //adding object to arraylist
           list.add(tempSoftware);
        }
    }
        catch(SQLException sqle){
        System.out.println(sqle);
        }
     return list;
    }
    
    //method that to get all customers from database
    public ArrayList<Customer> getAllCustomer()throws Exception{
    ArrayList<Customer> list = new ArrayList<>();
    Statement myStmt = null;
    ResultSet myRs = null;
    try{
       myStmt = conn.createStatement(); 
       myRs = myStmt.executeQuery("select * from customer");
       while(myRs.next()){
           //variables that store database values
           int id = myRs.getInt("cid");
           String fname= myRs.getString("fname");
           String sname= myRs.getString("sname");
           String dob = myRs.getString("dob");
           String address = myRs.getString("address");
           String postcode = myRs.getString("postcode");
           String phone = myRs.getString("phone");
           //passing database values to customer object
           Customer tempCustomer = new Customer(id,fname,sname,dob,address,postcode,phone);
           //adding object to arraylist
           list.add(tempCustomer);
        }
    }
        catch(SQLException sqle){
        System.out.println(sqle);
        }
     return list;
    }
    
    public ArrayList<Customer> searchCustomer(String lastName) throws Exception {
        ArrayList<Customer> list = new ArrayList<>();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            lastName += "%";
            myStmt = conn.prepareStatement("select * from customer where sname like ?");
            myStmt.setString(1, lastName);
            myRs = myStmt.executeQuery();
            while (myRs.next()) {
                 //variables that store database values
                int id = myRs.getInt("cid");
                String fname= myRs.getString("fname");
                String sname= myRs.getString("sname");
                String dob = myRs.getString("dob");
                String address = myRs.getString("address");
                String postcode = myRs.getString("postcode");
                String phone = myRs.getString("phone");
                 //passing database values to customer object
                Customer tempCustomer = new Customer(id,fname,sname,dob,address,postcode,phone);
                //adding object to arraylist
                list.add(tempCustomer);
            }
        }
         catch(SQLException sqle){
        System.out.println(sqle);
        }
        return list;
    }
  
     public void getProductOrders(int o_id,JTable tb){
          ResultSet rs;
         try{
             getProductOrders.setInt(1,o_id);
             rs=getProductOrders.executeQuery();
             tb.setModel(DbUtils.resultSetToTableModel(rs));
        }
         catch(SQLException sqle){
                JOptionPane.showMessageDialog(null,sqle.getMessage(),
                "SQL Error",JOptionPane.WARNING_MESSAGE);     
        }
    }
}