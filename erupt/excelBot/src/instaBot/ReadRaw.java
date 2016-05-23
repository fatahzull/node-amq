package instaBot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public  class ReadRaw {
    public static ArrayList <String>readFile(String path) throws FileNotFoundException, IOException {
        String line = null;
        ArrayList<String> al = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null) {
            if (line.contains("//")) {
                System.out.println(line);
                continue;
            }
            else {
                al.add(line);
            }
        }
        br.close();
        return al;
    }
}
