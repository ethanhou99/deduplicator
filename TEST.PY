def proc(n):
    if n == 0:
        return 1
    if n%2 == 0:
        return proc(n/2)
    else:
        return proc(3*n-1)

print(proc(11))