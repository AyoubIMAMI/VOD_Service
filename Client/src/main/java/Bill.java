import java.io.Serializable;
import java.math.BigInteger;

public class Bill implements Serializable {

    //movie name
    private final String movieName;
    //movie price
    private final BigInteger outrageousPrice;

    Bill(String movieName, BigInteger outrageousPrice) {
        this.movieName = movieName;
        this.outrageousPrice = outrageousPrice;
    }
}
