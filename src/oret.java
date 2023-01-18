import java.util.Arrays;
import java.util.Collections;

public class oret {
    static void print(String[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + ", ");
            }
            System.out.println();
        }
    }

    static void sort(String[][] data, int col) {
        try {
            Arrays.sort(data, (a, b) -> Integer.compare(Integer.parseInt(a[col]), Integer.parseInt(b[col])));
        } catch (Exception e) {
            Arrays.sort(data, (a, b) -> a[col].compareTo(b[col]));
        }
    }

    static void sort2(String[][] data, int col) {
        try {
//            Arrays.sort(data,(a,b)->Integer.compare(Integer.parseInt(a[col]),Integer.parseInt(b[col])));
            Arrays.sort(data, Collections.reverseOrder());
        } catch (Exception e) {
            Arrays.sort(data, (a, b) -> a[col].compareTo(b[col]));
        }
    }

    public static void main(String[] args) {
        String[][] data = {{"Abi", "3"}, {"Agus", "2"}, {"Aan", "1"}};
//       print(data);
//       sort(data,0);
//       Arrays.sort(data, Collections.reverseOrder());
//       print(data);
//        Integer[] arr = {5, 2, 1, 8, 10};
        Integer[] arr = {5, 2, 1, 8, 10};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            if (arr[i]==1){
                break;
            }
        }
//        Arrays.sort(arr,0,arr.length,Collections.reverseOrder());
//        sort2(data, 1);
//        print(data);
//        for (int values : arr) {
//            System.out.print(values + ", ");
//            // 1, 2, 5, 8, 10,
//        }
    }
}
