//[Baekjoon C++] 웨이팅 [큐,정렬]
#include <iostream>
#include <queue>
#include <vector>
#include <map>
#include <list>
using namespace std;

class Person {
public:
    int reserveTime;
    int arriveTime;

    Person() : reserveTime(0), arriveTime(0) {}
    Person(int reserveTime, int arriveTime) {
        this->reserveTime = reserveTime;
        this->arriveTime = arriveTime;
    }
};

// 오름차순 정렬
struct ComparePerson {
    bool operator()(Person const& p1, Person const& p2) {
        if (p1.arriveTime == p2.arriveTime) {
            return p1.reserveTime > p2.reserveTime;
        }
        return p1.arriveTime > p2.arriveTime;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);

    int N;
    cin >> N;

    // 예약 시간 order/ 예약시간, 사람
    map<int, list<Person>::iterator> reserveMap;
    list<Person> reserveList;

    // 손님 대기열
    priority_queue<Person, vector<Person>, ComparePerson> personPq;

    for (int i = 0; i < N; i++) {
        int reserveTime, arriveTime;
        cin >> reserveTime >> arriveTime;
        personPq.push(Person(reserveTime, arriveTime));
    }

    int time = 0;
    int maxTime = 0;

    while (!personPq.empty() || !reserveList.empty()) {
        time++;
        // 손님 대기열 확인 (in)
        if (!personPq.empty()) {
            // 현재시간 == 도착시간일 때, 인원들 map에 채워넣기
            // 매 시간마다 도착한 손님들의 예약시간을 체크하고 map에 입력
            int curArrivalTime = personPq.top().arriveTime;
            if (time == curArrivalTime) {
                while (!personPq.empty() && personPq.top().arriveTime == curArrivalTime) {
                    Person person = personPq.top();
                    personPq.pop();
                    reserveList.push_back(person);
                    auto it = prev(reserveList.end());
                    reserveMap[person.reserveTime] = it;
                }
            }
        }

        // 예약 손님 확인 (out)
        if (!reserveMap.empty() && reserveMap.count(time)) {
            auto it = reserveMap[time];
            Person curPerson = *it;
            maxTime = max(maxTime, time - curPerson.arriveTime);
            reserveList.erase(it);
            reserveMap.erase(time);
        }
        else if (!reserveList.empty()) {
            auto it = reserveList.begin();
            int key = it->reserveTime;
            maxTime = max(maxTime, time - it->arriveTime);
            reserveList.erase(it);
            reserveMap.erase(key);
        }
    }

    cout << maxTime;
    return 0;
}