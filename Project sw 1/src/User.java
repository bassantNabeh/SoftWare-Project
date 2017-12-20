
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

    public int count = 0;

    ArrayList<Object> User = new ArrayList<Object>();
    public DB D = new DB();
    public Product p = new Product();

    public String name;
    public int id;
    public String phone;
    public String password;

    public User() {
    }

    public User(String name, int id, String phone, String password) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.password = password;
    }

    public void Explorle_Product() {
        System.out.println("*************System have these products*****************");
        ArrayList<Product> Users = new ArrayList<Product>();
        User = D.Read_File(2);
        for (int i = 0; i < User.size(); i++) {
            Users.add((Product) User.get(i));
            //System.out.println(User.get(i).toString());

        }
        System.out.println("product id , productName ,product Price:");
        for (int i = 0; i < Users.size(); i++) {
            System.out.println(Users.get(i).id + " , " + Users.get(i).name + " ," + Users.get(i).price);
        }

        System.out.println("___________________________________________________________");
    }

    public void showspcific_Product_details() {
        ArrayList<Product> pp = new ArrayList<>();
        Explorle_Product();

        System.out.println("enter spcific id_ product to want to view:");
        Scanner in = new Scanner(System.in);
        int product_id = in.nextInt();

        ArrayList<Product> Users = new ArrayList<Product>();
        User = D.Read_File(2);
        for (int i = 0; i < User.size(); i++) {
            Users.add((Product) User.get(i));

        }
        int index = -1;
        for (int i = 0; i < Users.size(); i++) {
            if (Users.get(i).id == product_id) {
                System.out.println(Users.get(i).toString());
                index = i;
                break;
            }
        }

        if (index != -1) {
            String fileName = "products.txt";
            File f = new File(fileName);
            f.delete();

            p.count = count++;
            Users.get(index).count++;
            for (int i = 0; i < Users.size(); i++) {
                D.Write_file(2, Users.get(i));
            }
            show_all_system(product_id);
            // System.out.println("llllllllllllllllllllllllllllllllllllllllll");
        } else {
            System.out.println("Wrong id.");
        }

//       ArrayList<Object> x=Array
//       D.Update_file(2, Users);
    }

    public void show_all_system(int id) {
        DB db = new DB();
        ArrayList<Object> Brands1 = db.Read_File(3);
        ArrayList<Object> StoreOwners1 = db.Read_File(4);
        ArrayList<Brand> Brands = new ArrayList<>();
        ArrayList<StoreOwner> StoreOwners = new ArrayList<>();

        int x = 0;

        for (int i = 0; i < Brands1.size(); i++) {
            Brands.add((Brand) Brands1.get(i));

        }

        for (int d = 0; d < Brands.size(); d++) {

            for (int i = 0; i < Brands.get(d).p.size(); i++) {
                // System.out.println(StoreOwners.get(d).Stores.get(j).p.get(i).count);
                if (Brands.get(d).p.get(i).id == id) {
                    String fileName = "Brands.txt";
                    File f = new File(fileName);
                    f.delete();
                    Brands.get(d).p.get(i).count++;
                    for (int s = 0; s < Brands.size(); s++) {
                        D.Write_file(3, Brands.get(s));
                    }
                    return;
                }
            }

        }

        for (int i = 0; i < StoreOwners1.size(); i++) {
            StoreOwners.add((StoreOwner) StoreOwners1.get(i));
            //System.out.println("  here once.");

        }
        // System.out.println("");
        for (int d = 0; d < StoreOwners.size(); d++) {
            for (int j = 0; j < StoreOwners.get(d).Stores.size(); j++) {
                //System.out.println("Store :" + StoreOwners.get(d).Stores.get(j).name);
                for (int i = 0; i < StoreOwners.get(d).Stores.get(j).p.size(); i++) {
                    // System.out.println(StoreOwners.get(d).Stores.get(j).p.get(i).count);
                    if (StoreOwners.get(d).Stores.get(j).p.get(i).id == id) {
                        String fileName = "StoreOwner.txt";
                        File f = new File(fileName);
                        f.delete();
                        StoreOwners.get(d).Stores.get(j).p.get(i).count++;
                        //System.out.println(" StoreOwners.size() = "+StoreOwners.size());
                        //System.out.println(" StoreOwners.size.p() = "+StoreOwners.get(d).Stores.get(j).p.size());

                        for (int s = 0; s < StoreOwners.size(); s++) {
                            D.Write_file(4, StoreOwners.get(s));
                        }
                        return;
                    }
                }
            }
        }

    }

    public void print() {
        System.out.println("name=" + name + ", phone=" + phone + ", password=" + password);
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", id=" + id + ", phone=" + phone + ", password=" + password + '}';
    }

}
