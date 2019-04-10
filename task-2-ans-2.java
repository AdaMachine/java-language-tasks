package task_num2;

public class multnts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y,rslt=0;
		x=MyConsole.readInt("please enter a num");
		y=MyConsole.readInt("please enter a num");
		if(y>0) {
			for (int i=0;i<y;i++) {
				rslt=rslt+x;
			}
		}else {
			for (int i=0;i<x;i++) {
				rslt=rslt+y;	
			}
		}
		if (x<0&&y<0) {
			x=Math.abs(x);
			y=Math.abs(y);
			for (int i=0;i<y;i++) {
				rslt=rslt+x;
			}
		}
		System.out.println(rslt);
	}
}