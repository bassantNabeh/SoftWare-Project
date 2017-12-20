
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    public String read_buffer(String file_name) {
        String str = new String();
        try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                str += sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public ArrayList<Admin> Read_File_Admin() {
        ArrayList<Admin> list = new ArrayList();
        String fileName = "Admins.txt";
        String str = read_buffer(fileName);
        String[] objects = str.split(";");
        for (int i = 0; i < objects.length; i++) {
            Admin admin = new Admin();
            String[] objec = objects[i].split(",");
            admin.name = objec[0];
            admin.id = Integer.parseInt(objec[1]);
            admin.password = objec[2];
            admin.phone = objec[3];
            list.add(admin);
        }

        return list;
    }

    public ArrayList<Object> Read_File(int chose) {
        ArrayList<Object> list = new ArrayList<>();;
        String fileName = "";
        if (chose == 1) {//for admin.
            fileName = "Admins.txt";
            String str = read_buffer(fileName);
            String[] objects = str.split(";");
            for (int i = 0; i < objects.length; i++) {
                Admin admin = new Admin();
                String[] objec = objects[i].split(",");
                admin.name = objec[0];
                admin.id = Integer.parseInt(objec[1]);
                admin.password = objec[2];
                admin.phone = objec[3];
                list.add(admin);
            }

        } else if (chose == 2) {//product
            fileName = "products.txt";
            String str = read_buffer(fileName);
            String[] objects = str.split(";");
            for (int i = 0; i < objects.length; i++) {
                Product product = new Product();
                String[] objec = objects[i].split(",");
                product.name = objec[0];
                //System.out.println(" objec[0] = "+objec[0]);
                //System.out.println(" ob size ="+objec.length);
                //System.out.println("objec[1] = "+objec[1]);
                product.id = Integer.parseInt(objec[1]);
                product.brand = objec[2];
                product.category = objec[3];
                product.color = objec[4];
                product.amount = Integer.parseInt(objec[5]);
                product.points = Integer.parseInt(objec[6]);
                product.description = objec[7];
                ///////// System.out.println("price = "+objec[8]);
                product.price = Float.parseFloat(objec[8]);
                product.count = Integer.parseInt(objec[9]);
                list.add(product);
            }

        } else if (chose == 3) {//brand
            fileName = "Brands.txt";
            String str = read_buffer(fileName);
            String[] objects = str.split(";");
            //System.out.println("number of brands = "+objects.length);
            for (int i = 0; i < objects.length; i++) {
                Brand brand = new Brand();
                String[] objec = objects[i].split(",");
                // System.out.println("number of variable of brand = "+objec.length);
                brand.name = objec[0];
                brand.id = Integer.parseInt(objec[1]);
                brand.numOfProducts = Integer.parseInt(objec[2]);
                String[] arr_products = objec[3].split("#");
                // System.out.println(" number of products = "+arr_products.length);
                for (int j = 0; j < arr_products.length; j++) {
                    // System.out.println("*************************************");
                    String[] arr_pro = arr_products[j].split("=");
                    //System.out.println("number of product variable = "+arr_pro.length);
                    // System.out.println("arr_pro= "+arr_products[j]);
                    //for (int s = 0; s < arr_pro.length; s++) {
                        Product product = new Product();
                        product.name = arr_pro[0];
                        product.id = Integer.parseInt(arr_pro[1]);
                        product.brand = arr_pro[2];
                        product.category = arr_pro[3];
                        product.color = arr_pro[4];
                        product.amount = Integer.parseInt(arr_pro[5]);
                        product.points = Integer.parseInt(arr_pro[6]);
                        product.description = arr_pro[7];
                        product.price = Float.parseFloat(arr_pro[8]);
                        product.count = Integer.parseInt(arr_pro[9]);
                        brand.p.add(product);
                   // }
                    //
                }
                list.add(brand);
            }
        } else if (chose == 4) {
            fileName = "StoreOwner.txt";
            String str = read_buffer(fileName);
            String[] objects = str.split(";");
            for (int i = 0; i < objects.length; i++) {
                StoreOwner storeOwner = new StoreOwner();
                String[] objec = objects[i].split(",");
                storeOwner.name = objec[0];
                storeOwner.id = Integer.parseInt(objec[1]);
                storeOwner.password = objec[2];
                storeOwner.phone = objec[3];
                storeOwner.wallet.StoreMoney = Float.parseFloat(objec[4]);
                storeOwner.wallet.brandMoney = Float.parseFloat(objec[5]);
                String[] StoreOwnerStores = objec[6].split("%");
                ArrayList<Store> stors=new ArrayList<>();
               // System.out.println("number of stores:"+StoreOwnerStores.length);
                for (int j = 0; j < StoreOwnerStores.length; j++) {
                    String[] store = StoreOwnerStores[j].split("&");
                   // System.out.println("StoreOwnerStores[j]="+StoreOwnerStores[j]);
                    Store store1 = new Store();
                    store1.name = store[0];
                    store1.id = Integer.parseInt(store[1]);
                    store1.numOfProducts = Integer.parseInt(store[2]);
                    String[] arr_products = store[3].split("#");
                    // System.out.println(" number of products = "+arr_products.length);
                    for (int h = 0; h < arr_products.length; h++) {
                        // System.out.println("*************************************");
                        String[] arr_pro = arr_products[h].split("=");
                       // System.out.println("number of product variable = "+arr_pro.length);
                        // System.out.println("arr_pro= "+arr_products[j]);
                       // for (int s = 0; s < arr_pro.length; s++) {
                            Product product = new Product();
                            product.name = arr_pro[0];
                            product.id = Integer.parseInt(arr_pro[1]);
                            product.brand = arr_pro[2];
                            product.category = arr_pro[3];
                            product.color = arr_pro[4];
                            product.amount = Integer.parseInt(arr_pro[5]);
                            product.points = Integer.parseInt(arr_pro[6]);
                            product.description = arr_pro[7];
                            product.price = Float.parseFloat(arr_pro[8]);
                            product.count = Integer.parseInt(arr_pro[9]);
                            store1.p.add(product);
                       // }
                        
                    }
                    stors.add(store1);
                }
                storeOwner.Stores=stors;
                    list.add(storeOwner);

                }
            }else if (chose == 5) {
            fileName = "Customers.txt";
            String str = read_buffer(fileName);
            String[] objects = str.split(";");
            for (int i = 0; i < objects.length; i++) {
                Customer cust = new Customer();
                String[] objec = objects[i].split(",");
                cust.name = objec[0];
                cust.id = Integer.parseInt(objec[1]);
                cust.password = objec[2];
                cust.phone = objec[3];
                cust.numOfCard = Integer.parseInt(objec[4]);
                cust.points = Integer.parseInt(objec[5]);
                list.add(cust);
            }

        }else if(chose==6){
            fileName = "Suggest.txt";
             String str = read_buffer(fileName);
            String[] objects = str.split(",");
            for(int i=0;i<objects.length;i++){
                list.add(objects[i]);
            }
            
            
        } else {
            System.out.println("sorry you can't read");

        }

            return list;

        }
        //1 Admin 2 product 3brand. 4 storeowner 5customer

    public void Write_file(int chose, Object obj) {
        String object = "";
        String fileName = "";

        if (chose == 1) {
            fileName = "Admins.txt";
            Admin user = (Admin) obj;
            object += (user.name + "," + user.id + "," + user.password + "," + user.phone + ";");
        } else if (chose == 2) {
            fileName = "products.txt";
            Product product = (Product) obj;
            object += (product.name + "," + product.id + "," + product.brand + "," + product.category
                    + "," + product.color + "," + product.amount + "," + product.points + "," + product.description
                    + "," + product.price + "," + product.count + ";");
        } else if (chose == 3) {
            fileName = "Brands.txt";
            Brand brand = (Brand) obj;
            object += (brand.name + "," + brand.id + "," + brand.numOfProducts + ",");
            for (int i = 0; i < brand.p.size(); i++) {
                // object+=(brand.p.get(i)+"#");
                object += (brand.p.get(i).name + "=" + brand.p.get(i).id + "="
                        + brand.p.get(i).brand + "=" + brand.p.get(i).category
                        + "=" + brand.p.get(i).color + "=" + brand.p.get(i).amount + "="
                        + brand.p.get(i).points + "=" + brand.p.get(i).description
                        + "=" + brand.p.get(i).price + "=" + brand.p.get(i).count + "#");
            }

            object += ";";
        } else if (chose == 4) {
            fileName = "StoreOwner.txt";
            StoreOwner storeowner = (StoreOwner) obj;
            object += (storeowner.name + "," + storeowner.id + "," + storeowner.password
                    + "," + storeowner.phone + ","
                    + storeowner.wallet.StoreMoney + ","
                    + storeowner.wallet.brandMoney + ",");
            for (int j = 0; j < storeowner.Stores.size(); j++) {
                Store store = storeowner.Stores.get(j);
                object += (store.name + "&" + store.id + "&" + store.numOfProducts + "&");
                for (int i = 0; i < store.p.size(); i++) {
                    // object+=(brand.p.get(i)+"#");
                    object += (store.p.get(i).name + "=" + store.p.get(i).id + "="
                            + store.p.get(i).brand + "=" + store.p.get(i).category
                            + "=" + store.p.get(i).color + "=" + store.p.get(i).amount + "="
                            + store.p.get(i).points + "=" + store.p.get(i).description
                            + "=" + store.p.get(i).price + "=" + store.p.get(i).count + "#");
                }
                object += "%";

            }

            object += ";";
        } else if (chose == 5) {
            fileName = "Customers.txt";
            Customer custom = (Customer) obj;
            object += (custom.name + "," + custom.id + "," + custom.password + ","
                    + custom.phone + "," + custom.numOfCard + "," + custom.points + ";");
        }else if(chose==6){
            fileName = "Suggest.txt";
            object+=(String)obj+",";
            
            
        } else {
            System.out.println("sorry you can't write");
            return;
        }


        try {
            PrintWriter writer;
            writer = new PrintWriter(new FileOutputStream(new File(fileName), true));//"UTF-8");
            writer.append(object);
            // writer.print(object);
            writer.close();
        } catch (FileNotFoundException ex) {
            //System.out.println("Not found");
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Update_file(int chose, ArrayList<Object> obj) {
        String object = "";
        String fileName = "";

        if (chose == 1) {
            fileName = "Admins.txt";
            
            for(int temp=0;temp<obj.size();temp++){
                Admin user = (Admin) obj.get(temp);
            object += (user.name + "," + user.id + "," + user.password + "," + user.phone + ";");
            
            }
            
        } else if (chose == 2) {
            fileName = "products.txt";
            for(int temp=0;temp<obj.size();temp++){
            Product product = (Product) obj.get(temp);
            object += (product.name + "," + product.id + "," + product.brand + "," + product.category
                    + "," + product.color + "," + product.amount + "," + product.points + "," + product.description
                    + "," + product.price + "," + product.count + ";");
            }
        } else if (chose == 3) {
            fileName = "Brands.txt";
            for(int temp=0;temp<obj.size();temp++){
            Brand brand = (Brand) obj.get(temp);
            object += (brand.name + "," + brand.id + "," + brand.numOfProducts + ",");
            for (int i = 0; i < brand.p.size(); i++) {
                // object+=(brand.p.get(i)+"#");
                object += (brand.p.get(i).name + "=" + brand.p.get(i).id + "="
                        + brand.p.get(i).brand + "=" + brand.p.get(i).category
                        + "=" + brand.p.get(i).color + "=" + brand.p.get(i).amount + "="
                        + brand.p.get(i).points + "=" + brand.p.get(i).description
                        + "=" + brand.p.get(i).price + "=" + brand.p.get(i).count + "#");
            }

            object += ";";}
        } else if (chose == 4) {
            fileName = "StoreOwner.txt";
            for(int temp=0;temp<obj.size();temp++){
            StoreOwner storeowner = (StoreOwner) obj.get(temp);
            object += (storeowner.name + "," + storeowner.id + "," + storeowner.password
                    + "," + storeowner.phone + ","
                    + storeowner.wallet.StoreMoney + ","
                    + storeowner.wallet.brandMoney + ",");
            for (int j = 0; j < storeowner.Stores.size(); j++) {
                Store store = storeowner.Stores.get(j);
                object += (store.name + "&" + store.id + "&" + store.numOfProducts + "&");
                for (int i = 0; i < store.p.size(); i++) {
                    // object+=(brand.p.get(i)+"#");
                    object += (store.p.get(i).name + "=" + store.p.get(i).id + "="
                            + store.p.get(i).brand + "=" + store.p.get(i).category
                            + "=" + store.p.get(i).color + "=" + store.p.get(i).amount + "="
                            + store.p.get(i).points + "=" + store.p.get(i).description
                            + "=" + store.p.get(i).price + "=" + store.p.get(i).count + "#");
                }
                object += "%";

            }

            object += ";";}
        } else if (chose == 5) {
            fileName = "Customers.txt";
            for(int temp=0;temp<obj.size();temp++){
            Customer custom = (Customer) obj.get(temp);
            object += (custom.name + "," + custom.id + "," + custom.password + ","
                    + custom.phone + "," + custom.numOfCard + "," + custom.points + ";");
            }
        } else {
            System.out.println("sorry you can't write");
            return;
        }

        try {
            PrintWriter writer;
            writer = new PrintWriter(fileName, "UTF-8");
            writer.print(object);
            writer.close();
        } catch (FileNotFoundException ex) {
            //System.out.println("Not found");
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            //System.out.println("ex");
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
