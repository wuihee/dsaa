package dsaa.sorting;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Bucket sort assumes the input is drawn from a uniform distribution and has an
 * average runtime
 * of O(n).
 */
public class BucketSort {

    /**
     * Sorts a floating point array with a specified number of buckets.
     * 
     * @param A
     * @param n
     */
    public void sort(float[] A, int n) {
        List<Float>[] buckets = new ArrayList[n];

        // Create empty buckets.
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        // Add elements into the buckets.
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) A[i] * n;
            buckets[bucketIndex].add(A[i]);
        }

        // Sort the elements of each bucket.
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Combine the sorted arrays.
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0, size = buckets[i].size(); j < size; j++) {
                A[index++] = buckets[i].get(j);
            }
        }
    }
}
