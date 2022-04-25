package casestudy.utils;

import casestudy.models.Customer;

import java.io.*;
import java.util.Collection;
import java.util.List;

public class ReadAndWrite {
    public static List<Customer> write(Collection collection, String diaChi){
        File file = new File(diaChi);

        if(!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(collection);
        }catch (FileNotFoundException e ){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                fileOutputStream.close();
                objectOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    public static Object read(String diaChi){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        Object object = null;
        try{
            fileInputStream = new FileInputStream(diaChi);
            objectInputStream = new ObjectInputStream(fileInputStream);
            object =objectInputStream.readObject();
            return object;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
