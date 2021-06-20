package RecS.Utils;

import RecS.Models.Movies;
import RecS.Models.UserRec;
import RecS.Models.Users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static RecS.Utils.CsvReader.getImdbByID;
import static RecS.Utils.CsvReader.getPosterLinkByID;

public class Recommender {

    // Creates the List of #limit-top movies and returns it
    //changes from mile2 starts here
    public static List<Movies> limitedTop(HashMap<String, Double> map, int limit) throws IOException {
        List<Movies> top = new ArrayList<>();

        for (int i = 0; i < limit && i < map.size(); i++) {
            String id = null;
            Double maxR = Double.MIN_VALUE;
            for (String key : map.keySet()) {
                if (map.get(key) > maxR) {
                    maxR = map.get(key);
                    id = key;
                }
            }
            //top.add(new Movies(getTitleByID(id), getImdbByID(id), getGenreByID(id), getPosterLinkByID(id), getImdbByID(id)));
            map.remove(id);
        }

        return top;
    }

    // Calculate and assign relevancy score for each movie
    public static HashMap<String, Double> gradeMovies(UserRec user) throws IOException {
        String[] args = {user.getGender(), user.getAge(), user.getOccupation(), user.getGenre()};

        double[] coef = {0.333, 0.333, 0.333};
        HashMap<String, Double> simUsers = new HashMap<>();
        HashMap<String, Double> movies = new HashMap<>();

        args[1] = parseAge(args[1]);
        args[2] = parseStringOccupation(args[2]);

        //Calculate the similarity of users
        String[] arrOfStr;
        double fac;
        String line = "";
        BufferedReader users = new BufferedReader(new FileReader("./data/users.dat"));
        line = users.readLine(); //UserID::Gender::Age::Occupation::Zip-code
        while (line != null) {
            fac = 0;
            arrOfStr = line.split("::");
            for (int i = 0; i < 3; i++) fac += arrOfStr[i + 1].equalsIgnoreCase(args[i]) ? coef[i] : 0;
            simUsers.put(arrOfStr[0], fac);
            line = users.readLine();
        }
        users.close();
        // map new rating to movies
        BufferedReader ratings = new BufferedReader(new FileReader("./data/ratings.dat"));
        line = ratings.readLine(); //UserID::MovieID::Rating::Timestamp
        while (line != null) {
            arrOfStr = line.split("::");
            if (movies.containsKey(arrOfStr[1])) {
                movies.put(arrOfStr[1], (Integer.parseInt(arrOfStr[2]) * (simUsers.get(arrOfStr[0]) + 1) + movies.get(arrOfStr[1])) / 2);
            } else {
                movies.put(arrOfStr[1], Integer.parseInt(arrOfStr[2]) * (simUsers.get(arrOfStr[0]) + 1));
            }
            line = ratings.readLine();
        }
        ratings.close();
        if (!args[3].equals("")) return promoteFavGenre(movies, args[3]);
        return movies;
    }

    // if favorite genre is given, promote movies with such genres
    public static HashMap<String, Double> promoteFavGenre(HashMap<String, Double> map, String cat) throws IOException {
        String[] catArr = cat.toLowerCase().split("\\|");

        String[] arrOfStr;
        Set<String> cats;

        BufferedReader movies = new BufferedReader(new FileReader("./data/movies.dat"));
        String line = movies.readLine();
        while (line != null) {
            arrOfStr = line.split("::");
            cats = new HashSet<>(Arrays.asList(arrOfStr[2].toLowerCase().split("\\|")));
            for (String s : catArr) {
                if (cats.contains(s)) {
                    if (map.get(arrOfStr[0]) != null) map.put(arrOfStr[0], map.get(arrOfStr[0]) * 10);
                    break;
                }
            }
            line = movies.readLine();
        }
        movies.close();
        return map;
    }


//    // in the movies.dat file searches for movies with given ID and returns its genre
//    public static String getGenreByID(String movieID) throws IOException {
//        String genre = "";
//        BufferedReader movies = new BufferedReader(new FileReader("./data/movies.dat"));
//
//        String line = movies.readLine();
//
//        while ((line != null)) {
//            String[] film = line.split("::");
//            if (film[0].equals(movieID)) {
//                genre = film[2];
//                break;
//            }
//            line = movies.readLine();
//        }
//        movies.close();
//        return genre;
//    }

