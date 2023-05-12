T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    testcase = int(input())
    stud = list(map(int,input().split()))
    score = [0] * 101
    
    for s in stud:
        score[s] += 1
        
    for sc in range(len(score)): ## 최빈값이 같을 때 높은 값을 프린트 해주어야해서 index를 사용할 수 없음
        if score[sc] == max(score):
            ans = sc

    print("#%d %d" %(testcase, ans))
    # ///////////////////////////////////////////////////////////////////////////////////