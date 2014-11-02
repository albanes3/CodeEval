import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DetectFirstCycle {
	
	public static void main(String[] args) throws IOException{
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
				String[] nums = line.split("\\s+");
				int length = nums.length;
				ArrayList<Integer> numList = new ArrayList<Integer>();
				for(int i = 0; i<length; i++)
					numList.add(Integer.parseInt(nums[i]));
				detectFirstCycle(numList);
			}
		}
		finally{
			br.close();
		}
	}
	
	private static void detectFirstCycle(ArrayList<Integer> numSeq){
		int length = numSeq.size();
		ArrayList<Integer> subSeq = new ArrayList<Integer>();
		subSeq.add(numSeq.get(0));
		int size = 1;
		for(int i = 1; i<length; i++){
			for(int j=0; j<size; j++){
				if(subSeq.get(j)==numSeq.get(i)){
					int k = j;
					int g = i;
					while(k<size){
						if(subSeq.get(k)!=numSeq.get(g))
							break;
						k++;
						g++;
					}
					if(k==size){
						System.out.print("" + numSeq.get(i));
						for(int m=i+1; m<(i+size-j); m++){
							System.out.print(" " + numSeq.get(m));
						}
						System.out.println();
						return;
					}	
				}
			}
			subSeq.add(numSeq.get(i));
			size++;
		}
		System.out.println("No cycles detected.");
	}
}
