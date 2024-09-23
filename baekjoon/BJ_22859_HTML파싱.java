package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_22859_HTML파싱 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String html = br.readLine();
		html = html.replace("<main>","");
		html = html.replace("</main>","");
		String[] divs = html.split("</div>");

		StringBuilder sb = new StringBuilder();
		for (String div : divs) {
			String[] ps = div.split("<p>");
			sb.append("title : ").append(parsingDiv(ps[0])).append("\n");
			for (int i = 1; i < ps.length; i++) {
				sb.append(parsingP(ps[i])).append("\n");
			}
		}

		// System.out.println("result");
		System.out.println(sb);
	}

	public static String parsingP(String p) {
		StringBuilder sb = new StringBuilder();
		char[] data = p.toCharArray();
		boolean flag = false;
		for (int i = 0; i < data.length; i++) {
			if (flag) {
				if(data[i] == '>'){
					flag = false;
				}
				continue;
			}
			if(data[i] == '<'){
				flag = true;
				continue;
			}
			sb.append(data[i]);
		}
		char[] noTagData = sb.toString().toCharArray();
		StringBuilder result = new StringBuilder();

		int end = noTagData.length;
		for(int i = noTagData.length - 1; i >= 0; i--){
			if(noTagData[i] != ' ') break;
			end = i;
		}
		for(int i = 0; i < end; i++){
			if(i > 0 && noTagData[i] == ' ' && noTagData[i-1] == noTagData[i]) continue;
			result.append(noTagData[i]);
		}

		// System.out.println("p = "+result);
		return result.toString();
	}

	public static String parsingDiv(String div){
		char[] data = div.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean title = false;
		for (char c : data) {
			if(c == ' ' && !title) {
				sb = new StringBuilder();
				continue;
			}
			if(c == '\"'){
				if (Objects.equals(sb.toString(),"title=")) {
					sb = new StringBuilder();
					title = true;
					continue;
				} else if(title) {
					break;
				}
			}
			sb.append(c);
		}

		// System.out.println("title = "+sb);
		return sb.toString();
	}
}
