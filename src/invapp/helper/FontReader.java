package invapp.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FontReader {

    public static String readFontNameFromFile(String fileName) {

        String currentFont = "";
        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();

            if (line != null) {
                
                currentFont = line.split(",")[0];
            } else {
                currentFont = "";
            }

        } catch (FileNotFoundException fne) {
            
            try {
                java.io.File file = new java.io.File(fileName);
            file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
            
            fne.printStackTrace();
        } catch (IOException fne) {
            fne.printStackTrace();
        }
        return currentFont;
    }
    
    public static int readFontSizeFromFile(String fileName) {

        int currentSize = 8;
        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();

            if (line != null) {
                
                try {
                    currentSize = Integer.valueOf(line.split(",")[1]);
                } catch(java.lang.ArrayIndexOutOfBoundsException e) {
                    currentSize = 8;
                }
            } else {
                currentSize = 8;
            }

        } catch (FileNotFoundException fne) {
            
            try {
                java.io.File file = new java.io.File(fileName);
            file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
            
            fne.printStackTrace();
        } catch (IOException fne) {
            fne.printStackTrace();
        }
        return currentSize;
    }
}
