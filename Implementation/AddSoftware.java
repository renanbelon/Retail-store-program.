package CourseWork;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddSoftware extends JPanel implements ActionListener{

    JLabel sofIDL,sofNameL,sofpriceL,sofpubYearL,sofpubHouseL,processorReqL,ramReqL;
    JTextField sofIDT,sofNameT,sofpriceT,sofpubYearT,sofpubHouseT,processorReqT,ramReqT;
    JButton submitB;
    int w = 163;
    int h = 25;

    JLabel titleL;
    JPanel titleP;

    SqlQueries queries =new SqlQueries();

    public AddSoftware(){
    setSize(760,500);
    //setBackground(Color.GREEN);
    setLayout(null);
    
    // JPanel which holds the title label
    titleL = new JLabel("Add Software");
    titleL.setFont(new Font("Serif", Font.BOLD,25));
    titleP = new JPanel();
    titleP.setBounds(0,0,760,40);;
    //titleP.setBackground(Color.GREEN);
    titleP.add(titleL);
    add(titleP);
    
    sofIDL = new JLabel("Software ID");
    sofIDL.setBounds(10,60,100,h);
    add(sofIDL);
    
    sofIDT = new JTextField("New");
    sofIDT.setEditable(false);
    sofIDT.setBounds(160,60,w,h);
    add(sofIDT);
    
    sofNameL = new JLabel("Software Name");
    sofNameL.setBounds(10,88,100,h);
    add(sofNameL);
    
    sofNameT = new JTextField();
    sofNameT.setBounds(160,88,w,h);
    add(sofNameT);
    
    sofpriceL = new JLabel("Price");
    sofpriceL.setBounds(10,116,70,h);
    add(sofpriceL);
    
    sofpriceT = new JTextField();
    sofpriceT.setBounds(160,116,w,h);
    add(sofpriceT);
    
    sofpubYearL = new JLabel("Year of Publication");
    sofpubYearL.setBounds(10,144,110,h);
    add(sofpubYearL);
    
    sofpubYearT = new JTextField();
    sofpubYearT.setBounds(160,144,w,h);
    add(sofpubYearT);
    
    sofpubHouseL = new JLabel("Publication House");
    sofpubHouseL.setBounds(10,171,110,h);
    add(sofpubHouseL);
    
    sofpubHouseT = new JTextField();
    sofpubHouseT.setBounds(160,171,w,h);
    add(sofpubHouseT);
    
    processorReqL = new JLabel("Processor requirement");
    processorReqL.setBounds(10,199,140,h);
    add(processorReqL);

    processorReqT = new JTextField();
    processorReqT.setBounds(160,199,w,h);
    add(processorReqT);
    
    ramReqL = new JLabel("Ram Requirement");
    ramReqL.setBounds(10,227,120,h);
    add(ramReqL);
    
    ramReqT = new JTextField();
    ramReqT.setBounds(160,227,w,h);
    add(ramReqT);
    
    submitB = new JButton("Submit");
    submitB.setBounds(243,255,80,h);
    submitB.addActionListener(this);
    add(submitB);
   }
  
    public void actionPerformed(ActionEvent e){
    if(e.getSource()==submitB){
    String sofnamet = sofNameT.getText();
    String sofpricet = sofpriceT.getText();
    String sofpubyeart = sofpubYearT.getText();
    String sofpubhouset = sofpubHouseT.getText();
    String processorreqt= processorReqT.getText();
    String ramreqt= ramReqT.getText();
    
    if (sofnamet.trim().equals("") || sofpricet.trim().equals("") || sofpubyeart.trim().equals("") ||
    sofpubhouset.trim().equals("") || processorreqt.trim().equals("") || ramreqt.trim().equals("")){
    JOptionPane.showMessageDialog(this, "Please enter value in all text fields!","User Information",
    JOptionPane.WARNING_MESSAGE);
    }
    else{
        double price= Double.parseDouble(sofpriceT.getText());
        int pubyear = Integer.parseInt(sofpubYearT.getText());
    try{ 
        queries.connect();
        queries.insertSoftware(sofNameT.getText(),price,pubyear,sofpubHouseT.getText(),processorReqT.getText(),ramReqT.getText());
        sofNameT.setText("");
        sofpriceT.setText("");
        sofpubYearT.setText("");
        sofpubHouseT.setText("");
        processorReqT.setText("");
        ramReqT.setText("");
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


