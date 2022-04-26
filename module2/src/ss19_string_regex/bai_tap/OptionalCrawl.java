package ss19_string_regex.bai_tap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OptionalCrawl {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://dantri.com.vn/the-gioi.htm ");
            Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
            sc.useDelimiter("\\Z");
            String content = sc.next();
            sc.close();
            content = content.replaceAll("\\n+", "");

            Pattern p = Pattern.compile("\"name>(.*?)</a>");

            while (p.matcher(content).find()) {
                System.out.println(p.matcher(content).group(1));
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
