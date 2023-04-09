import java.util.HashMap;

public class _2_hash {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            // map에 같은 옷의 종류가 포함되어 있으면
            if(map.containsKey(clothes[i][1])) {
                // 옷의 종류에 해당하는 Value값을 1 더해준다. -> 옷의 종류를 출력하는 것이 아니니까 value값을 + 시킨다음 Value값들을 곱해주면 될듯.
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
                continue;
            }
            map.put(clothes[i][1], 1); // 옷을 추가해준다. 근데? 포함되어 있다면? 위에 조건 추가
        }
        // map에 있는 모든 value값을 곱해준다.
        for(String key : map.keySet()) {
            // 해당 옷의 종류를 입지 않는 경우 추가
            answer *= map.get(key) + 1;
        }
        // 모두 안입는 경우의 수를 빼준다.
        return answer -1;
    }
}
