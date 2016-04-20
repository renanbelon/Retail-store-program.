package CourseWork;



public class Book extends Product
{
//books instance variables
   private String author;
   private int nPages;
   private int ISBN;
   
   public Book(String author,int nPages, int ISBN,int pID,String pName,double cost, int pYearOfPublication,String pPublicationHouse){
    super(pID,pName,cost,pYearOfPublication,pPublicationHouse);
    this.author = author;
    this.nPages = nPages;
    this.ISBN=ISBN;
    }
  
//getters and setters methods
   public void setAuthor(String author)
   {
    this.author = author;
   }
   
   public String getAuthor()
   {
     return author;  
   }
   
   public void setNPages(int nPages)
   {
    this.nPages = nPages;
   }
   
   public int getNpages()
   {
   return nPages;
   }
   
   public void setISBN(int ISBN)
   {
    this.ISBN = ISBN;
   }
   
   public int getISBN()
   {
   return ISBN;
   }
   
}
