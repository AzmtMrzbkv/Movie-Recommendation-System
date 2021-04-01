import java.util.*;

class RateMeter{
	public static void main(String[] args){
		//we need to consider all edge cases of input values
		//This is simpler version of our implementation
		
		String occupation = args[1];
		String genres = args[0];

		// read input files
		// implement this part here

		Set<String> userIDs = getUserIDFromOccupation(occupation, /*  the name of the fiel with user list */);
		Set<String> movieIDs = getMovieIDFromGenres(genres, /*  the name of the fiel with genre list */);
		
		double average_rating = getAverageRating(userIDs, movieIDs, /*  the name of the fiel with rating list */);
		System.out.println(average_rating);
	}

	//implement this method
	private static Set<String> getUserIDFromOccupation(String occupation, /*  the name of the fiel with user list */){
	}

	//implement this method
	private static Set<String> getMovieIDFromGenres(String genres, /*  the name of the fiel with user list */){
	}

	//implement this method
	private static double getAverageRating(Set<String> userIDs, Set<String> movieIds, /*  the name of the fiel with user list */){

	} 
}
