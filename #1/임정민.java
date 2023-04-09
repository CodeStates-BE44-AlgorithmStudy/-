import java.util.*;

public class Solution1 {

    // ["leo", "kiki", "eden", "eden"] 참가자 명단. 동명이인이 있을 수 있음.
    // ["eden", "kiki", "leo"] 완주자 명단.
    // 완주하지 못한 사람을 리턴.

    // HashMap을 이용해 풀어보자

    // participant와 completion을 비교하면서 풀어야 할 것 같음.
    // 일단 participant를 해시맵에 저장. 주의할점은 동명이인.
    // 참가자를 순환해서 해시맵에 String, Integer로 저장 ("Leo", 1)
    // eden은 두명이니 ("eden", 2)로 저장
    // 완주자를 순환해 같은 이름이 나오면 value -1
    // 완주자중 eden은 한명이니 eden만 ("eden", 1)

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hashMap = new HashMap<>();

        for (String player : participant) {
            if (hashMap.containsKey(player)) {
                hashMap.put(player, hashMap.get(player) + 1);
            } else {
                hashMap.put(player, 1);
            }
        }

        for (String finishPlayer : completion) {
            hashMap.put(finishPlayer, hashMap.get(finishPlayer) - 1);
        }

        String answer = "";

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
}
