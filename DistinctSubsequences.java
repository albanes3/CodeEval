import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DistinctSubsequences {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = null;
		String line;
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
		try		
		{
			FileInputStream file = new FileInputStream(new File(filename));
			InputStreamReader InputReader = new InputStreamReader(file);
			br = new BufferedReader(InputReader);
			while((line = br.readLine()) != null){
				String[] tokens = line.split(",");
				System.out.println("" + numSubsequences(tokens[0],tokens[1]));
			}
		}
		finally{
			br.close();
		}
	}
	
	public static int numSubsequences(String seq, String subseq){
		int count = 0;
		if(subseq.length() == 1){
			Pattern p = Pattern.compile(subseq);
			Matcher m = p.matcher(seq);    
		    while (m.find()){
		    	count +=1;
		    }
		    return count;
		}
		int length = seq.length();
		for(int i = 0; i<length; i++){
			if(seq.charAt(i)==subseq.charAt(0)){
				count += numSubsequences(seq.substring(i+1),subseq.substring(1));
			}
		}
		return count;
	}
}
