package nl.blitz.cleancode.inventory;

import java.util.ArrayList;
import java.util.List;

class InventoryController {
    private List<Product> products = new ArrayList<>();

    public void addProduct(String n,double p,int q,String c,String s) {
        Product prod=new Product();
        prod.name=n;
        prod.price=p;
        prod.quantity=q;
        prod.category=c;
        prod.supplier=s;
        products.add(prod);
    }

    public Product findProduct(String name) {
        for(Product p:products) {
            if(p.name.equals(name)) {
                return p;
            }
        }
        return null;
    }

    public void updateStock(String productName,int newQuantity) {
        Product p=findProduct(productName);
        if(p!=null) {
            p.quantity=newQuantity;
        }
    }

    public List<Product> getLowStockItems() {
        List<Product> result=new ArrayList<>();
        for(Product p:products) {
            if(p.quantity<10) {
                result.add(p);
            }
        }
        return result;
    }

    public void processInventory() {
        for(Product p:products) {
            if(p.quantity<5) {
                System.out.println("Low stock: "+p.name);
            }
            if(p.price>100) {
                System.out.println("Expensive item: "+p.name);
            }
            if(p.category.equals("ELECTRONICS")) {
                System.out.println("Electronics item: "+p.name);
            }
        }
    }

    class Product {
        String name;
        double price;
        int quantity;
        String category;
        String supplier;
    }
}

