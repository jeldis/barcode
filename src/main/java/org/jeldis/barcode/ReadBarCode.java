package org.jeldis.barcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadBarCode {

    public ReadBarCode() {

    }

    public String[] getBarCode(String imageName) throws IOException, InterruptedException {

        String[] barCode;
        Runtime rt = Runtime.getRuntime();

        Process proc = rt.exec("zbarimg.exe " + imageName);

        InputStream stdin = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(stdin);
        BufferedReader br = new BufferedReader(isr);
        String line = null;

        long count = br.lines().count();
        barCode = new String[(int) count];
        int i = 0;

        while ((line = br.readLine()) != null) {
            barCode[i] = line;
            i++;
        }

        int exitVal = proc.waitFor();
        System.out.println("Process exitValue: " + exitVal);

        return barCode;

    }
}