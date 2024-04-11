package algo_202403;

public class P_가장긴팰린드롬 {
	public int solution(String s)
	{
		int answer = 1;

		char[] array = s.toCharArray();
		int length = array.length;
		for(int i = 1; i < length-1; i++){
			int left = i-1;
			int right = i+1;
			int count = 1;
			while(left >= 0 && right < length){
				if(array[left] == array[right]){
					count += 2;
					left--;
					right++;
				}else{
					break;
				}
			}

			answer = Math.max(answer,count);
		}
		for(int i = 0; i < length-1; i++){
			if(array[i] == array[i+1]){
				// System.out.println("array[i] = "+array[i] + ", array[i+1] = "+array[i+1]);
				int left = i-1;
				int right = i+2;
				int count = 2;
				while(left >= 0 && right < length){
					if(array[left] == array[right]){
						count += 2;
						left--;
						right++;
					}else{
						break;
					}
				}
				answer = Math.max(answer,count);
			}
		}

		return answer;
	}
}
