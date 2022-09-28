public interface IConnection {
    boolean signIn(String mail, String password);
    IVODService login(String mail, String password);
}
