class Node {
    int n;
    int alter;
    public Node(int n, int alter) {
        this.n = n;
        this.alter = alter;
    }
}

class Solution {
    int RED = 1;
    int BLUE = 0;
    public void buildGraph(List<List<Integer>> adjList, int[][] edges) {
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> adjListRed = new ArrayList<>();
        List<List<Integer>> adjListBlue = new ArrayList<>();
        boolean[][] seen = new boolean[n][2];
        Queue<Node> queue = new LinkedList<>();
        int i = 0;
        int level = 0;
        queue.add(new Node(0, 0));
        queue.add(new Node(0, 1));
        int[] ans = new int[n];
        seen[0][0] = true;
        seen[0][1] = true;
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        while (i < n) {
            adjListRed.add(new ArrayList<>());
            adjListBlue.add(new ArrayList<>());
            i++;
        }
        buildGraph(adjListRed, redEdges);
        buildGraph(adjListBlue, blueEdges);
        while (!queue.isEmpty()) {
            i = 0;
            int size = queue.size();
            while (i < size) {
                Node node = queue.remove();
                int num = node.n;
                int alter = node.alter;
                boolean trigger = false;
                for (int red : adjListRed.get(num)) {
                    if (!seen[red][RED] && alter == BLUE) {
                        ans[red] = Math.min(ans[red], level + 1);
                        seen[red][RED] = true;
                        queue.add(new Node(red, RED));
                    }
                }
                for (int blue : adjListBlue.get(num)) {
                    if (!seen[blue][BLUE] && alter == RED) {
                        seen[blue][BLUE] = true;
                        ans[blue] = Math.min(ans[blue],level + 1);
                        queue.add(new Node(blue, BLUE));
                    }
                }
                i++;
            }
            level++;
        }
        i = 0;
        while (i < n) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
            i++;
        }
        return (ans);
        
    }
}
/*
        n = 3, redEdges = [[0,1],[1,2]] ==, blueEdges = [] --

            o==1==2 ans=[0, 1, -1]

            0{1} r
            0{} b
            1{2} r
            1{} b
            2{}r
            2{}b
            
            [0] l=0
            if (l % 2 == 0) {
                while (nei : adjLR.get(0))
                    ans[nei] = l + 1
            }else
                while (nei : adjLL.get(0))

                0,0 0,1         ans0=0
                1,0 alt = 1 l=1 ans1= 1
                2,1 alt = 0 l=2 ans2= 2
                3,0 alt = 1 l=3
                1,1 alt = 0 l=4
                2,0 al = 1 l=5
                3,1 alt=0 l =6
                4,0 alt=1 l=7
             
*/