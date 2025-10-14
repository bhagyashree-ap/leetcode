class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < p.length()){
            return result;
        }

        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, right = 0, len = p.length();
        int remaining = len;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (count[rChar - 'a'] > 0)
            {
                remaining--;
            }
            count[rChar - 'a']--;
            right++;

            if (remaining == 0)
            {
                result.add(left);
            }

            if (right - left == len) {
                char lChar = s.charAt(left);
                if (count[lChar - 'a'] >= 0)
                {
                    remaining++;
                }
                count[lChar - 'a']++;
                left++;
            }
        }

        return result;
    }
}
