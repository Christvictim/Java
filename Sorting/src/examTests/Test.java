package examTests;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Morpheus on 2016-03-11.
 */
public class Test {
    public static void main(String[] args) {
        int[] test1 = {4, 1, 4, 6, 4, 8, 9, 3, 6, 4, 10};
        int a = amountDublettes(test1);

    }

    public static int amountDublettes(int[] arr) {
        int dublicaptes = 0;

        for (int j = 0; j < arr.length; j++){
            System.out.print(arr[j] + " ");
        }
        System.out.println();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        Iterator<Integer> hej = pq.iterator();
        for (int j = 1; j <= pq.size(); j++){
            if (hej.hasNext()){
                System.out.print(hej.next() + " ");
            }
        }

        Integer comp = pq.poll();

        while (!pq.isEmpty()) {
            int tmp = 0;
            Iterator<Integer> iter = pq.iterator();
            try {
                while (iter.hasNext()) {
                    if (iter.next().equals(comp)) {
                        tmp++;
                    } else {
                        dublicaptes = dublicaptes + tmp;
                        break;
                    }
                }
            } catch (ConcurrentModificationException e) {
                System.out.println("nej");
            }
            comp = pq.poll();
        }
        return dublicaptes;
    }
}
