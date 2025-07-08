public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        System.out.println("-----------Quantum Bookstore -----------");
        Inventory inventory = new Inventory();
        double totalPaid = 0.0;

        System.out.println("\n -----------Adding Books -----------");
        inventory.addBook(new PaperBook("ISBN001", "Java Basics", 2015, 50.0, "Alice", 10));
        inventory.addBook(new PaperBook("ISBN004", "C++ Mastery", 2020, 60.0, "David", 5));
        inventory.addBook(new EBook("ISBN002", "Learn Python", 2018, 30.0, "Bob", "PDF"));
        inventory.addBook(new EBook("ISBN005", "JavaScript Essentials", 2022, 25.0, "Eve", "EPUB"));
        inventory.addBook(new ShowcaseBook("ISBN003", "Ancient Scripts", 1990, 0.0, "Carol"));
        inventory.addBook(new ShowcaseBook("ISBN006", "Rare Manuscript", 1985, 0.0, "Frank"));
       
        
        System.out.println("\n -----------Listing All Books -----------");
        inventory.listBooks();

      
        System.out.println("\n-----------Removing Outdated Books (older than 10 years)-----------");
        inventory.removeOutdatedBooks(2024, 10);

       
        System.out.println("\n-----------Listing Books After Removal-----------");
        inventory.listBooks();

        
        System.out.println("\n-----------Buying PaperBook-----------");
        try {
            double paid = inventory.buyBook("ISBN001", 2, "buyer@example.com", "123 Main St");
            System.out.println( paid);
            totalPaid += paid;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------Buying PaperBook -----------");
        try {
            double paid = inventory.buyBook("ISBN004", 10, "buyer@example.com", "456 Elm St");
            System.out.println( paid);
            totalPaid += paid;
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }

        System.out.println("\n-----------Buying EBook-----------");
        try {
            double paid = inventory.buyBook("ISBN002", 1, "buyer@example.com", "");
            System.out.println( paid);
            totalPaid += paid;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

      
        System.out.println("\n-----------Buying ShowcaseBook -----------");
        try {
            inventory.buyBook("ISBN003", 1, "buyer@example.com", "");
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }


      
        System.out.println("\n-----------SUMMARY-----------");
        System.out.println("TOTAL PAID: " + totalPaid);
    }
}


