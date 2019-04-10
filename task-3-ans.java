public class GameOfLife {

		public static void main(String[] args) {
			System.out.println("welcome to the game of life !");//the welcome statement
			int s=MyConsole.readInt("please enter the size of the matrix");//entering the  size of the matrix 
			while(s<1||s>99) {//������ ����� �������(���0-100
				System.out.println("invalid input");
				s=MyConsole.readInt("please enter the size of the matrix");
			}
			boolean [][]matt =new boolean[s][s];//squar size boolean because of the ss 
			int g=MyConsole.readInt("please enter the maximun number of generetion");//entering the squar size of the matrix witch u can see in the integer plabe in the boolean
			while(g<1||g>99) {//������ ����� ������(���0-100
				System.out.println("invalid input");
				g=MyConsole.readInt("please enter the maximun number of generetion");
			}
			int k=firstgen(matt); //k=���� ������� ��������
			printBoard(matt);  //i want the matrix to print right after show of the first function where i intereduse the combination of x and y 
			int pltdtl[]=new int[2];//pltdtl=���� ����� ��������� �� ������ ����� ����� ���� ��� ����� [0]���� ������� �������[1]���� �����
			for (int i = 1; i < g; i++) {//������ ������ ������ ������� ��� ���� ��� �� ���������  
				int count=0;//������ ����� ����� ����� �� ����� ������� �� ��� ��� ��� 
				pltdtl=nextGen(matt);//������ ����� �� ����� ������� �������� ������� 
				System.out.println();//i want to under take a row 
				System.out.println("generetion number"+(i+1));//������  ��� ������
				printBoard(matt);//����� ������� 
				nextGen(matt);//����� ������� �� �������� 4 ������� �������
				for (int j = 0; j < matt.length; j++) {//����� ����� �� �� ��������� �� ������� �� ������ ����� ������ ��� ������ ��� �� ��� ������ ���� ������ �� ��� ��� ��� 
					for (int z = 0; z <matt.length; z++) {
						if(matt[j][z]==true) {
							count++;//�� ��� �� ������ ��� ����� ����� ������ ������ ��� ������ �� �������� ��� ����� ������ ������ ������ ���� ����
						}
					}
				}
				System.out.println();//underlining for better out put
				System.out.println("the number of creatures in this generetion "+count);//����� ��� ����� ������� �� ���� ������ �� ���� ������� �����	
				System.out.println("The number of creatures born when moving to this generation is:"+pltdtl[0]);//����� ���� ������� ��� ������ ��� ������ [0]����� ��� ����� ��������4 �
				System.out.println("The number of creatures died when moving to this generation is:"+pltdtl[1]);//���� ���� ����� ��� ������ ��� ���� [1]����� ��� ����� ��������4
				if (i==g) {//����� ������ ���� ����� �� ���� ���������� ��� ������ ����� 
					System.out.println("number of generetion have passed"+"\n"+"end game");
					break;//���� ������ ���� ����� ������
				}
				if(pltdtl[1]==0 && pltdtl[0] == 0) {//  ���� ���� ����� �� ���� ���� ����� �� �� ����� ���� 0 ��� �� ������
					System.out.println("the game is in static mode"+"\n"+"end game");
					break;//���� ������ ���� ����� ������
				}
				if((k+pltdtl[0])==0) {// ���� ���� ����� �� �� ��� ���� ������ �� ������ ����
					System.out.println("everybody is dead"+"\n"+"end game");
					break; //���� ������ ���� ����� ������
				}
			}
		}

		public static int firstgen(boolean [][]matt) {
			int k=MyConsole.readInt("please enter the number of the living creatures ");//���� ������� ��  ������
			for (int i = 0; i <= k-1; i++) {//����� ����� �� �� ������ ����� ����� 
				System.out.println("please entter the combination of creature number :"+(i+1));//������ ���� �����
				int x=MyConsole.readInt("Enter X value:");//����� ����
				int y=MyConsole.readInt("Enter y value:");//����� �����
				boolean flag=true;//������ ��� ����� ��� ����� �� ����� �� ����� ���� ����� �����  flage = true 
				if (y>matt.length||y<1) {//������(������ ���� ��� 0-���� ��� ������� )�Y
					System.out.println("invalid input");
					i--;//������ ����� ����� 
					flag=false;//���� ������ ����� ����� ����� flag = false
				}
				if (flag==true) {
					if (x>matt.length||x<1) {//������(������ ���� ��� 0-���� ��� ������� )�X
						System.out.println("invalid input");
						i--;//������ ����� �����
						flag=false;//���� ������ ����� ����� ����� flag = false
					}
				}
				if (flag==true) {
					x--;//if i want to check if the user inputed the same combination of creatuge in the next creature i need to check first if the creature is true and then i want to go to the place in the matrix where the creature is painted witch is is the place where the user input his combination minus one becuse the matrix also counts the zero so im saing if the creature is allready exist there -  
					y--;
					if (matt[y][x]==true) {
						System.out.println("youve allready put this combination");//---i will print youve allready put this combination
						i--;//and i will take the for one step back so that the program wont slid one step foreword 
					}else {matt[y][x]=true;//if it is not allready true in the place of the matrix where the 
					}
				}
			}
			return k;//����� ���� ������ ������ ����� �� �� ���� ������
		}
		public static int numOfNeighbors(boolean[][] matt, int x, int y) {
			int counter=0;//�� ������ ��� �� ������
			if((x>=0)&&(y>=0)&&(x<matt.length)&&(y<matt.length)) {//������ ��� ������� ����� �� ������� ��� ����� �������� 

				if (x-1>=0) {// ������ ������ ����� ������� ��� ����  
					if (y-1>=0) { //   ������ ������ ����� ������� ��� ����  
						if(matt[x-1][y-1]) 
							counter++;//��� ����� ����� ���� ����� ����������� ������ ������������ �� ���� ������ ���� ��� ���
					}
					if (matt[x-1][y]) 
						counter++;//��� ����� ����� ���� ����� ����������� ������ ������������ �� ���� ������ ���� ��� ���
					if (y+1 < matt.length) {//  ������ ������ ����� ������� ��� �����  
						if (matt[x-1][y+1]) 
							counter++;//��� ����� ����� ���� ����� ����������� ������ ������������ �� ���� ������ ���� ��� ���
					}
				}
				if (x+1 < matt.length) {// ������ ������ ����� ������� ���  
					if (y-1>=0) { // ������ ������ ����� ������� ���  
						if(matt[x+1][y-1])  
							counter++;//��� ����� ����� ���� ����� ����������� ������ ������������ �� ���� ������ ���� ��� ���
					}
					if (matt[x+1][y]) 
						counter++;//��� ����� ����� ���� ����� ����������� ������ ������������ �� ���� ������ ���� ��� ���
					if (y+1 < matt.length) {// ������ ������ ����� ������� ���  
						if (matt[x+1][y+1]) 
							counter++;//��� ����� ����� ���� ����� ����������� ������ ������������ �� ���� ������ ���� ��� ���
					}
				}
				if (y-1>=0) { // ������ ������ ����� ������� ���  
					if(matt[x][y-1])  
						counter++;//��� ����� ����� ���� ����� ����������� ������ ������������ �� ���� ������ ���� ��� ���
				}
				if (y+1 < matt.length) {// ������ ������ ����� ������� ���  
					if (matt[x][y+1]) 
						counter++;//��� ����� ����� ���� ����� ����������� ������ ������������ �� ���� ������ ���� ��� ���
				}
			}			
			return counter;// 55555��� ��� ���� ���� �� ���� ������ ���� ���
		}
		public static void printBoard(boolean[][] matt) {

			for (int i = 0; i <= matt.length-1; i++) 
			{
				if(i!=matt.length-1) { 
					if (i<=9)
						System.out.print("  "+(i+1));// 000������ �� ����� ������� �������� �� ����
					else
						System.out.print(" "+(i+1));
				}else {System.out.print(" "+(i+1));
				}
			}
			System.out.println("  ");//000���� ���� �����              
			System.out.print("  ");//����
			for (int i = 0; i < matt.length-1; i++) {//����� ������ ����� �� ���
				System.out.print("---");//  ���
			}
			System.out.print("---");
			System.out.println();
			for (int i = 0; i <= matt.length-1; i++) 
			{
				if (i<9)
					System.out.print((i+1)+" |");// ���� ������ �� ����� ��� ������� ������
				else
					System.out.print((i+1)+"|");
				for (int j = 0; j < matt.length; j++) 
				{
					if (matt[0].length-1==j) {//+�� ������� ��� ���� ������ ������������ �� ������ ��� ���� ����� ��
						if(matt[i][j]) 
							System.out.print("* ");                 
						else 
							System.out.print("  ");              					
					}
					else {//-����
						if(matt[i][j]) //if im in the middle of the matrix then print the dot 
							System.out.print(" * ");                   
						else 
							System.out.print("   ");			
					}
				}
				System.out.println("|");//���� �� ���� ����� ���� ������ ������ " |" ������ ����
			}
			System.out.print("  ");//����
			for (int i = 0; i < matt.length; i++) //����� ������ �� ������ �� ������ �����
			{
				System.out.print("---");// 
			}
		}
		public static int[] nextGen(boolean[][] matt ) {
			int dtl[]=new int [2];//creating a new array
			int born=0;//an integer
			int dead=0;
			boolean[][]nxgn=new boolean [matt.length][matt.length];//����� ������ �����

			for (int i = 0; i < nxgn.length-1; i++) {//����� ������ �� �������
				for (int j = 0; j < nxgn.length-1; j++) {
					if(i==0||j==0||j==matt.length-1||i==matt.length-1){//the side conditaion for the next generetion 
						if (matt[i][j]) dead++;
					}
					else {//if the creatures are not in the sides
						int nghbr=numOfNeighbors(matt, i, j);//if they are not in the side then we can call the nghbr function because there is no threat of theme beeing inthe side of the matrix and we can we can now apply the condition for the existence of the nighbrs of the creaturs 
						if (matt[i][j]) { 
							if (nghbr<2||nghbr>3) dead++;//if they 
							else nxgn[i][j] = true;
						}
						else {
							if(nghbr==3) {
								nxgn[i][j]=true;
								born++;
							}
						}
					}
				}
			}
			for(int i=0;i<matt.length;i++) {//here i am defining the old generetion of the matrix to the be congruent to the next generetion-nxgn
				for (int j=0;j<matt.length;j++) {
					matt[i][j]=nxgn[i][j];
				}
			}
			dtl[0]=born;
			dtl[1]=dead;
			return dtl;//����� �� ����� ����� �� ������� �� ���� ����
		}
	}
