import java.util.*;

class Solution {
    private Map<Integer, List<String>> memo = new HashMap<>();
    private Set<String> wordSet;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        return dfs(s, 0);
    }

    private List<String> dfs(String s, int start) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> validSentences = new ArrayList<>();

        if (start == s.length()) {
            validSentences.add("");
            return validSentences;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            
            if (wordSet.contains(prefix)) {
                List<String> subSentences = dfs(s, end);
                
                for (String sub : subSentences) {
                    if (sub.isEmpty()) {
                        validSentences.add(prefix);
                    } else {
                        validSentences.add(prefix + " " + sub);
                    }
                }
            }
        }

        memo.put(start, validSentences);
        return validSentences;
    }
}