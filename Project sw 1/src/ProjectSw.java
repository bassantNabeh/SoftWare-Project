
import java.util.ArrayList;
import java.util.Scanner;
import jdk.nashorn.internal.runtime.regexp.RegExp;

public class ProjectSw {

    public static ArrayList<User> Users = new ArrayList<>();

    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Brand> Brands = new ArrayList<>();
    public static ArrayList<Admin> Admins = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<StoreOwner> StoreOwners = new ArrayList<>();
    

   /* public static void main(String[] args)
    {
     DB db=new DB();   
        ArrayList<Object> arr=db.Read_File(4);
    }*/
    public static void main(String[] args) {
       /* DB db1=new DB();   
        ArrayList<Object> arrayyyyyyyyyyyyyyy=db1.Read_File(4);*/
        RegisterController Reges = new RegisterController();
        User user_class = new User();
        SystemController sys_con=new SystemController();
        StoreController stor_con=new StoreController();
        //System.out.println("Stor" + stor_con.GetProductById(1));
        StoreOwner owner=new StoreOwner();
        DB db=new DB();
        BuyingController buying_con=new BuyingController();
        Scanner in = new Scanner(System.in);
        int user_Number = 0;//1Admin 2StoreOwner 3Customer
        do {
            System.out.println("\n\n********************Welcome to MarchySite*******************"
                    + "Please Enter What you want to do:\n"
                    + "\n1-->login\n2-->Register\n3-->View specific product details"
                    + "\n4-->Explore products in store "
                    + "\nAny thing else consider exit the site.\nEnter your choice :  ");
            int chose_function = in.nextInt();
            User user_person=null;
            if (chose_function == 1) {
                System.out.print("Enter your Name :");
                User Current_user = new User();
                Current_user.name = in.next();
                System.out.print("Enter your password :");
                Current_user.password = in.next();
                user_Number = Reges.login(Current_user);
                if(user_Number==1){
                    int index_user=show_all_system(1,Current_user.password);
                    user_person=Admins.get(index_user);
                }
                else if(user_Number==2){
                    int index_user=show_all_system(2,Current_user.password);
                    System.out.println("index = "+index_user);
                    user_person=StoreOwners.get(index_user);
                    
                }else if(user_Number==3){
                    int index_user=show_all_system(3,Current_user.password);
                    user_person=customers.get(index_user);
                }
            } else if (chose_function == 2) {
                System.out.print("Enter your Name :");
                User Current_user = new User();
                
                Current_user.name = in.next();
                System.out.print("Enter your password :");
                Current_user.password = in.next();
                System.out.println("Enter user  phone:");
                Current_user.phone = in.next();
                System.out.println("what do you want to register?\n1:Admin"
                        + "\n2:strore owner \n 3:Customer ");
                int type = in.nextInt();
                if (type == 1 || type == 2 || type == 3) {
                   
                    if (Reges.Register(Current_user, type)) {
                        user_Number = type;
                         user_person=Current_user;
                    } else {
                        System.out.println("Sorry you can't register. ");
                        user_Number = 0;
                        
                    }

                }

            } else if (chose_function == 3) {
                user_class.showspcific_Product_details();
                user_Number = 0;
            } else if (chose_function == 4) {
                user_class.Explorle_Product();
                user_Number = 0;
            } else {
                System.out.println("Thanks for using our service.\nNow you will exit.");
                user_Number = 0;
                break;
            }

            if (user_Number == 1) {
                do{
                    System.out.println("you can Enter What you want to do:\n"
                    + "1-->Add product to system.\n2-->Add Brand to System."
                    + "\n3-->Explore products in store"
                    + "\n4-->View specific product details"
                    + "\nAny thing else consider log out.\nEnter your choice : ");
                    int chose_Admin_function=in.nextInt();
                    if(chose_Admin_function==1){
                        sys_con.AddProduct_to_System((Admin)user_person);
                    }else if(chose_Admin_function==2){
                        sys_con.Addbrand_to_System((Admin)user_person);
                    }else if(chose_Admin_function==3){
                        user_class.showspcific_Product_details();
                    }else if(chose_Admin_function==4){                         
                         user_class.Explorle_Product();
                    }else{
                        System.out.println("logout Success.");
                        break;
                    }
                    
                }while(true);

            } else if (user_Number == 2) {
                do{
                    System.out.println("you can Enter What you want to do:\n"
                    + "1-->Add Store.\n2-->Add Product to Store."
                    + "\n3-->Explore products in store"
                    + "\n4-->View specific product details"
                    + "\n5-->Explore number of views to each product in a store."
                    + "\n6-->Get the most viewed product in a store ."
                    + "\n7-->Suggest product. \nEnter your choice : ");
                    int chose_Admin_function=in.nextInt();
                    if(chose_Admin_function==1){
                        sys_con.AddStore_to_System((StoreOwner)user_person);
                    }else if(chose_Admin_function==2){
                        stor_con.AddProduct_to_Store((StoreOwner)user_person);
                        ArrayList<Object> arr=new ArrayList<>();
                        for(int i=0;i<StoreOwners.size();i++){
                            arr.add(StoreOwners.get(i));
                        }
                        db.Update_file(4,arr );
                    }else if(chose_Admin_function==3){
                        user_class.showspcific_Product_details();
                    }else if(chose_Admin_function==4){                         
                         user_class.Explorle_Product();
                    }else if(chose_Admin_function==5){
                        owner.Explore_number_showproduct((StoreOwner)user_person);
                    }else if(chose_Admin_function==6){
                        Product prod=owner.Getmax_number_showproduct((StoreOwner)user_person);
                        System.out.println("Most viewed product in your stores: "+ prod.toString());
                    }else if(chose_Admin_function==7){
                        System.out.println("Enter name of product you suggest:");
                        String productName=in.next();
                       owner.suggest(productName);
                    }else{
                        System.out.println("logout Success.");
                        break;
                    }
                    
                }while(true);

                

            } else if (user_Number == 3) {
                 do{
                    System.out.println("you can Enter What you want to do:\n"
                    + "1-->Suggest product \n2-->Buy product "
                    + "\n3-->Explore products in store"
                    + "\n4-->View specific product details"
                    + "\nAny thing else consider log out.\nEnter your choice : ");
                    int chose_Admin_function=in.nextInt();
                    if(chose_Admin_function==1){
                        System.out.println("Enter name of product you suggest:");
                        String productName=in.next();
                       owner.suggest(productName);
                    }else if(chose_Admin_function==2){
                        buying_con.BuyingProduct((Customer)user_person);
                    }else if(chose_Admin_function==3){
                        user_class.showspcific_Product_details();
                    }else if(chose_Admin_function==4){                         
                         user_class.Explorle_Product();
                    }else{
                        System.out.println("logout Success.");
                        break;
                    }
                    
                }while(true);


            }

        } while (true);

    }

