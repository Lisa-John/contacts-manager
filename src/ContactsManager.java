import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactsManager {
	static String directory = "data/";
	static String filename = "contacts.txt";
	static Path dataDirectory = Paths.get(directory);
	static Path contactsPath = Paths.get(directory, filename);
	static Input input = new Input();
	
	public static void main(String[] args) { //======== main starts =============
		
		createFile(); //create file if doesn't exist
		defaultMenu();
		
	}//================ end of main =================
	
	static void defaultMenu(){
		menu(); //show menu
		menuSelection(input.getInt(1,5)); //user selection
	}
// show menu
	static void menu(){
		System.out.println("");
		System.out.println(("1. View contacts."));
		System.out.println(("2. Add a new contact."));
		System.out.println(("3. Search a contact by name."));
		System.out.println(("4. Delete an existing contact."));
		System.out.println(("5. Exit."));
		System.out.println("");
	}
	
//menu seleciton
	static void menuSelection(int userSelection){
		switch(userSelection){
			case 1:
				printContacts();
				break;
			case 2:
				addContact();
				break;
			case 3:
				searchContact();
				break;
			case 4:
				deleteContact();
				break;
			case 5:
				System.exit(0);
				break;
		}
		defaultMenu();
	}
	
//This creates the contacts file if doesn't exist.
	static void createFile(){
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
	}
	
// Print contacts list
//			for (String contact : contactListR) {
//				if ((contact.toLowerCase()).contains(userInput)) {
//					inputNotFound = false;
//					System.out.println(contact);
//				}
//		}
	static void  printContacts(){
		List<String> contactList = null;
		try {
			contactList = Files.readAllLines(contactsPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int nameLength = 0;
		for (String contact : contactList) {
			int nameLengthTest = contact.lastIndexOf("-");

			if (nameLengthTest > nameLength){
				nameLength = nameLengthTest;
			}
		}
		String formatBar = "-";
		while (formatBar.length() < (nameLength + 15)){
			formatBar += "-";
		}
		String formatting = "%-"+ nameLength + "s | %-15s\n";
		System.out.printf(formatting, "Name", "Phone Number");
		System.out.println(formatBar);
		for (String contact : contactList) {
			String[] person = contact.split(" - ");
			String name = person[0];
			String phone = person[1];
			System.out.printf(formatting, name, phone);
		}
		System.out.println(formatBar);
	}
	
// Add a new contact to contacts list
	static void addContact(){
		input.getStrings();
		String name = input.getStrings("Enter a name");
		String number = input.getStrings("Enter a number");
		String userContact = name + " - " + number;
		try {
			Files.write(contactsPath, Arrays.asList(userContact), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	static void searchContact(){
		input.getStrings();
		String userInput = input.getStrings("What would you like to search for?").toLowerCase();
		List<String> contactListR = null;
		try {
			contactListR = Files.readAllLines(contactsPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean inputNotFound = true;
		for (String contact : contactListR) {
				if ((contact.toLowerCase()).contains(userInput)) {
					inputNotFound = false;
					System.out.println(contact);
				}
		}
		if (inputNotFound) {
			System.out.println("no " + userInput + " found in file");
		}
	}
	
	static void deleteContact(){
		input.getStrings();
		String userInput = input.getStrings("What would you like to delete?").toLowerCase();
		System.out.println(userInput);
		List<String> contactListR = null;
		try {
			contactListR = Files.readAllLines(contactsPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> newList = new ArrayList<>();
		for (String contact : contactListR) {
			if ((contact.toLowerCase()).contains(userInput)) {
				//do nothing
			} else {
			newList.add(contact);
			}
		}
		try {
			Files.write(contactsPath, newList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
	
	
	
	static void readContacts(){
	} //TBD

	//Reads and Prints the file
	@Deprecated
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
