import java.util.*;

class RateMeter{
	public static void main(String[] args){
		//we need to consider all edge cases of input values
		//This is simpler version of our implementation
		
		String occupation = args[1];
		String genres = args[0];

		Set<String> userIDs = getUserIDFromOccupation(occupation);
		Set<String> movieIDs = getMovieIDFromGenres(genres);
		
		double average_rating = getAverageRating(userIDs, movieIDs);
		System.out.println(average_rating);
	}

	private static Set<String> getUserIDFromOccupation(String occupation){
	}

	private static Set<String> getMovieIDFromGenres(String genres){
	}

	private static double getAverageRating(Set<String> userIDs, Set<String> movieIds){
	} 
}
