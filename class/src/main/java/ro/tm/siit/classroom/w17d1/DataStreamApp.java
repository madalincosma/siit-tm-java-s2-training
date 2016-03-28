package ro.tm.siit.classroom.w17d1;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataStreamApp class exhibits basic usage for writing data in a file.
 * @author mco
 *
 */
public class DataStreamApp {

	public static void main(String[] args) throws IOException {
		writeNumericValues("abcd.data");
	}
	
	static void writeNumericValues(String path) throws IOException {
	    DataOutputStream out = null;
		 try {
	        out = new DataOutputStream(
	           new BufferedOutputStream(new FileOutputStream(path))
	        );
	        // write some values from memory into the file
	        out.writeDouble(10.1E-13);
	        out.writeInt(222444);
	        out.writeUTF("something");
	    } finally {
	        if (out != null) out.close();
	    }
	}


}
