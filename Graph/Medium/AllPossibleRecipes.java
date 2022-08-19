// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
import java.util.*;
public class AllPossibleRecipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Set<String> set = new HashSet<>();
        int n = recipes.length;
        boolean found = true;

        for (String str : supplies)
            set.add(str);
        List<String> res = new ArrayList<>();

        while (found) {
            found = false;
            for (int i = 0; i < n; i++) {
                if (set.contains(recipes[i])) {
                    continue;
                }

                List<String> li = ingredients.get(i);
                boolean f = true;
                for (String s : li) {
                    if (!set.contains(s)) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    found = true;
                    set.add(recipes[i]);
                    res.add(recipes[i]);
                }
            }
        }
        return res;

    }
}

