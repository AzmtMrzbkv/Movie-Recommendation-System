# This is the second project of CSE36401 course

## Algorithm Overview

The Milestone 2 project proposes a Top-10 Movie Recommendation System based on User's Age, Gender, Occupation and Favorite Genres.
The suggested Algorithm works as follows: 


1. An input is parsed into a Gender, Age and Occupation (GAO) triplet and compared with the data in users.dat file.

2. For each similarity found between GAO in input and GAO in users.dat file, each user in the users.dat file is assigned a "Significancy Factor" (SF), which is a number between 0 and 1 (that is, 0 <= SF < 1, each similarity costs {0.333, 0.333, 0.333}).

3. The ratings.dat file is then observed. Here, the HashMap is created to store the MovieID and movie's new Rating. The new Rating is calculated as: NewRating = GivenRating * (1+SF). If the observed movie has been already rated by "other user", then we apply the next formula: NewRating2 = (NewRating + GivenRating2 * (1+SF2)) / 2 (that is, the average of the two ratings; here, GivenRating2 and SF2 are the ratings of the "other user").

4. If the input contains information about the favorite genre, then we "promote" the movies which includes one (or more) provided genres as: NewRating = GivenRating * 10. 

5. Finally, the Top-10 Movies with the highest rating are printed.


## How to run

```sh
$ docker build -t image_name /path/to/Dockerfile
```
```sh
$ docker run -it image_name
```
Inside the Dockerfile:

```sh
root@containerID$ . run.sh
```


## Example input/output

Input: 

```sh
java -cp target/cse364-project-1.0-SNAPSHOT.jar recommend.Tops “F” “25” “Grad student” “Action|Comedy”
```

Output:

```sh
Big One, The (1997) (http://www.imdb.com/title/tt0124295)
Nightmare Before Christmas, The (1993) (http://www.imdb.com/title/tt0107688)
Great Dictator, The (1940) (http://www.imdb.com/title/tt0032553)
Clerks (1994) (http://www.imdb.com/title/tt0109445)
City Lights (1931) (http://www.imdb.com/title/tt0021749)
When the Cats Away (Chacun cherche son chat) (1996) (http://www.imdb.com/title/tt0115856)
Braveheart (1995) (http://www.imdb.com/title/tt0112573)
Gold Rush, The (1925) (http://www.imdb.com/title/tt0015864)
March of the Wooden Soldiers (a.k.a. Laurel & Hardy in Toyland) (1934) (http://www.imdb.com/title/tt0024852)
Close Shave, A (1995) (http://www.imdb.com/title/tt0112691)

```

## Roles

1. Azamat Myrzabekov - Team Lead and Main Programmer (Algorithm Implementation)
2. Nursultan Kobeisinov - Tester and JaCoCo Implementation
3. Nodirkhuja Khujaev - Debugger
