n = int(input())

binary = bin(n)[2:]
binary = list(binary)
print(binary.count('1'))