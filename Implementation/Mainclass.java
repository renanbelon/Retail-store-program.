package CourseWork;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.*;


public class Mainclass extends JFrame implements ActionListener
{
    CardLayout c1;
    JPanel container,menu;
    
    AddCustomer ac;
    AddBook addbook;
    AddSoftware addsoftware;
    Inventory inventory;
    PlaceOrder placeorder;
    Orders orders;
    
    //menu
    JButton addCustomerB,addBookB,addSoftwareB,inventoryB,placeOrderB,ordersB;
    //Border 
    TitledBorder title;
    Border blackline = BorderFactory.createLineBorder(Color.black);
    SqlQueries queries = new SqlQueries();

    public Mainclass()throws SQLException{
        super("Sales System");
        setSize(800,650);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //menu Panel
        //menu1= new menu(this);
        //menu1.setLocation(10,10);

       
        container = new JPanel();
        container.setBounds(10,75,760,530);
        container.setBackground(Color.BLUE);
        c1 = new CardLayout();
        container.setLayout(c1);
        add(container);
        
        ac = new AddCustomer();
        addbook = new AddBook();
        addsoftware= new  AddSoftware();
        inventory = new Inventory();
        placeorder = new PlaceOrder();
        orders = new  Orders();
    
        container.add(ac,"card1");
        container.add(addbook,"card2");
        container.add(addsoftware,"card3");
        container.add(inventory,"card4");
        container.add(placeorder,"card5");
        container.add(orders,"card6");
       
        //menu
        menu = new JPanel();
        menu.setBounds(10,10,760,60);
        // setBackground(Color.BLACK);
   
        //Menu border
        title = BorderFactory.createTitledBorder(blackline, "Menu");
        title.setTitleJustification(TitledBorder.CENTER);
        menu.setBorder(title);
      
    
        //Menu buttons
        addCustomerB = new JButton("Add Customer");
        addCustomerB.addActionListener(this);
        menu.add(addCustomerB);    
        addBookB = new JButton("Add Book");
        addBookB.addActionListener(this);
        menu.add(addBookB);
        addSoftwareB = new JButton("Add Software");
        addSoftwareB.addActionListener(this);
        menu.add(addSoftwareB);
        inventoryB = new JButton("Inventory");
        inventoryB.addActionListener(this);
        menu.add(inventoryB);
        placeOrderB = new JButton("Place Order");
        placeOrderB.addActionListener(this);
        menu.add(placeOrderB);
        ordersB = new JButton("Orders");
        ordersB.addActionListener(this);
        menu.add(ordersB);
        
        add(menu); 
        //queries.connect();
        //array
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
    if(e.getSource()==addCustomerB){
     //frame.container.setBackground(Color.BLACK);
        c1.show(container,"card1");
    }
    if(e.getSource()==addBookB){
     //frame.container.setBackground(Color.BLACK);
        c1.show(container,"card2");
    }
    if(e.getSource()==addSoftwareB){
    c1.show(container,"card3");
    }
    if(e.getSource()==inventoryB){
        try{
        queries.connect();
        
        ArrayList<Book> books = null;
        ArrayList<Software> softwares = null;
        
        books = queries.getAllBook();
        softwares = queries.getAllSoftware();
        
        //pass books array to booksTableModelObject
        BookTableModel bmodel = new BookTableModel(books);
        SoftwareTableModel smodel = new SoftwareTableModel(softwares);
        
        //set tablemodel to the model that was created in the CustomerTableModel Class
        inventory.tableB.setModel(bmodel);
        inventory.tableS.setModel(smodel);
        
        queries.disconnect();
    }
     catch(Exception ee)
        {
        System.out.println(ee);
    }
        c1.show(container,"card4");
    }
     if(e.getSource()==placeOrderB){
         
         try{
             queries.connect();
             //queries.updateTableCustomer(placeorder.table);
             //queries.updateTableBook1(placeorder.bookList);
             //queries.updateTableSoftware1(placeorder.softwareList);
             
             ArrayList<Book> books = null;
             ArrayList<Software> softwares = null;
        
             books = queries.getAllBook();
             softwares = queries.getAllSoftware();
        
             //pass books array to booksTableModelObject
             BookTableModel bmodel = new BookTableModel(books);
             SoftwareTableModel smodel = new SoftwareTableModel(softwares);
        
             //set tablemodel to the model that was created in the CustomerTableModel Class
             placeorder.bookList.setModel(bmodel);
             placeorder.softwareList.setModel(smodel);
             
             queries.disconnect();
            }
         catch(Exception ee){
             System.out.println(ee);
            }
         
         
         c1.show(container,"card5");
    }
    if(e.getSource()==ordersB){
        try{
        queries.connect();
        queries.updateTableOrders(orders.table);

        
        //         ArrayList<Customer> customers = null;
//         customers = queries.getAllCustomer();
//         CustomerTableModel cmodel = new CustomerTableModel(customers);
//         orders.table.setModel(cmodel);
        
        queries.disconnect();
    }
    catch(Exception ee){
             System.out.println(ee);
            }
        c1.show(container,"card6");
    
    }
    
    
   }
   
   
   
    public static void main(String[]args)throws SQLException
    {
     
    new Mainclass();
    }

   
}
