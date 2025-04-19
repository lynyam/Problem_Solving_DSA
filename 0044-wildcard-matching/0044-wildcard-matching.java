class Solution {
    public boolean isMatch(String s, String p) {
        //clean input p ** => *
        if ((p == null || p.isEmpty()) && (s == null || s.isEmpty())) return (true);
        StringBuilder sb = new StringBuilder();
        int n = p.length();
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*' && i >= 1 && p.charAt(i - 1) == '*') continue;
            sb.append(p.charAt(i));
        }
        p = sb.toString();
        //System.out.println(p);

        List<Map<Character, Set<Integer>>> transitionTable = buildTransitionTable(p);
        return (simulate(s, transitionTable, p.length()));
    }

    public boolean simulate(String s, List<Map<Character, Set<Integer>>> transitionTable, int finalState) {
        Set<Integer> currStates = new HashSet<>();
        currStates.add(0);
        addEpsilonState(currStates, transitionTable);
        for (char c : s.toCharArray()) {
            Set<Integer> nextStates = new HashSet<>();
            for (Integer state : currStates) {
                if (transitionTable.get(state).containsKey(c)) {
                    nextStates.addAll(transitionTable.get(state).get(c));
                }
            }
            currStates = nextStates;
            addEpsilonState(currStates, transitionTable);
        }
        return (currStates.contains(finalState));
    }

    public void  addEpsilonState(Set<Integer> currStates, List<Map<Character, Set<Integer>>> transitionTable) {
        Queue<Integer> queue = new LinkedList<>(currStates);
        while (!queue.isEmpty()) {
            int state = queue.poll();
            if (transitionTable.get(state).containsKey('\0')) {
                for (int emptyState : transitionTable.get(state).get('\0')) {
                    if (!currStates.contains(emptyState)) {
                        queue.add(emptyState);
                        currStates.add(emptyState);
                    }
                }
            }
        }
    }

    List<Map<Character, Set<Integer>>> buildTransitionTable(String pattern) {
        int n = pattern.length();
        List<Map<Character, Set<Integer>>> delta = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            delta.add(new HashMap<>());
        }
        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            if (c == '?') {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    delta.get(i).putIfAbsent(ch, new HashSet<Integer>());
                    delta.get(i).get(ch).add(i + 1);
                }
            }
            else if (c == '*') {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    delta.get(i).putIfAbsent(ch, new HashSet<Integer>());
                    delta.get(i).get(ch).add(i + 1);
                    delta.get(i).get(ch).add(i);
                }
                delta.get(i).putIfAbsent('\0', new HashSet<Integer>());
                delta.get(i).get('\0').add(i + 1);
            } else {
                delta.get(i).putIfAbsent(c, new HashSet<Integer>());
                delta.get(i).get(c).add(i + 1);
            }
        }
        return (delta);
    }
}