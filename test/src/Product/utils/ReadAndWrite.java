package Product.utils;

import Product.models.Moto;
import Product.models.Oto;
import Product.models.Truck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    private static final String FILE_OTO ="src/Product/data/oto.csv";
    private static final String FILE_MOTO ="src/Product/data/moto.csv";
    private static final String FILE_TRUCK ="src/Product/data/truck.csv";
    public static void writeFile(String path, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeMoto(String part, List<Moto> list) {
        List<String> motos = new ArrayList<>();
        for (Moto moto : list) {
            motos.add(moto.line());
        }
        writeFile(part, motos);
    }

    public static void writeOto(String part, List<Oto> list) {
        List<String> otos = new ArrayList<>();
        for (Oto oto : list) {
            otos.add(oto.line());
        }
        writeFile(part, otos);
    }

    public static void writeTruck(String part, List<Truck> list) {
        List<String> lists = new ArrayList<>();
        for (Truck truck : list) {
            lists.add(truck.line());
        }
        writeFile(part, lists);

    }

    public static List<String> readFile(String part) {
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(part);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<Oto> readOto(){
        List<String> list = readFile(FILE_OTO);
        List<Oto> otoList = new ArrayList<>();
        String[] arr = null;
        for(String str : list){
            arr = str.split(",");
            otoList.add(new Oto(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]));
        }
        return  otoList;
    }
    public static List<Moto> readMoto(){
        List<String> list = readFile(FILE_MOTO);
        List<Moto> motoList = new ArrayList<>();
        String[] arr= null;
        for(String str : list){
            arr = str.split(",");
            motoList.add(new Moto(arr[0],arr[1],arr[2],arr[3],arr[4] ));
        }
        return motoList;
    }
    public static List<Truck> readTruck(){
        List<String> list = readFile(FILE_TRUCK);
        List<Truck> truckList = new ArrayList<>();
        String[] arr= null;
        for(String str : list){
            arr = str.split(",");
            truckList.add(new Truck(arr[0],arr[1],arr[2],arr[3],arr[4] ));
        }
        return truckList;
    }
}
