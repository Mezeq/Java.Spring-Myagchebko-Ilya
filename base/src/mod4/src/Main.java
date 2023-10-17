import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        List<String> hobbies = new ArrayList<>();
        System.out.println("Введите хобби(через запятую): ");
        String[] hobbyArray = scanner.nextLine().split(",");
        for (String hobby : hobbyArray) {
            hobbies.add(hobby.trim());
        }

        User user = new User(name, login, age, hobbies);

        try {
            FileOutputStream fileOut = new FileOutputStream("user.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

        try {
            FileInputStream fileIn = new FileInputStream("user.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            User deserializedUser = (User) in.readObject();
            in.close();
            fileIn.close();
            System.out.println(deserializedUser.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}