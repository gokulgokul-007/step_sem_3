class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class q1 {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product(101, "Laptop", 50000, 1);
        products[1] = new Product(102, "Mouse", 500, 2);
        products[2] = new Product(103, "Keyboard", 1500, 1);
        products[3] = new Product(104, "Monitor", 8000, 1);
        products[4] = new Product(105, "Pen Drive", 600, 3);

        for (int i = 0; i < products.length; i++) {
            double totalPrice = products[i].price * products[i].quantity;
            double discount;

            if (totalPrice >= 5000) {
                discount = totalPrice * 0.10;
            } else {
                discount = totalPrice * 0.05;
            }

            double finalPrice = totalPrice - discount;

            System.out.println("Product ID: " + products[i].id);
            System.out.println("Name: " + products[i].name);
            System.out.println("Total Price: ₹" + totalPrice);
            System.out.println("Discount: ₹" + discount);
            System.out.println("Final Price: ₹" + finalPrice);
            System.out.println();
        }
    }
}
