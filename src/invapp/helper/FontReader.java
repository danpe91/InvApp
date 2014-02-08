package invapp.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FontReader {

    public static String readFontFromFile(String fileName) {

        String currentFont = "";
        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            currentFont = br.readLine();

            if (currentFont != null) {
                currentFont = currentFont.trim();
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
}
