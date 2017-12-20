/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.security.acl.Owner;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Bosy
 */
public class TestingClass {

    public TestingClass() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    ProjectSw project = new ProjectSw();
    RegisterController reg = new RegisterController();
    SystemController system=new SystemController();
    StoreController stor=new StoreController();
    BuyingController buy = new BuyingController();
    
    
    Product p = new Product("cap", (float) 20.0, "description"," red", 5, 1,"caps Department",0, "adidas", 3) ;

    
    int id = 2;
    String name = "Elham";
    String password = "123elham";
    String phone = "112012012012";
    User admin = new Admin(name, id, phone, password);
    int idSO= 1;
    String nameSO= "Mai";
    String passwordSO= "123mai";
    String phoneSO = "211011011011";
    User owner=new StoreOwner(nameSO, idSO, phoneSO, passwordSO);
    int idCust = 1;
    String nameCust = "Katrain";
    String passwordCust = "123kat";
    String phoneCust = "313013013013";
    User customer = new Customer(nameCust, idCust, phoneCust, passwordCust);

    @Test
    public void login() {
        Assert.assertEquals(1, reg.login(admin));
    }

    @Test
    public void Register() {
        Assert.assertEquals(false, reg.Register(admin,1));
    }
    
    @Test
    public void validation() {
        Assert.assertEquals(true, system.validation(1,admin));
    }
 
    @Test
    public void AddProduct_to_System() {
        Assert.assertEquals(true, system.AddProduct_to_System((Admin) admin));
    }
    
    @Test
    public void Addbrand_to_System() {
        Assert.assertEquals(true, system.Addbrand_to_System((Admin) admin));
    }
    
    @Test
    public void AddStore_to_System() {
        Assert.assertEquals(true, system.AddStore_to_System((StoreOwner)owner));
    }
    
    @Test
    public void AddProduct_to_Store() {
        Assert.assertEquals(true, stor.AddProduct_to_Store((StoreOwner)owner));
    }
    
  /* @Test 
    public void GetProductById() {
        
        Assert.assertEquals(p, stor.GetProductById(1));
    }*/
    
    
    
}
