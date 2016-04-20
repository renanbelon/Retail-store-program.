package CourseWork;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class PlaceOrder extends JPanel implements ActionListener,MouseListener{
    //TITLE
    JPanel titleP;
    JLabel titleL;
    //***********************************
    // Labels, Textfields and buttons
    JLabel sNameL;
    JTextField sNameT;
    JButton findB,ClearBB,placeOrderB;
    //table
    JTable table;
    JScrollPane tableScroll;
    String[] columns ={"ID","FName","SName","DOB","PostCode","Phone"};
    // tabledpane and Jtables
    JTabbedPane tb;
    String[] bcolumns ={"b_id","bname","price"};
    String[] scolumns ={"s_id","sname","price"} ;
    DefaultTableModel btablemodel, stablemodel;
    JTable bookList,softwareList;
    JScrollPane bookScroll,softwareScroll;
    //Basket
    JLabel basketL;
    JTable basketListTable;
    JScrollPane basketScroll;
    //Total
    JLabel totalL;
    JTextField totalT;
    //customer id and sname textfields and labels
    JLabel cIDL,cSNameL;
    JTextField cID,cSName;
    //products 
    JPanel pcomponentsP;
    JLabel pIDL,pNameL,pPriceL,pQuantityL;
    JTextField pID,pName,pPrice,pQuantity;
    JButton addToBasket;
    public PlaceOrder(){
        setSize(760,530);
        setLayout(null);
        //*******************************************************************
        // JPanel which holds the title label
        titleL = new JLabel("Place Order");
        titleL.setFont(new Font("Serif", Font.BOLD,25));
        titleP = new JPanel();
        titleP.setBounds(0,0,760,40);;
        titleP.add(titleL);
        add(titleP);
        //*******************************************************************
        //find customer
        sNameL = new JLabel("Find Customer By Last Name");
        sNameL.setBounds(10,45,166,25);
        sNameT= new JTextField();
        sNameT.setBounds(176,45,100,25); 
        
        findB = new JButton("Find");
        findB.setBounds(279,45,60,25);
        findB.addActionListener(this);
        
        add(sNameL);
        add(sNameT);
        add(findB);
        
        //table customer
        table = new JTable();
        table.addMouseListener(this);
        tableScroll = new JScrollPane(table);
        tableScroll.setBounds(10,76,750,100);
        add(tableScroll);
        
        //customers id and sname textfields
        cIDL = new JLabel("ID");
        cIDL.setBounds(10,179,50,25);
        add(cIDL);
        
        cID = new JTextField();
        cID.setEditable(false);
        cID.setBounds(35,179,100,25);
        add(cID);
        
        cSNameL = new JLabel("Surname");
        cSNameL.setBounds(138,179,70,25);
        add(cSNameL);
        
        cSName = new JTextField();
        cSName.setEditable(false);
        cSName.setBounds(200,179,100,25);
        add(cSName);
        
        //Jtables
        btablemodel = new DefaultTableModel(bcolumns,0);
        bookList =new JTable(btablemodel);
        bookList.addMouseListener(this);
        bookScroll = new JScrollPane(bookList);
        
        stablemodel = new DefaultTableModel(scolumns,0);
        softwareList =new JTable(stablemodel);
        softwareList.addMouseListener(this);
        softwareScroll = new JScrollPane(softwareList);
        
        //tabbedpane 
        tb = new JTabbedPane();
        tb.setBounds(10,207,750,130);
        tb.add("Books",bookScroll);
        tb.add("Software",softwareScroll);
        add(tb);
        
        //product components
        pcomponentsP = new JPanel();
        pcomponentsP.setBounds(10,337,750,35);
        add(pcomponentsP);
        
        
        pIDL = new JLabel("ID");
        pNameL = new JLabel("Name");
        pPriceL = new JLabel("Price");
        pQuantityL = new JLabel("Quantity");
                
        pID = new JTextField();
        pID.setEditable(false);
        pID.setPreferredSize(new Dimension(100,25));
        pName = new JTextField();
        pName.setEditable(false);
        pName.setPreferredSize(new Dimension(130,25));
        pPrice = new JTextField();
        pPrice.setEditable(false);
        pPrice.setPreferredSize(new Dimension(100,25));
        pQuantity = new JTextField("1");
        pQuantity.setPreferredSize(new Dimension(100,25));
        
        addToBasket = new JButton("Add To Basket");
        addToBasket.addActionListener(this);
        
        pcomponentsP.add(pIDL);
        pcomponentsP.add(pID);
        pcomponentsP.add(pNameL);
        pcomponentsP.add(pName);
        pcomponentsP.add(pPriceL);
        pcomponentsP.add(pPrice);
        pcomponentsP.add(pQuantityL);
        pcomponentsP.add(pQuantity);
        pcomponentsP.add(addToBasket);
        
        
        //Basket components
        basketL = new JLabel("Basket");
        basketL.setBounds(330,372,80,25);
        add(basketL);
        
        basketListTable = new JTable();
        basketScroll = new JScrollPane(basketListTable);
        basketScroll.setBounds(10,395,750,100);
        add(basketScroll);
        
        //Total Label and TextField
        totalL = new JLabel("Total");
        totalL.setBounds(504,496,70,25);
        add(totalL);
        
        totalT = new JTextField("0.00");
        totalT.setEditable(false);
        totalT.setBounds(537,496,100,25);
        add(totalT);
        
        //buttons
        ClearBB = new JButton("Clear Basket");
        ClearBB.addActionListener(this);
        ClearBB.setBounds(10,496,120,25);
        add(ClearBB);
        
        placeOrderB = new JButton("Place Order");
        placeOrderB.setBounds(640,496,119,25);
        placeOrderB.addActionListener(this);
        add(placeOrderB);
    //*********************************************************************
   }
   SqlQueries queries = new SqlQueries();
   Basket tempBasket;
   ArrayList<Basket> basketList= new ArrayList<>();
   BasketTableModel basketTableModel;
   public void actionPerformed(ActionEvent e){
    if(e.getSource()== findB){
    try{
        //connect to database
        queries.connect();
        //Variable that gets the input from text field
        String lastName =sNameT.getText();
        //create an arraylist of Customers object and set it to null
        ArrayList<Customer> customers = null;
        // if input not null and more than 0 than search for customers by lastname and assign values to customers array
        if(lastName != null && lastName.trim().length()>0){
            customers = queries.searchCustomer(lastName);
        }
        //if input is 0 or null than get all customers and assign to customers array
        else {
            customers = queries.getAllCustomer();
        }
        //pass customer array to CustomerTableModelObject
        CustomerTableModel model = new CustomerTableModel(customers);
        //set table model to the model that was created in the CustomerTableModel Class
        table.setModel(model);
        
        queries.disconnect();
    
    }
    catch(Exception sqle){
        System.out.println(sqle);
    }
    }
    
    if(e.getSource()== addToBasket){
    String productprice = pPrice.getText();
    String productquantity = pQuantity.getText();
    int pquantitynumber = Integer.parseInt(pQuantity.getText());
    if(productprice.trim().equals("") || productquantity.trim().equals("")){
    JOptionPane.showMessageDialog(this, "Quantity and item price needs to be entered","User Information",JOptionPane.WARNING_MESSAGE);
    }
    else if(pquantitynumber < 1){
    JOptionPane.showMessageDialog(this, "Quantity needs to be 1 or more","Invalid Quantity",JOptionPane.WARNING_MESSAGE);
    }
    else{
    double totalvalue;
    totalvalue = Double.parseDouble(pPrice.getText())*Integer.parseInt(pQuantity.getText())+ Double.parseDouble(totalT.getText());
    totalT.setText(String.valueOf(totalvalue));
    
    int productid = Integer.parseInt(pID.getText());
    double priceperunit = Double.parseDouble(pPrice.getText());
    int quantity = Integer.parseInt(pQuantity.getText());
    
    tempBasket = new Basket(productid,pName.getText(),priceperunit,quantity);
    basketList.add(tempBasket);
    
    basketTableModel = new BasketTableModel(basketList);
    basketListTable.setModel(basketTableModel);
   }
   }
   if(e.getSource()==placeOrderB){
       //variable used for trim purpose only
       String cidt= cID.getText();
       if(cidt.trim().equals("")){
           JOptionPane.showMessageDialog(null,"Please Select Customer");
        }
        else if (basketList.isEmpty()){
            JOptionPane.showMessageDialog(null,"Basket is empty! Please insert item into the basket");
        
        }
        else{
    try{
        //connect to the database
        queries.connect();
        //get current date
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String oDate = dateFormat.format(date);
        //get current Time
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date time = new Date();
        String oTime = timeFormat.format(time);
        
        // convert text from textfields
        int cid = Integer.parseInt(cID.getText());
        double total = Double.parseDouble(totalT.getText());
        
        //insert values into the database
        queries.insertOrder(cid,oDate,oTime,total);
        // get o_id from table order/last value inserted
        int getOrderID = queries.getOrderID();
 
        //inserting productorder
        int counter = 0;
        while (counter <basketList.size()){
        queries.insertProductOrder(getOrderID,basketList.get(counter).getProductID(),basketList.get(counter).getQuantity());
        counter++;
        }
        //tempBasket= null;
        basketList.clear();
        basketTableModel = new BasketTableModel(basketList);
        basketListTable.setModel(basketTableModel);
        cID.setText("");
        cSName.setText("");
        pID.setText("");
        pName.setText("");
        pPrice.setText("");
        pQuantity.setText("1");
        totalT.setText("0.00");
        //disconnect from database
        queries.disconnect();
    }
    catch(SQLException sqle){
        System.out.println(sqle);
    }
    }
    }
    if(e.getSource()==ClearBB){
    basketList.clear();
    basketTableModel = new BasketTableModel(basketList);
    basketListTable.setModel(basketTableModel);
    totalT.setText("0.00");
    }
   }
public void mouseExited(MouseEvent e){
}

public void mouseEntered(MouseEvent e){
}

public void mouseReleased(MouseEvent e){
}

public void mousePressed(MouseEvent e){
}

public void mouseClicked(MouseEvent e){
if(e.getSource()==table){
String getCustomerID = "" + table.getValueAt(table.getSelectedRow(),0);
cID.setText(getCustomerID);

String getCustomerSurname = "" + table.getValueAt(table.getSelectedRow(),2);
cSName.setText(getCustomerSurname);
}

if(e.getSource()== bookList){
String getBookID = "" + bookList.getValueAt(bookList.getSelectedRow(),0);
pID.setText(getBookID);

String getBookName= "" + bookList.getValueAt(bookList.getSelectedRow(),1);
pName.setText(getBookName);

String getBookPrice= "" + bookList.getValueAt(bookList.getSelectedRow(),2);
pPrice.setText(getBookPrice);

}

if(e.getSource()== softwareList){
String getSoftwareID = "" + softwareList.getValueAt(softwareList.getSelectedRow(),0);
pID.setText(getSoftwareID);

String getSoftwareName= "" + softwareList.getValueAt(softwareList.getSelectedRow(),1);
pName.setText(getSoftwareName);

String getSoftwarePrice= "" + softwareList.getValueAt(softwareList.getSelectedRow(),2);
pPrice.setText(getSoftwarePrice);
}
}
}



