package CourseWork;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddBook extends JPanel implements ActionListener {
JLabel bookIDL,bookNameL,priceL,pubYearL,pubHouseL,authorNameL,numPagesL,ISBNL;
JTextField bookIDT,bookNameT,priceT,pubYearT,pubHouseT,authorNameT,numPagesT,ISBNT;
JButton submitB;
int w = 163;
int h = 25;
JPanel titleP;
JLabel titleL;
public AddBook(){
    setSize(760,500);
    setLayout(null);
    
    // JPanel which holds the title label
    titleL = new JLabel("Add Books");
    titleL.setFont(new Font("Serif", Font.BOLD,25));
    titleP = new JPanel();
    titleP.setBounds(0,0,760,40);;
    titleP.add(titleL);
    add(titleP);
    
    bookIDL = new JLabel("Book ID");
    bookIDL.setBounds(10,60,70,h);
    add(bookIDL);
    
    bookIDT = new JTextField("New");
    bookIDT.setEditable(false);
    bookIDT.setBounds(120,60,w,h);
    add(bookIDT);
    
    bookNameL = new JLabel("Book Name");
    bookNameL.setBounds(10,88,70,h);
    add(bookNameL);
    
    bookNameT = new JTextField();
    bookNameT.setBounds(120,88,w,h);
    add(bookNameT);
    
    priceL = new JLabel("Price");
    priceL.setBounds(10,116,70,h);
    add(priceL);
    
    priceT = new JTextField();
    priceT.setBounds(120,116,w,h);
    add(priceT);
    
    pubYearL = new JLabel("Year of Publication");
    pubYearL.setBounds(10,144,110,h);
    add(pubYearL);
    
    pubYearT = new JTextField();
    pubYearT.setBounds(120,144,w,h);
    add(pubYearT);
    
    pubHouseL = new JLabel("Publication House");
    pubHouseL.setBounds(10,171,110,h);
    add(pubHouseL);
    
    pubHouseT = new JTextField();
    pubHouseT.setBounds(120,171,w,h);
    add(pubHouseT);
    
    authorNameL = new JLabel("Author Name");
    authorNameL.setBounds(10,199,100,h);
    add(authorNameL);

    authorNameT = new JTextField();
    authorNameT.setBounds(120,199,w,h);
    add(authorNameT);
    
    numPagesL = new JLabel("Number of pages");
    numPagesL.setBounds(10,227,100,h);
    add(numPagesL);
    
    numPagesT = new JTextField();
    numPagesT.setBounds(120,227,w,h);
    add(numPagesT);
    
    ISBNL = new JLabel("ISBN");
    ISBNL.setBounds(10,255,100,h);
    add(ISBNL);
    
    ISBNT = new JTextField();
    ISBNT.setBounds(120,255,w,h);
    add(ISBNT);
   
    submitB = new JButton("Submit");
    submitB.setBounds(203,283,80,h);
    submitB.addActionListener(this);
    add(submitB);
   }
   int counter=0;
   SqlQueries queries =new SqlQueries();
   
   public void actionPerformed(ActionEvent e){
    if (e.getSource()==submitB)
    {
        String booknamet= bookNameT.getText();
        String pricet= priceT.getText();
        String pubyeart = pubYearT.getText();
        String pubhouset = pubHouseT.getText();
        String authornamet = authorNameT.getText();
        String numpagest = numPagesT.getText();
        String isbnt2 = ISBNT.getText();
        int numofpages = Integer.parseInt(numPagesT.getText());
        if(booknamet.trim().equals("")||pricet.trim().equals("")|| pubyeart.trim().equals("")||
        pubhouset.trim().equals("") ||authornamet.trim().equals("")|| numpagest.trim().equals("")
        || isbnt2.trim().equals("")){
         JOptionPane.showMessageDialog(this, "Please enter value in all text fields!","User Information",
         JOptionPane.WARNING_MESSAGE);
        }
        if(numofpages <1){
         JOptionPane.showMessageDialog(this, "Incorrect number of pages!","User Information",
           JOptionPane.WARNING_MESSAGE);
        }
        else{
            double price= Double.parseDouble(priceT.getText());
            int nofpages = Integer.parseInt(numPagesT.getText());
            int pubyear = Integer.parseInt(pubYearT.getText());
            int isbnt = Integer.parseInt(ISBNT.getText());
         try{ 
            queries.connect();
            queries.insertbook(bookNameT.getText(),price,pubyear,pubHouseT.getText(),authorNameT.getText(),nofpages,isbnt);
            bookNameT.setText("");
            priceT.setText("");
            pubYearT.setText("");
            pubHouseT.setText("");
            authorNameT.setText("");
            numPagesT.setText("");
            ISBNT.setText("");
            queries.disconnect();
        }
        catch(SQLException a)
        {
         System.out.println(a);
        }
        }
    }
   }
}