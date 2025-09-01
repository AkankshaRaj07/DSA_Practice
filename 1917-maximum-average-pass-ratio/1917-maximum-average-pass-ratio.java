

class Solution {
    private double calculateGain(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max-heap based on gain
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(
                calculateGain(b[0], b[1]),
                calculateGain(a[0], a[1])
            )
        );

        // Initialize heap
        for (int[] cls : classes) {
            maxHeap.offer(new int[]{cls[0], cls[1]});
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            int[] top = maxHeap.poll();
            top[0]++; // add passing student
            top[1]++; // add total student
            maxHeap.offer(top);
        }

        // Compute final result
        double totalRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            int[] cls = maxHeap.poll();
            totalRatio += (double) cls[0] / cls[1];
        }

        return totalRatio / classes.length;
    }
}
