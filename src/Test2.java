import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test2 {

	public static void main(String[] args) {

//This creates the contacts file.
		String directory = "data";
		String filename = "contacts.txt";
		Path dataDirectory = Paths.get(directory);
		Path dataFile = Paths.get(directory, filename);

		if (!Files.isDirectory(dataDirectory)){
			try {
				Files.createDirectories(dataDirectory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (!Files.exists(dataFile)){
			try {
				Files.createFile(dataFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}




	}
}
