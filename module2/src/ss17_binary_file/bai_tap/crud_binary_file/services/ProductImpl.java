package ss17_binary_file.bai_tap.crud_binary_file.services;


import ss17_binary_file.bai_tap.crud_binary_file.model.Product;
import ss17_binary_file.bai_tap.crud_binary_file.util.ProductFile;

import java.util.*;

public class ProductImpl implements IProduct{
    public static List<Product> productList = new ArrayList<>();
    public static ProductFile productFile = new ProductFile();
    Scanner sc = new Scanner(System.in);

    {
        productList.add(new Product(1, "xe điện", "vinfast", 10000.0, "blue"));
        productList.add(new Product(2, "ebook", "google", 30000.0, "red"));
        productList.add(new Product(3, "chém gió", "đông lào", 20000.0, "~~~"));

        ProductFile.writeToFile(productList);
    }

    public void display() {
            List<Product> productListFormFile = ProductFile.readDataFromFile();

        for (Product p: productListFormFile) {
            System.out.println(p);
        }

//            System.out.format("%5d | ", o.getId());
//            System.out.format("%20s | ", o.getName());
//            System.out.format("%5d | ", o.getManufacturer());
//            System.out.format("%20d | ", o.getPrice());
//            System.out.format("%10.1f%n", o.getColor());
    }

    public void add()  {
        System.out.print("Enter the id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        System.out.print("Enter the manufacture: ");
        String manu = sc.nextLine();
        System.out.print("Enter the price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the color: ");
        String color = sc.nextLine();
        productList.add(new Product( id,name, manu, price, color));

        ProductFile.writeToFile(productList);
    }

    @Override
    public void search() {
        System.out.println("enter the id search");
        int ids = Integer.parseInt(sc.nextLine());
        int size = productList.size();
        for (int i = 0; i < size; i++) {
            if (productList.get(i).getId() == ids) {
                System.out.println(productList.get(i));
                break;
            }else {
                System.out.println("id is not found");
            }
        }

    }

    public void edit() {
        boolean check = false;
        System.out.println("enter the id need Edit");
        int id = Integer.parseInt(sc.nextLine());
        int size = productList.size();
        for (int i = 0; i < size; i++) {
            if (productList.get(i).getId() == id) {
                check = true;
                System.out.print("Enter the new id: ");
                productList.get(i).setId(Integer.parseInt(sc.nextLine()));
                System.out.print("Enter the new name: ");
                productList.get(i).setName(sc.nextLine());
                System.out.print("Enter the new manufacture: ");
                productList.get(i).setManufacturer(sc.nextLine());
                System.out.print("Enter the new price: ");
                productList.get(i).setPrice(Double.parseDouble(sc.nextLine()));
                System.out.print("Enter the new color: ");
                productList.get(i).setColor(sc.nextLine());
                break;
            }
        }
        if (!check) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            ProductFile.writeToFile(productList);
        }
    }

    public void delete()  {
        System.out.println("enter the id need dell");
        int id = Integer.parseInt(sc.nextLine());
        Product product = null;
        int size = productList.size();
        for (int i = 0; i < size; i++) {
            if (productList.get(i).getId() == id) {
                product = productList.get(i);
                break;
            }
        }
        if (product != null) {
            productList.remove(product);
            ProductFile.writeToFile(productList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    public void sortProductByName() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Product product:productList){
            System.out.println(product);
        }
    }
    public void sortProductByPrice(){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice()> o2.getPrice()){
                    return 1;
                }else if(o1.getPrice()< o2.getPrice()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        for (Product product:productList){
            System.out.println(product);
        }
    }
    public void sortProductById(){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getId()- o2.getId();
            }
        });
        for (Product product:productList){
            System.out.println(product);
        }
    }


}
