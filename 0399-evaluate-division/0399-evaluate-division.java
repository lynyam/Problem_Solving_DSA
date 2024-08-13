class Solution {
    HashMap<String, HashMap<String, Double>> graph;

    public void buildGraph(List<List<String>> equations, double[] values) {
        int i = 0;
        int n = equations.size();

        while (i < n) {
            List<String> eq = equations.get(i);
            String dividand = eq.get(0);
            String diviseur = eq.get(1);
            double quotien = values[i];
            double invQuotien = 1 / values[i];
            graph.putIfAbsent(dividand, new HashMap<String, Double>());
            graph.putIfAbsent(diviseur, new HashMap<String, Double>());
            graph.get(dividand).put(diviseur, quotien);
            graph.get(diviseur).put(dividand, invQuotien);
            i++;
        }

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        int i = 0;
        int n = queries.size();
        double[] ans = new double[n];

        buildGraph(equations, values);
        for (List<String> query : queries) {
            String dividand = query.get(0);
            String diviseur = query.get(1);
            if (!graph.containsKey(dividand) || !graph.containsKey(diviseur)) {
                ans[i++] = -1.0;
                continue ;
            }
            double res = dfs(dividand, diviseur, 1.0, new HashSet<String>());
            ans[i++] = res == Double.MAX_VALUE ? -1.0 : res;
        }
        return (ans);
    }

    public double dfs(String dividand, String diviseur, double ans, HashSet<String> seen) {
        double res = Double.MAX_VALUE;
        
        seen.add(dividand);
        if (dividand.equals(diviseur)) {
            return (ans);
        }
        HashMap<String, Double> neighbor = graph.get(dividand);
        for (String bridge : neighbor.keySet()) {
            if (!seen.contains(bridge)) {
                res = Math.min(res, dfs(bridge, diviseur, ans * neighbor.get(bridge), seen));
            }
        }
        return (res);

    }
}
/*
     - eq Pair[]
        - eq[i] = [Ai, Bi]
     - val double[]
        - val[i] = Ai/ Bi => result of eq[i]
    - Ai or Bi represent String single var
    - queries
        - queries[j] = [Cj, Dj] jth query to answ Cj / Dj
    - ret asw of all queries | -1.0 if not
    - if var not occ in list of eq, ans = -1.0


*/