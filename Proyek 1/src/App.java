import java.util.Scanner;
import com.config.MyConfig;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("-".repeat(20));
        System.out.println("SELAMAT DATANG DI APLIKASI PROGRAM DATA BASE");
        System.out.println("-".repeat(20));
        System.out.println("1. Read Data");
        System.out.println("2. Insert Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("5. Exit");
        System.out.println("-".repeat(20));

        while (true) {
            System.out.println("-".repeat(20));
            System.out.print("Masukkan pilihan: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    readData();
                    break;
                case 2:
                    insertData();
                    break;
                case 3:
                    editData();
                    break;
                case 4:
                    deleteData();
                    break;
                case 5:
                    System.out.println("Terima kasih telah berkunjung di aplikasi ini.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
        }
    }

    public static void readData() {
        MyConfig myConfig = new MyConfig();
        myConfig.connection();
        myConfig.getDatabase();
    }

    public static void insertData() {
        MyConfig myConfig = new MyConfig();
        myConfig.insertData();
    }

    public static void editData() {
        MyConfig myConfig = new MyConfig();
        myConfig.editData();
    }

    public static void deleteData() {
        MyConfig myConfig = new MyConfig();
        myConfig.deleteData();
    }
}