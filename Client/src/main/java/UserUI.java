import java.util.Scanner;

public class UserUI {
    private boolean isLogged = false;
    private Scanner scanner;

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
            System.out.println("1 - Login");
            System.out.println("2 - Register");
            input = scanner.nextLine();

            if(input.equals("1")) return 1;
            if(input.equals("2")) return 2;
        }

        return 0;
    }


    public String[] getMailPass(){
        String mail = "";
        String pass = "";

        System.out.println();
        System.out.println("Please enter a mail:");
        mail = scanner.nextLine();
        System.out.println("Please enter a password:");
        pass = scanner.nextLine();

        return new String[] {mail, pass};
    }
}