    public static int show_all_system(int type,String password) {
        DB db = new DB();
        ArrayList<Object> products1 = db.Read_File(2);
        //System.out.println("****************************");
        ArrayList<Object> Brands1 = db.Read_File(3);
        //System.out.println("****************************");
        ArrayList<Object> Admins1 = db.Read_File(1);
        //System.out.println("****************************");
        ArrayList<Object> customers1 = db.Read_File(5);
        //System.out.println("****************************");
        ArrayList<Object> StoreOwners1 = db.Read_File(4);

       // System.out.println("************products****************");
        for (int i = 0; i < products1.size(); i++) {
            products.add((Product) products1.get(i));
           // System.out.println(products.get(i));
        }
       // System.out.println("************Brands****************");
        for (int i = 0; i < Brands1.size(); i++) {
            Brands.add((Brand) Brands1.get(i));
            //System.out.println(Brands.get(i));
        }
       // System.out.println("************Admins****************");
        for (int i = 0; i < Admins1.size(); i++) {
            Admins.add((Admin) Admins1.get(i));
          //  System.out.println(Admins.get(i));
          if(type==1&&Admins.get(i).password.equals(password))
          {
              return i;
          }
        }
        //System.out.println("************Customer****************");
        for (int i = 0; i < customers1.size(); i++) {
            customers.add((Customer) customers1.get(i));
            System.out.println("customer password :"+customers.get(i).password);
            if(type==3&&customers.get(i).password.equals(password))
          {
              return i;
          }
        }
        //System.out.println("************Store owner****************");
        for (int i = 0; i < StoreOwners1.size(); i++) {
            StoreOwners.add((StoreOwner) StoreOwners1.get(i));
            System.out.println("owner password="+StoreOwners.get(i).password+" ,password = "+password);
           if(type==2&&StoreOwners.get(i).password.equals(password))
          {
              System.out.println("----------------------------------");
              return i;
          }
        }
        return -1;
    }

}

