import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DataRecovery {

	public static void main(String[] args) throws IOException{
		BufferedReader br = null;
		String line;
		String filename = args[0];
		if(filename == null){
			System.out.println("No file path specified!");
			return;
		}
		File AddFile = new File(filename);
		if(!AddFile.exists()){
			System.out.println("File " + filename + " not found!");
			return;
		}
		try{
			FileInputStream file = new FileInputStream(new File(filename));
			InputStreamReader InputReader = new InputStreamReader(file);
			br = new BufferedReader(InputReader);
			while((line = br.readLine()) != null){
				String[] split = line.split(";");
				String[] words = split[0].split("\\s+");
				String[] nums = split[1].split("\\s+");
				int length = nums.length;
				ArrayList<Integer> numList = new ArrayList<Integer>();
				for(int i = 0; i<length; i++)
					numList.add(Integer.parseInt(nums[i]));
				String[] newWords = constructSentence(numList,words);
				printSentence(newWords);
			}
		}
		finally{
			br.close();
		}
	}

	private static void printSentence(String[] words){
		System.out.print(words[0]);
		int length = words.length;
		for(int i=1; i<length; i++)
			System.out.print(" " + words[i]);
		System.out.println();
	}

	private static String[] constructSentence(ArrayList<Integer> numList, String[] words){
		int length = words.length;
		int i=0;
		while(i<length){
			if(numList.contains(i+1))
				i++;
			else{
				numList.add(i+1);
				break;
			}		
		}
		String[] newWords = new String[length];
		for(i=0; i<length; i++){
			newWords[numList.get(i)-1] = words[i];
		}
		return newWords;
	}
}


