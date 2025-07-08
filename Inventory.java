import java.util.*;

public class Inventory {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println(" -Added " + book.getDetails());
    }

    public Book removeBook(String isbn) {
        Book removed = books.remove(isbn);
        if (removed != null) {
            System.out.println("-Removed " + removed.getDetails());
        }
        return removed;
    }

    public List<Book> removeOutdatedBooks(int currentYear, int maxAge) {
        List<Book> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> it = books.entrySet().iterator();
        while (it.hasNext()) {
            Book book = it.next().getValue();
            if (currentYear - book.getYear() > maxAge) {
                removed.add(book);
                it.remove();
                System.out.println("Removed outdated " + book.getDetails());
            }
        }
        return removed;
    }

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = books.get(isbn);
        if (book == null || !book.isForSale()) {
            throw new Exception("Book not available for sale.");
        }
        if (book instanceof PaperBook) {
            PaperBook pb = (PaperBook) book;
            if (pb.getStock() < quantity) {
                throw new Exception(" Not enough stock.");
            }
            pb.reduceStock(quantity);
            ShippingService.send(pb, address);
            System.out.println("Bought " + quantity + " of " + pb.getTitle());
            return pb.getPrice() * quantity;
        } else if (book instanceof EBook) {
            EBook eb = (EBook) book;
            MailService.send(eb, email);
            System.out.println(" Bought EBook " + eb.getTitle());
            return eb.getPrice() * quantity;
        } else {
            throw new Exception(" Book not for sale.");
        }
    }

    public void listBooks() {
        for (Book book : books.values()) {
            System.out.println( book.getDetails());
        }
    }
}
