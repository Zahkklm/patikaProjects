package com.patika;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class PatikaStore {
    private final Set<Brand> brands;
    private final List<Product> products;

    public PatikaStore() {
        brands = new TreeSet<>(Arrays.asList(
                new Brand("Samsung"),
                new Brand("Lenovo"),
                new Brand("Apple"),
                new Brand("Huawei"),
                new Brand("Casper"),
                new Brand("Asus"),
                new Brand("HP"),
                new Brand("Xiaomi"),
                new Brand("Monster")
        ));
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    public void listBrands() {
        System.out.println("Markalarımız");
        System.out.println("--------------");
        for (Brand brand : brands) {
            System.out.println("- " + brand);
        }
        System.out.println();
    }

    public void listProducts(String type) {
        System.out.printf("%s Listesi\n", type);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| ID | Ürün Adı                      | Fiyat     | Marka     | %s \n", type.equals("Notebook") ? "Depolama  | Ekran     | RAM         " : "Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        for (Product product : products) {
            if ((type.equals("Notebook") && product instanceof Notebook) ||
                    (type.equals("Cep Telefonu") && product instanceof Phone)) {
                System.out.println(product);
            }
        }
        System.out.println();
    }

    public void filterProductsById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Ürün bulunamadı.");
    }

    public void filterProductsByBrand(String brandName) {
        for (Product product : products) {
            if (product.getBrand().getName().equalsIgnoreCase(brandName)) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        PatikaStore store = new PatikaStore();

        // Örnek ürünler ekleniyor
        Brand samsung = new Brand("Samsung");
        Brand apple = new Brand("Apple");
        Brand lenovo = new Brand("Lenovo");

        store.addProduct(new Phone(3199, 10, 100, "Samsung Galaxy A51", samsung, "128 GB", 6.5, 4000, 6, "Siyah"));
        store.addProduct(new Phone(7379, 5, 50, "iPhone 11", apple, "64 GB", 6.1, 3046, 6, "Mavi"));
        store.addProduct(new Notebook(7000, 15, 10, "HUAWEI Matebook 14", new Brand("Huawei"), "16 GB", "512 SSD", 14));
        store.addProduct(new Notebook(3699, 20, 20, "LENOVO V14 IGL", lenovo, "8 GB", "1024 SSD", 14));

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz : ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    store.listProducts("Notebook");
                    break;
                case 2:
                    store.listProducts("Cep Telefonu");
                    break;
                case 3:
                    store.listBrands();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
