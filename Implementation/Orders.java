package CourseWork;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Orders extends JPanel implements MouseListener{

    JLabel titleL,pOrder;
    JPanel titleP;
    JTable table,productOrdersT;
    JScrollPane tableScroll, ordersScroll;
    SqlQueries queries = new SqlQueries();

     public Orders(){
        setSize(760,500);
        setLayout(null);
        
        //title panel
        titleL = new JLabel("Orders");
        titleL.setFont(new Font("Serif", Font.BOLD,25));
        titleP = new JPanel();
        titleP.setBounds(0,0,760,40);;
         titleP.add(titleL);
        add(titleP);
        
        //**********************************************
        //table of orders
        table = new JTable();
        table.addMouseListener(this);
        tableScroll = new JScrollPane(table);
        tableScroll.setBounds(10,56,740,170);
        add(tableScroll);
        //**********************************************
        //attributes of products related to selected order
        pOrder = new JLabel("Products from selected order");
        pOrder.setBounds(10,235,250,25);
        add(pOrder);
        
        productOrdersT = new JTable();
        ordersScroll = new JScrollPane(productOrdersT);
        ordersScroll.setBounds(10,260,740,200);
        add(ordersScroll);
        
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
            //get value from table as string
            String getOrderID = "" + table.getValueAt(table.getSelectedRow(),0);
            // convert string to int
            int getOrderIDint = Integer.parseInt(getOrderID);
        
        try{
            //connect to database
        queries.connect();
        //get int from table when clicked/ pass values to method getproductorder which creates the product order table model
        queries.getProductOrders(getOrderIDint,productOrdersT);
        //disconnect from database
        queries.disconnect();
     }
     catch(SQLException sqle){
     System.out.println(sqle);
    }
        }
    }
}

