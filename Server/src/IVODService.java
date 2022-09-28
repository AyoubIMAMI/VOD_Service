import java.util.List;

public interface IVODService {

    List<MovieDesc> viewCatalog();
    Bill playMovie(String isbn, IClientBox box);
}
