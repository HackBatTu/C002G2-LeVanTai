package ss17_binary_file.bai_tap.crud_binary_file.util;

import ss17_binary_file.bai_tap.crud_binary_file.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFile {
//    private final String FILE = "src/ss17_binary_file/bai_tap/crud_binary_file/product.txt";

    public static void writeToFile(List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream("src/ss17_binary_file/bai_tap/crud_binary_file/data/product.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(){
        List<Product> products= new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream("src/ss17_binary_file/bai_tap/crud_binary_file/data/product.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }



}
