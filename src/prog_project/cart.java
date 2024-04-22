package prog_project;
import java.util.*;

public class  cart extends  customer {
    private int customerId;
    private int nProducts = 0;
    private int size;
    product[] products;

    public cart(int size) {
        this.size = size;
        products = new product[size];
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getNProducts() {
        return nProducts;
    }

    public void setcustomerid(int customerId) {
        this.customerId = customerId;
    }

    public void addproduct(product product) {
        if (nProducts < size) {
            products[nProducts++] = product;
        } else {
            System.out.println("Cart is full");
        }
    }
  public void removeProduct(String productName) {
    for (int i = 0; i < nProducts; i++) {
        if (products[i].getName().equals(productName)) {
            // Shift the elements to the left to fill the gap
            for (int j = i; j < nProducts - 1; j++) {
                products[j] = products[j + 1];
            }
            // Reduce the number of products
            nProducts--;
            // Exit the loop after the first occurrence is removed
            return;
        }
    }
    // If the product is not found
    System.out.println("Product '" + productName + "' not found in the cart");
}


    public double calcprice() {
        double sum = 0;
        for (int i = 0; i < nProducts; i++) {
            sum += products[i].getPrice();
        }
        return sum;
    }

    public void placeorder(customer customer) {
        order order = new order();
        order.printorderinfo(customer, this);
    }
    public void productslist(){
        for(int i=0;i<nProducts;i++){
            System.out.println((i+1)+":"+products[i].getName()+"->"+products[i].getPrice());
            
        }
    }
}
