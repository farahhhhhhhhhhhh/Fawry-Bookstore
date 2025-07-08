public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, int year, double price, String author) {
        super(isbn, title, year, price, author);
    }

    @Override
    public boolean isForSale() { return false; }

    @Override
    public String getDetails() {
        return String.format("-ShowcaseBook: %s by %s, Year: %d (Not for sale)", title, author, year);
    }
}
