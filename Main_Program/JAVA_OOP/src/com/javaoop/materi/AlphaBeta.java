package com.javaoop.materi;

public class AlphaBeta{
    public static void main(String[] args) {
        Solution test = new Solution();
        int piles[] = {10, 11, 9, 9,  14, 15, 2, 4, 5, 1,  4,  7,  9, 9, 3,  4};
        System.out.println(test.stoneGame(piles));
    }
}
class Solution {
    public boolean stoneGame(int[] piles) {
        return minimax(piles, 0, piles.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE, true) > 0;
    }
    private int minimax(int[] piles, int begin, int end,
                        int alpha, int beta, boolean maximizing) {
        if (begin > end) return 0;
        
        if (maximizing) {
            int val = Integer.MIN_VALUE;
            val = Math.max(val, minimax(piles, begin + 1, end, alpha, beta, false) + piles[begin]);
            alpha = Math.max(alpha, val);
            if (alpha >= beta) return val;
            val = Math.max(val, minimax(piles, begin, end - 1, alpha, beta, false) + piles[end]);
            return val;
        } else {
            int val = Integer.MAX_VALUE;
            val = Math.min(val, minimax(piles, begin + 1, end, alpha, beta, true) - piles[begin]);
            beta = Math.min(beta, val);
            if (alpha >= beta) return val; 
            val = Math.min(val, minimax(piles, begin, end - 1, alpha, beta, true) - piles[end]);
            return val;
        }
    }
}