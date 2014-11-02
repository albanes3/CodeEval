import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.math.BigInteger;


public class NthFibonacci {

	private static HashMap<Integer,BigInteger> hmap;

	public static void main(String[] args){
		ArrayList<Integer> fibList = new ArrayList<Integer>();;
		try {
			fibList = readFromFile(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(fibList == null)
			return;
		hmap = new HashMap<Integer,BigInteger>(Collections.max(fibList),2);
		int length = fibList.size();
		for(int i =0; i<length; i++){
			System.out.println("" + fib(fibList.get(i)));
		}
	}

	private static BigInteger fib(int n) {
		if(n <= 0)
			return BigInteger.ZERO;
		if(n == 1)
			return BigInteger.ONE;
		if(hmap.containsKey(n))
			return hmap.get(n);
		hmap.put(n,fib(n-1).add(fib(n-2)));	
		return hmap.get(n);
	}

	private static ArrayList<Integer> readFromFile(String filename) throws IOException{
		BufferedReader br = null;
		String line;
		ArrayList<Integer> fibList = new ArrayList<Integer>();
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
			while((line = br.readLine()) != null){
				fibList.add(Integer.parseInt(line));
			}
		}
		finally{
			br.close();
		}
		return fibList;
	}
}
