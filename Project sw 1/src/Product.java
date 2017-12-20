/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samar sabry
 */
public class Product {
    String name;
    float price;
    String  description;
    String color;
    int amount;
    int id;
    String category;
    int points;
    String brand;
    int count;

    public Product(String name, float price, String description, String color, int amount, int id, String category, int points, String brand, int count) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.color = color;
        this.amount = amount;
        this.id = id;
        this.category = category;
        this.points = points;
        this.brand = brand;
        this.count = count;
    }

    public Product() {
    }
    
    public Product(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public void setName(String n)
    {
        name=n;
    }
    public void setId(int i)
    {
        id=i;
    }
    public void setPrice(float p)
    {
        price=p;
    }
    public void setDes(String  des)
    {
        description=des;
    }
    
    public void setColor(String c)
    {
        color=c;
    }
    public void setCategory(String cat)
    {
        category=cat;
    }
    public void setPoints(int p)
    {
        points=p;
    }
    public void setBrand(String b)
    {
        brand=b;
    }
    public void setAmount(int a)
    {
        amount=a;
    }
    
    
     public String getName()
    {
        return name;
    }
    public int getId()
    {
      return  id;
    }
    public float getPrice()
    {
       return price;
    }
    public String getDes()
    {
        return description;
    }
    
    public String  getColor()
    {
        return color;
    }
    public String getCategory()
    {
        return category;
    }
    public int getPoints()
    {
        return points;
    }
    public String getBrand()
    {
       return brand;
    }
    public int getAmount()
    {
      return   amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", price=" + price + ", description=" + description + ", color=" + color + ", amount=" + amount + ", id=" + id + ", category=" + category + ", points=" + points + ", brand=" + brand + ", count=" + count + '}';
    }
    
    
}
