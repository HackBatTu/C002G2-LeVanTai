package ss16_io_text_file.thuc_hanh;

import java.io.*;
import java.util.Scanner;

public class CountNumInFileTest {
    public void readFileText(String filePath){
        System.out.println("src/ss16_io_text_file/thuc_hanh/file.txt");
        try{
            File file = new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line =" ";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(file);
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println("Tổng = "+ sum);
        }catch (Exception e){
            System.err.println("File k tồn tại or nội dung có lỗi !");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhập dường dẫn file : ");
        String path = scanner.nextLine();
        CountNumInFileTest countNumInFileTest = new CountNumInFileTest();
        countNumInFileTest.readFileText(path);
    }
}
