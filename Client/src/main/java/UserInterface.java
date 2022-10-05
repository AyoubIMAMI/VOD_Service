import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface(){
        scanner = new Scanner(System.in);
    }

    /**
     * Ask the user for login or register
     * @return 0 : User want to quit, 1 : User want to log in, 2 user want to register.
     */
    public int loginRegisterAsk(){
        String input = "";

        while((!input.equals(":q"))) {
            System.out.println("\nPlease select an action: (press :q to quit)");
            System.out.println("    1 - Login");
            System.out.println("    2 - Register");
            input = scanner.nextLine();

            if(input.equals("1")) return 1;
            if(input.equals("2")) return 2;
        }

        return 0;
    }

    /**
     * Ask the client what does he want to do: view catalog or quit
     * @return integer representing the client choice
     */
    public int serviceAsk(){
        String input = "";

        while((!input.equals(":q"))) {
            System.out.println("Please select an action: (press :q to quit)");
            System.out.println("    1 - View catalog");
            input = scanner.nextLine();

            if(input.equals("1")) return 1;
        }

        return 0;
    }

    /**
     * Print the catalog of movies
     * @param movieDescList the movieDesc list
     */
    public void printCatalog(List<MovieDesc> movieDescList){
        System.out.println();
        System.out.println("Movies present in our catalog, please select the one you wish to watch:");
        int numberOfMovies = movieDescList.size();
        for(int i = 1; i < numberOfMovies + 1; i++)
            System.out.println("   " + i + " - " + movieDescList.get(i-1));
        System.out.println();
    }

    /**
     * Allow the client to select the movie he wants to watch
     * @param movieDescList the movieDesc list
     * @return the unique isbn
     */
    public String selectMovie(List<MovieDesc> movieDescList) {
        //creating a list of integer to check below if the input of the client is available
        int availableMovieNumber = movieDescList.size();
        List<Integer> answersAvailable = new ArrayList<>();
        for(int i = 0; i < availableMovieNumber; i++)
            answersAvailable.add(i);

        String input = scanner.nextLine();

        //avoid input other than digit
        whileWrongFormatInput(input);

        //avoid input other than the available ones
        while (!answersAvailable.contains(Integer.parseInt(input) - 1)) {
            System.out.println("\nPlease select the digit of the corresponding movie : ");
            input = scanner.nextLine();

            //avoid input other than digit (second security in case if the client chose a wrong number than not a number)
            whileWrongFormatInput(input);
        }

        return movieDescList.get(Integer.parseInt(input) - 1).getIsbn();
    }

    /**
     * Check if the input format is not a digit [0-9] and ask for a correct input
     * (avoid input other than digit)
     * @param input - input of the client
     */
    void whileWrongFormatInput(String input) {
        while (!isNumeric(input)) {
            System.out.println("\nPlease select only the digit of the corresponding movie : ");
            input = scanner.nextLine();
        }
    }

    /**
     * Check if a string is numeric of not
     * @param input - the string to check
     * @return true if the string is numeric (ex: "0"), false otherwise (ex: "a")
     */
    public static boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public String[] getMailPass(){
        String mail;
        String pass;

        System.out.println();
        System.out.println("Please enter a mail:");
        mail = scanner.nextLine();
        System.out.println("Please enter a password:");
        pass = scanner.nextLine();

        return new String[] {mail, pass};
    }
}
