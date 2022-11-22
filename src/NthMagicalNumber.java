public class NthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        int M = 1000000007;
        int lcm = lcm(a, b);
        long conclude = lcm / a + lcm / b - 1;
        long mul = n / conclude;
        long ans = mul * lcm % M;
        if (n % conclude == 0)
            return (int) ans;
        int cnt = 1;
        int na = (a < b ? a : 0);
        int nb = (a < b ? 0 : b);
        int res = Math.max(na, nb);
        while (cnt < n % conclude) {
            if (na + a < nb + b) {
                na += a;
                res = na;
            }
            else {
                nb += b;
                res = nb;
            }
            cnt++;
        }
        return (int) (((ans + res) % M) % M);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
