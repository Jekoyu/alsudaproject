public class twodimensi {
    public static void main(String[] args) {
        String [][] data = new String[3][3];//deklarasi awal tanpa mengisi
        String data2[][] = {{"1","Hanafi"},{"2","Ryobi"},{"3","Dhani"}};//deklarasi dengan isi langsung
        for (int i = 0; i < data2.length; i++) {//melakukan perulangan sebanyak baris data
            for (int j = 0; j < data2[i].length; j++) {//melakukan perulangan sebanyak kolom data
                System.out.print(data2[i][j]+" ");//digunakan untuk menampilkan data pada array data2
            }
            System.out.println();
        }
    }
}
