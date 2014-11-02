import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class ShortestRepitition {
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
				shortestRep(line);

			}
		}
		finally{
			br.close();
		}
	}

	private static void shortestRep(String line) {
		String shortestRep = "";
		int i = 1;
		int length = line.length();
		if(length == 0)
			System.out.println("0");
		else if(length == 1)
			System.out.println("1");
		else{
			shortestRep += line.charAt(0);
			while(i<length){
				if(shortestRep.charAt(0) == line.charAt(i)){
					int count = countSubstrings(shortestRep,line.substring(i));
					if(count*i == line.substring(i).length()){
						System.out.println("" + i);
						return;
					}
					else{
						shortestRep += line.charAt(i);
					}
				}
				else{
					shortestRep += line.charAt(i);
				}
				i++;
				if(i == length)
					System.out.println("" + i);
			}
		}

	}

	private static int countSubstrings(String shortestRep, String remainder) {
		int count = 0;
		int idx = 0;
		int length = shortestRep.length();

		while ((idx = remainder.indexOf(shortestRep, idx)) != -1)
		{
			idx+=length;
			count++;
		}
		return count;
	}
}
