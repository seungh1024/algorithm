

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long A, LA = 0, HA = 0; // lower answer, higher answer
	static int oneCnt = 0;         // 현재 k보다 낮은 비트(0..k-1)에 있는 1의 개수
	static long one = 1L;          // 2^k
	static long mask = 3L;         // (11) << k  => (k+1, k) 두 비트를 보는 창

	static long nearestLower(long A, long one, long mask, int oneCnt) {
		long x = A ^ mask;                 // (10)->(01)로 스왑 (호출 조건이 10일 때만!)

		while ((one >> 1L) > 0) {
			one >>= 1L;
			if (oneCnt > 0) {
				oneCnt--;
				x |= one;
			} else {
				if ((x & one) != 0) {
					x -= one;
				}
			}
		}
		return x;
	}

	static long nearestHigher(long A, long one, long mask, int oneCnt) {
		long x = A ^ mask;                 // (01)->(10)로 스왑 (호출 조건이 01일 때만!)
		long idx = 0;
		while (((1L << idx) & mask) == 0) {
			if (oneCnt > 0) {
				oneCnt--;
				x |= (1L << idx);
			} else {
				if ((x & (1L << idx)) != 0) {
					x -= 1L << idx;
				}
			}
			idx++;
		}
		return x;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Long.parseLong(br.readLine());

		// LSB -> MSB로 창(두 비트)을 옮기며 첫 10(아래), 첫 01(위)을 찾는다.
		for (int k = 0; k < 63; k++) {
			if (LA != 0 && HA != 0)
				break;

			long bits = A & mask;

			// 창이 10이면: 10->01로 바꾸면 값이 감소, popcount는 유지 => "가장 가까운 작은 수" 후보
			if (LA == 0 && bits == (one << 1L)) {
				LA = nearestLower(A, one, mask, oneCnt);
			}

			// 창이 01이면: 01->10로 바꾸면 값이 증가, popcount는 유지 => "가장 가까운 큰 수" 후보
			if (HA == 0 && bits == one) {
				HA = nearestHigher(A, one, mask, oneCnt);
			}

			// 다음 k로 넘어가기 전에, 현재 bit(k)가 1이면 oneCnt에 반영 (다음 창의 "아래쪽 1 개수")
			if ((A & one) != 0)
				oneCnt++;

			one <<= 1L;
			mask <<= 1L;
		}

		System.out.println(LA + " " + HA);
	}

}
