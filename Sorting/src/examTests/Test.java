package examTests;

import java.util.*;

/**
 * Testkod för att testa kladder från tentor och så vidare :D
 */
public class Test {
    /*
    public static void main(String[] args) {
        int[] test1 = {4, 1, 4, 6, 4, 8, 9, 3, 6, 4, 10};
        int a = amountDublettes(test1);

    }

    public static int amountDublettes(int[] arr) {
        int dublicaptes = 0;

        //****PRINT
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(arr.length - 1, new OurComparator());
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        Iterator<Integer> hej = pq.iterator();

        //****PRINT
        for (int j = 1; j <= pq.size(); j++) {
            if (hej.hasNext()) {
                System.out.print(hej.next() + " ");
            }
        }
        System.out.println();

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
            System.out.println("bajs");
            comp = pq.poll();
        }
        return dublicaptes;
    }

    private static class OurComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return -1;
            } else if (o1 > o2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    */
}
