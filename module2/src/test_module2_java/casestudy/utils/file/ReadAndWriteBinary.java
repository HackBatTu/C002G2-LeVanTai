package test_module2_java.casestudy.utils.file;

import java.io.*;
import java.util.Collection;

public class ReadAndWriteBinary {
    public static void write(Collection collec, String diaChi){
        File file = new File(diaChi);
        if(!file.exists()){ // kiểm tra tồn tại
            try {
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(collec);

        }catch (FileNotFoundException e ){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                fos.close();
                oos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static Object read(String diaChi){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Object o = null;
        try{
            fis = new FileInputStream(diaChi);
            ois = new ObjectInputStream(fis);
            o =ois.readObject();
            return o;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
