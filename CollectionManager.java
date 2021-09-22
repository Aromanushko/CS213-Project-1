package albummanager;
import java.util.Scanner;
public class CollectionManager {

	// execute command; return status after command is issued
	private String execCommand(String command)
	{
		String retMes = "";
		switch(command)
		{
			case "A" :
			
			break;
			case "D" :

			break;
			case "L" :

			break;
			case "R" :

			break;
			case "P" :

			break;
			case "PD" :

			break;
			case "PG" :

			
			break;
			case "Q" :
			retMes = "Collection Manager Terminated";
			break;
			default :
			retMes = "Invalid command!";
			break;
		}
		return retMes;	
	}
	// resolve command from user input
	private String parseCommand(String rawInput) {
		return rawInput.split(",")[0];
	}

	public void run()
	{
		String command = "";
		// define scanner
		Scanner in = new Scanner(System.in);
		// start notifcation
		System.out.println("Collection Manager starts running.");
		// run loop until quit command (Q) is issued by user
		while(!(command.equals("Q")))
		{
			command = parseCommand(in.nextLine());
			System.out.println(execCommand(command)); 
		}
		in.close();
		//System.out.println("Collection Manager Terminated");
	}
}
