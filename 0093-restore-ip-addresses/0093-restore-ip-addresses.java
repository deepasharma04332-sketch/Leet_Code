import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int startIndex, List<String> path, List<String> result) {
        if (path.size() == 4) {
            if (startIndex == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int i = startIndex; i < Math.min(startIndex + 3, s.length()); i++) {
            String part = s.substring(startIndex, i + 1);
            
            if (isValid(part)) {
                path.add(part);
                backtrack(s, i + 1, path, result);
                path.remove(path.size() - 1); 
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}