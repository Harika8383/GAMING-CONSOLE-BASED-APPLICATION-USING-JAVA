import java.util.Scanner;
import java.util.Random;
class A{
	public static void main(String[]args){
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
					System.out.println("Invalid move!!Please try again...\n");
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