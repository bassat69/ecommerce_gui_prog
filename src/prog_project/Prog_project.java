package prog_project;
import javax.swing.JOptionPane;

public class Prog_project {

    public static void main(String[] args) {
        // Create product instances
        electpro eli = new electpro();
        clothing_p drip = new clothing_p();
        book_p bookworm = new book_p();

        // Set product details
        eli.setBrand("Samsung");
        eli.setId(1);
        eli.setPrice(599.9f);
        eli.setName("Smartphone");
        eli.setWarranty_period(1);

        drip.setFabric("Cotton");
        drip.setId(2);
        drip.setName("T-shirt");
        drip.setPrice(19.99f);
        drip.setSize("Medium");

        bookworm.setAuthor("O Reilly");
        bookworm.setId(3);
        bookworm.setPrice(39.99f);
        bookworm.setPublisher("X Publications");
        bookworm.setName("OOP");

        // Create customer instance
        customer cuh = new customer();

        // Set customer details
        String name = JOptionPane.showInputDialog(null, "Enter name:");
        cuh.setName(name);

        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id:"));
        cuh.setId(id);

        String address = JOptionPane.showInputDialog(null, "Enter address:");
        cuh.setAddress(address);

        int n_products = Integer.parseInt(JOptionPane.showInputDialog(null, "How many items would you like to order?"));
        cart carti = new cart(n_products);

        for (int i = 0; i < n_products; i++) {
            Object[] options = {drip.getName(), bookworm.getName(), eli.getName()};
            int op = JOptionPane.showOptionDialog(null, "Which product would you like to add?", "Select Product", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (op == 0)
                carti.addproduct(drip);
            else if (op == 1)
                carti.addproduct(bookworm);
            else
                carti.addproduct(eli);
        }

        order ord = new order();
        ord.printorderinfo(cuh, carti);

        int choice = JOptionPane.showConfirmDialog(null, "Do you want to remove something?", "Remove Product", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            String productName = JOptionPane.showInputDialog(null, "Enter product name:");
            carti.removeProduct(productName);
            StringBuilder updatedOrder = new StringBuilder("Your updated order is:\n");
            updatedOrder.append("Customer Name: ").append(cuh.getName()).append("\n");
            updatedOrder.append("Customer ID: ").append(cuh.getId()).append("\n");
            updatedOrder.append("Customer Address: ").append(cuh.getAddress()).append("\n\n");

            updatedOrder.append("Products in Cart:\n");
            for (int i = 0; i < carti.getNProducts(); i++) {
                updatedOrder.append(carti.products[i].getName()).append(" - $").append(carti.products[i].getPrice()).append("\n");
            }
            JOptionPane.showMessageDialog(null, updatedOrder.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Thank you for using our program <3");
        }
    }
}
