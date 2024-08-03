class Solution {
    HashMap<String, HashMap<String, Double>> graph;
    int n;

    public void buildGraph(List<List<String>> equations, double[] values) {
        int i = 0;
        while (i < n) {
            String dividend = equations.get(i).get(0);
            String diviseur = equations.get(i).get(1);
            graph.putIfAbsent(dividend, new HashMap<String, Double>());
            graph.putIfAbsent(diviseur, new HashMap<String, Double>());
            graph.get(dividend).put(diviseur, values[i]);
            graph.get(diviseur).put(dividend, (1 / values[i]));
            i++;
        }

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        int i = 0;
        n = equations.size();
        int m = queries.size();
        double[] ans = new double[m];

        buildGraph(equations, values);
        while (i < m) {
            String dividend = queries.get(i).get(0);
            String diviseur = queries.get(i).get(1);
            if (!graph.containsKey(dividend) || !graph.containsKey(diviseur)) {
                    ans[i] = -1.0;
                    i++;
                    continue ;
            }
            HashSet<String> seen = new HashSet<>();
            seen.add(dividend);
            double res = dfs(dividend, diviseur, 1.0, seen);
            
            ans[i] = res == Double.MIN_VALUE ? -1 : res;
            i++;
        }
        return (ans);
    }

    public double dfs(String dividend, String diviseur, double ans, HashSet<String> seen) {
        if (dividend.equals(diviseur))
            return (ans);
        if (graph.containsKey(dividend)) {
            HashMap<String, Double> couples = graph.get(dividend);
            for (String neighbor : couples.keySet()) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    double res = dfs(neighbor, diviseur, ans * couples.get(neighbor), seen);
                    if (res == Double.MIN_VALUE)
                        continue ;
                    return (res);
                }
            }
        }
        return (Double.MIN_VALUE);
    }
}