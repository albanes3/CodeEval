
public class MultiplicationTables {
	public static void main(String[] args){
		for(int i = 1; i<13; i++){
			if(i<10)
				System.out.print(" ");
			System.out.print(i);
			
			int j = 2;
			for(; j<13; j++){
				if(i*j<10)
					System.out.print("   " + i*j);
				else if(i*j<100)
					System.out.print("  " + i*j);
				else
					System.out.print(" " + i*j);
			}
			System.out.println("");
		}
	}
}
