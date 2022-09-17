package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void randomTest() {
        BuggyAList<Integer> list1 = new BuggyAList<>();
        final int N = 500;

        for (int i = 0; i < N; ++i) {
            int operation = StdRandom.uniform(0, 2);
            if (operation == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                list1.addLast(randVal);
                System.out.println("addLast("+randVal+")");
            } else if (operation == 1) {
                list1.removeLast();
                System.out.println("removeLast()");
            }
        }
    }
}
