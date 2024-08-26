class Solution {
    HashMap<String, HashMap<String, Double>> graph;
    int n;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        n = values.length;
        int i = 0;
        double[] ans = new double[queries.size()];
        
        for (List<String> eq : equations) {
            String num = eq.get(0);
            String den = eq.get(1);
            double quotien = values[i++];
            graph.putIfAbsent(num, new HashMap<String, Double>());
            graph.putIfAbsent(den, new HashMap<String, Double>());
            graph.get(num).put(den, quotien);
            graph.get(den).put(num, 1 / quotien);
        }
        i = 0;
        for (List<String> query : queries) {
            String num = query.get(0);
            String den = query.get(1);
            if (!graph.containsKey(num) || !graph.containsKey(den)) {
                ans[i++] = -1.0;
                continue ;
            }
            double res = dfs(num, den, 1.0, new HashSet<String>());
            ans[i++] = res == Double.MIN_VALUE ? -1.0 : res;
        }
        return (ans);
    }

    public double dfs(String num, String den, double quotian, HashSet<String> seen) {
        double ans = Double.MIN_VALUE;
        if (num.equals(den))
            return (quotian);
        seen.add(num);
        HashMap<String, Double> connexion = graph.get(num);
        for (String key : connexion.keySet()) {
            if (!seen.contains(key)) {
                ans = Math.max(ans, dfs(key, den, quotian * connexion.get(key), seen));
            }
        }
        return (ans);
    }
}
/**
    - eq List<List<String>>
        - eq[i] = [ai, bj]
    - value double[]
        - val[i] = ai / bi
    - q[i] = [cj, dj] jth  query
        - u must find as cj/dj =?
    - ans off all q[i] | -1
    - ex :
        - equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        - [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 */