package CourseWork;


public class Customer
{   
    private int cID;
    private String fName,sName,dob,address,postCode,phone;
    
    public Customer (int cID,String fName,String sName, String dob, String address, String postCode,String phone){
    
    this.cID = cID;
    this.fName = fName;
    this.sName = sName;
    this.dob =dob;
    this.address= address;
    this.postCode = postCode;
    this.phone = phone;
    
    
    }
   
    public void setCID(int cID){
    this.cID = cID;
        }
        
    public int getCID(){
    return cID;
    }
   
    public void setFName(String fName){
        this.fName = fName;
    }
    
    public String getFName(){
        return fName;
    }
  
    public void setSName(String sName){
    this.sName = sName;
    }
    
    public String getSName(){
    return sName;
    }
    
    public void setDob(String dob){
    this.dob = dob;
    }
    
    public String getDob(){
    return dob;
    }
    
    public void setAddress(String address){
    this.address = address;
    }
    
    public String getAdress(){
    return address;
    }
    
    public void setPostCode(String postCode){
    this.postCode = postCode;
    }
    
    public String getPostCode(){
    return postCode;
    }
    
    public void setPhone(String phone){
    this.phone = phone;
    }
    
    public String getPhone(){
    return phone;
    }
}
