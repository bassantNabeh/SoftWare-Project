/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samar sabry
 */
public class Admin extends User{
    
    public Admin(){
    }

    // int credit;
    public Admin(String name, int id, String phone, String password) {
        super(name, id, phone, password);
    }

    public void print() {
        System.out.println("name=" + name + ", phone=" + phone + ", password=" + password);
    }
    
    
   
}
