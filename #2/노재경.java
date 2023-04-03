import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        /**
         *  Map<의상의 종류, 의상의 갯수> 형태로 Map을 생성
         *  중복되는 이름의 의상이 없기 때문에 단순히 갯수로만 세는 것이 가능.
         *  이후 중복 공식 적용
         *  기본적으로 중복의 공식은 N x M 이지만, 해당 문제에서는 입지 않는다는 선택지도 존재
         *      ex - (노란 모자, 녹색 터번) / (파란 선글라스) 에서는 파라 선글라스만 착용이 가능하다.
         *      만일 기존의 조합이었다면 노란 모자와 녹색 터번 중 하나는 반드시 착용해야 한다.
         *  즉, N * M이 아니라 (N+1) * (M+1) 이 적용된다.
         *  또한 '입지 않는다'는 선택지를 조합에 추가했기 때문에 '아무것도 입지 않은 경우'를 빼줘야 한다.
         */
        int answer = 1;
        HashMap<String, Integer>clothMap = new HashMap<>();

        /**
         * Map 구성
         */
        for (String[] clothe : clothes) {
            if (clothMap.containsKey(clothe[1])) { // 이미 의상의 종류가 맵에 있다면 
                clothMap.put(clothe[1], clothMap.get(clothe[1])+1); // 갯수를 하나 늘린다.
                continue;
            }
            clothMap.put(clothe[1], 1); // 의상의 종류가 맵에 없다면, 의상의 종류가 1개 있음을 맵에 추가한다.
        }

        for(String key : clothMap.keySet()){
            answer*=clothMap.get(key)+1; // (N+1) * (M+1)을 계산한다.
        }

        return answer-1; // 아무것도 입지 않은 경우를 제거한다.
    }
}
