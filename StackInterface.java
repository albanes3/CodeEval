import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class StackInterface {
	public static void main(String[] args){
		//readFromFile(args[0]);
		String[] tokens = {"0","1","2","3","4","5","6","7"};
		stackOps(tokens);
	}

	private static void readFromFile(String filename) {
		BufferedReader br = null;
		File input = new File(filename);
		if(!input.exists()){
			System.out.println("File does not exist!");
			return;
		}
		try{
			FileInputStream file = new FileInputStream(input);
			InputStreamReader ir = new InputStreamReader(file);
			br = new BufferedReader(ir);
			String line = "";
			while((line = br.readLine()) != null){
				String[] tokens = line.split("\\s+");
				stackOps(tokens);
			}
		}
		catch(IOException e){
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

	private static void stackOps(String [] tokens) {
		int length = tokens.length;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for(int i = 0; i<length; i++){
			stack.push(Integer.parseInt(tokens[i]));	
		}
		if(!stack.isEmpty())
			System.out.print("" + stack.pop());
		else
			return;
		if(!stack.isEmpty())
			stack.pop();
		else
			return;
		while(!stack.isEmpty()){
			System.out.print(" " + stack.pop());
			if(!stack.isEmpty())
				stack.pop();
		}
		System.out.println();
	}
}
