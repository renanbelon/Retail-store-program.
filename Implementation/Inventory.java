package CourseWork;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;


class Inventory extends JPanel{
    JPanel bookP,sofP,titleP;
    JTabbedPane tb;
    JLabel titleL;
    // book's contents
    JTable tableB;
    JScrollPane tableBScroll;
    //Sofrware's contents
    JTable tableS;
    JScrollPane tableSScroll;
   public Inventory(){
    setSize(760,500);
    setLayout(null);
    //***********************************************************
    // JPanel which holds the title label
    titleL = new JLabel("Inventory");
    titleL.setFont(new Font("Serif", Font.BOLD,25));
    titleP = new JPanel();
    titleP.setBounds(0,0,760,40);;
    titleP.add(titleL);
    add(titleP);
    
    //***********************************************************
    //tabbedpane and software and book Jpanel
    bookP = new JPanel();
    bookP.setLayout(null);
    
    //books table
    tableB = new JTable();
    tableB.setSize(715,150);
    tableB.setLocation(10,20);           
    tableBScroll = new JScrollPane(tableB);
    tableBScroll.setSize(715,150);
    tableBScroll.setLocation(10,20);
    bookP.add(tableBScroll);
    
    //***********************************************************
    //Software Contents
    sofP=new JPanel();
    sofP.setLayout(null);
    
    tableS = new JTable();
    tableS.setSize(715,150);
    tableS.setLocation(10,20);           
    tableSScroll = new JScrollPane(tableS);
    tableSScroll.setSize(715,150);
    tableSScroll.setLocation(10,20);
    sofP.add(tableSScroll);
    //***********************************************************
    tb = new JTabbedPane();
    tb.setBounds(10,40,740,450);
    tb.add("Books",bookP);
    tb.add("Software",sofP);
    add(tb);
    //***********************************************************
   }
}

