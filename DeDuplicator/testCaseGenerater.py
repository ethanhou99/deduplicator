obj1 = "test.txt"
obj2 = "test1.txt"

with open(obj1, "w") as f:
    for i in range(10240000):
        f.write(chr(i%256))
f.close()

with open(obj2,"w") as f:
    for i in range(10240000-1):
        f.write(chr(i%256))
    f.write(chr(123))
f.close()