/*  StoreOwner storeOwner=new StoreOwner();
        storeOwner.name="Mai";
        storeOwner.id=1;
        storeOwner.password="123mai";
        storeOwner.wallet.StoreMoney=0;
        storeOwner.wallet.brandMoney=0;
        storeOwner.phone="211011011011";
        
        ArrayList<Store> stors=new ArrayList<>();
        Store stor=new Store();
        stor.name="toys Store";
        stor.id=1;
        stor.numOfProducts=1;
        Product p2 = new Product();
        p2.amount = 5;
        p2.name = "parpy";
        p2.brand = "qeuen";
        p2.color = "pank";
        p2.id = 1;
        p2.category = "toy Department";
        p2.points = 0;
        p2.price = 20;
        p2.description="best girls toy";
        p2.count=0;
        stor.p.add(p2);
        stors.add(stor);
        storeOwner.Stores=stors;
       // System.out.println(" samar existance = "+syst.validation(4,storeOwner ));*/
 /* db.Write_file(4, storeOwner);*/
//RegisterController re=new RegisterController();
// re.Register();
//SystemController syst = new SystemController();

/* StoreOwner storeOwner=new StoreOwner();
        storeOwner.name="Mai";
        storeOwner.id=1;
        storeOwner.password="123mai";
        storeOwner.wallet.StoreMoney=0;
        storeOwner.wallet.brandMoney=0;
        storeOwner.phone="211011011011";
        System.out.println(" samar existance = "+syst.validation(4,storeOwner ));*/
// db.Write_file(4, storeOwner);
/*Admin admin=new Admin ();
        admin.id=2;
        admin.name="Elham";
        admin.password="123elham";
        admin.phone="112012012012";
        System.out.println(" elham existance = "+syst.validation(1, admin));*/
// db.Write_file(1, admin);
/*Customer  customer1=new Customer();
        customer1.id=1;
        customer1.name="Katrain";
        customer1.password="123kat";
        customer1.phone="313013013013";
        customer1.points=0;
        customer1.numOfCard=12345;*/
//db.Write_file(5, customer1);
/*Customer  customer2=new Customer();
        customer2.id=2;
        customer2.name="Samar";
        customer2.password="123samar";
        customer2.phone="314014014014";
        customer2.points=0;
        customer2.numOfCard=12345;
        System.out.println(" samar existance = "+syst.validation(5, customer2));*/
// db.Write_file(5, customer2);
/* Customer  customer3=new Customer();
        customer3.id=3;
        customer3.name="Bassant";
        customer3.password="123basant";
        customer3.phone="315015015015";
        customer3.points=0;
        customer3.numOfCard=12345;*/
//db.Write_file(5, customer3);
// SystemController syst = new SystemController();
// DB db = new DB();
//        Product p = new Product();
//        Brand p1 = new Brand();
//        p1.name = "brand1";
//        p1.id = 1;
//        p1.numOfProducts = 1;
//
//        p.amount = 5;
//        p.name = "cap";
//        p.brand = "adidas";
//        p.color = "red";
//        p.id = 1;
//        p.category = "caps Department";
//        p.points = 0;
//        p.price = 20;
//        p1.p.add(p);
//        db.Write_file(3, p1);
/*Product p2 = new Product();
        p2.amount = 5;
        p2.name = "cap";
        p2.brand = "adidas";
        p2.color = "red";
        p2.id = 1;
        p2.category = "caps Department";
        p2.points = 0;
        p2.price = 20;
        p2.description="description";
        db.Write_file(2, p2);*/
//StoreController s = new StoreController();
//s.Addbrand_to_Store();
/*User user=new Admin();
        user.id=1;
        user.name="us1";
        user.password="p1";
        user.phone="1234";*/
//Users.add(user);
// db.Write_file(1, user);
/* User user1=new Admin();
        user1.id=1;
        user1.name="us1";
        user1.password="p1";
        user1.phone="1234";
        // System.out.println(syst.validation(1,user1));
        RegisterController resg=new RegisterController();
        System.out.println(resg.login(user1));
        System.out.println(resg.Register(user1));*/
         //resg.Register();
