class Solution {
    private boolean dfs(int start, int l, int[] label, List<List<Integer>> graph )
    {
        label[start] = l;
        for(int nei : graph.get(start))
        {
            System.out.println(nei);
            if(label[nei] == -1)
            {
                if(!dfs(nei, 1-l, label, graph ))
                {
                    return false;
                }
            }
            else if(label[nei] == label[start])
            return false;

        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] label = new int[n+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: dislikes)
        {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);


        }
        Arrays.fill(label, -1);
        for(int i = 1 ; i <= n; i++)
        {
            if(label[i] == -1)
            {
                if(!dfs(i, 0, label, graph ))
                {
                    return false;
                }
            }
        }
        return true;
        
    }
}