
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
public class Store {
   public  String name ;
    public int id;
    public int numOfProducts;
    ArrayList<Product> p=new ArrayList<>();
    
    
    
    
   // Brand b;

    
    
    public Store() {
    }

    public Store(String name, int id, int numOfProducts,ArrayList<Product> p) {
        this.name = name;
        this.id = id;
        this.numOfProducts = numOfProducts;
        this.p=p;
    }

    @Override
    public String toString() {
        return "Store{" + "name=" + name + ", id=" + id + ", numOfProducts=" + numOfProducts + ", p=" + p  + '}';
    }
    
    
}
