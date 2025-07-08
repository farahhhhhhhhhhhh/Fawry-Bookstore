public class MailService {
    public static void send(EBook book, String email) {
        System.out.println(" Sending the mail " + book.getTitle() + " to " + email);
    }
} 