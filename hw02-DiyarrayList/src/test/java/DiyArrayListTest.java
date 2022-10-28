import org.example.DiyArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiyArrayListTest {

    private List<Integer> value;

    @BeforeEach
    void before() {
        value = new DiyArrayList<>();
        for (int i = 0; i < 5; i++) {
            value.add(i);
        }
    }

    @Test
    void sizeTest() {
        assertEquals(5, value.size());
    }

    @Test
    void isEmptyTest() {
        List<Integer> list = new DiyArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    void containsTest() {
        for (int i = 0; i < value.size(); i++) {
            assertEquals((int) value.get(i), i);
        }
    }

    @Test
    void addTest() {
        List<Integer> values = new DiyArrayList<>();
        for (int i = 0; i < 5; i++) {
            values.add(i);
        }
        assertArrayEquals(values.toArray(), value.toArray());
    }

    @Test
    void getTest() {
        for (int i = 0; i < value.size(); i++) {
            assertEquals(value.get(i), i);
        }
    }

    @Test
    void setTest() {
        value.set(2, 10);
        assertEquals(10, value.get(2));
    }

    @Test
    void getIllegalArgumentTest() {
        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> value.get(-1)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> value.get(value.size() + 15))
        );
    }

    @AfterEach
    void afterTests() {
        value = null;
    }

}
