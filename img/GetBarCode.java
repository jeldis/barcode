//https://www.javaworld.com/article/2071275/core-java/when-runtime-exec---won-t.html

import java.util.*;
import java.io.*;

public class GetBarCode {
    public static void main(String args[]) {

        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("zbarimg.exe barcodeCollage.jpg");
            InputStream stdin = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdin);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            System.out.println("<OUTPUT>");
            while ((line = br.readLine()) != null)
                System.out.println(line);
            System.out.println("</OUTPUT>");
            int exitVal = proc.waitFor();
            System.out.println("Process exitValue: " + exitVal);
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }
}