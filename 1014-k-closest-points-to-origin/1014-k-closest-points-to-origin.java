class Solution {
    private final Random rand = new Random();

    public int[][] kClosest(int[][] points, int k) {

        if(points.length == k) return points;

        quickSelect(points, 0, points.length - 1, k - 1);

        return Arrays.copyOf(points, k);
    }
    public void quickSelect(int[][] A, int start, int end, int index){
        if(start == end) return;

        int pIndex = start + rand.nextInt(end - start + 1);

        swap(A, pIndex, start);

        long pivot = dist2(A[start]);

        int orange = start;

        for(int green = start; green <= end; green++){
            if(dist2(A[green]) < pivot){
                orange++;
                swap(A, orange, green);
            }
        }

        swap(A, start, orange);

        if(index == orange) return;
        else if(index < orange) quickSelect(A, start, orange - 1, index);
        else quickSelect(A, orange + 1, end, index); 
    }
    public long dist2(int[] p){
        return 1L * p[0] * p[0] + 1L * p[1] * p[1];
    }
    public void swap(int[][] A, int i, int j){
        int[] temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}