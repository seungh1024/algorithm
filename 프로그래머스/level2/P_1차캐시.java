package algo_202401;

import java.util.*;

public class P_1차캐시 {
	public static void main(String[] args) {
		P_1차캐시 test = new P_1차캐시();
		int cacheSize = 5;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
			"NewYork", "Rome"};
		int result = 52;
		int answer = test.solution(cacheSize, cities);
		if (result == answer) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int cacheSize, String[] cities) {
		int answer = 5; // 첫 도시 미스나니 5부터 시작

		int length = cities.length;
		int size = 1;

		if(cacheSize == 0){
			return length*5;
		}
		if(length == 0){
			return 0;
		}

		Map<String,City> map = new HashMap<>(); // 있는지 없는지 체크
		String firstCityName = cities[0].toLowerCase();
		City first = new City(firstCityName);
		map.put(firstCityName,first);
		City old = new City("old");
		old.before = first;
		City young = new City("young");
		young.next = first;
		first.next = old;
		first.before= young;


		for(int i = 1; i <length; i++){
			String city = cities[i].toLowerCase();
			if(map.get(city) == null){ // miss
				if(size >= cacheSize){ // 크기 초과면 기존걸 쫓아내야 함
					size--;
					City oldCity = old.before; // 가장 오래된 도시
					City newOldCity = oldCity.before; // 새롭게 오래된 도시
					old.before = newOldCity;
					newOldCity.next = old;
					// map.remove(oldCity.name);
					map.put(oldCity.name,null); // 오래된 도시를 Null로 바꿔줌
				}
				City newCity = new City(city);
				City nextCity = young.next;
				young.next = newCity; //young 포인터 변경
				newCity.next = nextCity; // 새로운 도시 다음에 기존 도시를 추가
				newCity.before = young; // 새로운 도시 이전이 young 포인터
				nextCity.before = newCity;

				map.put(city,newCity);
				answer += 5;
				size++;
			}else{ // hit
				City hitCity = map.get(city);
				City nextCity = hitCity.next;
				City beforeCity = hitCity.before;
				nextCity.before = beforeCity;
				beforeCity.next = nextCity;

				City youngCity = young.next;
				hitCity.next = youngCity;
				hitCity.before = young;
				young.next = hitCity;
				youngCity.before = hitCity;

				answer++;
			}
		}

		return answer;
	}

	public static class City{
		String name;
		City before, next;

		public City(String name){
			this.name= name;
		}

		@Override
		public String toString(){
			return "name: "+name;
		}
	}
}
