package ss17_binary_file.bai_tap.coppy_file_binary;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Copy {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream ins = null;
        OutputStream ous = null;
        try {
            ins = new FileInputStream(source);
            ous = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = ins.read(buffer)) > 0) {
                ous.write(buffer, 0, length);
            }
        } finally {
            ins.close();
            ous.close();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter source file:");
        String sourcePath = sc.nextLine();
        System.out.printf("Enter target file:");
        String destPath = sc.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingJava7Files(sourceFile, destFile);
            System.out.printf("Copy completed");
        } catch (IOException ioe) {
            System.out.printf("Can't copy that file");
            System.out.printf(ioe.getMessage());
        }
    }
}
