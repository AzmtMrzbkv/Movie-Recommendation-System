import java.util.*;
import java.io.*;

// We need to debug this code
// 1) occupation can be empty ("") // done
// 2) Can other values be empty?   // done
// 3) What to print if there is no movie matches? // done
// 4) Handling incorrect user inputs // done
// 5) Add trim() method to handle cases such as "Action| Advanture" // will be implemented later


//6) Logical ERROR of output: when type "horror|comedy|western doctor" it gives number // done
// although there is no such film with these genres (not 100%, but i couldn't find)
//7) Is it our task to check whether user input contains other chars except '|'???

//8) Afaik min rating is 1, so if there is no such film output is "No rating"?? // done

public class RateMeter {
    public static void main(String[] args) throws Exception {
        //we need to consider all edge cases of input values
        //This is simpler version of our implementation

        // Handling incorrect args length ( != 2 )
        if( args.length != 2){
            System.out.println("Wrong input, please, try again! \nNote: The input must be two strings in double quotes separated by space. For example: \"adventure\" \"educator\"");
            System.exit(0);
        }

        String occupation = parseStringOccupation(args[1]);
        String genres = args[0];

        // read input file
        FileReader movies = new FileReader("../data/movies.dat");
        FileReader ratings = new FileReader("../data/ratings.dat");
        FileReader users = new FileReader("../data/users.dat");

        Set<String> userIDs = getUserIDFromOccupation(occupation, users);
        Set<String> movieIDs = getMovieIDFromGenres(genres, movies);

        if(userIDs.isEmpty() || movieIDs.isEmpty()) System.exit(0);

        double average_rating = getAverageRating(userIDs, movieIDs, ratings);
        System.out.println(average_rating);
    }

    // add handling of not specified or unknown occupation
    private static String parseStringOccupation(String occupation) {
        String occupationIndex = "";
            switch (occupation) {
//            case "other":
//                //0:  "other" or not specified??
//                occupationIndex = "0";
//                break;
                case "academic":
                case "educator":
                    occupationIndex = "1";
                    break;
                case "artist":
                    occupationIndex = "2";
                    break;
                case "clerical":
                case "admin":
                    occupationIndex = "3";
                    break;
                case "college":
                case "grad student":
                case "gradstudent":
                    occupationIndex = "4";
                    break;
                case "customer service":
                case "customerservice":
                    occupationIndex = "5";
                    break;
                case "doctor":
                case "health care":
                case "healthcare":
                    occupationIndex = "6";
                    break;
                case "executive":
                case "managerial":
                    occupationIndex = "7";
                    break;
                case "farmer":
                    occupationIndex = "8";
                    break;
                case "homemaker":
                    occupationIndex = "9";
                    break;
                case "K-12 studio":
                case "K-12studio":
                    occupationIndex = "10";
                    break;
                case "lawyer":
                    occupationIndex = "11";
                    break;
                case "programmer":
                    occupationIndex = "12";
                    break;
                case "retired":
                    occupationIndex = "13";
                    break;
                case "sales":
                case "marketing":
                    occupationIndex = "14";
                    break;
                case "scientist":
                    occupationIndex = "15";
                    break;
                case "self-employed":
                    occupationIndex = "16";
                    break;
                case "technician":
                case "engineer":
                    occupationIndex = "17";
                    break;
                case "tradesman":
                case "craftsman":
                    occupationIndex = "18";
                    break;
                case "unemployed":
                    occupationIndex = "19";
                    break;
                case "writing":
                    occupationIndex = "20";
                    break;
                default:
                    if(occupation.equals("")) occupation = "\"\"";
                    System.out.println("No such occupation: "+ occupation);
                    occupationIndex = "-1";
            }
        return occupationIndex;
    }

    private static Set<String> getUserIDFromOccupation(String occupation, FileReader file) throws IOException {
        if(occupation.equals("-1")) return new HashSet<>();

        // UserID::Gender::Age::Occupation::Zip-code    in users.dat
        BufferedReader read = new BufferedReader(file);
        occupation = occupation.toLowerCase(Locale.ROOT);

        Set<String> userIDs = new HashSet<>();

        String line = read.readLine();
        while (line != null) {
            String[] arrOfStr = line.toLowerCase(Locale.ROOT).split("::");
            if (occupation.equals(arrOfStr[3])) userIDs.add(arrOfStr[0]);
            line = read.readLine();
        }

        return userIDs;
    }

    //implement this method
    private static Set<String> getMovieIDFromGenres(String genreString, FileReader file) throws IOException {
        BufferedReader read = new BufferedReader(file);
        String[] genres = genreString.toLowerCase(Locale.ROOT).split("\\|");
        // this set will be returned
        Set<String> movieIDs = new HashSet<>();

        String line = read.readLine();
        // every line in .dat file => MovieID::Title::Genres
        while (line != null) {
            String[] lineArray = line.toLowerCase(Locale.ROOT).split("::");
            Set<String> genreSet = new HashSet<>(Arrays.asList(lineArray[2].split("\\|")));
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

        if(movieIDs.isEmpty()){
            System.out.println("No movies with such genre(s) found!");
            System.exit(0);
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
            String[] lineArray = line.toLowerCase(Locale.ROOT).split("::");

            if (userIDs.contains(lineArray[0]) && movieIds.contains(lineArray[1])) {
                averageRating += Double.parseDouble(lineArray[2]);
                number++;
            }

            line = read.readLine();
        }

        if (number != 0) averageRating /= number;
        else{
            System.out.println("Movies with such genre(s) were not rated by people of this occupation!");
            System.exit(0);
        }

        return averageRating;
    }
}

