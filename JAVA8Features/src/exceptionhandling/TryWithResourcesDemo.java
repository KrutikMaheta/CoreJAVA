/**
 * The try-with-resources statement can be used only with those resources that
 * implement the AutoCloseable interface defined by java.lang.
 * 
 * When the try block ends, the resource is automatically released.
 * 
 * It is important to understand that a resource declared in the try statement is
 * implicitly final. This means that you can’t assign to the resource after it has been created
 * 
 * 
 */

package exceptionhandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResourcesDemo {

	public static void main(String[] args) {
		int i;
		// here both fin and fout is being closed as soon as the program control
		// goes out of the try statement
		try (FileInputStream fin = new FileInputStream(args[0]);
				FileOutputStream fout = new FileOutputStream(args[1])) {
			do {
				i = fin.read();
				if (i != -1)
					fout.write(i);
			} while (i != -1);
		}
		// Demo for the multi catch statements [Feature of JAVA 7]
		catch (ArrayIndexOutOfBoundsException | IOException e) {
			System.out.print(e);
		}
	}

}
