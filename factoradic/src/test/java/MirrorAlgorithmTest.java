import com.progdigy.permutation.MirrorAlgorithm;
import com.progdigy.permutation.Permutation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class MirrorAlgorithmTest {

    @Test
    void uniqueness() {
        Permutation p = new MirrorAlgorithm(5);
        HashSet<String> map = new HashSet<>();
        do {
            String key = p.toString();
            Assertions.assertFalse(map.contains(key));
            map.add(key);
        } while (p.next());
    }

    @Test
    void rewind() {
        Permutation p = new MirrorAlgorithm(5);
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
        Permutation a = new MirrorAlgorithm(4);
        Permutation b = new MirrorAlgorithm(4);
        do {
            Assertions.assertTrue(b.setBase(a.getBase()));
            Assertions.assertEquals(a, b);
        } while (a.next());
    }

    @Test
    void setOrder() {
        Permutation a = new MirrorAlgorithm(4);
        Permutation b = new MirrorAlgorithm(4);
        do {
            Assertions.assertTrue(b.setOrder(a.getOrder()));
            Assertions.assertEquals(a, b);
        } while (a.next());

        Assertions.assertFalse(b.setOrder(new int[]{0,0,0,0}));
        Assertions.assertFalse(b.setOrder(new int[]{0,2,2,3}));
        Assertions.assertFalse(b.setOrder(new int[]{1,0,4,2}));
    }
}
