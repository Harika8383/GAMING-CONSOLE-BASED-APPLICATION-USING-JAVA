import java.util.Scanner;
import java.util.Random;
class A{
	static Scanner sc=new Scanner(System.in);
	public static void game(int computer){
		int c=0;
		System.out.println("Your number should range between 1 and 100");
		int x=sc.nextInt();
		if(x<1 || x>100){
			System.out.println("Invalid input!!Please try again...");
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
	public static void main(String[]args){
		Random r=new Random();
		int min=1;
		int max=100;
		int computer=r.nextInt(max-min+1)+min;
		game(computer);
	}
}