
public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =MyConsole.readInt("enter a three charectarized numbers" );
			int x=n%10;
			int y=((n%100)-x)/10;
			int z=(n-(n%100))/100;
		
		int f=x*x+z*z+y*y;	
		System.out.println("the sum of the charactaraized squar ="+f);
		}
	}


