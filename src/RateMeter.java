import java.util.*;
import java.io.*;

public class RateMeter {
    public static void main(String[] args) throws Exception {
        //we need to consider all edge cases of input values
        //This is simpler version of our implementation

        String occupation = args[1];
        String genres = args[0];

        // read input file
        FileReader movies = new FileReader("../data/movies.dat");
        FileReader ratings = new FileReader("../data/ratings.dat");
        FileReader users = new FileReader("../data/users.dat");

        Set<String> userIDs = getUserIDFromOccupation(occupation, users);
        Set<String> movieIDs = getMovieIDFromGenres(genres, movies);

        double average_rating = getAverageRating(userIDs, movieIDs, ratings);
        System.out.println(average_rating);


    }

    //implement this method
    private static Set<String> getUserIDFromOccupation(String occupation, FileReader file) throws IOException {
        // UserID::Gender::Age::Occupation::Zip-code    in users.dat
        BufferedReader br = new BufferedReader(file);
        occupation = occupation.toLowerCase(Locale.ROOT);

        String line = br.readLine();
        Set<String> h = new HashSet<String>();

        while (line != null) {

            String[] arrOfStr = line.toLowerCase(Locale.ROOT).split("::");
            if (occupation.equals(arrOfStr[3]))
                h.add(arrOfStr[0]);

            line = br.readLine();
        }
        return h;
    }

    //implement this method
    private static Set<String> getMovieIDFromGenres(String genres, FileReader file) {
        return new HashSet<String>();
    }

    //implement this method
    private static double getAverageRating(Set<String> userIDs, Set<String> movieIds, FileReader file) {
        return 0;
    }


}

