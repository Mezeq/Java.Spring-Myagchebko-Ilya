import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i <= 1000; i++) {
          if (i % 3 == 0 || i % 5 == 0);
                  sum = sum + i;
        }
        System.out.println(sum);
    }
}