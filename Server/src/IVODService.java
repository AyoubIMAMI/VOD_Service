import java.util.List;

public interface IVODService extends java.rmi.Remote {
    List<MovieDesc> viewCatalog();
    Bill playMovie(String isbn, IClientBox box);
}
