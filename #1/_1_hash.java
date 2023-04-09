import java.util.HashMap;

public class _1_hash {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }
    public static String solution(String[] participant, String[] completion) {
        /**
         * completion 배열에 있는 참가자는 무조건 participant에 포함된다.
         * 그러면 participant에는 값이 있지만 completion에 없는 참가자가 있을 것이다.
         * completion의 길이는 participant의 길이보다 1 작습니다. 라는 제한사항이 있음. 그러면 미완주자는 1명
         * 참가자 중에는 동명이인이 있을 수 있습니다...? -> 어떻게 구분하지,,? -> 일단 테스트케이스는 통과를 함.
         */
        String answer = "";
        // 해시맵? 활용해서 풀어보기
        HashMap<String, Integer> map = new HashMap<>();
        // 전체 참가자를 돌면서 각각의 이름을 key로 하고 value를 1로 하는 해시맵을 값을 추가
        for(String name : participant) {
            map.put(name, 1);
        }
        // 완주자를 돌면서 각각의 이름을 key로 하고 map에서 같은 key값이 있는 값들을 0으로 대체
        for(String name : completion) {
            map.put(name, 0);
        }
        // 완주자에서 이름이 없었던 참가자 이름은 value값이 0이 안됐을테니 answer값에 넣어준다.
        for(String name : participant) {
            if(map.get(name) != 0) {
                answer = name;
            }
        }
        return answer;
    }
}
