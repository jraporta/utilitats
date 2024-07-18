import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Csv implements Iterable<String[]>{
	
	private Path path;
	
	public Csv (Path path) {
		this.path = path;
	}
	
	public Path getPath() {
		return this.path;
	}
	
	public static Collection<String[]> toCollection(Collection<String[]> c, Path path) throws IOException {
		c.clear();
		try (Scanner fitxer = new Scanner(Files.newBufferedReader(path))){
			while(fitxer.hasNext()) {
				c.add(fitxer.nextLine().split(","));
			}
		}
		return c;
	}

	@Override
	public Iterator<String[]> iterator() {
		Iterator<String[]> ite = null;
		try {
			ite = Csv.toCollection(new HashSet<String[]>(), this.path).iterator();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ite;
	}
	
	
}
