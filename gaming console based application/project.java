import java.util.Scanner;
import java.util.Random;
class ColorConsole {
    static String Black = "\u001b[30m";
    static String Red = "\u001b[31m";
    static String Green = "\u001b[32m";
    static String Yellow = "\u001b[33m";
    static String Blue = "\u001b[34m";
    static String Magenta = "\u001b[35m";
    static String Cyan = "\u001b[36m";
    static String White = "\u001b[37m";
    static String BrightBlack = "\u001b[30;1m";
    static String BrightRed = "\u001b[31;1m";
    static String BrightGreen = "\u001b[32;1m";
    static String BrightYellow = "\u001b[33;1m";
    static String BrightBlue = "\u001b[34;1m";
    static String BrightMagenta = "\u001b[35;1m";
    static String BrightCyan = "\u001b[36;1m";
    static String BrightWhite = "\u001b[37;1m";
    static String Reset = "\u001b[0m";}
class TicTacToe extends ColorConsole{
	static Scanner sc=new Scanner(System.in);
	public static void printBoard(char[][] board){
		for(int i=0;i<3;i++){
			System.out.println(BrightCyan+".---.---.---."+Reset);
			for(int j=0;j<3;j++){
				if(j==0){
					System.out.print(BrightCyan+"| "+Reset);
				}
				System.out.print(board[i][j]+BrightCyan+" | "+Reset);
			}
			System.out.println();
		}
		System.out.println(BrightCyan+".---.---.---."+Reset);
	}
	public static boolean haveWon(char[][] board,char player){
		for(int i=0;i<3;i++){
			if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
				return true;
			}
		}
		for(int i=0;i<3;i++){
			if(board[0][i]==player && board[1][i]==player && board[2][i]==player){
				return true;
			}
		}
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
			return true;
		}
		if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
			return true;
		}
		return false;
	}
	public static int r(){
		int row=sc.nextInt();
		if(row>2){
			System.out.println(Red+"Invalid Row Value! Please try again.."+Reset);
			return r();
		}
		return row;
	}
	public static int c(){
		int col=sc.nextInt();
		if(col>2){
			System.out.println(Red+"Invalid Column Value! Please try again.."+Reset);
			return c();
		}
		return col;
	}
	public static void tic_tac_toe(){
		char[][] board=new char[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				board[i][j]=' ';
			}
		}
		char player='X';
		boolean gameOver=false;
		while(!gameOver){
			printBoard(board);
			System.out.println("Player "+player+" enter : ");
			System.out.println("Enter the row value : ");
			int row=r();	
			System.out.println("Enter the column value : ");
			int col=c();
			if(board[row][col]==' '){
				board[row][col]=player;
				gameOver=haveWon(board,player);
				if(gameOver){
					printBoard(board);
						System.out.println(player+" has won!!");
					return;
				}
				else{
					if(player=='X'){
						player='O';
					}
					else{
						player='X';
					}
				}
			}
			else{
				System.out.println(Red+"Invalid move!! Please try again..."+Reset);
			}
		}
		printBoard(board);
	}
}
class RockPaperScissor extends ColorConsole{
	public static void rock_paper_scissor(){
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		boolean b=true;
		String player="";
		while(b){
			String[] rps={"rock","paper","scissors"};
			String computer=rps[r.nextInt(rps.length)];
			while(true){
				System.out.print("Enter your move (rock, paper, scissor) -> ");
				player=sc.next();
				if(player.equals("rock") || player.equals("paper") || player.equals("scissor")){
					break;
				}
				else{
					System.out.println(Red+"Invalid move!!Please try again...\n"+Reset);
				}
			}
			System.out.println("Computer's Move : "+computer);
			if(player.equals(computer)){
				System.out.println("THE GAME IS A TIE!!\n");
			}
			else if(player.equals("rock")){
				if(computer.equals("paper")){
					System.out.println("YOU LOSE!!\n");
				}
				else{
					System.out.println("YOU WIN!!\n");
				}
			}
			else if(player.equals("paper")){
				if(computer.equals("rock")){
					System.out.println("YOU WIN!!\n");
				}
				else{
					System.out.println("YOU LOSE!!\n");
				}
			}
			else{
				if(computer.equals("rock")){
					System.out.println("YOU LOSE!!\n");
				}
				else{
					System.out.println("YOU WIN!!\n");
				}
			}
			System.out.println("Do you want to play again? y/n");
			char c=sc.next().charAt(0);
			if(c=='y'){
				b=true;
			}
			else{
				b=false;
			}
		}
	}
}
class Sudoko extends ColorConsole{
	static Scanner sc=new Scanner(System.in);
	public static boolean isSafe(char[][] board,int row,int col,int n){
		for(int i=0;i<board.length;i++){
			if(board[i][col]==(char)(n+'0') || board[row][i]==(char)(n+'0')){
				return false;
			}
		}
		int gridRow=(row/3)*3;
		int gridCol=(col/3)*3;
		for(int i=gridRow;i<gridRow+3;i++){
			for(int j=gridCol;j<gridCol+3;j++){
				if(board[i][j]==(char)(n+'0')){
					return false;
				}
			}
		}
		return true;
	}
	public static boolean solve(char[][] board,int row,int col){
		if(row==board.length){
			return true;
		}
		int nrow=row;
		int ncol=col+1;
		if(ncol==board.length){
			nrow++;
			ncol=0;
		}
		if(board[row][col]!=' '){
			return solve(board,nrow,ncol);
		}
		for(int i=1;i<=9;i++){
			if(isSafe(board,row,col,i)){						board[row][col]=(char)(i+'0');
				if(solve(board,nrow,ncol)){
					return true;
				}								board[row][col]=' ';
			}
		}
		return false;
	}
	public static void display(char[][] board){
		int c=0;
		int d=0;
		System.out.println(BrightCyan+"X-----------X-----------X-----------X"+Reset);
		for(int i=0;i<9;i++){
			c=0;
			d++;
			for(int j=0;j<9;j++){
				if(c==0){
					System.out.print(BrightCyan+"| "+Reset);
				}
				System.out.print(board[i][j]+" ");
				c++;
				System.out.print(BrightCyan+"| "+Reset);
			}
			if(d%3==0){
				System.out.println(BrightCyan+"\nX-----------X-----------X-----------X"+Reset);	
			}
			else{
				System.out.println(BrightCyan+"\n*-----------*-----------*-----------*"+Reset);
			}
		}
	}
	public static void sudoko(){
		char[][] board={
				{'7',' ','2',' ','5',' ','6',' ',' '},
				{' ',' ',' ',' ',' ','3',' ',' ',' '},
				{'1',' ',' ',' ',' ','9','5',' ',' '},
				{'8',' ',' ',' ',' ',' ',' ','9',' '},
				{' ','4','3',' ',' ',' ','7','5',' '},
				{' ','9',' ',' ',' ',' ',' ',' ','8'},
				{' ',' ','9','7',' ',' ',' ',' ','5'},
				{' ',' ',' ','2',' ',' ',' ',' ',' '},
				{' ',' ','7',' ','4',' ','2',' ','3'},
		};
		System.out.println("Initial Sudoko : \n");
		display(board);
		if(solve(board,0,0)){
			System.out.println("Solved Sudoko : \n");
			display(board);
		}
		else{
			System.out.println("No solution exists!!");
		}
	}
}
class NumberGuessing extends ColorConsole{
	static Scanner sc=new Scanner(System.in);
	public static void game(int computer){
		int c=0;
		System.out.println("Your number should range between 1 and 100");
		int x=sc.nextInt();
		if(x<1 || x>100){
			System.out.println(Red+"Invalid input!!Please try again..."+Reset);
			game(computer);
		}
		int min=1;
		int max=100;
		while(c<5){
			if(x==computer){
				System.out.println("The correct number is : "+computer+"\n You have guessed the number!\nYOU WON!!");
				return;
			}
			if(x<computer){
				min=x;
				System.out.println("Your number should be greater than "+min+" and less than "+max);
			}
			else{
				max=x;
				System.out.println("Your number should be greater than "+min+" and less than "+max);
			}
			c++;
			if(c<5){
				x=sc.nextInt();
			}
			else{
				System.out.println("You have no more chances left!!\nThe correct number is : "+computer+"\nYOU LOST!!");
			}
		}
	}
	public static void numberGuessing(){
		Random r=new Random();
		int min=1;
		int max=100;
		int computer=r.nextInt(max-min+1)+min;
		game(computer);
	}
}
class A extends ColorConsole{
	static 	Scanner sc=new Scanner(System.in);
	public static void display(){
		System.out.println(BrightYellow+"Choose a number to play a game you want : \n1. tic-tac-toe\n2. rock-paper-scissor\n3. sudoko\n4. Number Guessing Game"+Reset);
	}
	public static void m1(){
		System.out.println("Do you want to continue playing : (yes/no)");
		String c=sc.next();
		if(c.equals("yes")){
			m2();
		}
		else if(c.equals("no")){
			System.out.println(Green+"Visit again! Have some fun!!"+Reset);
		}
		else{
			System.out.println(Red+"Invalid Input! Please try again.."+Reset);
			m1();
		}
	}
	public static void m2(){
		display();
		switch(sc.nextInt()){
			case 1:
				System.out.println("Ready to play tic-tac-toe?!!");
				TicTacToe.tic_tac_toe();
				m1();
				break;
			case 2:
				System.out.println("Ready to play rock-paper-scissor?!!");
				RockPaperScissor.rock_paper_scissor();
				m1();
				break;
			case 3:
				System.out.println("Ready to play sudoko?!!");
				Sudoko.sudoko();
				m1();
				break;
			case 4:
				System.out.println("Ready to play Number-Guessing game?!!");
				NumberGuessing.numberGuessing();
				m1();
				break;
			default:
				System.out.println(Red+"Invalid Inputs! Please try again..."+Reset);
				m2();
		}
	}
	public static void main(String[]args){
		m2();
	}
}