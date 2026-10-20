class Solution {
    public String simplifyPath(String path) {
        String[] comps = path.split("/");
        List<String> list = new ArrayList<>();
        for (String comp : comps) {
            if (comp.equals("..")) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else if (!comp.isEmpty() && !comp.equals(".")) {
                list.add(comp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append("/").append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}