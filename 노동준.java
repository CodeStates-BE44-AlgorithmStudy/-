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

//문제 2


import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        
        int answer = 1;
        int a = 0;
        ArrayList<String> list = new ArrayList<String>();
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            if(map.containsKey(clothes[i][1]) == false) {
                map.put(clothes[i][1], 2);
                list.add(a, clothes[i][1]);
                a++;
            }
            else map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        }
        
        for (int i = 0; i < list.size(); i++) {
            answer *= map.get(list.get(i));
        }
        
        
        
        return answer - 1;
        
    }
}
