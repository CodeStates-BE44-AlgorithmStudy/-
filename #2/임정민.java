import java.util.*;

public class Solution2 {
    /*제한사항
    clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
    스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
    같은 이름을 가진 의상은 존재하지 않습니다.
    clothes의 모든 원소는 문자열로 이루어져 있습니다.
    모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
    스파이는 하루에 최소 한 개의 의상은 입습니다.*/

//    [["yellow_hat", "headgear"],
//    ["blue_sunglasses", "eyewear"],
//    ["green_turban", "headgear"]]

    // yello gear
    // blue  eye
    // green gear
    // yello gear, blue eye
    // green gear, blue eye
    // 총 5가지 경우의 수

    // 경우의 수 계산 (headgear의 개수 + 1) * (eyewear의 개수 + 1) - 1
    // 하나의 종류를 입지 않은경우도 포함해서 + 1
    // 헤드기어랑 선글라스 모두 입지 않은 경우 - 1

    public int solution(String[][] clothes) {
        Map<String, Integer> hashMap = new HashMap<>();

        for (String[] cloth : clothes) {
            String key = cloth[1];
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }

        int answer = 1;
        for (int count : hashMap.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}
