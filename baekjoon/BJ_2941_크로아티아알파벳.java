package day0221;

import java.io.*;
import java.util.*; 

public class BJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		System.out.println(croatia(data,0));
	}
	
	public static int croatia(String s, int count) {//start croatia
		StringBuilder sb = new StringBuilder();
		String check;
		for(char c : s.toCharArray()) {
			sb.append(c);
			check = sb.toString(); //sb를 문자열로 변환
			
			if(sb.length() == 3) {//앞 두 글자가 dz인 경우만 여기로 옴
				if(check.equals("dz=")) {//dz=이면 1개 추가
					count++;
					sb.setLength(0);//저장된 문자열 초기화
				}else {//아니면 '=' 으로 시작하는 글자가 없으므로 3개 추가
					count += 2;
					sb.delete(0,2);
				}
				
			}else if(sb.length() == 2) {
				if(check.equals("dz")) { //dz= 이 나올 수 있으므로 추가로 확인
					continue;
				}
				
				//해당 문자열이면 문자열 지우고 개수 +1
				if(check.equals("c=") || check.equals("c-") || check.equals("d-") || check.equals("lj") || check.equals("nj") || check.equals("s=") || check.equals("z=")) {
					sb.setLength(0);
				}else {//문자열이 아니라면 앞 자리만 똑 떼고 개수 +1
					sb.delete(0, 1);
//					System.out.println(sb);
				}
				count++;
				
			}
		}
//		System.out.println(sb);
//		System.out.print('\n');
		return count+sb.length();
	}//end croatia
}

