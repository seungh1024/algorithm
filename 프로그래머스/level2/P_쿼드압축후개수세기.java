package algo_202401;

import java.util.Arrays;

public class P_쿼드압축후개수세기 {
	public static void main(String[] args) {
		P_쿼드압축후개수세기 test = new P_쿼드압축후개수세기();
		int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
		int[] answer = test.solution(arr);
		int[] result = {4,9};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static int[] count;

	public int[] solution(int[][] arr) {
		count = new int[2];
		int length = arr.length;
		find(arr,0,0,length);
		return count;
	}

	public static void find(int[][] arr, int x, int y, int length){
		int ex = x+length;
		int ey = y+length;
		int target = arr[x][y];
		boolean check = false;
		for(int i = x; i < ex; i++){
			for(int j = y; j < ey; j++){
				if(arr[i][j] != target){
					check = true;
					break;
				}
			}
			if(check){
				break;
			}
		}
		// 전부 같지 않은 경우
		if(check){
			int nextLength = length/2;
			find(arr,x,y,nextLength);
			find(arr,x+nextLength,y,nextLength);
			find(arr,x,y+nextLength,nextLength);
			find(arr,x+nextLength,y+nextLength, nextLength);
		}else{ //전부 같은 경우
			count[target]++;
		}
	}
}
