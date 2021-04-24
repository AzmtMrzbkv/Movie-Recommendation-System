# Software-Engineering---CSE36401

This project is the assignment of Software Engineering! 
    
For this milestone we finished dockerfile, pom.xml configurations and succesfully wrote the algorithm code to find rating by the occupation of user and genres he/she chooses. From the data files we read the data, setup environment and according to genres of films and ratings taken from the some occupation we obtain all scores and evaluate the average. Exception handlings for incorrect user inputs are also considered.

# How to run your program. 

To build the image:
*$ docker build -t image_name /path/to/Dockerfile*

To run the container:
*$ docker run -it image_name*

An example of java command line:

*java RateMeter "Adventure" "educator"*

Several Notes for users:
*The input must be two strings in double quotes separated by space.(Otherwise our program will warn you to enter correctly)
*If there is no film rated by some occupation with given genres program will show: Movies with such genre(s) were not rated by people of this occupation!
*If the occupation name was different from the occupations given in data file, then: No such occupation: ...

Roles of each member:
1) 20192022_Myrzabekov Azamat: creating the repository; dockerfile configurations; pom.xml configurations; main skeleton of java code (several functions that read and analyzes the ratings.dat, movies.dat; searching needed info in Google
2) 20192017_Kobeisinov Nursultan: additional features of java code(from userID identify and search for occupation, comments); checking basic input cases; to fill and write instructions/ description for README.md; re-checking the java code
3) 20192016_Khujaev Nodirkhuja: main debugging; adding exception handling; line corrections/enhancing readibility; pom.xml config.

# Group ID: 7 | Team members: 

20192017_Kobeisinov Nursultan, <br/>
20192016_Khujaev Nodirkhuja, <br/>
20192022_Myrzabekov Azamat


# Comments:
There is a problem with "pom.xml" file (or with a Dockerfile). Untill we can find it and solve it, our program does not perform as expected. We are working to solve it as fast as possible.
