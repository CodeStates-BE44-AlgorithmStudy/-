import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        /**
         *  단 한 명만 완주에 실패
         *  1. 참가자 명단과 완주자 명단을 이름 순으로 정렬
         *  2. 두 배열을 한 명 씩 비교해서 같은 인덱스에 이름이 다른 사람이 있다면 해당 참가자는 완주에 실패한 것
         *  3. 완주자 명단을 기준으로 참가자 명단과 이름 비교
         *  4. 만약 이름이 다른 경우가 없을 경우 마지막 참가자가 완주에 실패한 것 => 모두 통과 한 경우는 없기 때문
         *
         *  기존
         *  participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
         *  completion = {"josipa", "filipa", "marina", "nikola"};
         *  => 정렬 후
         *  participant = {"filipa", "josipa", "marina", "nikola", "vinko"};
         *  completion = {"filipa", "josipa", "marina", "nikola"};
         *
         *  따라서 마지막 vinko가 완주에 실패
         *
         *  기존
         *  participant = ["mislav", "stanko", "mislav", "ana"]
         *  completion = ["stanko", "ana", "mislav"]
         *  =>정렬 후
         *  participant = ["ana", "mislav", "mislav", "stanko"]
         *  completion = ["ana", "mislav", "stanko"]
         *  두 번째 mislav에서 완주자의 이름과 다름 = 두 번째 mislav는 완주에 실패!
         */

        Arrays.sort(participant); // 이름 순 정렬
        Arrays.sort(completion); // 이름 순 정렬

        for(int i=0;i<completion.length;i++){   // 이름을 서로 비교하며 다른 이름이 나오면 해당 선수가 완주하지 못 한 선수
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[participant.length-1]; // 만일 모든 이름이 같다면 마지막 이름의 참가자가 완주하지 못 한 선수
    }
}
