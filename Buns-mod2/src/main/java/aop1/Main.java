package aop1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class)) {
            UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
            Book book = context.getBean("book", Book.class);

            performLibraryActions(uniLibrary, book);

        } catch (Exception e) {
            handleException(e);
        }
    }

    private static void performLibraryActions(UniLibrary uniLibrary, Book book) {
        uniLibrary.getBook(book);
        uniLibrary.getMagazine();
        uniLibrary.returnBook();
        uniLibrary.returnMagazine();
    }
    private static void handleException(Exception e) {
        System.out.println("An exception occurred: " + e.getMessage());
    }
}

