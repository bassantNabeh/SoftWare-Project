import java.util.ArrayList;
import java.util.Scanner;

public class BuyingController {
    DB db=new DB();
    Product product;
    Wallet wallet;
    


void AddToChart(Customer customer)
    {
        StoreController store =new StoreController();
        Scanner input=new Scanner(System.in);
        
        int numOfProducts=0;
        System.out.println("Enter number of products you want to buy.");
        numOfProducts=input.nextInt();
        
        while(numOfProducts!=0)
        {
            Product p=new Product();
            int code , amount=0;
            System.out.println("Enter code of product.");
            code=input.nextInt();
            System.out.println("Enter amount .");
            amount=input.nextInt();
            
            
            p=store.GetProductById(code);
            System.out.println("p= "+p.name);
            
          if(p!=null)
          {
             if(p.amount<amount)
             {
                 System.out.println("Sorry, there is does not enough amout of this product .");
                 System.out.println("Please, enter new amount of this product.");
                 amount=input.nextInt();
                 
             }
             for(int i=0;i<amount;i++)
             {
                 customer.chart.add(p);
             }
          }
          else{
              System.out.println("Sorry, this code does not exist!!");
          }
          numOfProducts--;
        }
        System.out.println("your products!");
        for(int i=0;i<customer.chart.size();i++)
        {
            System.out.println(customer.chart.get(i).name);
        }
     BuyingProduct(customer);   
        
    }
    
    
    public void BuyingProduct(Customer customer)
    {
        Scanner input=new Scanner(System.in);
        
        ArrayList<Product> chart=customer.chart;
        float totalPrice=0 , customerPoint=0;
        int totalPoints=0;
        int choose;
        for(int i=0;i<chart.size();i++)
        {
            totalPrice+=chart.get(i).price;
            totalPoints+=chart.get(i).points;
        }
     
        System.out.println("Do you want use your voucher ?!");
        System.out.println("       1- yes                2- no");
        
        choose=input.nextInt();
        if(choose==1)
        {
            voucher(totalPrice,customer);
        }
        else{
                 System.out.println("Now,you need to pay "+totalPrice);
        }
        customer.points+=totalPoints;
        System.out.println("Your account now has "+customer.points+" points.");
        
      
    }
    
    public void voucher(float price, Customer customer)
    {
        int customerPoints=0;
        customerPoints=customer.points;
        System.out.println("your points  before paying by vaucher:  "+customerPoints);
        System.out.println("The price  before paying by vaucher:  "+price);

        customerPoints=customerPoints*10;
        if(customerPoints==0)
        {
            System.out.println("Sorry,you don't have enough points!");
        }
       else if(customerPoints==price)
        {
            customerPoints=0;
            price=0;           
        }
       else if(customerPoints>price)
        {
            customerPoints-=price;
            price=0;
            customerPoints=customerPoints/10;
        }
       else if(customerPoints<price )
       {          
           price=price-customerPoints;
           customerPoints=0;
           
       }
      customer.points=customerPoints;
      System.out.println("your points now after paying by vaucher:  "+customerPoints);
      System.out.println("The price now after paying by vaucher:  "+price);

      if(price!=0)
      {
          System.out.println("Now,you need to pay "+price);
      }
    }
    
    /*public void Explorle_Product(){
        ArrayList<Object> array=new ArrayList();
       ArrayList<Product> Products = new ArrayList();
       array=db.Read_File(2);
       for(int i=0;i<array.size();i++)
       {
          Products.add((Product)array.get(i));
           
       }
       for(int i=0;i<Products.size();i++){
           System.out.println(Products.get(i).id+" - "+Products.get(i).name);
           System.out.println(Products.get(i).amount+", "+Products.get(i).price);
       }
       System.out.println("hello");
   
    }*/
}
