import java.util.List;
import java.util.Scanner;

public class UserUI {
    private final Scanner scanner;

    public UserUI(){
        scanner = new Scanner(System.in);
    }

    /**
     * Ask the user for login or register
     * @return 0 : User want to quit, 1 : User want to log in, 2 user want to register.
     */
    public int loginRegisterAsk(){
        String input = "";

        while((!input.equals(":q"))) {
            System.out.println("Please select an action: (press :q to quit)");
            System.out.println("    1 - Login");
            System.out.println("    2 - Register");
            input = scanner.nextLine();

            if(input.equals("1")) return 1;
            if(input.equals("2")) return 2;
        }

        return 0;
    }

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

    public void printCatalog(List<MovieDesc> movieDescList){
        System.out.println();
        System.out.println("Movies present in our catalog, please select the one you wish to watch:");
        int numberOfMovies = movieDescList.size();
        for(int i = 1; i < numberOfMovies + 1; i++)
            System.out.println("   " + i + " - " + movieDescList.get(i-1));
        System.out.println();
    }

    public String selectMovie(List<MovieDesc> movieDescList) {
        String input = scanner.nextLine();
        return movieDescList.get(Integer.parseInt(input)-1).getIsbn();
    }
}
