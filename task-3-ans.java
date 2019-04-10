public class GameOfLife {

		public static void main(String[] args) {
			System.out.println("welcome to the game of life !");//the welcome statement
			int s=MyConsole.readInt("please enter the size of the matrix");//entering the  size of the matrix 
			while(s<1||s>99) {//התנאים לקיום המטריצה(בין0-100
				System.out.println("invalid input");
				s=MyConsole.readInt("please enter the size of the matrix");
			}
			boolean [][]matt =new boolean[s][s];//squar size boolean because of the ss 
			int g=MyConsole.readInt("please enter the maximun number of generetion");//entering the squar size of the matrix witch u can see in the integer plabe in the boolean
			while(g<1||g>99) {//התנאים לקיום הדורות(בין0-100
				System.out.println("invalid input");
				g=MyConsole.readInt("please enter the maximun number of generetion");
			}
			int k=firstgen(matt); //k=מספר היצורים הראשונים
			printBoard(matt);  //i want the matrix to print right after show of the first function where i intereduse the combination of x and y 
			int pltdtl[]=new int[2];//pltdtl=שווה למערך שהפונקציה של הדורות הבאים פולטת כאשר בתא ראשון [0]שווה לנולדים והאחרון[1]שווה המתים
			for (int i = 1; i < g; i++) {//הלולאה שתיהיה אחראית למעברים בין דורו דור אם הפונקציות  
				int count=0;//הגדרתי משתנה להיות אחראי על ספירת היצורים סך הכך בכל דור 
				pltdtl=nextGen(matt);//המשתנה שקולט את המערך שמחזירה הפונקציה הרביעית 
				System.out.println();//i want to under take a row 
				System.out.println("generetion number"+(i+1));//הכותרת  בכל מטריצה
				printBoard(matt);//הדפסת המטריצה 
				nextGen(matt);//קליטת הנתונים של הפונקציה 4 במטריצה הנוכחית
				for (int j = 0; j < matt.length; j++) {//לולאה שתרוץ על כל האפשרויות של המטריצה של המשתמש בשביל שתעזור לנו להדפיס כמה דך הכל יצורים חיים נמצאים כל פעם בכל דור 
					for (int z = 0; z <matt.length; z++) {
						if(matt[j][z]==true) {
							count++;//כל פעם אם המיקום כבר הוגדר כנכון בלולאה הראשית אשר מכירלה את הפונקציה אשר דואגת לביצוע הדורות המשתנה יעלה באחד
						}
					}
				}
				System.out.println();//underlining for better out put
				System.out.println("the number of creatures in this generetion "+count);//מימוש התת לולאה שנעזרנו בא בכדי להדפיס את כמות היצורים החיים	
				System.out.println("The number of creatures born when moving to this generation is:"+pltdtl[0]);//הדפסת כמות הנולדים אשר נמצאים בתא הראשון [0]במערך אשר פולטת הפונקציה4 ה
				System.out.println("The number of creatures died when moving to this generation is:"+pltdtl[1]);//דפסת כמות המתים אשר נמצאים בתא השני [1]במערך אשר פולטת הפונקציה4
				if (i==g) {//התנאי הראשון לסוף המשחק אם עברו מספרהדורות אשר המשתמש הגדיר 
					System.out.println("number of generetion have passed"+"\n"+"end game");
					break;//סיום הלולאה כאשר התנאי מתקיים
				}
				if(pltdtl[1]==0 && pltdtl[0] == 0) {//  תנאי לסוף המשחק אם המצב סטטי כלומר אם מס המתים שווה 0 כמו מס נולדים
					System.out.println("the game is in static mode"+"\n"+"end game");
					break;//סיום הלולאה כאשר התנאי מתקיים
				}
				if((k+pltdtl[0])==0) {// תנאי לסוף המשחק אם אם אין יותר נולדים או יצורים חיים
					System.out.println("everybody is dead"+"\n"+"end game");
					break; //סיום הלולאה כאשר התנאי מתקיים
				}
			}
		}

		public static int firstgen(boolean [][]matt) {
			int k=MyConsole.readInt("please enter the number of the living creatures ");//מספר היצורים של  המשתמש
			for (int i = 0; i <= k-1; i++) {//לולאה שתרוץ על כל התנאים לקיום היצור 
				System.out.println("please entter the combination of creature number :"+(i+1));//הכותרת מספר היצור
				int x=MyConsole.readInt("Enter X value:");//מיקום שורה
				int y=MyConsole.readInt("Enter y value:");//מיקום עמודה
				boolean flag=true;//המשתנה אשר יעזור לנו לקיים את התנאי אי יצירת יצור באותו מיקום  flage = true 
				if (y>matt.length||y<1) {//התנאים(שהמספר יהיה בין 0-גודל צלע המטריצה )בY
					System.out.println("invalid input");
					i--;//הלולאה חוזרת אחורה 
					flag=false;//כאשר הלולאה חוזרת אחורה נגדיר flag = false
				}
				if (flag==true) {
					if (x>matt.length||x<1) {//התנאים(שהמספר יהיה בין 0-גודל צלע המטריצה )בX
						System.out.println("invalid input");
						i--;//הלולאה חוזרת אחורה
						flag=false;//כאשר הלולאה חוזרת אחורה נגדיר flag = false
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
			return k;//במידה וכלל התנאים קיימים תחזיר לי את מספר השכנים
		}
		public static int numOfNeighbors(boolean[][] matt, int x, int y) {
			int counter=0;//מה שיספור לנו את השכנים
			if((x>=0)&&(y>=0)&&(x<matt.length)&&(y<matt.length)) {//התנאים לכך שהתנאים הבאים לא יתייחסו לכל המעבר מהמטריצה 

				if (x-1>=0) {// הכוונה לשלושת התאים הנמצאים בצד שמאל  
					if (y-1>=0) { //   הכוונה לשלושת התאים הנמצאים בצד למטה  
						if(matt[x-1][y-1]) 
							counter++;//התא שנמצא בתנאי שורה למעלה קונגררואנטי לחיובי והמשתנהשסופר את מספר השכנים עולה פעם אחת
					}
					if (matt[x-1][y]) 
						counter++;//התא שנמצא בתנאי שורה למעלה קונגררואנטי לחיובי והמשתנהשסופר את מספר השכנים עולה פעם אחת
					if (y+1 < matt.length) {//  הכוונה לשלושת התאים הנמצאים בצד למעלה  
						if (matt[x-1][y+1]) 
							counter++;//התא שנמצא בתנאי שורה למעלה קונגררואנטי לחיובי והמשתנהשסופר את מספר השכנים עולה פעם אחת
					}
				}
				if (x+1 < matt.length) {// הכוונה לשלושת התאים הנמצאים בצד  
					if (y-1>=0) { // הכוונה לשלושת התאים הנמצאים בצד  
						if(matt[x+1][y-1])  
							counter++;//התא שנמצא בתנאי שורה למעלה קונגררואנטי לחיובי והמשתנהשסופר את מספר השכנים עולה פעם אחת
					}
					if (matt[x+1][y]) 
						counter++;//התא שנמצא בתנאי שורה למעלה קונגררואנטי לחיובי והמשתנהשסופר את מספר השכנים עולה פעם אחת
					if (y+1 < matt.length) {// הכוונה לשלושת התאים הנמצאים בצד  
						if (matt[x+1][y+1]) 
							counter++;//התא שנמצא בתנאי שורה למעלה קונגררואנטי לחיובי והמשתנהשסופר את מספר השכנים עולה פעם אחת
					}
				}
				if (y-1>=0) { // הכוונה לשלושת התאים הנמצאים בצד  
					if(matt[x][y-1])  
						counter++;//התא שנמצא בתנאי שורה למעלה קונגררואנטי לחיובי והמשתנהשסופר את מספר השכנים עולה פעם אחת
				}
				if (y+1 < matt.length) {// הכוונה לשלושת התאים הנמצאים בצד  
					if (matt[x][y+1]) 
						counter++;//התא שנמצא בתנאי שורה למעלה קונגררואנטי לחיובי והמשתנהשסופר את מספר השכנים עולה פעם אחת
				}
			}			
			return counter;// 55555כאן אני מבקש ממנו את כמות השכנים שהוא אסף
		}
		public static void printBoard(boolean[][] matt) {

			for (int i = 0; i <= matt.length-1; i++) 
			{
				if(i!=matt.length-1) { 
					if (i<=9)
						System.out.print("  "+(i+1));// 000מדפיסה את השורה הראשונה והעליונה של הלוח
					else
						System.out.print(" "+(i+1));
				}else {System.out.print(" "+(i+1));
				}
			}
			System.out.println("  ");//000לרדת שורה ורווח              
			System.out.print("  ");//רווח
			for (int i = 0; i < matt.length-1; i++) {//לולאת שמטרתה לעשות את הגג
				System.out.print("---");//  הגג
			}
			System.out.print("---");
			System.out.println();
			for (int i = 0; i <= matt.length-1; i++) 
			{
				if (i<9)
					System.out.print((i+1)+" |");// הקיר השמאלי אם מרווח בין המספרים לערכים
				else
					System.out.print((i+1)+"|");
				for (int j = 0; j < matt.length; j++) 
				{
					if (matt[0].length-1==j) {//+אם במטריצה אני נמצא בעמודה האחרונהתדפיס את הערכים בלי רווח והשאר אם
						if(matt[i][j]) 
							System.out.print("* ");                 
						else 
							System.out.print("  ");              					
					}
					else {//-השאר
						if(matt[i][j]) //if im in the middle of the matrix then print the dot 
							System.out.print(" * ");                   
						else 
							System.out.print("   ");			
					}
				}
				System.out.println("|");//בסוף כל שורה שהפור עובר הפוציה מדפיסה " |" ויורדת שורה
			}
			System.out.print("  ");//רווח
			for (int i = 0; i < matt.length; i++) //לולאה שיוצרת את הסגירה של המסגרת מלמטה
			{
				System.out.print("---");// 
			}
		}
		public static int[] nextGen(boolean[][] matt ) {
			int dtl[]=new int [2];//creating a new array
			int born=0;//an integer
			int dead=0;
			boolean[][]nxgn=new boolean [matt.length][matt.length];//יצירת מטריצת בדיקה

			for (int i = 0; i < nxgn.length-1; i++) {//לולאה להעתקה של המטריצה
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
			return dtl;//מחזיר את המערך שמכיל את הנתונים של הדור החדש
		}
	}
