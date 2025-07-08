public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author);
        this.stock = stock;
    }

    public int getStock() { return stock; }
    public void reduceStock(int quantity) { this.stock -= quantity; }

    @Override
    public boolean isForSale() { return stock > 0; }

    @Override
    public String getDetails() {
        return String.format("-PaperBook: %s by %s, Year: %d, Price: %.2f, Stock: %d", title, author, year, price, stock);
    }
}
