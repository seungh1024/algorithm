#include<bits/stdc++.h>
using namespace std;
 
vector <int> dp(90001, 1e9);
int n, m, k;
 
int main()
{
    cin >> n >> m >> k; dp[0] = 0;
    for (int i; n--;)
    {
        cin >> i;
        for (int j(i); j < 90001; j++)
            dp[j] = min(dp[j], dp[j - i] + 1);
    }
    for (int i(90000); !!~i; i--)
        if (!(i % k) && dp[i] <= m)
            cout << i, exit(0);
}