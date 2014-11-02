import java.io.File;
import java.io.IOException;

public class FileSize {
	public static void main(String[] args) throws NumberFormatException, IOException{
		String filename = args[0];
		if(filename == null){
			System.out.println("No file path specified!");
			return;
		}
		File AddFile = new File(filename);
		if(!AddFile.exists())
		{
			System.out.println("File " + filename + " not found!");
			return;
		}	
			System.out.println(AddFile.length());
	}
}
