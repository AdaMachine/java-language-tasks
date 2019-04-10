package task_num2;

public class arithmatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] sidra= new int [15];
		boolean p=true;

		for (int i=0; i<sidra.length; i++) {
			sidra[i] = MyConsole.readInt("please enter a number ");
		}
		for (int i=0;i<sidra.length-2;i++) {
			if (sidra[i+1]==((sidra[i+2])+(sidra[i]))/2) {
				p=true;
			}else{
				p=false;
			
			break;
			}
		}
		if(p==true){	
			System.out.println("its arithmatic ");
		}else {System.out.println("its not arithmatic ");
	}
}
}