public class Main{
    public static void main(String[] args) {
        int[][] x = {
                {20, 34, 2},
                {9, 12, 18},
                {3, 4, 5}
        };
        int minElement = findMinimumElement(x);
        System.out.println(minElement);
    }

    public static int findMinimumElement(int[][] arr) {
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }
}