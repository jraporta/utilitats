package n3exercici1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Scanner;

public class Csv {
	
	
	
	public static Collection<String[]> toCollection(Collection<String[]> c, Path path) throws IOException {
		c.clear();
		try (Scanner fitxer = new Scanner(Files.newBufferedReader(path))){
			while(fitxer.hasNext()) {
				c.add(fitxer.nextLine().split(","));
			}
		}
		return c;
	}
	
	
}
