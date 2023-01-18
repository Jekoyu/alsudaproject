import java.util.Scanner;
import java.util.Random;

public class nemu {

    static Scanner str = new Scanner(System.in);
    static Scanner in = new Scanner(System.in);
    static String jadwalPenerbangan[][] = { { "Yogyakarta - Jakarta - 06:30", "980000", "Beruang Laut" },
            { "Yogyakarta - Lombok  - 14:00", "1200000", "Umbrella" },
            { "Yogyakarta - Bandung - 16:40", "690000", "Gajah Terbang" },
            { "Surabaya   - Medan   - 10:40", "1740000", "Umbrella" },
            { "Bandung   - Semarang - 17:50", "1180000", "Gajah Terbang" },
            { "Surabaya   - Manado  - 09:20", "1080000", "Beruang Laut" },
            { "Jakarta    - Bali    - 08:40", "1320000", "Gajah Terbang" } };
    static String pesantiket[][] = new String[12][11];
    static String beliTiket[][] = new String[12][11];

    public static void daftarPenerbangan(String jdwlP[][]) {
        System.out.println("\n<==== DAFTAR PENERBANGAN ====>");
        System.out.print("Urutkan Berdasarkan \n1.Harga Termurah \n2.Harga Termahal \nPilih? ");
        int pil = in.nextInt();
        switch (pil) {
            case 1:
                System.out.println("\nNO Asal\t\tTujuan\t   Jam\t\tHarga\t\tMaskapai");
                ascending(jdwlP);
                break;
            case 2:
                System.out.println("\nNO Asal\t\tTujuan\t   Jam\t\tHarga\t\tMaskapai");
                descending(jdwlP);
                break;
            default:
                System.out.println("Yang anda Masukkan Salah  O)O");
                break;
        }
    }

