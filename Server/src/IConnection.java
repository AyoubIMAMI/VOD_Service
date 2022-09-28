public interface IConnection extends java.rmi.Remote {
    boolean signIn(String mail, String password);
    IVODService login(String mail, String password);
}
