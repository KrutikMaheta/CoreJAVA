// Creating simple phonebook using properties class 

package collections.demos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Properties_Load_Store_Demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties phoneBook = new Properties();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name, phoneNo;
		boolean changed = false;
		FileInputStream fin = null;

		try {
			fin = new FileInputStream("phonebook.dat");
		} catch (FileNotFoundException e) {

		}

		try {
			if (fin != null) {
				phoneBook.load(fin);
				fin.close();
			}
		} catch (IOException e) {
			System.out.println("Error in reading file");
		}

		do {
			System.out.println("Enter name : (Enter quit to stop)");
			name = br.readLine();
			if (name.equals("quit"))
				continue;
			System.out.println("Enter contact number : ");
			phoneNo = br.readLine();
			phoneBook.put(name, phoneNo);
			changed = true;

		} while (!(name.equals("quit")));

		if (changed) {
			FileOutputStream fout = new FileOutputStream("phonebook.dat");
			phoneBook.store(fout, "Telehone book");
			fout.close();
		}

		do {
			System.out.println("Enter a name to find : ");
			name = br.readLine();
			if (name.equals("quit"))
				continue;
			phoneNo = (String) phoneBook.getProperty(name);
			System.out.println(phoneNo);
		} while (!(name.equals("quit")));

	}

}
