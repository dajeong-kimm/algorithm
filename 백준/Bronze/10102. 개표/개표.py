n = int(input())
vote = list(input())

A = vote.count("A")
B = vote.count("B")

if A>B:
    print("A")
elif A<B:
    print("B")
else:
    print("Tie")