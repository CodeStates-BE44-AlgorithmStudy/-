import java.util.*;
class Solution {
public static String solution(String[] participant, String[] completion) {
    // 참가자 명단의 한명만 완주 명단에 없음
    // 동명 이인의 숫자 세기가 키포인트
    // 해쉬 맵에 이름 : 명수로 기록
    // 이후 탈락자 찾기
    String answer = "";

    Map<String, Integer> hm = new HashMap<>();
	
    //참가자 명단을 반복문으로 해쉬맵에 추가
    for (String p : participant) {
        if(hm.containsKey(p)){
        hm.put(p, hm.get(p)+1);
        } else hm.put(p,1);
    }
    
    //완주자 명단을 반복문으로 해쉬맵에서 줄이기
    for (String c : completion) {
        hm.put(c, hm.get(c) - 1);
    }
    
    //완주 못한사람 찾기
    for (String key : hm.keySet()) {
        if (hm.get(key) != 0) {
            answer = key;
            break;
        }
    }

    return answer;
}
}
