import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReverseWords {
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
				String[] tokens = line.split("\\s+");
				System.out.print(tokens[tokens.length-1]);
				for(int i = tokens.length - 2; i>=0; i--){
					System.out.print(" " + tokens[i]);
				}
				System.out.println("");
			}
		}
		finally{
			br.close();
		}
		
	}
}
