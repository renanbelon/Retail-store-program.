// package CourseWork;
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.border.*;
// 
// 
// public class Gui extends JFrame implements ActionListener
// {
//      CardLayout c1;
//     JPanel container,menu;
//     
//     AddCustomer ac;
//     AddBook addbook;
//     AddSoftware addsoftware;
//     Inventory inventory;
//     PlaceOrder placeorder;
//     Client client;
//     
//     //menu
//     JButton addCustomerB,addBookB,addSoftwareB,inventoryB,placeOrderB,clientsB;
//     //Border 
//     TitledBorder title;
//     Border blackline = BorderFactory.createLineBorder(Color.black);
//     
//     
//     
// 
//   
//     public Gui()
//     {
//          super("Sales System");
//         setSize(800,650);
//         setLocationRelativeTo(null);
//         setLayout(null);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         
//         //menu Panel
//         //menu1= new menu(this);
//         //menu1.setLocation(10,10);
// 
//        
//         container = new JPanel();
//         container.setBounds(10,75,760,500);
//         container.setBackground(Color.BLUE);
//         c1 = new CardLayout();
//         container.setLayout(c1);
//         add(container);
//         
//         ac = new AddCustomer();
//         addbook = new AddBook();
//         addsoftware= new  AddSoftware();
//         inventory = new Inventory();
//         placeorder = new PlaceOrder();
//         client = new  Client();
//     
//         container.add(ac,"card1");
//         container.add(addbook,"card2");
//         container.add(addsoftware,"card3");
//         container.add(inventory,"card4");
//         container.add(placeorder,"card5");
//         container.add(client,"card6");
//        
//         //menu
//         menu = new JPanel();
//         menu.setBounds(10,10,760,60);
//         // setBackground(Color.BLACK);
//    
//         //Menu border
//         title = BorderFactory.createTitledBorder(blackline, "Menu");
//         title.setTitleJustification(TitledBorder.CENTER);
//         menu.setBorder(title);
//       
//     
//         //Menu buttons
//         addCustomerB = new JButton("Add Customer");
//         addCustomerB.addActionListener(this);
//         menu.add(addCustomerB);    
//         addBookB = new JButton("Add Book");
//         addBookB.addActionListener(this);
//         menu.add(addBookB);
//         addSoftwareB = new JButton("Add Software");
//         addSoftwareB.addActionListener(this);
//         menu.add(addSoftwareB);
//         inventoryB = new JButton("Inventory");
//         inventoryB.addActionListener(this);
//         menu.add(inventoryB);
//         placeOrderB = new JButton("Place Order");
//         placeOrderB.addActionListener(this);
//         menu.add(placeOrderB);
//         clientsB = new JButton("Clients");
//         clientsB.addActionListener(this);
//         menu.add(clientsB);
//         
//         add(menu); 
//         
//         //array
//         Product [] productList = new Product[100];
//         
//         setVisible(true);
//         
//   }
//     
//     public void actionPerformed(ActionEvent e)
//     {
//     if(e.getSource()==addCustomerB){
//      //frame.container.setBackground(Color.BLACK);
//         c1.show(container,"card1");
//     }
//         
//     else if(e.getSource()==addBookB){
//      //frame.container.setBackground(Color.BLACK);
//         c1.show(container,"card2");
//     }
//     else if(e.getSource()==addSoftwareB){
//     c1.show(container,"card3");
//     }
//     else if(e.getSource()==inventoryB){
//        
//     c1.show(container,"card4");
//     }
//      else if(e.getSource()==placeOrderB){
//     c1.show(container,"card5");
//     }
//     else if(e.getSource()==clientsB){
//     c1.show(container,"card6");
//     }
// }
//     
//     public static void main(String[]args)
//     {
//     new Gui();
//     }
// 
//    
// }
