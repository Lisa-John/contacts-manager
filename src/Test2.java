import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {

//This creates the contacts file.
		String directory = "data/";
		String filename = "contacts.txt";
		Path dataDirectory = Paths.get(directory);
		Path contactsPath = Paths.get(directory, filename);


		if (!Files.isDirectory(dataDirectory)){
			try {
				Files.createDirectories(dataDirectory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (!Files.exists(contactsPath)){
			try {
				Files.createFile(contactsPath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
// Add a line to an existing line
//		try {
//			Files.write(
//					Paths.get("data", "contacts.txt"),
//					Arrays.asList("Terry Merry | 7896780987"),
//					StandardOpenOption.APPEND
//			);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}




// Print out each line in an existing file, along with the line number

		List<String> contactList = null;
		try {
			contactList = Files.readAllLines(contactsPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < contactList.size(); i += 1) {
			System.out.println((i + 1) + ": " + contactList.get(i));
		}






//Reads the file
//		try {
//			List<String> contents = Files.readAllLines(
//					Paths.get("data", "contacts.txt")
//			);
//
//	} catch (IOException e) {
//			e.printStackTrace();
//		}



//		List<String> newContacts = new ArrayList<>();
//		newContacts.add("Jack Sparrow | 9897675432");
//		newContacts.add("Jane Tarzan | 5423236789");
//		newContacts.add("Sammy Sam | 4563459876");
//
//		System.out.println(allList());
//		try {
//			Files.write(contactsPath, newContacts, StandardOpenOption.APPEND);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(allList());



	}//================end of main =================

	//Reads and Prints the file
	public static String allList() {


		try {
			List<String> contacts = Files.readAllLines(Paths.get("data/contacts.txt"));
			return contacts.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "Exception!";
		}
	}
}
