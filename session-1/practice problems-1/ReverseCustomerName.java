public class ReverseCustomerName {
    static String reverseCustomerName(String name) {
        return new StringBuilder(name).reverse().toString();
    }
    public static void main(String[] args) {
        String name = "Sunil";
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reverseCustomerName(name));
    }
}