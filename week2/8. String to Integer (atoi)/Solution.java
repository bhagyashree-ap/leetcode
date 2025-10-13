class Solution {
    public int myAtoi(String s) {
        long num = 0;
        int i = 0, sign = 1;

        while (i<s.length() && s.charAt(i) == ' ')
        {
            i++;
        }

        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+'))
        {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }

        for (; i < s.length() && Character.isDigit(s.charAt(i)); i++)
        {
            num = num * 10 + (s.charAt(i) - '0');
            if (sign * num >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if (sign * num <= Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE;
            }
        }

        return (int)(sign * num);
    }
}
