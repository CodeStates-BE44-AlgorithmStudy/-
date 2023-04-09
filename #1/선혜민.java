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
