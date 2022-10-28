import org.example.myArray.MyArray;
import org.example.annotation.After;
import org.example.annotation.Before;
import org.example.annotation.Test;
import org.example.exeption.FailedException;

public class MyArrayTest {
    private MyArray myArray;
    private Integer[] arr;

    @Before
    void addToArray() {
        myArray = new MyArray();
        try {
            arr = new Integer[3];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new FailedException(e.getMessage());
        }
    }

    @Test
    public void sumArray() {
        var sum = myArray.sumArr(arr);
        if (sum != 6) {
            throw new FailedException("Sum = 6");
        }
    }

    @Test
    void sizeArray() {
        var size = myArray.size(arr);
        if (size != 4) {
            throw new FailedException("size = " + (arr.length + 1));
        }
    }

    @Test
    void isEmpty() {
        var isEmpty = myArray.isEmpty(arr);
        if (!isEmpty) {
            throw new FailedException("Array is not empty");
        }
    }

    @After
    void deleteArr() {
        arr = new Integer[0];
    }
}
