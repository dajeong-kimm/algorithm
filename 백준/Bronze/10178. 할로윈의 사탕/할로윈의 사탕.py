n = int(input())

for _ in range(n):
    total, N = map(int, input().split())
    print(f"You get {total//N} piece(s) and your dad gets {total%N} piece(s).")