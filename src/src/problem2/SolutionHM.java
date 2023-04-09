package problem2;
import java.util.HashMap;
import java.util.Iterator;
public class SolutionHM {
    public int solution(String[][] clothes) {

        // 1. 종류별 구분 : EX) headgear, eyewear ...
        HashMap <String, Integer> hash = new HashMap<>();
        for(String [] clothe : clothes){
            String type = clothe [1]; // 종류만 꺼내오는
            hash.put(type, hash.getOrDefault(type, 0) +1);
        }

        // 2. 입지 않는 경우를 추가하여 모든 조합 계산하기
        Iterator<Integer> it = hash.values().iterator();
        // 곱셈을 위해 answer에 1을 할당하며 선언
        int answer = 1;

        while(it.hasNext()){
            // hasNext : 읽어올 요소가 남아있는지 확인하는 메서드, 요소가 있으면 true, 없으면 false
            answer *= it.next().intValue() + 1;
            // next : 다음 데이터를 반환
            // intValue : ㅊ Integer 객체에서 int형 값을 뽑아내
            // +1 : 각 옷 종류에 대해서 안 입는 경우를 +1로 추가
            // EX) headgear에 속한 의상이 yellow_hat,green_turban 로 2개이기에 2가지 조건이 있으면서 이 두가지를 착용하지 않는다는 조건 한개도 있기에 +1로 총 조건은 3개가 되도록 하는 것이다
        }
        // 3. 아무종류의 옷도 입지 않는 경우 제외하기
        return answer - 1;
    }
}

