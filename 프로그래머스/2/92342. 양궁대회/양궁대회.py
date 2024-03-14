from itertools import combinations_with_replacement
from collections import Counter
def solution(n, info):
    maxdiff, max_comb = 0, {}
    # 1. 주어진 조합에서 각각의 점수 계산
    # combi : 라이언이 각 과녁을 맞춘 화살 수를 기록 (키 : 과녁 점수, 값 : 과녁에 맞힌 화살 수)
    # score1 : 어피치, score2 : 라이언
    def calculate_score(combi):
        score1, score2 = 0,0
        for i in range(1,11):
            if info[10-i] < combi.count(i):
                score1 += i
            elif info[10-i] > 0 :
                score2 += i
        return score1, score2
    
    # 2. 최대 차이와 조합 저장
    # 라이언과 어피치의 점수 차이가 가장 클 때의 점수 차이와 라이언의 과녁 점수 정보를 갱신
    def calculate_diff(diff, cnt):
        nonlocal maxdiff, max_comb
        if diff>maxdiff:
            max_comb = cnt
            maxdiff = diff
    
    # 3. 가능한 라이언의 과녁 점수 조합의 모든 경우에 대해서 체크
    for combi in combinations_with_replacement(range(11),n):
        cnt = Counter(combi)
        score1, score2 = calculate_score(combi)
        diff = score1 - score2
        calculate_diff(diff, cnt)
    
    # 4. 최대 차이가 0 이상인 경우, 조합 반환
    if maxdiff > 0:
        answer = [0]*11
        for n in max_comb:
            answer[10-n] = max_comb[n]
        return answer
    else: # 5. 최대 차이가 0인 경우, -1 반환
        return [-1]
    
    