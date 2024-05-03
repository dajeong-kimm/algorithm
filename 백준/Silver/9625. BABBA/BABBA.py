n = int(input())

k = 0
a,b = 1,0
while True:
    tmp_a = a
    tmp_b = b
    a = tmp_b
    b = tmp_a+tmp_b
    k += 1
    if k == n:
        print(a,b)
        break