package CourseWork;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddCustomer extends JPanel implements ActionListener{
    JLabel IDL,fNameL,sNameL,DOBL,addressL,postCodeL,PhoneL;
    JTextField IDT,fNameT,sNameT,DOBT,addressT,postCodeT,PhoneT;
    JButton submitCB;
    JPanel titleP;
    JLabel titleL;
    
    SqlQueries queries = new SqlQueries();
    
    public AddCustomer(){
    setBounds(0,73,760,400);
    setLayout(null);
    
    // JPanel which holds the title label
    titleL = new JLabel("Add Customer");
    titleL.setFont(new Font("Serif", Font.BOLD,25));
    titleP = new JPanel();
    titleP.setBounds(0,0,760,40);;
    titleP.add(titleL);
    add(titleP);
    
    
    IDL = new JLabel("ID");
    IDL.setBounds(10,45,40,25);
    add(IDL);
    
    IDT = new JTextField("New");
    IDT.setEditable(false);
    IDT.setBounds(130,45,150,25);
    add(IDT);
    
    fNameL = new JLabel("First Name");
    fNameL.setBounds(10,73,100,25);
    add(fNameL);
    
    fNameT = new JTextField();
    fNameT.setBounds(130,73,150,25);
    add(fNameT);
    
    sNameL = new JLabel("Surname");
    sNameL.setBounds(10,101,100,25);
    add(sNameL);
    
    sNameT = new JTextField();
    sNameT.setBounds(130,101,150,25);
    add(sNameT);
    
    DOBL = new JLabel("Date of Birth");
    DOBL.setBounds(10,128,100,25);
    add(DOBL);
    
    DOBT = new JTextField();
    DOBT.setBounds(130,128,150,25);
    add(DOBT);
    
    addressL = new JLabel("address");
    addressL.setBounds(10,157,100,25);
    add(addressL);
    
    addressT = new JTextField();
    addressT.setBounds(130,156,150,25);
    add(addressT);
    
    postCodeL = new JLabel("Postcode");
    postCodeL.setBounds(10,184,100,25);
    add(postCodeL);
    
    postCodeT = new JTextField();
    postCodeT.setBounds(130,184,150,25);
    add(postCodeT);
    
    PhoneL = new JLabel("Phone");
    PhoneL.setBounds(10,212,100,25);
    add(PhoneL);
    
    PhoneT = new JTextField();
    PhoneT.setBounds(130,212,150,25);
    add(PhoneT);
    
    submitCB = new JButton("Submit");
    submitCB.setBounds(200,240,80,25);
    submitCB.addActionListener(this);
    add(submitCB);
    }

    public void actionPerformed(ActionEvent e){
    if (e.getSource() == submitCB){
        String fnamet = fNameT.getText();
        String snamet =sNameT.getText();
        String dobt = DOBT.getText();
        String addresst = addressT.getText();
        String postcodet = postCodeT.getText();
        String phonet = PhoneT.getText();
        if(fnamet.trim().equals("")|| snamet.trim().equals("") || dobt.trim().equals("") ||
        addresst.trim().equals("") || postcodet.trim().equals("") || phonet.trim().equals(""))
        {
        JOptionPane.showMessageDialog(this, "Please enter value in all text fields!","User Information",
        JOptionPane.WARNING_MESSAGE);
        }
        else{
        try{
            queries.connect();
            queries.insertCustomer(fNameT.getText(),sNameT.getText(),
            DOBT.getText(),addressT.getText(),postCodeT.getText(),PhoneT.getText());
            fNameT.setText("");
            sNameT.setText("");
            DOBT.setText("");
            addressT.setText("");
            postCodeT.setText("");
            PhoneT.setText("");
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
