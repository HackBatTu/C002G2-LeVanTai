package casestudy.utils.file;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReadAndWriteBuffer {
    public static void writeFile(Collection collections, String diaChi) {
        File file = new File(diaChi);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Object string : collections) {
                bufferedWriter.write(String.valueOf(string));
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //    public static Object readFile(String diaChi) {
//        File file = new File(diaChi);
//        FileReader fileReader = null;
//        BufferedReader bufferedReader = null;
//        String line = null;
//        try {
//            fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//
//            line = bufferedReader.readLine();
//            return line;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
