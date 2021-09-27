package albummanager;

import java.util.Scanner;
/** 
 * @author Robert Reid, Anthony Romanushko
 * CollectionManager class user interface
 */
public class CollectionManager {
	private Collection collection = new Collection();
	
	/**
	 * Function to add album to collection and return results
	 * @param arr array with arguments for command to run with
	 * @return retMes with outcome of function
	 */
	private String addAlbum(String[] arr)
	{
		String retMes;
		int numParameter = arr.length;
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
		return retMes;
	}
	/**
	 * Function to remove album from collection and return results
	 * @param arr array with arguments for command to run with
	 * @return retMes with outcome of function
	 */
	private String deleteAlbum(String[] arr)
	{
		String retMes;
		int numParameter = arr.length;
		//Check number of parameters 
		if(numParameter == 2) {
			// try to remove album of name (arr[1]) and artist (arr[2])
			if(collection.remove(new Album(arr[1],arr[2])))
			{
				retMes = arr[1] + "::" + arr[2] + " >> deleted.";
			}
			else
			{
				retMes = arr[1] + "::" + arr[2] + " >> is not in the collection.";
			}
		}
		else
		{
			//Command has wrong number of parameters
			retMes = "Invalid Command.";
		}
		return retMes;
	}
	/**
	 * Function to lend album from collection and return results
	 * @param arr array with arguments for command to run with
	 * @return retMes with outcome of function
	 */
	private String lendAlbum(String[] arr)
	{
		String retMes;
		int numParameter = arr.length;
		//Check number of parameters 
		if(numParameter == 2) {
			// try to lend out album of name (arr[1]) and artist (arr[2])
			if(collection.lendingOut(new Album(arr[1],arr[2])))
			{
				retMes = arr[1] + "::" + arr[2] + " >> lending out and set to not available.";
			}
			else
			{
				retMes = arr[1] + "::" + arr[2] + " >> is not available.";
			}
		}
		else
		{
			//Command has wrong number of parameters
			retMes = "Invalid Command.";
		}
		return retMes;
	}
	/**
	 * Function to return album to collection and return results
	 * @param arr array with arguments for command to run with
	 * @return retMes with outcome of function
	 */
	private String returnAlbum(String[] arr)
	{
		String retMes;
		int numParameter = arr.length;
		//Check number of parameters 
		if(numParameter == 2) {
			// try to return album of name (arr[1]) and artist (arr[2])
			if(collection.returnAlbum(new Album(arr[1],arr[2])))
			{
				retMes = arr[1] + "::" + arr[2] + " >> returning and set to available.";
			}
			else
			{
				retMes = arr[1] + "::" + arr[2] + " >> return cannot be completed.";
			}
		}
		else
		{
			//Command has wrong number of parameters
			retMes = "Invalid Command.";
		}
		return retMes;
	}
	/**
	 * method that resolves user commands and then executes them if valid, returns operation status of command afterwards
	 * @param rawInput from the parseCommand method
	 * @return returned message to the user
	 */
	private String execCommand(String rawInput)
	{
		String command = parseCommand(rawInput);
		String retMes = "";
		int numParameter = rawInput.split(",").length;
		// array of split of command and arguments, variable length dependent on which command user issued
		// arr[0] = command; arr[1] = title; arr[2] = artist; arr[3] = genre; arr[4] = date;
		String[] arr = rawInput.split(",");
		switch(command)
		{
			case "A" :
				retMes = addAlbum(arr);
			break;
			case "D" :
				retMes = deleteAlbum(arr);
			break;
			case "L" :
				retMes = lendAlbum(arr);
			break;
			case "R" :
				retMes = returnAlbum(arr);
			break;
			case "P" :
				if(numParameter == 1){ collection.print(); }
			break;
			case "PD" :
				if(numParameter == 1) { collection.printByReleaseDate(); }
			break;
			case "PG" :
				if(numParameter == 1) { collection.printByGenre(); }
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
	
	/**
	 * 
	 * @param g the genre as string
	 * @return the enumerated value of genre 
	 */
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
	
	/**
	 * 
	 * @param rawInput, the command line input
	 * @return string command 
	 */
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
	/**
	 * function with loop to read in user commands to execute, terminates program when user issues Q command
	 */
	public void run() {
			String command = "";
			// define scanner
			Scanner in = new Scanner(System.in);
			// start notifcation
			System.out.println("Collection Manager starts running.");
			// run loop until quit command (Q) is issued by user
			while(!(command.equals("Q")))
			{
				command = in.nextLine();
				System.out.println(execCommand(command));
			}
			in.close();
	}
	
	
}