import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        LinkedList<String> retire = new LinkedList<>(Arrays.asList(participant));
        retire.sort(Comparator.naturalOrder());
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++) {
            if(retire.get(0).equals(completion[i])) {
                retire.remove(0);
            }
            else if(retire.get(1).equals(completion[i])) { // 미 완주자가 중간에 나왔을 경우
                retire.remove(1); 
            }
        }

        answer = retire.get(0);
        return answer;
    }
}



//방법 2

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
