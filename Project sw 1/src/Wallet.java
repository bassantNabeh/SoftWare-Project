/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samar sabry
 */
public class Wallet {
    float StoreMoney , brandMoney;
    
    Wallet()
    {
    StoreMoney=0;
    brandMoney=0;
    }
    
    public void setStoreMoney(float s)
    {
        StoreMoney=s;
    }
    public void setBrandMoney(float s)
    {
        brandMoney=s;
    }
    
     public float getStoreMoney()
    {
       return StoreMoney;
    }
    public float getBrandMoney()
    {
        return brandMoney;
    }
}
