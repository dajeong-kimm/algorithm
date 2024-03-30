s = list(input())
for i in range(len(s)):
    n = ord(s[i])+13
    if s[i].isupper():
        if n>ord('Z'):
            n -= 26
        s[i] = chr(n)
    elif s[i].islower():
        if n>ord('z'):
            n -= 26
        s[i] = chr(n)

print(''.join(s))


    
