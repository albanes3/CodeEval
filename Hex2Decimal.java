import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Hex2Decimal {
	
	public static void main(String[] args){
		ArrayList<String> hexList = readFromFile(args[0]);
		//ArrayList<String> test = new ArrayList<String>();
		//test.add("00");test.add("01");test.add("02");test.add("ab");
		//printDecimalNumbers(test);
		printDecimalNumbers(hexList);
	}
	
	private static ArrayList<String> readFromFile(String filename){
		BufferedReader br = null;
		String line;
		ArrayList<String> hexList = new ArrayList<String>();
		if(filename == null){
			System.out.println("No file path specified!");
			return null;
		}
		File AddFile = new File(filename);
		if(!AddFile.exists())
		{
			System.out.println("File " + filename + " not found!");
			return null;
		}
		try		
		{
			FileInputStream file = new FileInputStream(new File(filename));
			InputStreamReader InputReader = new InputStreamReader(file);
			br = new BufferedReader(InputReader);
			while((line = br.readLine()) != null) 
			{
				hexList.add(line);
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
		return hexList;
	}
	
	private static void printDecimalNumbers(ArrayList<String> hexList){
		for(int i =0; i<hexList.size(); i++){
			int size = hexList.get(i).length();
			int decimalNum = 0;
			char[] hex = hexList.get(i).toCharArray();
			for(int j=0; j<size; j++){
				if(hex[j] < ':'){
					//System.out.println("test: " + decimalNum + " " + hex[j] + " " + (hex[j] - 48) + " " + (size-j-1));
					decimalNum += (hex[j] - 48)*Math.pow(16,size-j-1);
				}
				else{
					//System.out.println("test: " + decimalNum + " " + hex[j] + " " + (hex[j] - 87) + " " + (size-j-1));
					decimalNum += (hex[j] - 87)*Math.pow(16,size-j-1);
				}
			}
			System.out.println("" + decimalNum);
		}
	}
}
