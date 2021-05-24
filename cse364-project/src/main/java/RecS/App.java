package RecS;

// this class will be the controller

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RestController
public class App {
    //here will be functions mapped to GET

    //this function return recommendation list
    @GetMapping("/users/recommendations ")
    public List<Movies> recommendForUser(@RequestBody Users newUser) {
        // this part to be implemented
        return null;
    }

    @GetMapping("/movies/recommendations ")
    public List<Movies> recommendByMovie(@RequestBody LimitedRec newRequest) {
        // this part to be implemented
        return null;
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
            System.out.printf("Invalid genre: \"%s\"\n", args[3]);
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
