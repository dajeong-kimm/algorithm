def accept(s):
    a = ['a','e','i','o','u']
    a_count = 0
    A,B = 0,0
    for i in range(len(s)):
        if s[i] in a:
            a_count += 1
            A += 1
            B = 0
        else:
            A = 0
            B += 1
        if A == 3 or B == 3:
            return False
        if i<len(s)-1 and (s[i] == s[i+1]):
            if s[i] != "e" and s[i] != 'o':
                return False
    if a_count==0:
        return False
    return True
    


while True:
    s = input()
    if s == "end":
        break
    if accept(s):
        print(f"<{s}> is acceptable.")
    else:
        print(f"<{s}> is not acceptable.")