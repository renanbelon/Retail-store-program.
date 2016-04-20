package CourseWork;



public class Software extends Product
{
     private String processor,ram;

    public Software(String processor,String ram,int pID,String pName,double cost, int pYearOfPublication,String pPublicationHouse){
        super(pID,pName,cost,pYearOfPublication,pPublicationHouse);
        this.processor = processor;
        this.ram = ram;

    }

   public void setProcessor(String processor)
   {
    this.processor = processor;
   }
   
   public String getProcessor()
   {
     return processor;  
   }

   public void setRam(String ram)
   {
    this.ram = ram;
   }
   
   public String getRam()
   {
     return ram;  
   }
   
}
//Software details must store the minimum computer system requirements
// (e.g. RAM and processor requirements).