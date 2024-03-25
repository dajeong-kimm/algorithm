total = int(input())

book = []
for _ in range(9):
    book.append(int(input()))
    
print(total-sum(book))