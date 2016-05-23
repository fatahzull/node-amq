package instaBot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConfigFile {
	public ArrayList readFile(String path) throws FileNotFoundException, IOException {
		String line = null;
		ArrayList<String> al = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(path));
		while ((line = br.readLine()) != null) {
            if (line.contains("//") || line.trim().isEmpty()) {                
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