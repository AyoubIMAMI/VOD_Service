/**
 * @author Bonnet Kilian
 * @author IMAMI Ayoub
 *
 * VOD_RMI_project
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Connexion c = new Connexion(0);

        Movies movies = new Movies();
        movies.serialize();
    }

}
