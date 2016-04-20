package CourseWork;


public class Product
{
//instance variables
private int pID;
private String pName;
private double cost;
private int pYearOfPublication;
private String pPublicationHouse;
//************************************************
public Product(int pID,String pName,double cost, int pYearOfPublication,String pPublicationHouse){
this.pID = pID;
this.pName = pName;
this.cost= cost;
this.pYearOfPublication= pYearOfPublication;
this.pPublicationHouse= pPublicationHouse;

}
//getters and setters methods
public void setPID(int pID)
{
  this.pID = pID;
}
   
public int getPID(){
  return pID;
}

public void setPName(String pName)
{
  this.pName = pName;
}

public String getPName()
{
  return pName;
}

public void setCost(Double cost)
{
  this.cost = cost;
}

public double getCost()
{
  return cost;
}

public void setPYearOfPublication(int  pYearOfPublication)
{
this.pYearOfPublication =  pYearOfPublication;
}

public int getPYearOfPublication()
{
return  pYearOfPublication;
}

public void setPPublicationHouse(String pPublicationHouse)
{
this.pPublicationHouse = pPublicationHouse;
}

public String getPPublicationHouse()
{
return pPublicationHouse;
}
//***************************************************************
}
