package RecS.Utils;

import RecS.Models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<Movies> readMoviesCsv() throws IOException {
        List<Movies> movies = new ArrayList<>();

        BufferedReader csvReader = new BufferedReader(new FileReader("./src/main/resources/movies_corrected.csv"));
        String line = csvReader.readLine();
        while (line != null) {
            String[] data = line.split(",");
            movies.add(new Movies(data[0], data[1], data[2], getPosterLinkByID(data[0]), getImdbByID(data[0])));
            line = csvReader.readLine();
        }
        csvReader.close();

        return movies;
    }

    public static List<Users> readUsersCsv() throws IOException {
        List<Users> users = new ArrayList<>();

        BufferedReader csvReader = new BufferedReader(new FileReader("./src/main/resources/users.csv"));
        String line = csvReader.readLine();

        while (line != null) {
            String[] data = line.split(",");
            users.add(new Users(data[0], data[1], data[2], data[3], data[4]));
            line = csvReader.readLine();
        }
        csvReader.close();

        return users;
    }

    public static List<Ratings> readRatingsCsv() throws IOException {
        List<Ratings> ratings = new ArrayList<>();

        BufferedReader csvReader = new BufferedReader(new FileReader("./src/main/resources/ratings.csv"));
        String line = csvReader.readLine();

        while (line != null) {
            String[] data = line.split(",");
            ratings.add(new Ratings(data[0], data[1], data[2], data[3]));
            line = csvReader.readLine();
        }
        csvReader.close();

        return ratings;
    }

//    // in the movies.dat file searches for movie with given title and returns its ID
//    public static String getIdByTitle(String title) throws IOException {
//        String id = ""; // get this from movies.dat file
//        BufferedReader movies = new BufferedReader(new FileReader("./data/movies.dat"));
//        String line = movies.readLine();
//
//        while ((line != null)) {
//            String[] film = line.split("::");
//            if (film[1].equals(title)) {
//                id = film[0];
//                break;
//            }
//            line = movies.readLine();
//        }
//        movies.close();
//        return id;
//    }

    public static String getImdbByID(String movieID) throws IOException {
        String link = "";
        BufferedReader linkReader = new BufferedReader(new FileReader("./src/main/resources/links.csv"));
        String line = linkReader.readLine();

        while ((line != null)) {
            String[] film = line.split(",");
            if (film[0].equals(movieID)) {
                link = film[1];
                break;
            }
            line = linkReader.readLine();
        }
        linkReader.close();
        return "https://www.imdb.com/title/tt" + link;
    }

    public static String getPosterLinkByID(String movieID) throws IOException {
        String posterLink = "";
        BufferedReader posterReader = new BufferedReader(new FileReader("./src/main/resources/movie_poster.csv"));
        String line = posterReader.readLine();

        while ((line != null)) {
            String[] film = line.split(",");
            if (film[0].equals(movieID)) {
                posterLink = film[1];
                break;
            }
            line = posterReader.readLine();
        }
        posterReader.close();
        return posterLink;
    }
}
