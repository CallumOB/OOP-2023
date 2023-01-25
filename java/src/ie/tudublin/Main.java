package ie.tudublin;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Hello world");

		Cat myCat = new Cat("Cat");
		for (int i = 0; i < 10; i++) {
			myCat.kill();
		}	
	}
	
}