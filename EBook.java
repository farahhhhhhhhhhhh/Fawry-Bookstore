public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int year, double price, String author, String fileType) {
        super(isbn, title, year, price, author);
        this.fileType = fileType;
    }

    public String getFileType() { return fileType; }

    @Override
    public boolean isForSale() { return true; }

    @Override
    public String getDetails() {
        return String.format("-EBook: %s by %s, Year: %d, Price: %.2f, FileType: %s", title, author, year, price, fileType);
    }
}
