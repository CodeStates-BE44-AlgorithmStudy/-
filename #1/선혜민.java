import java.util.Arrays;
public class SolutionHM {
    public String solution(String[] participant, String[] completion) {
        //수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
        // 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때
        // 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

        // 두 배열 다 오름차순으로 정렬해서 비교할 수 있도록 하기
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) { // 일치하지 않을때
                // completion[i]에 일치 하지 않는 participant[i] 값을 리턴
                return participant[i];
            }
        }
        // completion를 다 순회했을때 participant의 맨 마지막 요소가 낙오자라면
        return participant[participant.length-1];
    }
}

//해시 풀이

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
