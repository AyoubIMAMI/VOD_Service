public class Connexion implements IConnection {
    @Override
    public boolean signIn(String mail, String password) {
        return false;
    }

    @Override
    public IVODService login(String mail, String password) {
        return null;
    }
}
