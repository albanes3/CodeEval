import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class LongestWord {

	public static void main(String[] args){
		readFromFile(args[0]);
	}

	private static void readFromFile(String filename){
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
			while((line = br.readLine()) != null) 
			{
				String[] tokens = line.split("\\s+");
				int length = tokens.length;
				int maxLength = 0;
				String longestWord = "";
				for(int i =0; i<length; i++){
					if(tokens[i].length()>maxLength){
						maxLength = tokens[i].length();
						longestWord = tokens[i];
					}
				}
				System.out.println(longestWord);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
