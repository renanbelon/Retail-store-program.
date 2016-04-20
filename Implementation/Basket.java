
package CourseWork;


public class Basket
{
    private int productID;
    private String productName;
    private double pricePerUnit;
    private int quantity;
    public Basket(int productID, String productName,double pricePerUnit,int quantity )
    {    
         this.productID = productID;
         this.productName = productName;
         this.pricePerUnit = pricePerUnit;
         this.quantity = quantity;
    }

    public void setProductID(int productID){
    this.productID = productID;
    }
    
    public int getProductID(){
    return productID;
    }
    
    public void setProductName(String productName){
    this.productName = productName;
    }
    
    public String getProductName(){
    return productName;
    }
    
    public void setPricePerUnit(double pricePerUnit){
    this.pricePerUnit = pricePerUnit;
    }
    
    public double getPricePerUnit(){
        return pricePerUnit; 
    }
    
    public void setQuantity(int quantity){
     this.quantity = quantity;
    }
    
    public int getQuantity(){
        return quantity;
    }
}