    //find the user that has given the greatest rating to the movie with movieID
//    public static Users posFanFromMovieID(String movieID) throws IOException {
//        String userId = "";
//        int maxRating = 0;// get this from ratings.dat file
//        BufferedReader ratings = new BufferedReader(new FileReader("./data/ratings.dat"));
//        String line = ratings.readLine();
//
//        while ((line != null)) {
//            String[] arr = line.split("::");
//            if (arr[1].equals(movieID) && Integer.parseInt(arr[2]) > maxRating) {
//                maxRating = Integer.parseInt(arr[2]);
//                userId = arr[0];
//            }
//            line = ratings.readLine();
//        }
//        ratings.close();
//
//        return getUserById(userId);
//    }

//    // in the movies.dat file searches for movies with given ID and returns its title
//    public static String getTitleByID(String movieID) throws IOException {
//        String title = "";
//        BufferedReader movies = new BufferedReader(new FileReader("./data/movies.dat"));
//        String line = movies.readLine();
//
//        while ((line != null)) {
//            String[] film = line.split("::");
//            if (film[0].equals(movieID)) {
//                title = film[1];
//                break;
//            }
//            line = movies.readLine();
//        }
//        movies.close();
//        return title;
//    }

    //find user with given userId
//    public static Users getUserById(String userID) throws IOException {
//        BufferedReader users = new BufferedReader(new FileReader("./data/users.dat"));
//        String line = users.readLine();
//
//        while ((line != null)) {
//            String[] arr = line.split("::");
//            if (arr[0].equals(userID)) {
//                return new Users(arr[1], arr[2], arr[3], "");
//            }
//            line = users.readLine();
//        }
//        return null;
//    }

    public static boolean isValidInput(String gender, String age, String occupation, String genre) throws IOException {
        boolean isValid = true;

        // Invalid gender error
        if (!isGender(gender) && !gender.equals("")) { // check here
            System.out.printf("Invalid gender: \"%s\"\n", gender);
            isValid = false;
        }
        //Invalid age error
        if (!isValidAge(age) && !age.equals("")) {
            System.out.printf("Invalid age: \"%s\"\n", age);
            isValid = false;
        }
        //Invalid occupation error
        if (!isOccupation(occupation.toLowerCase()) && !occupation.equals("")) {
            System.out.printf("Invalid occupation: \"%s\"\n", occupation);
            isValid = false;
        }
        //Invalid genre error
        if (!isGenre(genre)) {
            System.out.printf("Invalid genre: \"%s\"\n", genre);
            isValid = false;
        }
        return isValid;
    }

    // If genre is present in movies, return true; otherwise false
    // has changes from mile2 (end here)
    public static boolean isGenre(String genre) throws IOException {
        if (genre.equals("")) return true;
        Set<String> genres = new HashSet<>(Arrays.asList(genre.toLowerCase().split("\\|")));
        Set<String> allGenres = new HashSet<>();

        BufferedReader movies = new BufferedReader(new FileReader("./data/movies.dat"));
        String line = movies.readLine();

        while (line != null) {
            String[] arrOfStr = line.toLowerCase().split("::");
            allGenres.addAll(Arrays.asList(arrOfStr[2].toLowerCase().split("\\|")));
            line = movies.readLine();
        }
        movies.close();
        return allGenres.containsAll(genres);
    }

    // If gender is either M or F, return true; otherwise return false
    public static boolean isGender(String gender) {
        return gender.equals("M") || gender.equals("F");
    }

    // If age is greater than -1 and is number, return true; otherwise false;
    public static boolean isValidAge(String age) {
        return !parseAge(age).equals("-1");
    }

    // If translation of occupation to its number is successful, return true; otherwise false.
    public static boolean isOccupation(String occ) {
        return !parseStringOccupation(occ).equals("-1");
    }

    // Return range representation for each input age, using info in README.pm
    public static String parseAge(String age) {

        try {
            int ageInt = Integer.parseInt(age);
            if (ageInt < 0) return "-1";
            if (ageInt < 18) return "1";
            if (ageInt < 25) return "18";
            if (ageInt < 35) return "25";
            if (ageInt < 45) return "35";
            if (ageInt < 50) return "45";
            if (ageInt < 56) return "50";
            return "56";
        } catch (Exception e) {
            return "-1";
        }
    }

    public static String parseStringOccupation(String occupation) {
        String occupationIndex;
        switch (occupation) {
//            case "other":
//                //0:  "other" or not specified??
//                occupationIndex = "0";
//                break;
            case "": // occupation is omitted
                occupationIndex = "";
                break;
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
                occupationIndex = "-1";
        }
        return occupationIndex;
    }
}
