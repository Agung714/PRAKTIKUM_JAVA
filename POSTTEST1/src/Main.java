import java.io.*;
import java.util.*;

public class Main {
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<Barang> DataBarang = new ArrayList<>();
    private static ArrayList<akun> DataAkun = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        DataBarang.add(new Barang("Mug", 30000, 20));
        DataBarang.add(new Barang("Gantungan kunci", 10000, 40));
        DataBarang.add(new Barang("Kaos", 60000, 20));
        DataBarang.add(new Barang("Topi", 40000, 10));
        menu_login();
    }

    private static void nambah_data() throws NumberFormatException, IOException {
        System.out.println("=================");
        System.out.println("Tambah Data Barang");
        System.out.println("=================\n");
        System.out.print("Masukan Jumlah Data yang ingin dimasukan : ");
        int batasan = error_int();
        clear();
        for (int i = 0; i < batasan; i++) {
            System.out.println("==============================");
            System.out.println("Data ke- " + (i+1));
            System.out.print("Masukkan Nama Barang : ");
            String nama = input.readLine();
            System.out.print("Masukkan Harga Barang :");
            double harga = error_int();
            System.out.print("Masukkan Jumlah Stok Barang :");
            int stok = error_int();
            Barang new_data = new Barang(nama, harga, stok);
            DataBarang.add(new_data);
        }
        System.out.println("===============================");
        System.out.println("    Data Berhasil Ditambah");
        System.out.println("===============================");

    }

    private static void tampil_data() throws NumberFormatException, IOException {
        System.out.println(
                "====================================================================");
        System.out.println(
                "\n| No |\tNama\t            |\tHarga                 |\tStok       |");
        System.out.println(
                "====================================================================");
        for (int i = 0; i < DataBarang.size(); i++) {
            System.out.printf("| %2d ", (i + 1));
            System.out.printf("|\t%-20s  ", DataBarang.get(i).getNama());
            System.out.printf("|\t%-20s   ", DataBarang.get(i).getHarga());
            System.out.printf("|\t%-20s    ", DataBarang.get(i).getStok());
            System.out.println("\n");
        }
        System.out.println("Tekan enter untuk melanjutkan. . .");
        input.readLine();
    }

    private static void update_data() throws NumberFormatException, IOException {
        tampil_data();
        System.out.println("=================");
        System.out.println("Update Data Barang");
        System.out.println("=================");
        System.out.println("");
        System.out.print("Input nama barang : ");
        String nm = input.readLine();
        System.out.println(
                "====================================================================");
        System.out.println(
                "\n| No |\tNama            |\tHarga                 |\tStok         |");
        System.out.println(
                "====================================================================");
        for (Barang barang : DataBarang) {
            if (barang.getNama().equals(nm)) {
                System.out.printf("|\t%-20s  ", barang.getNama());
                System.out.printf("|\t%-20s   ", barang.getHarga());
                System.out.printf("|\t%-20s    ", barang.getStok());
                System.out.println("\n");
                System.out.println("1. Ubah  Nama");
                System.out.println("2. Ubah  Harga");
                System.out.println("3. Ubah  Stok");
                System.out.print("Pilihan : ");
                int pilihan = Integer.parseInt(input.readLine());
                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan Nama baru : ");
                        barang.setNama(input.readLine());
                        break;
                    case 2:
                        System.out.print("Masukkan Harga baru : ");
                        barang.setHarga(error_int());
                        break;
                    case 3:
                        System.out.print("Masukkan Stok : ");
                        barang.setStok(error_int());
                        break;
                    default:
                        System.err.println("==========================");
                        System.err.println("  Inputan tidak terdaftar ");
                        System.err.println("==========================");
                        break;

                }

            }
        }
    }

    private static void delete_data() throws NumberFormatException, IOException {
        tampil_data();
        System.out.println("=================");
        System.out.println("Delete Data Barang");
        System.out.println("=================");
        System.out.print("Input nama barang : ");
        String nm2 = input.readLine();
        System.out.println(
                "====================================================================");
        System.out.println(
                "\n| No |\tNama            |\tHarga                 |\tStok         |");
        System.out.println(
                "====================================================================");for (Barang barang : DataBarang) {
            if (barang.getNama().equals(nm2)) {
                System.out.printf("|\t%-20s  ", barang.getNama());
                System.out.printf("|\t%-20s   ", barang.getHarga());
                System.out.printf("|\t%-20s    ", barang.getStok());
                System.out.println("\n");
                System.out.print("Hapus data [y/n] : ");
                String yakin = input.readLine();
                if (yakin.equalsIgnoreCase("y")) {
                    DataBarang.remove(barang);
                    System.out.println("===============================");
                    System.out.println("    Data berhasil dihapus !");
                    System.out.println("===============================");
                }
                break;
            }
        }
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int error_int() throws IOException {
        int masukkan_integer = 0;
        while (true) {
            try {
                masukkan_integer = Integer.parseInt(input.readLine());
                break;
            } catch (NumberFormatException e) {
                System.err.print("\tInputan harus Integer : ");
            }
        }
        return masukkan_integer;
    }

    private static void exit() {
        System.out.println("===============================================");
        System.out.println("  TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI");
        System.out.println("===============================================");
    }

    private static void menu_login() throws NumberFormatException, IOException {
        while (true) {
            clear();
            System.out.println("================================");
            System.out.println("= 1. Register                  =");
            System.out.println("= 2. Login                     =");
            System.out.println("= 3. Exit                      =");
            System.out.println("================================");
            System.out.print("Masukkan pilihan Anda : ");
            int pilih = error_int();
            switch (pilih) {
                case 1:
                    daftar();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    exit();
                    System.exit(0);
                    break;
                default:
                    System.err.println("==========================");
                    System.err.println(" Inputan tidak terdaftar");
                    System.err.println("==========================");
                    break;
            }
        }

    }

    private static void daftar() throws IOException {
        clear();
        System.out.println("=============================");
        System.out.println("=           REGISTER        =");
        System.out.println("=============================");
        System.out.print("Masukkan username : ");
        String user = input.readLine();
        System.out.print("Masukkan password : ");
        String pass = input.readLine();
        akun new_akun = new akun(user, pass);
        DataAkun.add(new_akun);
        System.out.println("===============================");
        System.out.println("    Akun berhasil ditambah");
        System.out.println("===============================");
        System.out.println("");
        System.out.println("Tekan enter untuk melanjutkan. . .");
        input.readLine();
        login();
    }

    private static void login() throws NumberFormatException, IOException {
        clear();
        System.out.println("==============================");
        System.out.println("=           LOGIN            =");
        System.out.println("==============================");
        System.out.print("Masukkan Username : ");
        String userp = input.readLine();
        System.out.print("Masukkan Password : ");
        String passp = input.readLine();
        for (akun akun : DataAkun) {
            if (akun.getusername().equals(userp)) {
                if (akun.getPass().equals(passp)) {
                    clear();

                    utama();
                    break;
                }
            } else {
                clear();
                System.out.println("=================================");
                System.out.println("  Username atau Password Salah");
                System.out.println("=================================");
            }
        }
    }

    private static void utama() throws NumberFormatException, IOException {
        boolean lanjut = true;
        while (lanjut) {
            clear();
            System.out.println("\t=========================");
            System.out.println("\t          Menu      ");
            System.out.println("\t=========================");
            System.out.println("\t= 1. Tambah Data Barang =");
            System.out.println("\t= 2. Lihat   Data Barang =");
            System.out.println("\t= 3. Ubah    Data Barang =");
            System.out.println("\t= 4. Hapus   Data Barang =");
            System.out.println("\t= 5. Kembali    =");
            System.out.print("\n\tMasukan Pilihan Anda : ");
            int pilih = error_int();
            switch (pilih) {
                case 1:
                    clear();
                    nambah_data();
                    break;
                case 2:
                    clear();
                    tampil_data();
                    break;
                case 3:
                    clear();
                    update_data();
                    break;
                case 4:
                    clear();
                    delete_data();
                    break;
                case 5:
                    clear();
                    menu_login();
                    break;
                default:
                    System.err.println("===============================");
                    System.err.println("    Inputan tidak terdaftar");
                    System.err.println("===============================");
                    System.out.println("Tekan enter untuk melanjutkan");
                    input.readLine();
                    break;
            }
        }
        exit();
    }
}