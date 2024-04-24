package algo_202404;

import java.util.*;

public class P_카드게임 {

	public static boolean[] check;
	public static int N;

	public int solution(int coin, int[] cards) {
		int answer = 0;

		N = cards.length;
		check = new boolean[N + 1];
		int index = N / 3;
		Queue<Integer> myCard = new ArrayDeque<>();
		for (int i = 0; i < index; i++) {
			check[cards[i]] = true;
			myCard.offer(cards[i]);
		}

		boolean[] addCard = new boolean[N + 1];
		int target = N + 1;
		while (true) {
			if (index >= N) {
				answer++;
				break;
			}
			for (int i = 0; i < 2 && index < N; i++) {
				addCard[cards[index]] = true;
				check[cards[index]] = true;
				myCard.offer(cards[index]);
				index++;
			}

			int size = myCard.size();
			boolean flag = false;

			// System.out.println("====== start =========");
			// System.out.println("check = "+ Arrays.toString(check));
			// System.out.println("addCard = "+ Arrays.toString(addCard));
			// System.out.println("myCard = "+ myCard);
			// System.out.println("coin = "+ coin);

			for (int s = 0; s < size; s++) {
				int card = myCard.poll();
				if (!check[card])
					continue;

				if (!flag) {
					if (check[target - card] && !addCard[card] && !addCard[target - card]) {
						check[card] = false;
						check[target - card] = false;
						flag = true;
					} else if (!addCard[card] && addCard[target - card] && coin >= 1) { // 새로 먹은 것 중에 있다면,
						coin--;
						addCard[target - card] = false;
						check[target - card] = false;
						check[card] = false;
						flag = true;
					} else if (addCard[card] && addCard[target - card] && coin >= 2) {
						coin -= 2;
						addCard[target - card] = false;
						addCard[card] = false;
						check[card] = false;
						check[target - card] = false;
						flag = true;
					} else {
						myCard.offer(card);
					}
				} else {
					myCard.offer(card);
				}
			}

			// System.out.println("check = "+ Arrays.toString(check));
			// System.out.println("addCard = "+ Arrays.toString(addCard));
			// System.out.println("myCard = "+ myCard);
			// System.out.println("coin = "+ coin);
			// System.out.println("===========");

			answer++;

			if (!flag) {
				break;
			}
		}

		return answer;
	}

}
