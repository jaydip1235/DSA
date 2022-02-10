// https://leetcode.com/problems/reveal-cards-in-increasing-order/
import java.util.*;
public class RevealCardsInAsc {
    public int[] deckRevealedIncreasing(int[] deck) {

        int n = deck.length;
        Arrays.sort(deck);
        LinkedList<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            que.addLast(i);
        }
        int[] ans = new int[n];
        int pointer = 0;
        boolean turn = true;
        while (que.size() > 0) {
            if (turn == true) {
                ans[que.removeFirst()] = deck[pointer++];
            } else {
                que.addLast(que.removeFirst());
            }
            turn = !turn;
        }
        return ans;
    }
}
