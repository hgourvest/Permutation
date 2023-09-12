import com.progdigy.permutation.Factoradic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoradicTest {
    @Test
    void getIndex() {
        Factoradic a = new Factoradic(4);
        int index = 0;
        do {
            Assertions.assertEquals(index++, a.getIndex());
        } while (a.next());
    }

    @Test
    void setIndex() {
        Factoradic a = new Factoradic(4);
        Factoradic b = new Factoradic(4);
        int index;
        do {
            index = a.getIndex();
            Assertions.assertTrue(b.setIndex(index));
            Assertions.assertEquals(a, b);
        } while (a.next());
        Assertions.assertFalse(b.setIndex(index+1));
    }
}
