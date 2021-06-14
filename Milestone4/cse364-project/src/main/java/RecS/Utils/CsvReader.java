package RecS.Utils;

import RecS.Models.*;
import ch.qos.logback.core.net.SyslogOutputStream;

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
            movies.add(new Movies(data[0], data[1], data[2]));
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
            String[] data = line.split(" ");
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
            String[] data = line.split(" ");
            ratings.add(new Ratings(data[0], data[1], data[2], data[3]));
            line = csvReader.readLine();
        }
        csvReader.close();

        return ratings;
    }

    public static List<Posters> readPostersCsv() throws IOException {
        List<Posters> posters = new ArrayList<>();

        BufferedReader csvReader = new BufferedReader(new FileReader("./src/main/resources/movie_poster.csv"));
        String line = csvReader.readLine();
        while (line != null) {
            String[] data = line.split(" ");
            posters.add(new Posters(data[0], data[1]));
            line = csvReader.readLine();
        }
        csvReader.close();

        return posters;
    }

    public static List<Links> readLinksCsv() throws IOException {
        List<Links> links = new ArrayList<>();

        BufferedReader csvReader = new BufferedReader(new FileReader("./src/main/resources/movie_poster.csv"));
        String line = csvReader.readLine();
        while (line != null) {
            String[] data = line.split(" ");
            links.add(new Links(data[0], data[1]));
            line = csvReader.readLine();
        }
        csvReader.close();

        return links;
    }
}
