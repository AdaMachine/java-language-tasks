package task_num2;

public class sum_num  {

	public static void main(String[] args) {

		double x=MyConsole.readDouble("enter a num between 0-1");
		while (x>1||x<0) {
			System.out.println("please try again");
			x=MyConsole.readDouble("enter a num between 1-0");
		}
		int sum=0;
		int i=1;
		while(x*i<1){
			sum=sum+i;
			i++;
		}
		System.out.println("sum= "+sum);
		
		
	}

}
