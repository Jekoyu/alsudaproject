public class Mentah {
    static void print(int [][]a){
        for (int[] ints : a) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {6, 7, 8}, {11, 12, 13}};
        int [][] temp = a;
        a = new int[temp.length+1][3];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                a[i][j] = temp[i][j];
            }
        }
        print(a);

    }
}
