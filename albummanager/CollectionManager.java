package albummanager;

import java.util.Scanner;

public class CollectionManager {
	private Collection collection = new Collection();
	/**
	 * 
	 * @param command from the parseCommand method
	 * @return returned message to the user
	 */
	private String execCommand(String rawInput)
	{
		String command = parseCommand(rawInput);
		String retMes = "";
		int numParameter = rawInput.split(",").length;
		String[] arr = rawInput.split(",");
		switch(command)
		{
			case "A" :
				//Check number of parameters 
				if(numParameter == 5) {
					//check if the date is valid
					 if(new Date(arr[4]).isValid()) {
						 //Check validity of Genre
						 String genre = validateGenre(arr[3]);
						 Album a = new Album(arr[1], arr[2], Genre.valueOf(genre), new Date(arr[4]));
						 if(collection.add(a)) {
							retMes =  a.toString() + " >> added.";
						 }else {
							 retMes = a.toString() + " >> is already in the collection.";
						 } 
					 }else {
						 //Date is invalid
						 retMes = "Invalid Date.";
					 }
				}else {
					//Command has wrong number of parameters
					retMes = "Invalid Command.";
				}
				
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
	
	private String validateGenre(String g) {
		boolean isUnknown = true;
		 for(Genre x : Genre.values()) {
			 if(Genre.valueOf(g).equals(x)) {
				 isUnknown = false;
			 }
		 }
		 //If genre doesnt match any enums set it unknown 
		 if(isUnknown) {g = "Unknown";}
		 return g;
	}
	
	private String parseCommand(String rawInput) {
		if(rawInput.contains(","))
        {
			return rawInput.split(",")[0];
        }
        else
        {
            return rawInput;
        }
	}
	
	public void run() {
		boolean running = true;
		
		while(running) {
			String command = "";
			// define scanner
			Scanner in = new Scanner(System.in);
			// start notifcation
			System.out.println("Collection Manager starts running.");
			// run loop until quit command (Q) is issued by user
			while(!(command.equals("Q")))
			{
				//command = parseCommand(in.nextLine());
				System.out.println(execCommand(command)); 
			}
			in.close();
			//System.out.println("Collection Manager Terminated");
		}
	}
	
	
}
