package bai_tap_lam_them.bai_1_movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {
    static final String PATH = "src/bai_tap_lam_them/bai_1_movie/movie.csv";

    public static void writeFile(String path,List<String> list){
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String e: list) {
                bufferedWriter.write(e);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeMovie(List<Movie> movieList){
        List<String> list = new ArrayList<>();
        for (Movie e:movieList) {
            list.add(e.line());
        }
        writeFile(PATH,list);
    }
    public static List<String> readFile(String pathFile){
        List<String> list= new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line= bufferedReader.readLine()) !=null){
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
    public static List<Movie> readMovie(){
        List<String> list= readFile(PATH);
        List<Movie> movieList = new ArrayList<>();
        String[] arr = null;
        for (String str : list){
            arr = str.split(",");
            movieList.add(new Movie(arr[0],arr[1],arr[2],Integer.parseInt(arr[3]) ));
        }
        return movieList;
    }
}
