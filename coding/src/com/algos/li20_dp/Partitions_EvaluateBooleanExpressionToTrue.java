package  com.algos.li20_dp;

public class Partitions_EvaluateBooleanExpressionToTrue {
    public static void main(String[] args) {
        Partitions_EvaluateBooleanExpressionToTrue obj = new Partitions_EvaluateBooleanExpressionToTrue();
        String exp = "F|T^F";
        System.out.println(obj.evaluateExp(exp));
        System.out.println(obj.evaluateExp2(exp));
    }

    public long evaluateExp(String exp) {
        int n = exp.length();
        return f(0, n - 1, 1, exp);
    }

    int mod = 1000000007;
    public long f(int i, int j, int isTrue, String exp) {
        // Base case 1:
        if (i > j)
            return 0;
        // Base case 2:
        if (i == j) {
            if (isTrue == 1){
                if (exp.charAt(i) == 'T') return 1;
                else return 0;
            } else {
                if (exp.charAt(i) == 'F') return 1;
                else return 0;
            }
        }

        long ways = 0;
        for (int ind = i + 1; ind <= j - 1; ind += 2) {
            long lT = f(i, ind - 1, 1, exp);
            long lF = f(i, ind - 1, 0, exp);
            long rT = f(ind + 1, j, 1, exp);
            long rF = f(ind + 1, j, 0, exp);

            if (exp.charAt(ind) == '&') {
                if (isTrue == 1)
                    ways = (ways + (lT * rT) % mod) % mod;
                else
                    ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lF * rF) % mod) % mod;
            } else if (exp.charAt(ind) == '|') {
                if (isTrue == 1)
                    ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lT * rT) % mod) % mod;
                else
                    ways = (ways + (lF * rF) % mod) % mod;
            } else {
                if (isTrue == 1)
                    ways = (ways + (lF * rT) % mod + (lT * rF) % mod) % mod;
                else
                    ways = (ways + (lF * rF) % mod + (lT * rT) % mod) % mod;
            }
        }
        return ways;
    }

    public long evaluateExp2(String exp) {
        int n = exp.length();
        
        long[][][] dp = new long[n][n][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= n - 1; j++) {
                //Base case 1:
                if (i > j) continue;
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    // Base case 2:
                if (i == j) {
                    if (isTrue == 1) {
                        if(exp.charAt(i) == 'T') dp[i][j][isTrue] = 1;
                        else dp[i][j][isTrue] = 0;
                    }else {
                        if(exp.charAt(i) == 'F') dp[i][j][isTrue] = 1;
                        else dp[i][j][isTrue] = 0;
                    }
                    continue;
                }

                // reccurence logic:
                long ways = 0;
                for (int ind = i + 1; ind <= j - 1; ind += 2) {
                    long lT = dp[i][ind - 1][1];
                    long lF = dp[i][ind - 1][0];
                    long rT = dp[ind + 1][j][1];
                    long rF = dp[ind + 1][j][0];

                    if (exp.charAt(ind) == '&') {
                        if (isTrue == 1) ways = (ways + (lT * rT) % mod) % mod;
                        else ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lF * rF) %
                         mod) % mod;
                    }
                    else if (exp.charAt(ind) == '|') {
                        if (isTrue == 1) ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lT *
                        rT) % mod) % mod;
                        else ways = (ways + (lF * rF) % mod) % mod;
                    }
                    else {
                        if (isTrue == 1) ways = (ways + (lF * rT) % mod + (lT * rF) % mod) % mod;
                        else ways = (ways + (lF * rF) % mod + (lT * rT) % mod) % mod;
                    }
                }
                dp[i][j][isTrue] = ways;
                }
            }
        }
        return dp[0][n - 1][1];
    }

}
