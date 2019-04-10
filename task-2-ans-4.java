package task_num2;

public class InversePerm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=MyConsole.readInt("please enter the lenth of the arry");
		int [] g_one=new int [i];
		for (int a=0;a<g_one.length;a++) {
			g_one[a]= MyConsole.readInt("please enter your num in the arry from 1");
		}
		int g_two[]=new int[i];
		
		for (int j = 0; j < g_two.length; j++) {
			g_two[j]=g_one[g_one[j]-1];
		}
		for (int j = 0; j < g_two.length; j++) {
			System.out.print(g_one[j]+", ");
			System.out.println(g_two[j]);
		}
	}
}
