public class ShippingService {
    public static void send(PaperBook book, String address) {
        System.out.println("-Shipping " + book.getTitle() + " to " + address);
    }
} 