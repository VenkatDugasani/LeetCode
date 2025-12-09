class Solution {
    public boolean bfs(int node,int visited[],int distance[],int parent[],int[][] graph )
    {
        visited[node] = 1;
        distance[node] = 0;
        parent[node] = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty())
        {
            int v = q.poll();
            for(int nei: graph[v])
            {
                if(visited[nei] == 0)
                {
                    visited[nei] = 1;
                    parent[nei] = v;
                    distance[nei] = 1 +distance[v];
                    q.add(nei);
                    
                }
                else if(nei != parent[v])
                {
                    if(distance[nei] == distance[v]) 
                    return false;
                }
            }
        }
        return true;


    }
    public boolean isBipartite(int[][] graph) {

        // List<List<Integer>> g = new ArrayList<>();
        int n = graph.length;
        int visited[] = new int[n];
        int distance[] = new int[n];
        int parent[] = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(visited, 0);
        for(int i = 0; i < n; i++)
        {
            if(visited[i] == 0)
            {
                if(!bfs(i, visited, distance, parent, graph))
                {
                    return false;
                }
            }
        }
       return true;
        
    }
}