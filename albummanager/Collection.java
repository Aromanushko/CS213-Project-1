package albummanager;

public class Collection {
	private Album[] albums;
	private int numAlbums; //Number of albums currently in collection
	
	/**
	 * searches the collection albums for the target album
	 * @param album to find
	 * @return integer index of album if found, -1 if album is not found
	 */
	private int find(Album album) {
		int index = -1;
		for(int i = 0; i < albums.length; i++) {
			if(album.equals(albums[i])) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * Grows the size of albums by 4 
	 */
	private void grow() {
		Album[] t = new Album[albums.length + 4];
		for(int i = 0; i < albums.length; i ++) {
			t[i] = albums[i];
		}
		albums = t;
	}
	
	/**
	 * Adds an album to the collection if it does not exist already
	 * @param album to add to collection
	 * @return true if album is successfully added, false if album already exists in collection
	 */
	public boolean add(Album album) {
		//This for loop checks if the album already exists in the collection
		for(int i = 0; i < albums.length; i++) {
			if(album.equals(albums[i])) {
				//return false because album already exists
				return false;
			}
		}
		//Loop to check for next available index
		for(int i = 0; i < albums.length; i++) {
			if(albums[i].equals(null)) {
				//when the index is clear add the album
				albums[i] = album;
				//return true to terminate the loop
				return true;
			}
		}
		//Since no index was null we need to grow and repeat the input process
		grow();
		albums[albums.length - 3] = album;
		return true;
	}
	
	/**
	 * Removed an album from the collection if it exists
	 * @param album to remove from collection
	 * @return true if album is successfully removed, false if the album does not exist in collection
	 */
	public boolean remove(Album album) {
		//This for loop checks if the album already exists in the collection
		for(int i = 0; i < albums.length; i++) {
			if(album.equals(albums[i])) {
				//Album exists in collection so we move the indexes down
				for(int r = i; r < albums.length - 1; r++) {
					albums[r] = albums[r+1];
				}
				//return true when operation is complete and album is removed
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * Sets album being lent out to not available if it exists in the collection
	 * @param album to lend out
	 * @return false if album does not exist in collection, true if album is successfully set to not available
	 */
	public boolean lendingOut(Album album) {
		//This for loop checks if the album already exists in the collection
				for(int i = 0; i < albums.length; i++) {
					if(album.equals(albums[i])) {
						//sets availability to false if album is found
						albums[i].setAvailability(false);
						return true;
					}
				}
				return false;
	}
	
	/**
	 * Sets album being returned to available if it exists in the collection
	 * @param album that is being returned
	 * @return false if the album does not exist in the collection, true if album is successfully set to available
	 */
	public boolean returnAlbum(Album album) {
		//This for loop checks if the album already exists in the collection
		for(int i = 0; i < albums.length; i++) {
			if(album.equals(albums[i])) {
				//sets availability to true if album is found
				albums[i].setAvailability(true);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Displays the list of albums in the collection without specifying the order
	 */
	public void print() {
		boolean empty = true;
		for(Album x : albums)
		{
			empty = false;
		}
		if(empty) {
			System.out.println("This Collection is Empty!");
		}else {
			System.out.println("*List of Albums in the Collection.");
			for(Album x : albums)
			{
				System.out.println(x.toString());
			}
			System.out.println("*End of List.");
		}
	}
	
	/**
	 * Displays the list of albums in the collection ordered by release date
	 */
	public void printByReleaseDate() {
		//Going to use selection sort
		boolean empty = true;
		Album[] talbums = new Album[albums.length];
		for(int y = 0; y < albums.length; y++) {
			talbums[y] = albums[y];
			if(albums[y] != null) {
				empty = false;
			}
		}
		
		if(empty) {
			System.out.println("This Collection is Empty!");
		}else {
			int n = talbums.length;
	        for (int i = 0; i < n-1; i++)
	        {
	            // Find the minimum element in unsorted array
	            int min_idx = i;
	            for (int j = i+1; j < n; j++) {
	            	if(talbums[j] != null) {
	            		if (talbums[j].getDate().compareTo(talbums[min_idx].getDate()) < 0)
	                    min_idx = j;
	            	}
	            }
	            Album temp = talbums[min_idx];
	            talbums[min_idx] = talbums[i];
	            talbums[i] = temp;
	        }
	        System.out.println("*Albums by Release Date.");
	        for(int x = 0; x < talbums.length; x++) {
	        	System.out.println(talbums[x].toString());
	        }
	        System.out.println("*End of List.");
		}   
	}
	
	/**
	 * Displays the list of albums in the collection ordered by genre
	 */
	public void printByGenre() {
		boolean empty = true;
		for(Album x : albums)
		{
			empty = false;
		}
		if(empty)
		{
			System.out.println("This Collection is Empty!");
		}else {
			System.out.println("*Album Collection by Genre.");
			for(Genre genre : Genre.values())
			{
				for(Album x : albums)
				{
					if(x.getGenre().equals(genre))
					{
						System.out.println(x.toString());
					}
				}
			}
			System.out.println("*End of List.");
		}
	}
	
	
}
