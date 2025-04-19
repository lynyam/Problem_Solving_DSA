class Solution {
    public boolean isMatch(String s, String p) {
    int i = 0, j = 0;
    int starIdx = -1;
    int match = 0;

    while (i < s.length()) {
        // Si les caractères correspondent ou que c’est '?'
        if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
            i++;
            j++;
        }
        // Si on trouve un '*', on enregistre sa position
        else if (j < p.length() && p.charAt(j) == '*') {
            starIdx = j;
            match = i;
            j++; // essayer de matcher à partir du prochain caractère dans p
        }
        // Si le précédent caractère était '*', on backtrack
        else if (starIdx != -1) {
            j = starIdx + 1;
            match++;
            i = match;
        }
        // Aucun match
        else {
            return false;
        }
    }

    // Vérifie que le reste de `p` ne contient que des '*'
    while (j < p.length() && p.charAt(j) == '*') {
        j++;
    }

    return j == p.length();
}

}