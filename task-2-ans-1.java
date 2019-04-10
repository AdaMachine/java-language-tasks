package task_num2;

public class star_draw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=MyConsole.readInt("please enter a number -even for a crown odd for a diamond");
		if (n<=2)
			System.out.println("please enter a bigger number");
		if (0==n%2) {
			for (int i=0;i<=n;i++) {
				for (int s=0;s<=2*n-1;s++) {
					if(s<i||s>2*n-i-1)
						System.out.print("*");
					else
						System.out.print(" ");


				}

				System.out.println("");
			}	
		}
		else {
			for (int q=0;q<n;q++) {
				for (int r=0;r<n;r++) {
					if(q<n/2) 
						if((r>=n/2-q)&&(r<=n/2+q)){ 
							System.out.print("*");
						}else { System.out.print(" ");}
					else if((q==n/2)) {
						if(r==n/2)
							System.out.print("$");
						else System.out.print("*");
					}
					else
						if (q>n/2) {
							if(r>=n/2-(n-1-q)&&(r<=n/2+(n-q-1)))
						System.out.print("*");
						else System.out.print(" "); 
						}
				}
			System.out.println("");
			}
		}

	}

}

