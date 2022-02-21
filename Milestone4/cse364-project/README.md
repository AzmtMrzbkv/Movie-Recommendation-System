<!-- COPY FROM MILESTONE3-->
# RecS - MOVIE RECOMMENDATION APPLICATION. 
## This is the project of team SWEbeasts

## How to run

```sh
$ docker build -t image_name /path/to/Dockerfile
```
```sh
$ docker run -p 8080:8080 -it image_name
```
For Part I, inside Docker run:

```sh
root@containerID$ . run.sh
```
You can view the following result using any browser:
![alt text](https://user-images.githubusercontent.com/62408255/122774380-16b0e400-d2e4-11eb-899e-8b364707bef2.png)

## Overview of Algorithm

This project proposes a Movie Recommendation System based on User's Personal Data and Requested Favorite Genres. Our goal is to provide quality service to find the film you are interested in. Whole process of building webservice completed solely on the enthusiasm of 3 members.

Here the 

The principle of code and backend algorithms works as follows:

1. An input is parsed into a Gender, Age and Occupation (GAO) triplet and compared with the data in users.dat file.

2. For each similarity found between GAO in input and GAO in users.dat file, each user in the users.dat file is assigned a "Significancy Factor" (SF), which is a number between 0 and 1 (that is, 0 <= SF < 1, each similarity costs {0.333, 0.333, 0.333}).

3. The ratings.dat file is then observed. Here, the HashMap is created to store the MovieID and movie's new Rating. The new Rating is calculated as: NewRating = GivenRating * (1+SF). If the observed movie has been already rated by "other user", then we apply the next formula: NewRating2 = (NewRating + GivenRating2 * (1+SF2)) / 2 (that is, the average of the two ratings; here, GivenRating2 and SF2 are the ratings of the "other user").

4. If the input contains information about the favorite genre, then we "promote" the movies which includes one (or more) provided genres as: NewRating = GivenRating * 10. 

5. Finally, the Top-10 Movies with the highest rating are returned.

The Milestone 3 (part 2) project proposes a Top-N Movie Recommendation System (N is a limit, if N is absent, it is by default 10) based on  Movie Title (further some User's Age, Gender, Occupation and Favorite Genres are used).
The suggested Algorithm works as follows: 

1. Find a user that has given the greatest rating for movie with given Movie Title
2. Use found-user's Gender, Age, and Occupation to recommend top-N movies using the algorithm for part 1.

## Roles

1. Azamat Myrzabekov - Team Lead and Main Programmer (Algorithm Implementation)
2. Nursultan Kobeisinov - Tester and JaCoCo Implementation
3. Nodirkhuja Khujaev - Debugger and Readme writing



## Example input/output

Input (part 1): 

```sh
curl -X GET http://localhost:8080/users/recommendations -H ‘Content-type:application/json’ -d ‘{“gender”: “”, “age”: “15”, “occupation”: “”, “genres”: “Drama”}’
```
Note: genre atribute must be "genres"

Output (part 1):

```sh
[{"title":"Alley Cats, The (1968)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0064006"},{"title":"Hate (Haine, La) (1995)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0113247"},{"title":"Song of Freedom (1936)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0028282"},{"title":"Schlafes Bruder (Brother of Sleep) (1995)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0114354"},{"title":"One Little Indian (1973)","genres":"Comedy|Drama|Western","imdb":"https://www.imdb.com/title/tt0070481"},{"title":"World of Apu, The (Apur Sansar) (1959)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0052572"},{"title":"Pather Panchali (1955)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0048473"},{"title":"Paths of Glory (1957)","genres":"Drama|War","imdb":"https://www.imdb.com/title/tt0050825"},{"title":"City Lights (1931)","genres":"Comedy|Drama|Romance","imdb":"https://www.imdb.com/title/tt0021749"},{"title":"Lamerica (1994)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0110299"}]

```

Input (part 2.1): 

```sh
curl -X GET http://localhost:8080/movies/recommendations -H ‘Content-type:application/json’ -d ‘{“title”: “Toy Story (1995)”, “limit”: 20}’
```

Output (part 2.1):

```sh
[{"title":"Bittersweet Motel (2000)","genres":"Documentary","imdb":"https://www.imdb.com/title/tt0168515"},{"title":"Song of Freedom (1936)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0028282"},{"title":"One Little Indian (1973)","genres":"Comedy|Drama|Western","imdb":"https://www.imdb.com/title/tt0070481"},{"title":"Alley Cats, The (1968)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0064006"},{"title":"Marcello Mastroianni: I Remember Yes, I Remember (1997)","genres":"Documentary","imdb":"https://www.imdb.com/title/tt0119614"},{"title":"Three Seasons (1999)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0138874"},{"title":"Close Shave, A (1995)","genres":"Animation|Comedy|Thriller","imdb":"https://www.imdb.com/title/tt0112691"},{"title":"Firelight (1997)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0119125"},{"title":"Tango Lesson, The (1997)","genres":"Romance","imdb":"https://www.imdb.com/title/tt0120275"},{"title":"Some Folks Call It a Sling Blade (1993)","genres":"Drama|Thriller","imdb":"https://www.imdb.com/title/tt0108181"},{"title":"White Christmas (1954)","genres":"Musical","imdb":"https://www.imdb.com/title/tt0047673"},{"title":"Sunset Blvd. (a.k.a. Sunset Boulevard) (1950)","genres":"Film-Noir","imdb":"https://www.imdb.com/title/tt0043014"},{"title":"Rebecca (1940)","genres":"Romance|Thriller","imdb":"https://www.imdb.com/title/tt0032976"},{"title":"Robin Hood (1973)","genres":"Animation|Children's","imdb":"https://www.imdb.com/title/tt0070608"},{"title":"Hunger, The (1983)","genres":"Horror","imdb":"https://www.imdb.com/title/tt0085701"},{"title":"Great Dictator, The (1940)","genres":"Comedy","imdb":"https://www.imdb.com/title/tt0032553"},{"title":"Prince of Egypt, The (1998)","genres":"Animation|Musical","imdb":"https://www.imdb.com/title/tt0120794"},{"title":"Bandits (1997)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0118682"},{"title":"Love Jones (1997)","genres":"Romance","imdb":"https://www.imdb.com/title/tt0119572"},{"title":"March of the Wooden Soldiers (a.k.a. Laurel & Hardy in Toyland) (1934)","genres":"Comedy","imdb":"https://www.imdb.com/title/tt0024852"}]
```
Input (part 2.2): 


```sh
curl -X GET http://localhost:8080/movies/recommendations -H ‘Content-type:application/json’ -d ‘{“title”: “Toy Story (1995)”}’
```
Output (part 2.2):

```sh
[{"title":"Bittersweet Motel (2000)","genres":"Documentary","imdb":"https://www.imdb.com/title/tt0168515"},{"title":"Song of Freedom (1936)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0028282"},{"title":"One Little Indian (1973)","genres":"Comedy|Drama|Western","imdb":"https://www.imdb.com/title/tt0070481"},{"title":"Alley Cats, The (1968)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0064006"},{"title":"Marcello Mastroianni: I Remember Yes, I Remember (1997)","genres":"Documentary","imdb":"https://www.imdb.com/title/tt0119614"},{"title":"Three Seasons (1999)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0138874"},{"title":"Close Shave, A (1995)","genres":"Animation|Comedy|Thriller","imdb":"https://www.imdb.com/title/tt0112691"},{"title":"Firelight (1997)","genres":"Drama","imdb":"https://www.imdb.com/title/tt0119125"},{"title":"Tango Lesson, The (1997)","genres":"Romance","imdb":"https://www.imdb.com/title/tt0120275"},{"title":"Some Folks Call It a Sling Blade (1993)","genres":"Drama|Thriller","imdb":"https://www.imdb.com/title/tt0108181"}]
```

