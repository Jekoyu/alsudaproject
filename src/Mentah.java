import java.awt.desktop.SystemSleepEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Mentah {
    static Scanner in = new Scanner(System.in);
    static Scanner is = new Scanner(System.in);
    static String[] prodi = {"S. Informasi", "Informatika", "Psikologi", "Akuntansi", "Manajemen"};
    static String[] hBsw = {"No.Daftar", "NIK", "NISN", "JK", "Nama", "Agama", "Alamat", "T.Tulis", "T.Wawancara", "Status", "Prodi"};
    static String[] hRgl = {"No.Daftar", "NIK", "NISN", "JK", "Nama", "Agama", "Alamat", "N.UTBK", "Status", "Prodi"};

    static String[][] rejected = new String[100][3];

    public static void judul(String a) {
        System.out.println("==========================================");
        System.out.println("\t" + a);
        System.out.println("==========================================");
    }

    public static void regular(String[][] regular) {
        LinkedList<String> nama = new LinkedList<>();
        boolean c = true;
        while (c) {
            judul("REGULAR");
            System.out.println("1. Tambah Urutan");
            System.out.println("2. Input data sesuai urutan");
            System.out.println("3. Lihat Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih : ");
            int pil = in.nextInt();
            switch (pil) {
                case 1:
                    System.out.print("Masukkan nama : ");
                    nama.add(is.nextLine().toUpperCase());
                    break;

                case 2:
                    if (nama.size() == 0) {
                        System.out.println("Daftar Nama Kosong");
                    } else {
                        regular = addRegular(regular, nama.remove());
                    }
                    break;
                case 3:
                    if (regular.length >= 1) {
                        judul("URUTKAN BERDASAR");
                        for (int i = 0; i < hRgl.length; i++) {
                            System.out.println((i + 1) + ". " + hRgl[i]);
                        }
                        System.out.print("Pilihan : ");
                        sort(regular, in.nextInt() - 1);
                    }
                    lihat(regular, "No.Daftar\tNIK\tNISN\tJK\tNama\tAgama\tAlamat\tN.UTBK\tStatus\tProdi");
                    break;
                case 4:
                    cari(regular, "No.Daftar\tNIK\tNISN\tJK\tNama\tAgama\tAlamat\tN.UTBK\tStatus\tProdi");
                    break;
                case 5:
                    c = false;
                    break;
                default:
                    System.out.println("Pilihan tidak ada");
                    break;
            }
        }
    }


    static String[][] addRegular(String[][] regular, String nama) {
        boolean c = false;
        String[] temp2 = new String[10];
        String[][] temp = new String[regular.length + 1][10];
        for (int i = 0; i < regular.length; i++) {
            for (int j = 0; j < regular[0].length; j++) {
                temp[i][j] = regular[i][j];
            }
        }
        judul("IPUTKAN DATA " + nama);
        for (int i = 0; i < temp2.length; i++) {
            switch (i) {
                case 0:
                    temp2[i] = nodaftar(temp, "RGL");
                    break;
                case 1:
                    System.out.print("NIK\t\t\t: ");
                    temp2[i] = is.nextLine();
                    break;
                case 2:
                    System.out.print("NISN\t\t\t: ");
                    temp2[i] = is.nextLine();
                    break;
                case 3:
                    temp2[i] = nama;
                    break;
                case 4:
                    System.out.print("Jenis Kelamin(L/P)\t: ");
                    temp2[i] = is.nextLine().toUpperCase();
                    break;
                case 5:
                    System.out.print("Agama\t\t\t: ");
                    temp2[i] = is.nextLine().toUpperCase();
                    break;
                case 6:
                    System.out.print("Alamat\t\t\t: ");
                    temp2[i] = is.nextLine().toUpperCase();
                    judul("Inputkan Nilai TES");
                    System.out.println("No Daftar\t\t: " + temp2[0]);
                    System.out.println("Nama\t\t\t: " + temp2[3]);
                    break;
                case 7:
                    System.out.print("Nilai UTBK\t\t: ");
                    temp2[i] = is.nextLine();
                    break;
                case 8:
                    if (Integer.parseInt(temp2[7]) >= 500) {
                        temp2[8] = "LULUS";
                    } else {
                        temp2[8] = "TIDAK LULUS";
                    }
                    break;
                case 9:
                    if (temp2[8].equals("LULUS")) {
                        judul("SELAMAT ANDA LULUS TES");
                        c = true;
                        temp2[9] = prodi[pilProdi() - 1];
                    } else {
                        judul("MOHON MAAF ANDA TIDAK LULUS");
                    }
                    break;
            }
        }
        if (c) {
            for (int i = 0; i < temp2.length; i++) {
                temp[temp.length - 1][i] = temp2[i];
            }
        } else {
            for (int i = 0; i < 100; i++) {
                if (rejected[i][0] == null) {
                    rejected[i][0] = temp2[2];
                    rejected[i][1] = nama;
                    rejected[i][2] = temp2[6];
                    break;
                }
            }
        }
        return temp;
    }

    static void lihat(String[][] data, String header) {

            judul(header);
            for (int i = 0; i < data.length; i++) {
                if (data[i][0] != null) {
                    for (int j = 0; j < data[i].length; j++) {
                        System.out.print(data[i][j] + "\t");
                    }
                    System.out.println();
                }
            }


    }

    static void cari(String[][] data, String h) {
        judul("CARI DATA");
        System.out.println("Data yang dicari: ");
        String a = is.nextLine();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j].equals(a)) {
                    judul(h);
                    for (int k = 0; k < data[i].length; k++) {
                        System.out.print(data[i][k] + "\t");
                    }
                } else {
                    judul("DATA TIDAK DITEMUKAN");
                }
            }
        }
    }

    static void beasiswa(String[][] beasiswa) {
        LinkedList<String> nama = new LinkedList<>();
        boolean c = true;
        while (c) {
            judul("BEASISWA");
            System.out.println("1. Tambah Urutan");
            System.out.println("2. Input data sesuai urutan");
            System.out.println("3. Lihat Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih : ");
            int pil = in.nextInt();

            switch (pil) {
                case 1:
                    System.out.print("Masukkan nama : ");
                    nama.add(is.nextLine().toUpperCase());
                    break;
                case 2:
//                    System.out.println(beasiswa.length);
                    if (nama.size() == 0) {
                        System.out.println("Daftar Nama Kosong");
                    } else {
//                        System.out.println(nama.remove());
                        beasiswa = addBeasiswa(beasiswa, nama.remove());
//                    System.out.println(beasiswa.length);
                    }
                    break;
                case 3:
                    if (beasiswa.length >= 1) {
                        judul("URUTKAN BERDASAR");
                        for (int i = 0; i < hBsw.length; i++) {
                            System.out.println((i + 1) + ". " + hBsw[i]);
                        }
                        System.out.print("Pilihan : ");
                        sort(beasiswa, in.nextInt() - 1);
                    }
                    lihat(beasiswa, "No.Daftar\tNIK\tNISN\tJK\tNama\tAgama\tAlamat\tT.Tulis\tT.Wawancara\tStatus\tProdi");
                    break;
                case 4:
                    cari(beasiswa, "No.Daftar\tNIK\tNISN\tJK\tNama\tAgama\tAlamat\tT.Tulis\tT.Wawancara\tStatus\tProdi");
                    break;
                case 5:
                    c = false;
                    break;
                default:
                    System.out.println("Pilihan tidak ada");
                    break;
            }
        }
    }

    static String[][] addBeasiswa(String[][] beasiswa, String nama) {
        boolean c = false;
        String[] temp2 = new String[11];
        String[][] temp = new String[beasiswa.length + 1][11];
        for (int i = 0; i < beasiswa.length; i++) {
            for (int j = 0; j < beasiswa[0].length; j++) {
                temp[i][j] = beasiswa[i][j];
            }
        }
        judul("IPUTKAN DATA " + nama);
        for (int i = 0; i < temp2.length; i++) {

            switch (i) {
                case 0:
                    temp2[i] = nodaftar(temp, "BSW");
                    break;
                case 1:
                    System.out.print("NIK\t\t\t: ");
                    temp2[i] = is.nextLine();
                    break;
                case 2:
                    System.out.print("NISN\t\t\t: ");
                    temp2[i] = is.nextLine();
                    break;
                case 3:
                    temp2[i] = nama;
                    break;
                case 4:
                    System.out.print("Jenis Kelamin(L/P)\t: ");
                    temp2[i] = is.nextLine().toUpperCase();
                    break;
                case 5:
                    System.out.print("Agama\t\t\t: ");
                    temp2[i] = is.nextLine().toUpperCase();
                    break;
                case 6:
                    System.out.print("Alamat\t\t\t: ");
                    temp2[i] = is.nextLine().toUpperCase();
                    judul("Inputkan Nilai TES");
                    System.out.println("No Daftar\t\t: " + temp2[0]);
                    System.out.println("Nama\t\t\t: " + temp2[3]);
                    break;
                case 7:
                    System.out.print("Nilai Tes Tulis\t\t: ");
                    temp2[i] = is.nextLine();
                    break;
                case 8:
                    System.out.print("Nilai Tes Wawancara\t: ");
                    temp2[i] = is.nextLine();
                    break;
                case 9:
                    if (Integer.parseInt(temp2[7]) >= 70 && Integer.parseInt(temp2[8]) >= 75) {
                        temp2[9] = "LULUS";
                    } else {
                        temp2[9] = "TIDAK LULUS";
                    }
                    break;
                case 10:
                    if (temp2[9].equals("LULUS")) {
                        judul("SELAMAT ANDA LULUS TES");
                        c = true;
                        temp2[10] = prodi[pilProdi() - 1];
                    } else {
                        judul("MOHON MAAF ANDA TIDAK LULUS");
                    }
                    break;
            }
        }
        if (c) {
            for (int i = 0; i < temp2.length; i++) {
                temp[temp.length - 1][i] = temp2[i];
            }
        } else {
            for (int i = 0; i < 100; i++) {
                if (rejected[i][0] == null) {
                    rejected[i][0] = temp2[2];
                    rejected[i][1] = nama;
                    rejected[i][2] = temp2[6];
                    break;
                }
            }
        }
        return temp;
    }

    static int pilProdi() {
        judul("SILAHKAN PILIH PRODI");
        for (int i = 0; i < prodi.length; i++) {
            System.out.println((i + 1) + ". " + prodi[i]);
        }
        System.out.print("Pilihan : ");
        int pil = in.nextInt();
        return pil;
    }

    public static void menu(String[][] regular, String[][] beasiswa) {
        boolean c = true;
        while (c) {
            judul("Sistem Informasi Mahasiswa");
            System.out.println("1. Regular");
            System.out.println("2. Beasiswa");
            System.out.println("3. Mahasiswa Tidak Diterima");
            System.out.println("4. Keluar");
            System.out.print("Pilih : ");
            int pilih = in.nextInt();
            switch (pilih) {
                case 1:
                    regular(regular);
                    break;
                case 2:
                    beasiswa(beasiswa);
                    break;
                case 3:
                    lihat(rejected, "NISN\tNama\tAlamat");
                    break;
                case 4:
                    System.out.println("Keluar dari program....");
                    c = false;
                    break;
                default:
                    System.out.println("Pilihan tidak ada");
                    break;
            }
        }
    }


    public static String nodaftar(String[][] arr, String a) {
        String re = "";
        if (arr.length == 0) {
            re = a + "0001";
        } else {
            for (int i = 0; i < 10; i++) {
                if (arr[i][0] == null) {
                    re = a + String.format("%04d", (i + 1));
                    break;
                }
                if (!arr[i][0].equals(a + String.format("%04d", i))) {
                    re = a + String.format("%04d", (i));
                }
            }
        }
        return re;
    }

    static void sort(String[][] data, int col) {
        try {
            Arrays.sort(data, (a, b) -> Integer.compare(Integer.parseInt(a[col]), Integer.parseInt(b[col])));
//            Arrays.sort(data, Collections.reverseOrder());
        } catch (Exception e) {
            Arrays.sort(data, (a, b) -> a[col].compareTo(b[col]));
        }
    }

    public static void main(String[] args) {
        String[][] regular = new String[0][10];
        String[][] beasiswa = new String[0][11];
        menu(regular, beasiswa);
    }
}
