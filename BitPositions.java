import java.io.*;


public class BitPositions {
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
				if(tokens.length == 3){
					int bit1 = Integer.parseInt(tokens[0]) & (int)Math.pow(2, Integer.parseInt(tokens[1])-1);
					int bit2 = Integer.parseInt(tokens[0]) & (int)Math.pow(2, Integer.parseInt(tokens[2])-1);
					if( (bit1>0 && bit2>0) || (bit1 == bit2))
						System.out.println("true");
					else
						System.out.println("false");
					//System.out.println("" + bit1 + " " + bit2);
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
