t = int(input())

for _ in range(t):
    is_ana = False
    a,b = map(str,input().split())
    a_list = list(a)
    b_list = list(b)
    if len(a_list) != len(b_list):
        print(f"{a} & {b} are NOT anagrams.")
        
    else:
        for i in range(len(a_list)):
            if a_list[i] in b_list:
                b_list.remove(a_list[i])
        if not b_list:
            print(f"{a} & {b} are anagrams.")
        else:
            print(f"{a} & {b} are NOT anagrams.")
        
