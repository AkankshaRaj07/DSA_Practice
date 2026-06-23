class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/+");
        StringBuilder sb = new StringBuilder();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } 
            else if (part.equals("..")) {
                if (sb.length() > 0) {
                    int lastSlash = sb.lastIndexOf("/");
                    sb.delete(lastSlash, sb.length());
                }
            } 
            else {
                sb.append("/").append(part);
            }
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}