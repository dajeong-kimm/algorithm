t = int(input())

def is_palindrome(str_):
    left = 0
    right = len(str_)-1
    while left<right:
        if str_[left]==str_[right]:
            left += 1
            right -= 1
        else:
            tmp = str_[left:right]
            if tmp==tmp[::-1]:
                return 1
            tmp = str_[left+1:right+1]
            if tmp==tmp[::-1]:
                return 1
            return 2
    return 0
for _ in range(t):
    s = input()
    answer = is_palindrome(s)
    print(answer)
