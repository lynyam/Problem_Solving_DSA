class Solution {
    HashMap<String, HashMap<String, Double>> graph;

    public void buildGraph(List<List<String>> eq, double[] v) {
        int i = 0;
        int n = eq.size();
        while (i < n) {
            String from = eq.get(i).get(0);
            String to = eq.get(i).get(1);
            graph.putIfAbsent(from, new HashMap<String, Double>());
            graph.putIfAbsent(to, new HashMap<String, Double>());
            graph.get(from).put(to, v[i]);
            graph.get(to).put(from, (1 / v[i]));
            i++;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        int n = queries.size();
        double[] ans = new double[n];
        int i = 0;
        
        buildGraph(equations, values);
        for (List<String> query : queries) {
            if (!graph.containsKey(query.get(0)) || !graph.containsKey(query.get(1))) {
                ans[i] = -1.0;
                i++;
                continue ;
            }
            Double ret = dfs(query.get(0), query.get(1), 1.0, new HashSet<String>());
            ans[i] = ret == Double.MIN_VALUE ? -1 : ret;
            i++;
        }
        return (ans);
    }

    public double dfs(String from, String to, double ans, HashSet<String> seen) {
        double ret = Double.MIN_VALUE;
        seen.add(from);
        if (from.equals(to))
            return (ans);
        HashMap<String, Double> neighborMap = graph.get(from);
        if (neighborMap != null) {
            for (String neighbor : neighborMap.keySet()) {
                if (!seen.contains(neighbor)) {
                    ret = Math.max(ret, dfs(neighbor, to, ans * neighborMap.get(neighbor), seen));
                }
            }
        }
        return (ret);
    }
}
/*
    - eq Pair<>[]
        - eq[i] = [Ai, Bi]
    - val int[]
        - val[i] = Ai/Bi, Ai, Bi String single variable
    - q/ q[j] = [Cj, Dj] jth query to find for Cj/Dj
    -ret: ans of all q[j] not sigle ans ret -1
    - no division by 0, if var not in list res = -1;
 
*/