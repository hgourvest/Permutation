import com.progdigy.permutation.Permutation;
import com.progdigy.permutation.RotateAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class RotateTest {
    @Test
    void uniqueness() {
        Permutation p = new RotateAlgorithm(5);
        HashSet<String> map = new HashSet<>();
        do {
            String key = p.toString();
            Assertions.assertFalse(map.contains(key));
            map.add(key);
        } while (p.next());
    }

    @Test
    void rewind() {
        Permutation p = new RotateAlgorithm(5);
        String key = p.toString();
        while (p.next()) {
            p.previous();
            Assertions.assertEquals(key, p.toString());
            p.next();
            key = p.toString();
        }
    }
}
