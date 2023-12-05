package aop1;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary {

    public void getBook(Book book) {
        System.out.println("Мы берем книгу из UniLibrary " + book.getName());
        printSeparator();
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал из UniLibrary");
        printSeparator();
    }

    public void returnBook() {
        System.out.println("Мы возвращаем книгу в UniLibrary ");
    }

    public void returnMagazine() {
        try {
            int x = 10 / 0; // Simulating some operation
            System.out.println("Мы возвращаем журнал в UniLibrary ");
        } catch (ArithmeticException e) {
            handleException(e);
        }
    }

    private void printSeparator() {
        System.out.println("-------------------------------------------------");
    }

    private void handleException(Exception e) {
        System.out.println("An exception occurred: " + e.getMessage());
    }
}
