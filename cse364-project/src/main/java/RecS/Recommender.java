package RecS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Recommender {
    static final int MAX_TOP = 3000;

    private Recommender(){}; // private constructor

    public static List<Movies> limitedTop(HashMap<Movies, Double> map, int limit ) throws IOException {
        List<Movies> top = new ArrayList<>();

        for(int i = 0; i < limit && i < MAX_TOP; i++){
            Movies movie = null; Double maxR = Double.MIN_VALUE;
            for(Movies key: map.keySet()){
                if(map.get(key) > maxR){
                    maxR = map.get(key);
                    movie = key;
                }
            }
            top.add(movie);
            map.remove(movie);
        }

        return top;
    }

    public static HashMap<String, Double> findSimilarUsers(Users user) throws IOException {
        double[] coef = {0.333, 0.333, 0.333};
        HashMap<String, Double> simUsers = new HashMap<>();
        HashMap<Movies, Double> movies = new HashMap<>();

        BufferedReader users = new BufferedReader(new FileReader("./data/users.dat"));

        String[] arrOfStr; double fac;
        String line = users.readLine();
        while(line != null){
            fac = 0;
            arrOfStr = line.split("::");
            // this part is important

            fac = (arrOfStr[1].equalsIgnoreCase(user.getGender()) ? coef[0]: 0)
                    + (arrOfStr[2].equalsIgnoreCase(parseAge(user.getAge())) ? coef[1]: 0)
                    + (arrOfStr[3].equalsIgnoreCase(parseStringOccupation(user.getOccupation())) ? coef[2]: 0);

            simUsers.put(arrOfStr[0], fac);
            line = users.readLine();
        }
        users.close();

        BufferedReader ratings = new BufferedReader(new FileReader("./data/ratings.dat"));

        line = ratings.readLine();
        while(line != null){
            arrOfStr = line.split("::");
            // this part is important
            if(movies.containsKey(arrOfStr[1])){
                // VOT ZDES PRODOLJU
                movies.put(new Movies(), (Integer.parseInt(arrOfStr[2])*(movies.get(arrOfStr[0])+ 1) + movies.get(arrOfStr[1]))/2);
            }
            else{
                movies.put(arrOfStr[1], Integer.parseInt(arrOfStr[2])*(movies.get(arrOfStr[0])+ 1));
            }
            line = ratings.readLine();
        }
        ratings.close();

        return movies;
    }

    public static String getIMDB(String movieID){
        // to be implemented
        String link = ""; // get this from links.dat

        return "https://www.imdb.com/title/ttXXXXXXX" + link;
    }

    public static HashMap<String, Double> mapWithNewRatCat(HashMap<String, Double> map, String cat) throws IOException {
        String[] catArr = cat.toLowerCase(Locale.ROOT).split("\\|");

        String[] arrOfStr; Set<String> cats;
        BufferedReader movies = new BufferedReader(new FileReader("./data/movies.dat"));

        String line = movies.readLine();
        while(line != null){
            arrOfStr = line.split("::");
            cats = new HashSet<>(Arrays.asList(arrOfStr[2].toLowerCase(Locale.ROOT).split("\\|")));
            for(String s: catArr){
                // promote movies with required genre
                if(cats.contains(s)){
                    // this part is important
                    if( map.get(arrOfStr[0]) != null) map.put(arrOfStr[0], map.get(arrOfStr[0]) * 10);
                    break;
                }
            }
            line = movies.readLine();
        }
        movies.close();

        return map;
    }

    public static boolean isValidInput(String[] args) throws IOException {
        boolean isValid = true;
        // Invalid gender error
        if(!isGender(args[0]) && !args[1].equals("")){
            System.out.printf("Invalid gender: \"%s\"\n", args[0]);
            isValid = false;
        }
        //Invalid age error
        if(!isValidAge(args[1]) && !args[1].equals("")){
            System.out.printf("Invalid age: \"%s\"\n", args[1]);
            isValid = false;
        }
        //Invalid occupation error
        if(!isOccupation(args[2].toLowerCase(Locale.ROOT)) && !args[2].equals("")){
            System.out.printf("Invalid occupation: \"%s\"\n", args[2]);
            isValid = false;
        }
        //Invalid genre error
        if(args.length == 4 && !isGenre(args[3])){
            System.out.printf("Invalid genres: \"%s\"\n", args[3]);
            isValid = false;
        }
        return isValid;
    }

    // If genre is present in movies, return true; otherwise false
    public static boolean isGenre(String genre) throws IOException {
        Set<String> genres = new HashSet<>(Arrays.asList(genre.toLowerCase(Locale.ROOT).split("\\|")));
        Set<String> allGenres = new HashSet<>();

        BufferedReader movies = new BufferedReader(new FileReader("./data/movies.dat"));
        String line = movies.readLine();

        while(line != null){
            String[] arrOfStr = line.toLowerCase(Locale.ROOT).split("::");
            allGenres.addAll(Arrays.asList(arrOfStr[2].toLowerCase(Locale.ROOT).split("\\|")));
            line = movies.readLine();
        }
        movies.close();

        return allGenres.containsAll(genres);
    }

    // If gender is either M or F, return true; otherwise return false
    public static boolean isGender(String gender){
        return gender.equals("M") || gender.equals("F");
    }

    // If age is greater than -1 and is number, return true; otherwise false;
    public static boolean isValidAge(String age){
        return !parseAge(age).equals("-1");
    }

    // If translation of occupation to its number is successful, return true; otherwise false.
    public static boolean isOccupation(String occ){
        return !parseStringOccupation(occ).equals("-1");
    }

    // Return range representation for each input age, using info in README.pm
    public static String parseAge(String age){

        try {
            int ageInt = Integer.parseInt(age);
            if(ageInt < 0) return "-1";
            if(ageInt < 18) return "1";
            if(ageInt < 25) return "18";
            if(ageInt < 35) return "25";
            if(ageInt < 45) return "35";
            if(ageInt < 50) return "45";
            if(ageInt < 56) return "50";
            return "56";
        } catch(Exception e){
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
