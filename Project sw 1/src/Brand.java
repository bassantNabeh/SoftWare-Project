
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samar sabry
 */
public class Brand {
    String name;
    int id;
    int numOfProducts;
    ArrayList<Product> p=new ArrayList<>();
   /// Wallet wallet;
    
   
    Brand()
    {
        name="";
        id=0;
       numOfProducts=0;
      
    }
    
    public void setname(String n)
    {       
        name=n;
    }
    public void setId(int i)
    {
        id=i;
    }
    public void setNumOfProducts(int n)
    {
        numOfProducts=n;
    }
    public void setproducts(ArrayList<Product> arr)
    {
        p=arr;
    }

    @Override
    public String toString() {
        return "Brand{" + "name=" + name + ", id=" + id + ", numOfProducts=" + numOfProducts + ", p=" + p + '}';
    }
    
    
    
}
