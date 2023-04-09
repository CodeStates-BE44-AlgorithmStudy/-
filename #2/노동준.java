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
