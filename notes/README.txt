READ ME
———————————————

This readme contains software requirements, install directions and quiz answers for Levels Beyond’s technical interview. 

Requirements
———————————————
- JDK 1.7 or later
- Maven 3.0+



How to install and run
———————————————

1) Get the project: 

git clone https://github.com/RockChalkJay/LevelsBeyond.git

3) Change to install dir

cd ./LevelsBeyond/notes

2) Build the notes jar file with Maven: 

mvm clean package

3) Run the application with this command. The application by default uses port 8080. Optionally, you can bind the application to another port using the --server.port parameter. 

java -jar ./target/notes-0.1.0.jar --server.port=8082

———————————————
How well does your note-searching-api scale or not scale? How would you make your search more efficient?

My search is not scalable in that it is a brute force method. Performance is measured in two ways: CPU cycles and memory usage. I’m going to assume we are aiming for speed. In that case, I’d create a binary search with the keywords (meaning all unique words in each note)being the search term and the nodes containing all the notes containing that keyword.


How would you add security to your API?

Spring, conveniently, has a security module package. This package handles authentication.
However, the login and password (along all other data) will be in clear text. Encryption can be implemented via https instead of http.

What features should we add to this API next?

1) Remove a note
2) Edit an existing note
3) Sort notes by date
4) Make notes persistent e.g. backed by a database
5) Add categories
6) Unique notebooks per user

How would you test the API?

First, I would create JUnit tests. These set of test cases would perform checks of the functionality of Note.java and NoteBook.java classes. Next I would use a tool like SoapUI (now known as Ready!API) to test end to end functionality along with load testing.