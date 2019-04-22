## I. Documentation

### This program is: Deduplication
This task is about designing a deduplication system that can save similar files with more efficiency in space
utilization.

### Group members:
Zhongyuan Cai, Yicun Hou, Haoxuan Jia, Zifan Wang, Boyang Zhou

### High-level description:
Basic idea is to split the input file into fixed pieces and calculate each piece's hashcode(MD5). Each file saved in
the locker has a pair of info which is like {filename, [hashcodes,hashcodes,...]} and this part is saved in the
mataData. Also there's a simplified bloom filter(using only one hash function) that record each hashcodes and count its
numbers which makes it easier for deletion. If file to be saved has some part with same hashcode as recorded in the
mata, there's no need to save that piece and thus how deduplication works.

### Extra Features:

#### Substring search
- Appoint a specific encoding format ( ASCII, UTF8 or UTF16 )
- For each sliced file in the locker, match the substring with content, and record the hashcode file where substring
matches
- Search in the mataData, a structure which is like {filename, [hashcodes.....]}, in this case
Hashmap<String, ArrayList<String>> especially. Print out the filename that matches with a recoreded hashcode (recorded
above)

#### File Deletion

#### Networked access
- Create a ssh tester account. While use want to use network access run the project, use the tester account to login to the server, then go to the project directory and run the project as usual. The file transfer will use ssh command. This feature needs reservation before testing, since the server is deployed in personal laptop and we need to run the server to support this function.

#### Store directories of files as one entity
- The data structure to save the folder information is to build a HashMap<FolderName,HashMap<FilePath, FileName>>, this hashmap keeps to the directory logic of the original folder. 
- For saving the blank folder, we treat each folder as a file as will. 
  - While saving the folder, the hashcode of the folder is set to -1; 
  - While saving the file, the hashcode is the real hash code of the file. 
- On the contrary, while retrieving the folder or file:
  - If the program notice the hashcode is -1, the program will create a folder;
  - If the program notice the hashcode is not -1, the program will restore the file to the original path.
- The above implementation guarantees the original dirctory logic of the input folder. Also, use can retrieve the file under the folder individually once they saved the folder as one entity.
- The program will check the input is file or folder automatically, users don't need to give extra command to save or retrieve a folder.

#### Real-time GUI

#### Store MySQL databases

#### Store similar images


## III. Work breakdown
### Zhongyuan Cai

### Yicun Hou
- Command line processing and function call
- Ability to store directories of files as one entity, including:
  - Save and retieve blank foler
  - Save and retrieve folder and subfolder's content
  - Ability to retrieve folder's files individually
  - Ability to retrieve folder as original directory logic
- Develop networked access to the locker

### Haoxuan Jia

### Zifan Wang
- Implement tools: MD5 encodeing, check path, make directory, search string in file
- Basic structure of the main function (main function from the prototype version)
- Implement Substring search
- All test cases (till prototype version)

### Boyang Zhou

## IV. Jira links
The working pregress can be tracked in [Jira](https://agile.bu.edu/jira/projects/GROUP7/summary).

