import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class NmodM {


	public static void main(String[] args){
		try {
			readFromFile(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readFromFile(String filename) throws IOException {
		BufferedReader br = null;
		String line;
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
		try		
		{
			FileInputStream file = new FileInputStream(new File(filename));
			InputStreamReader InputReader = new InputStreamReader(file);
			br = new BufferedReader(InputReader);
			while((line = br.readLine()) != null){
				String[] tokens = line.split(",");
				if(tokens.length == 2){
					int div1 = Integer.parseInt(tokens[0]);
					int div2 = Integer.parseInt(tokens[1]);
					System.out.println("" + (div1 - div1/div2*div2));
				}
				else{
					System.out.println("ERROR: Incorrect formatting");
				}
			}
		}
		finally{
			br.close();
		}

	}
}
