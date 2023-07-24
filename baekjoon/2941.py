str = input()

arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="}

check1 = {"s", "z", "c"}
check2 = {"c", "d"}
check3 = {"l", "n"}
cnt = 0
for i in range(len(str)):
    if str[i] == '=':
        if i>0 and str[i-1] in check1:
            cnt += 1
            if i>1 and str[i-1] == "z" and str[i-2] == "d":
                cnt += 1
    elif str[i] == '-':
        if i>0 and str[i-1] in check2:
            cnt += 1
    elif str[i] == 'j':
        if i>0 and str[i-1] in check3:
            cnt += 1

print(len(str)-cnt)
