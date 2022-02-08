package SWExpertAcademy;

public class Solution_1228_암호문1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case<=10; test_case++) {
			LinkedList<String> link = new LinkedList<>();
			int first = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//원본 데이터 입력
			for(int i = 0; i < first; i++) {
				link.add(st.nextToken());
			}
			//세번째 줄
			int third = Integer.parseInt(br.readLine());
			//네번째 줄
			st = new StringTokenizer(br.readLine(),"I");
			
//			for(int i = 0; i < third; i++) {
//				System.out.println(st.nextToken());
//			}
			
			for(int i = 0; i < third; i++) {
				//I로 구분한 것을 다시 공백으로 구분함
				StringTokenizer order = new StringTokenizer(st.nextToken());
				//index
				int x = Integer.parseInt(order.nextToken());
				//number
				int y = Integer.parseInt(order.nextToken());
				
				for(int j = 0; j < y; j++) {
					//각 순서에 맞게 삽입
					link.add(x,order.nextToken());
//					System.out.println(order.nextToken());
					x++;//index가 증가하므로 더해짐
				}
			}
			
			
			
			Iterator<String> result = link.iterator();
			StringBuilder sb = new StringBuilder();
			sb.append("#"+test_case+" ");
			for(int i = 0; i <10; i++) {
				sb.append(result.next()).append(" ");
			}
			System.out.println(sb);
//			sb.delete(0, sb.length());
			sb.setLength(0);
//			System.out.println(sb);
			
			
		}
	}

}

//#1 449047 400905 139831 408347 512816 992679 693002 835918 768525 949227 
//#2 150706 600576 565945 486128 594841 566753 244528 233616 556294 697547 
//#3 973313 271510 434200 132826 186343 308937 115088 438559 139738 948108 
//#4 505428 811504 426664 713940 855599 655028 878767 259061 870009 141255 
//#5 267162 670435 488135 605710 353909 276272 171102 871819 129966 404856 
//#6 192530 407162 275094 303667 851080 385930 909225 863939 286381 776616 
//#7 136752 320395 397751 875871 683248 246614 942192 856739 914031 556177 
//#8 482032 518037 513679 145989 422525 497171 841413 364367 572438 104109 
//#9 438278 128145 818986 814573 692305 541108 569934 812165 774081 789114 
//#10 596308 376463 344210 520543 173961 644251 888643 787798 136503 153477 

