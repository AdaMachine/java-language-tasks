public class exr1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t,d;
		t=MyConsole.readInt("please enter time ");
		d=MyConsole.readInt("please enter your distence ");
		System.out.println("the speed as in one ml per hour :" + (d/t)/1.6);
		System.out.println("the speed as in one km per hour :" + d/t);		
	}

}
