/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samar sabry
 */
public class AdminController {
    Brand brand;
    Admin admin;
    
    
    public void AddProduct_to_System(Admin admin)
   {
       
   }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "AdminController{" + "brand=" + brand + ", admin=" + admin + '}';
    }
    
    
}
