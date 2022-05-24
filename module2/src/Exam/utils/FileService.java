package Exam.utils;

import Exam.models.DienThoaiChinhHang;
import Exam.models.DienThoaiXachTay;

import java.io.*;
import java.util.*;

public class FileService {

    private static void writeToFile(String pathFile, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void writeMobileChinhHang(String pathFile, List<DienThoaiChinhHang> dienThoaiChinhHangs) {
        List<String> strings = new ArrayList<>();

        for (DienThoaiChinhHang mobiec : dienThoaiChinhHangs) {
            strings.add(mobiec.line());
        }
        writeToFile(pathFile, strings);
    }

    public static void writeMobieXachTay(String pathFile, List<DienThoaiXachTay> dienThoaiXachTays) {
        List<String> strings = new ArrayList<>();

        for (DienThoaiXachTay mobiex : dienThoaiXachTays) {
            strings.add(mobiex.line());
        }
        writeToFile(pathFile, strings);
    }


    private static List<String> readFile(String pathFile) {
        List<String> list = new ArrayList<>();
        File file = new File(pathFile);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<DienThoaiChinhHang> readMobileChinhHang(String pathFile) {
        List<DienThoaiChinhHang> mobilec = new ArrayList<>();
        List<String> strings = readFile(pathFile);

        String[] arr;
        for (String s : strings) {
            arr = s.split(",");
            mobilec.add(new DienThoaiChinhHang(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]));
        }
        return mobilec;
    }

    public static List<DienThoaiXachTay> readMobieXachTay(String pathFile) {
        List<DienThoaiXachTay> mobiex = new ArrayList<>();
        List<String> strings = readFile(pathFile);

        String[] arr;
        for (String s : strings) {
            arr = s.split(",");
            mobiex.add(new DienThoaiXachTay(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]));
        }
        return mobiex;
    }


}
