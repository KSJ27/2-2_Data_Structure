import java.util.*;

import static java.util.Collections.*;

class Bubble<T extends Comparable<T>> {
    private T[] result;

    T[] Sorting(T [] arr) {
        this.result = arr.clone();

        for (int i = result.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(result[j].compareTo(result[j+1]) > 1) swap(List.of(result), j, j+1);
            }
        }
        return result;
    }
}



