T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for t in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    str_t = str(t)
    cnt = 0
    if '3' in str_t or '6' in str_t or '9' in str_t:
        cnt = str_t.count('3')+ str_t.count('6')+str_t.count('9')
        print('-'*cnt,end=' ')
    else:
        print(t,end=' ')