import java.util.Scanner;
class A{
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
		System.out.println("X-----------X-----------X-----------X");
		for(int i=0;i<9;i++){
			c=0;
			d++;
			for(int j=0;j<9;j++){
				if(c==0){
					System.out.print("| ");
				}
				System.out.print(board[i][j]+" ");
				c++;
				System.out.print("| ");
			}
			if(d%3==0){
				System.out.println("\nX-----------X-----------X-----------X");	
			}
			else{
				System.out.println("\n*-----------*-----------*-----------*");
			}
		}
	}
	public static void main(String[]args){
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