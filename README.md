# Deduplicator Group7
## Description

The current prototype can save files with any format into any locker. If the locker doesn't exist the program will create a new locker and save a file in it automatically. When the file's saved, the deduplicator will cut the input file to multiple small pieces and except the last piece, the rest pieces are in the same size. If a file is same to the saved files, the hash code of the file pieces are also same as the saved file pieces and the new file will be saved as pointers point to the duplicated pieces instead of saving the file again. MetaData in this part is worked as a pointer and written in two files meta and b_cnt (some info hasn't been used yet but are saved for the convenience of deletion in the future)

## Instruction

### To run the project in command line:
1. Change the working directory to ../group7/DeDuplicator/src
2. Compile the source code file `dedup.java`
```
javac dedup.java
```
3. Save a file
- The target file to save should in `../group7/DeDuplicator/src`
- Then run the collowing code:
```
//Code example to save test.txt to locker1
java dedup -addFile text.txt -locker locker1
```
4. Retrieve a file
```
// Code example to retrieve test.txt from locker1
java dedup -retrieveFile text.txt -locker locker1
```

### To run the project in IntelliJ
Please click [here](https://agile.bu.edu/bitbucket/projects/EC504PROJ/repos/group7/browse/DeDuplicator/src/readme.txt) to check detailed instruction.

## Group Members

Zhongyuan Cai
Yiun Hou
Haoxuan Jia
Zifan Wang
Boyang Zhou