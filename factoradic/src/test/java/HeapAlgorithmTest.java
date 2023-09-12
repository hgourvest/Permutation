import com.progdigy.permutation.HeapAlgorithm;
import com.progdigy.permutation.MirrorAlgorithm;
import com.progdigy.permutation.Permutation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class HeapAlgorithmTest {
    @Test
    void uniqueness() {
        Permutation p = new HeapAlgorithm(5);
        HashSet<String> map = new HashSet<>();
        do {
            String key = p.toString();
            Assertions.assertFalse(map.contains(key));
            map.add(key);
        } while (p.next());
    }

    @Test
    void rewind() {
        Permutation p = new HeapAlgorithm(5);
        String key = p.toString();
        while (p.next()) {
            p.previous();
            Assertions.assertEquals(key, p.toString());
            p.next();
            key = p.toString();
        }
    }

    @Test
    void setBase() {
        Permutation a = new HeapAlgorithm(5);
        Permutation b = new HeapAlgorithm(5);
        do {
            Assertions.assertTrue(b.setBase(a.getBase()));
            Assertions.assertEquals(a, b);
        } while (a.next());
    }

}
