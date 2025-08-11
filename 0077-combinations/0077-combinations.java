class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1, new ArrayList<>());
        return result;
    }

    public void helper(int n, int k, int i, List<Integer> slate){
        if(slate.size() == k){
            result.add(new ArrayList<>(slate));
            return;
        }

        if(i > n || slate.size() + (n - i + 1) < k) return;

        helper(n, k, i + 1, slate); //exclude

        //include;
        slate.add(i);
        helper(n, k, i + 1, slate);
        slate.remove(slate.size() - 1);
    }
}