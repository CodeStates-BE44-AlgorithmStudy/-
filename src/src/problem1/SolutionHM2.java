package problem1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class SolutionHM2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 이 문제에서 Key는 Participant의 이름, Value는 Count가 되기에 --> String/Integer
        HashMap<String, Integer> hash = new HashMap<>();

        for (String player : participant)
            // HashMap.put(Key,Value)
            // getOrDefault : Key에 해당하는 Value가 없을 경우 default로써 0을 반환
            // participant에 있는 player이라면 valuer 값에 1을 각각 할당 해주게 됨
            hash.put(player, hash.getOrDefault(player, 0) + 1);

        // 순회하면서 완주자의 value에는 0이 할당되고 완주자에 없는 낙오자라면 1 그대로 남아 구분하게됨
        for (String player : completion)
            hash.put(player, hash.get(player) - 1);

        Iterator<Map.Entry<String, Integer>> it = hash.entrySet().iterator();

        while(it.hasNext()){ // 다음 객체가 있을 동안
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() != 0){ // 0이 아니라면 곧 낙오자라면 !
                answer = entry.getKey(); // key가 결국 player를 뜻하기에
                break;
            }
        }
        return answer;
    }
}
