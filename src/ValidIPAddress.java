public class ValidIPAddress {
    public String validIPAddress(String queryIP) {
        if (queryIP.length() > 40)
            return "Neither";
        int len = queryIP.length();
        int count_m = 0;
        int count_d = 0;
        int count_n = 0;
        int count_a = 0;
        int count_o = 0;
        for (int i = 0; i < len; i++) {
            char c = queryIP.charAt(i);
            if ('0' <= c && c <= '9')
                count_n++;
            else if ('a' <= c && c <= 'f' || 'A' <= c && c <= 'F')
                count_a++;
            else if (c == ':')
                count_m++;
            else if (c == '.')
                count_d++;
            else
                count_o++;
        }
        if (count_o != 0)
            return "Neither";
        if (!(count_m == 0 && count_d == 3 || count_d == 0 && count_m == 7))
            return "Neither";
        if (count_m != 0)
            return IPV6(queryIP);
        else
            return count_a == 0 ? IPV4(queryIP) : "Neither";
    }

    String IPV4(String queryIP) {
        String[] substr = queryIP.split("\\.");
        if (substr.length != 4)
            return "Neither";
        for (String s: substr) {
            if (s.length() == 0)
                return "Neither";
            long num = Long.parseLong(s);
            if (num < 0 || num > 255)
                return "Neither";
            if (num != 0 && s.charAt(0) == '0' || num == 0 && s.length() != 1)
                return "Neither";
        }
        return "IPv4";
    }

    String IPV6(String queryIP) {
        String[] substr = queryIP.split(":");
        if (substr.length != 8)
            return "Neither";
        for (String s: substr) {
            if (s.length() <= 0 || s.length() > 4)
                return "Neither";
        }
        return "IPv6";
    }
}
