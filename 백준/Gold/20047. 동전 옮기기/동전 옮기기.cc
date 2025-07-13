#include <iostream>
#include <vector>
using namespace std;
vector<char> s, t;
bool dp[10001][3] = { false, };
char str[2];
int n;

int main() {
	cin >> n;

	for (int i = 0;i < n;i++) {
		char k;
		cin >> k;
		s.push_back(k);
	}
	for (int i = 0;i < n;i++) {
		char k;
		cin >> k;
		t.push_back(k);
	}
	int x, y;
	cin >> x >> y;

	str[0] = s[x]; str[1] = s[y];
	s.erase(s.begin() + x); s.erase(s.begin() + y - 1);
	s.push_back('n'); s.push_back('n'); //임의로 뒤에 채우기
	
	//초기화
	if (s[0] == t[0])
		dp[0][0] = true;
	if (t[0] == str[0])
		dp[0][1] = true;
        
	//점화식
	for (int i = 1;i < n;i++) {
		dp[i][0] = dp[i - 1][0] && (s[i] == t[i]);
		dp[i][1] = (dp[i - 1][0] && (str[0] == t[i])) || (dp[i - 1][1] && (s[i - 1] == t[i]));
		dp[i][2] = (dp[i - 1][1] && (str[1] == t[i])) || (dp[i - 1][2] && (s[i - 2] == t[i]));
	}

	//출력
	if (dp[n - 1][2])
		cout << "YES\n";
	else cout << "NO\n";
	
}