    public static String[][] ascending(String jp[][]) {
        String a[][] = jp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                int harga1 = Integer.parseInt(a[j][1]);
                int harga2 = Integer.parseInt(a[j + 1][1]);
                if (harga1 > harga2) {
                    int temp = harga1;
                    harga1 = harga2;
                    harga2 = temp;
                    // urut jadwal
                    String p = a[j][0];
                    a[j][0] = a[j + 1][0];
                    a[j + 1][0] = p;
                    // urut maskapai
                    String m = a[j][2];
                    a[j][2] = a[j + 1][2];
                    a[j + 1][2] = m;
                    a[j][1] = String.valueOf(harga1);
                    a[j + 1][1] = String.valueOf(harga2);
                }

            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println((i + 1) + ". " + a[i][0] + "\t\t" + a[i][1] + "\t\t" + a[i][2]);
        }
        jp = a;
        return jp;
    }

    public static String[][] descending(String jp[][]) {
        String a[][] = jp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                int harga1 = Integer.parseInt(a[j][1]);
                int harga2 = Integer.parseInt(a[j + 1][1]);
                if (harga1 < harga2) {
                    int temp = harga1;
                    harga1 = harga2;
                    harga2 = temp;
                    // urut jadwal
                    String p = a[j][0];
                    a[j][0] = a[j + 1][0];
                    a[j + 1][0] = p;
                    // urut maskapai
                    String m = a[j][2];
                    a[j][2] = a[j + 1][2];
                    a[j + 1][2] = m;
                    a[j][1] = String.valueOf(harga1);
                    a[j + 1][1] = String.valueOf(harga2);
                }

            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println((i + 1) + ". " + a[i][0] + "\t\t" + a[i][1] + "\t\t" + a[i][2]);
        }
        jp = a;
        return jp;
    }

    public static void pesanTiket(String jwdP[][], String psnT[][]) {
        System.out.println("\nNO Asal\t\tTujuan\t   Jam\t\tHarga\t\tMaskapai");
        ascending(jwdP);
        System.out.println("\n<=== PESAN TIKET ===>");
        System.out.print("Jumlah Tiket : ");
        int jt = in.nextInt();

        for (int i = 0; i < jt; i++) {
            if (psnT[i][5] != null) {
                i = i + 1;
            }
            System.out.println("\nTiket ke - " + (i + 1));
            // Jadwal Penerbangan
            System.out.print("Pilih Jadwal Penerbangan : ");
            int jp = in.nextInt();
            if (jp > 7) {
                System.out.println("Nomor Yang Anda Pilih Salah");
                System.out.println("\nPemesanan Tiket ke-" + (i + 1) + " Gagal  T~T");
                System.out.println("Kembali Ke Halaman Utama...");
                break;
            }
            // Nama
            System.out.print("Masukkan Nama : ");
            psnT[i][0] = str.nextLine().toUpperCase();
            // Usia
            System.out.print("Usia Penumpang \n1.Dewasa(Lebih Dari 8 Tahun)\n2.Anak-anak(Potongan 30%)\nPilih : ");
            int usia = in.nextInt();
            if (usia > 2) {
                System.out.println("Nomor Yang Anda Pilih Salah");
                System.out.println("\nPemesanan Tiket ke-" + (i + 1) + " Gagal  T~T");
                System.out.println("Kembali Ke Halaman Utama...");
                break;
            }
            switch (usia) {
                case 1:
                    psnT[i][1] = "DEWASA";
                    psnT[i][3] = jwdP[jp - 1][1];
                    break;
                case 2:
                    psnT[i][1] = "ANAK-ANAK";
                    psnT[i][3] = jwdP[jp - 1][1];
                    int harga = Integer.parseInt(psnT[i][3]);
                    harga = harga * 30 / 100;
                    int harga1 = Integer.parseInt(psnT[i][3]);
                    int total = harga1 - harga;
                    psnT[i][3] = String.valueOf(total);
                    break;
                default:
                    System.out.println("Pilihan anda tidak ada '-v-'");
                    System.out.println("\nPemesanan Tiket ke-" + (i + 1) + " Gagal  T~T");
                    System.out.println("Kembali Ke Halaman Utama...");
                    break;
            }
            // Kelas
            System.out.print("Kelas \n1.Ekonomi \n2.Bisnis(Kenaikan Harga 35%) \nPilih : ");
            int pilihkelas = in.nextInt();
            if (pilihkelas > 2) {
                System.out.println("Nomor Yang Anda Pilih Salah");
                System.out.println("\nPemesanan Tiket ke-" + (i + 1) + " Gagal  T~T");
                System.out.println("Kembali Ke Halaman Utama...");
                break;
            }
            switch (pilihkelas) {
                case 1:
                    psnT[i][2] = "Ekonomi";
                    psnT[i][3] = psnT[i][3];
                    System.out.println(psnT[i][3]);
                    break;
                case 2:
                    psnT[i][2] = "Bisnis";
                    int harga = Integer.parseInt(psnT[i][3]);
                    harga = harga * 35 / 100;
                    int harga1 = Integer.parseInt(psnT[i][3]);
                    int total = harga + harga1;
                    psnT[i][3] = String.valueOf(total);

                    break;
                default:
                    System.out.println("Yang Anda Masukkan Salah");
                    System.out.println("\nPemesanan Tiket ke-" + (i + 1) + " Gagal  T~T");
                    System.out.println("Kembali Ke Halaman Utama...");
                    break;
            }

            psnT[i][4] = jwdP[jp - 1][0];

            psnT[i][7] = jwdP[jp - 1][2];

            psnT[i][8] = jwdP[jp - 1][1];

            System.out.print("Tentukan Tanggal Penerbangan(TGL-BLN-THN) : ");
            psnT[i][5] = str.nextLine().toUpperCase();
            // Tipe Penerbangan
            System.out.print("Pulang Pergi(Y/N) ? ");
            String pp = str.nextLine().toUpperCase();
            if (pp.equals("N")) {
                psnT[i][6] = "Satu Arah";
            } else if (pp.equals("Y")) {
                psnT[i][6] = "Pulang Pergi";
                int harga = Integer.parseInt(psnT[i][3]);
                int total = harga * 2;
                psnT[i][3] = String.valueOf(total);
                System.out.print("Tentukan Tanggal Pulang(TGL-BLN-THN) : ");
                String pulang = str.nextLine();
                psnT[i][10] = pulang;
            } else {
                System.out.println("Yang Anda Masukkan Salah");
                System.out.println("\nPemesanan Tiket ke-" + (i + 1) + " Gagal  T~T");
                System.out.println("Kembali Ke Halaman Utama...");
            }
            // Harga Total 1 Tiket
            psnT[i][9] = jwdP[jp - 1][1];
            // Tiket berhasil di pesan
            System.out.println("\nTiket Berhasil di Pesan  ^>^");
        }
    }

    public static void hapusTiket(String tik[][]) {
        if (tik[0][0] == null) {
            System.out.println("\nAnda Belum Memesan Tiket");
        } else {
            lihatPesananTiket(tik);
            System.out.println("\n< BATALKAN PESANAN TIKET >");
            System.out.print("Pilih Tiket Keberapa Yang Ingin di Batalkan ? ");
            int i = in.nextInt();
            tik[i - 1][0] = null;
            tik[i - 1][1] = null;
            tik[i - 1][2] = null;
            tik[i - 1][3] = null;
            tik[i - 1][4] = null;
            tik[i - 1][5] = null;
            tik[i - 1][6] = null;
            tik[i - 1][7] = null;
            tik[i - 1][8] = null;
            tik[i - 1][9] = null;
            if (tik[i - 1][10] != null) {
                tik[i - 1][10] = null;
            }
            for (int k = 0; k < tik.length - 1; k++) {
                if (tik[k][0] == null) {
                    if (tik[k + 1][0] != null) {
                        tik[k][0] = tik[k + 1][0];
                        tik[k][1] = tik[k + 1][1];
                        tik[k][2] = tik[k + 1][2];
                        tik[k][3] = tik[k + 1][3];
                        tik[k][4] = tik[k + 1][4];
                        tik[k][5] = tik[k + 1][5];
                        tik[k][6] = tik[k + 1][6];
                        tik[k][7] = tik[k + 1][7];
                        tik[k][8] = tik[k + 1][8];
                        tik[k][9] = tik[k + 1][9];
                        if (tik[k + 1][10] != null) {
                            tik[k][10] = tik[k + 1][10];
                        }
                        tik[k + 1][0] = null;
                        tik[k + 1][1] = null;
                        tik[k + 1][2] = null;
                        tik[k + 1][3] = null;
                        tik[k + 1][4] = null;
                        tik[k + 1][5] = null;
                        tik[k + 1][6] = null;
                        tik[k + 1][7] = null;
                        tik[k + 1][8] = null;
                        tik[k + 1][9] = null;
                        tik[k + 1][10] = null;
                    }
                }
            }
            System.out.println("Tiket ke-" + i + " Berhasil di Batalkan  ^D^");
        }
    }

    public static void lihatPesananTiket(String tik[][]) {
        if (tik[0][5] == null) {
            System.out.println("\nAnda Belum Memesan Tiket 0-0");
        } else {
            System.out.println("\n<TIKET>");
            for (int i = 0; i < tik.length; i++) {
                if (tik[i][5] == null) {
                    break;
                }
                System.out.println("\nTiket ke " + (i + 1));
                System.out.println("Nama\t\t: " + tik[i][0]);
                System.out.println("Usia\t\t: " + tik[i][1]);
                System.out.println("Maskapai\t: " + tik[i][7]);
                System.out.println("Kelas\t\t: " + tik[i][2]);
                System.out.println("Harga\t\t: " + tik[i][9]);
                System.out.println("Jadwal\t\t: " + tik[i][4]);
                System.out.println("Tipe\t\t: " + tik[i][6]);
                System.out.println("Tanggal Pergi\t: " + tik[i][5]);
                if (tik[i][10] != null) {
                    System.out.println("Tanggal Pulang\t: " + tik[i][10]);
                }
            }
        }
    }

    public static int noKursi(int a) {
        int no = 0;
        for (int i = 0; i < a + 1; i++) {
            no = (i + 1);
        }
        return no;
    }

    public static int noP(int a) {
        Random nomor = new Random();
        int no = nomor.nextInt(100);
        return no;
    }

    public static void beliTiket(String psnT[][], String buy[][]) {
        lihatPesananTiket(psnT);
        if (psnT[0][5] == null) {
            System.out.println("\nKembali Ke Halaman Utama...");
        } else {
            System.out.print("\nBeli Tiket(Y/N) ? ");
            String beli = str.nextLine().toUpperCase();

            if (beli.equals("Y")) {
                for (int i = 0; i < psnT.length; i++) {
                    if (psnT[i][0] == null) {
                        break;
                    }
                    // Kursi
                    String tipe = "A00";
                    String nomer = String.valueOf(noKursi(i));
                    String kursi = tipe + nomer;
                    buy[i][0] = kursi;
                    // No Penerbangan
                    String tp = "PST";
                    String no = String.valueOf(noP(i));
                    String Penerbangan = tp + no;
                    buy[i][10] = Penerbangan;
                    // nama
                    buy[i][1] = psnT[i][0];
                    // jadwal
                    buy[i][2] = psnT[i][4];
                    // tgl
                    buy[i][3] = psnT[i][5];
                    // kelas
                    buy[i][4] = psnT[i][2];
                    // tipe
                    buy[i][5] = psnT[i][6];
                    // maskapai
                    buy[i][6] = psnT[i][7];
                    // sub harga
                    buy[i][7] = psnT[i][8];
                    // harga total
                    buy[i][8] = psnT[i][3];
                    // tgl pulang
                    if (psnT[i][10] != null) {
                        buy[i][9] = psnT[i][10];
                    }
                }
                for (int i = 0; i < buy.length; i++) {
                    if (buy[i][0] == null) {
                        break;
                    }
                    System.out.println("Harga Tiket Ke-" + (i + 1) + " Rp." + buy[i][8]);
                }
                int total_h = 0;
                for (int i = 0; i < psnT.length; i++) {
                    if (psnT[i][0] == null) {
                        break;
                    }
                    int total;
                    total = Integer.parseInt(buy[i][8]);
                    total_h = total_h + total;
                }
                System.out.println("Total Pembayaran = Rp." + total_h);
                System.out.print("Bayar : ");
                int bayar = in.nextInt();
                bayar(bayar, total_h);
                // tiket(buy);
                System.out.println("\nTerima Kasih...  UwU");
                remove(psnT);
            } else if (beli.equals("N")) {
                System.out.println("\nPembelian Dibatalkan T~T");
            } else {
                System.out.println("Yang Anda Masukkan Salah -_-");
                beliTiket(psnT, buy);
            }
        }
    }

    public static void bayar(int by, int tl) {
        if (by == tl) {
            System.out.println("\n<== Tiket Berhasil Dibeli ^o^ ==>");
        } else if (by < tl) {
            System.out.println("Uang Yang Anda Masukkan Kurang o#o");
            endbuy();
        } else if (by > tl) {
            int kembalian = 0;
            kembalian = kembalian + (by - tl);
            System.out.println("Kembalian Anda Rp." + kembalian + " ^v^");
        } else {
            System.out.println("Yang Anda Masukkan Salah ^u^");
            endbuy();
        }
    }

    public static void endbuy() {
        System.out.print("\nLanjutkan Pembelian(Y/N) ?");
        String lnjt = str.nextLine().toUpperCase();
        if (lnjt.equals("Y")) {
            beliTiket(pesantiket, beliTiket);
        } else if (lnjt.equals("N")) {
            menudirect();
        } else {
            System.out.println("Yang Anda Masukkan Salah -c-");
        }
    }

    public static void tiket(String belT[][]) {
        if (belT[0][0] == null) {
            System.out.println("\nSilahkan Beli Tiket Terlebih Dahulu  $-$");
        } else {
            for (int i = 0; i < belT.length; i++) {
                if (belT[i][0] == null) {
                    break;
                }
                System.out.println("\nTiket ke-" + (i + 1));
                System.out.println("No Penerbangan\t\t: " + belT[i][10]);
                System.out.println("Maskapai\t\t: " + belT[i][6]);
                System.out.println("No Kursi \t\t: " + belT[i][0]);
                System.out.println("Nama Penumpang\t\t: " + belT[i][1]);
                System.out.println("Asal-Tujuan-Jam\t\t: " + belT[i][2]);
                System.out.println("Kelas\t\t\t: " + belT[i][4]);
                System.out.println("Tipe\t\t\t: " + belT[i][5]);
                System.out.println("Tanggal Keberangkatan\t: " + belT[i][3]);
                if (belT[i][9] != null) {
                    System.out.println("Tanggal Pulang\t\t: " + belT[i][9]);
                }
            }
        }
    }

    public static void remove(String psnT[][]) {
        for (int i = 0; i < psnT.length; i++) {
            psnT[i][0] = null;
            psnT[i][1] = null;
            psnT[i][2] = null;
            psnT[i][3] = null;
            psnT[i][4] = null;
            psnT[i][5] = null;
            psnT[i][6] = null;
            psnT[i][7] = null;
            psnT[i][8] = null;
            psnT[i][9] = null;
            psnT[i][10] = null;
        }
    }

    public static int menu() {
        System.out.println("\n<==== MENU ====>");
        System.out.println("1. Daftar Penerbangan");
        System.out.println("2. Pesan Tiket");
        System.out.println("3. Batalkan Pemesanan");
        System.out.println("4. Lihat Pesanan Tiket");
        System.out.println("5. Beli Tiket");
        System.out.println("6. Lihat Tiket");
        System.out.println("7. Keluar");
        System.out.print("Pilih\t: ");
        int pilih = in.nextInt();
        return pilih;
    }

    public static void menudirect() {
        int pilih = 0;
        do {
            pilih = menu();
            switch (pilih) {
                case 1:
                    daftarPenerbangan(jadwalPenerbangan);
                    break;
                case 2:
                    pesanTiket(jadwalPenerbangan, pesantiket);
                    break;
                case 3:
                    hapusTiket(pesantiket);
                    break;
                case 4:
                    lihatPesananTiket(pesantiket);
                    break;
                case 5:
                    beliTiket(pesantiket, beliTiket);
                    break;
                case 6:
                    tiket(beliTiket);
                    break;
                case 7:
                    System.out.println("Keluar dari program... ;(");
                    break;
                default:
                    System.out.println("\nPilihan Yang Anda Pilih Tidak Ada :)");
                    break;
            }
        } while (pilih != 7);
    }

    public static void main(String[] args) {

        System.out.println("---------------------------------------------------------------");
        System.out.println("\t\t< PEMESANAN TIKET PESAWAT >");
        menudirect();

    }

}