package prog_project;
import javax.swing.JOptionPane;

public class order extends customer {
    int order_id = 1;

    public void printorderinfo(customer cuh, cart carti) {
        StringBuilder orderInfo = new StringBuilder();
        orderInfo.append("Order ID: ").append(order_id).append("\n");
        orderInfo.append("Customer ID: ").append(cuh.getId()).append("\n");
        orderInfo.append("Total Price: ").append(carti.calcprice()).append("\n");
        orderInfo.append("Products in Cart:\n");
        for (int i = 0; i < carti.getNProducts(); i++) {
            orderInfo.append(carti.products[i].getName()).append(" - $").append(carti.products[i].getPrice()).append("\n");
        }
        JOptionPane.showMessageDialog(null, orderInfo.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}
