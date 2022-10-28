package org.example.myArray;

public class MyArray {

    public Integer sumArr(Integer[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public Integer size(Integer[] arr) {
        return arr.length + 1;
    }

    public boolean isEmpty(Integer[] arr) {
        boolean isEmpty = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                isEmpty = true;
                break;
            }
        }
        return isEmpty;
    }
}
