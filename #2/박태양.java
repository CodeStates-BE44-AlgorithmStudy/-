import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        //경우의수 구하기
        //옷 종류 : 키 , 옷 개수 : 값
        //keyset > 값1 * 값2 ... 
        int answer = 1;
        Map<String, Integer> hm = new HashMap<>();
        
        //옷 이름은 상관 x 종류 + 숫자 로 해쉬맵에 추가
        for(String[] c : clothes) {
            if(hm.containsKey(c[1])) {
                hm.put(c[1],hm.get(c[1])+1);
            }else hm.put(c[1],1);
    }
        //경우의수 구하기
        //+1 은 안입는 옷의 경우 확통 문제
        for (String key : hm.keySet()) {
            answer *= hm.get(key)+1;
        }
        return answer - 1;
    }
}
