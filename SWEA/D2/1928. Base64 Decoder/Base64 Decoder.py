# from base64 import b64decode
t = int(input())
decode = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
      'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
      '0','1','2','3','4','5','6','7','8','9','+','/'
      ]
for test_case in range(1,t+1):
    word = input()
    length = len(word)

    res = ''

    for q in range(length):
        num = decode.index(word[q])

        bin_num = str(bin(num)[2:])

        while len(bin_num)<6:
            bin_num = '0'+bin_num

        res += bin_num

    r = ''
    for w in range(length*6//8):
        e = int(res[w*8:w*8+8],2)

        r += chr(e)

    print(f"#{test_case} {r}")

# s = "Life itself is a quotation."
# print(len(s))