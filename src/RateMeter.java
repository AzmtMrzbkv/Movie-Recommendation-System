import java.util.*;
import java.io.*;

<<<<<<< HEAD
// We need to debug this code
// 1) occupation can be empty ("")
// 2) Can other values be empty?
// 3) What to print if there is no movie matches?
// 4) Handling incorrect user inputs

=======
>>>>>>> 8d85577b71a10febb022af8c14204f7f483ccff0
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
<<<<<<< HEAD
    private static Set<String> getUserIDFromOccupation(String occupation, FileReader file) {
        return new HashSet<String>();
    }

    //implement this method
    private static Set<String> getMovieIDFromGenres(String genreString, FileReader file) throws IOException {
        BufferedReader read = new BufferedReader(file);
        String[] genres = genreString.toLowerCase(Locale.ROOT).split("|");
        // this set will be returned
        Set<String> movieIDs = new HashSet<>();

        String line = read.readLine();
        // every line in .dat file => MovieID::Title::Genres
        while (line != null) {
            String[] lineArray = line.toLowerCase(Locale.ROOT).split("::");
            Set<String> genreSet = new HashSet<>(Arrays.asList(lineArray[2].split("|")));
            boolean correctMov = true;

            for (String genre : genres) {
                if (!genreSet.contains(genre)) {
                    correctMov = false;
                    break;
                }
            }

            if (correctMov) movieIDs.add(lineArray[0]);

            line = read.readLine();
        }

        return movieIDs;
    }

    //implement this method
    private static double getAverageRating(Set<String> userIDs, Set<String> movieIds, FileReader file) throws IOException {
        BufferedReader read = new BufferedReader(file);
        double averageRating = 0;
        int number = 0;

        String line = read.readLine();
        //each line in the file => UserID::MovieID::Rating::Timestamp

        while (line != null) {
            String[]  lineArray = line.toLowerCase(Locale.ROOT).split("::");

            if(userIDs.contains(lineArray[0]) && movieIds.contains(lineArray[1])){
                averageRating += Double.parseDouble(lineArray[2]);
                number++;
            }

            line = read.readLine();
        }

        if (number != 0) averageRating /= number;

        return averageRating;
    }
=======
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


>>>>>>> 8d85577b71a10febb022af8c14204f7f483ccff0
}

