l, r = map(int, input().split())

strL = str(l)
strR = str(r)

lenL = len(strL)
lenR = len(strR)

if lenL < lenR:
    strL = "0"*(lenR-lenL) + strL

print(strL)
# for i in range(l, r+1):
#     strL