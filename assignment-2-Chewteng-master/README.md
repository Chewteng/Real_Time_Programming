## Requirements for Assignment-2
[Read the instruction](https://github.com/STIW3054-A202/Assignments_and_Project/blob/main/Assignment-2.md)

## Your Info:
<img src="https://user-images.githubusercontent.com/51124053/113738759-c210ba80-9731-11eb-9890-e62a0334790b.jpeg" width="180" height="220">

👉 Matric Number: 263117

👉 Name: H'ng Chew Teng

📚 I am a student in the sixth semester and I am currently studying a bachelor's degree in Information Technology.

😄 I am from Johor and currently stay in my hometown.

## Introduction
<p align="justify">This assignment 2 is to develop a program with Telegram Bots by using MAVEN and Java programming language. First of all, scraping the data from three specific url link given and storing that data into the Sqlite database. The program will receive the input through Telegram Bots and return the corresponding results based on the choice of the user. There will be four choices in the system. The first function of the system is that it will able to receive an input of matric number through Telegram Bots and return the student's name, Github ID, Github link, Youtube channel name and the Youtube link from the Sqlite database back to the Telegram Bots when the user selects the /matricno option. Each matric number is executed using a thread. Besides, the system can also count the number of students in this real-time programming class and display out their details such as matric number and name when the /totalstudent option is chosen. Apart from that, the system will also count the number of students who have and have not submitted the Github account when the user clicks the /githubsubmission option. For the /githubsubmission option, the system will have one extra function which is /comparegithubsubmission option to display the list of student data who has and has not submitted the Github account with the correct matric number. This /githubsubmission option is the same function as the /youtubesubmission option.</p>

## Flow Diagram of the requirements
<img width="1700" height="900" alt="flow_chart" src="https://user-images.githubusercontent.com/51124053/118088053-0f4f0e80-b3f9-11eb-8751-2f71130876f6.png">

## User manual/guideline for using the system
<p align="justify">1.	Clone this repository: https://github.com/STIW3054-A202/assignment-2-Chewteng.git to your Java IDE, but remember put this repository to the path: C:\Users\User\IdeaProjects\ directory.</p>
<p align="justify">2.	Go to the program file which has named as App.java located in the src/main/java/my/uum/ folder.</p>
<p align="justify">3.	Run that program file.</p>
<p align="justify">4.	After the “Telegram Bot is now ready to be used!” message is displayed, users can now access the bot using telegram.</p>
<p align="justify">5.	Access the bot by searching the bot name s263117_A202, or using the link “t.me/s263117_A202_bot”.</p>
<p align="justify">6.	To start the function of the Telegram Bot, users need to click or write “/start” command or else an alert message will be displayed.</p>
<p align="justify">7.	After that, four options will be shown and users can now choose any one command to use the program.</p>
<p align="justify">8.	A reply from the bot will then be displayed based on the choice of the users.</p>
<p align="justify">9.	If “/matricno” command is entered or clicked, users have to key in the correct matric number from the list of students in this class and the corresponding student's name, Github ID, Github link, Youtube channel name and the Youtube link will be displayed or else an error message will be thrown.</p>
<p align="justify">10.	If “/totalstudent” command is entered or clicked, a total number of students in this class followed by their details which are matric number and name will be displayed.</p>
<p align="justify">11.	 If “/githubsubmission” command is entered or clicked, a total number of students who have and have not submitted the Github account followed by the student details (matric number and name) who have not submitted will be displayed.</p>
<p align="justify">12.	After choosing the “/githubsubmission” command, users will have one extra function which is “/comparegithubsubmission” command to view the details of students who have submitted and not yet submitted their Github account.</p>
<p align="justify">13.	If “/youtubesubmission” command is entered or clicked, a total number of students who have and have not submitted the Youtube video followed by the student details (matric number and name) who have not submitted will be displayed.</p>
<p align="justify">14.	After choosing the “/youtubesubmission” command, users will have one extra function which is “/compareyoutubesubmission” command to view the details of students who have submitted and not yet submitted their Youtube video.</p>


## Result/Output (Screenshot of the output)
1. Show Telegram Bots is now ready to be used
<img width="500" height="400" alt="Telegram_is_ready" src="https://user-images.githubusercontent.com/51124053/117963526-13c0ec00-b353-11eb-8308-2e00ff738571.png">

2. The output when receiving the input through Telegram Bots
<img width="650" alt="Telegram_is_ready" src="https://user-images.githubusercontent.com/51124053/117989171-ab800380-b36e-11eb-99ed-c499df379c39.png">

## UML Class Diagram
<img width="800" height="560" alt="class_diagram" src="https://user-images.githubusercontent.com/51124053/118113404-d7f05a00-b418-11eb-9d97-7343ef011e14.png">

## Database Design
<img width="650" alt="database_design" src="https://user-images.githubusercontent.com/51124053/118107713-b17af080-b411-11eb-8c0b-342af268ab89.png">

## Youtube Presentation
[<img src ='https://user-images.githubusercontent.com/51124053/115151536-d93f9880-a09f-11eb-830f-9999abe30238.png' width=100 height=100 />](https://youtu.be/401nvKfop9A)

## References (Not less than 10)
1.	Bermudez, R. (2021, March 9). How To Update. Retrieved from https://github.com/rubenlagus/TelegramBots/wiki/How-To-Update#to-version-242
2.	Cambo Tutorial. (2020, April 30). How to Web Scrape with Java using Jsoup Library | Extract Website Data + Source Code. Retrieved from https://www.youtube.com/watch?v=BEvRZUEQ3Dc
3.	EmojiTerra. (2021). Symbols Emoji & Signs Emoji. Retrieved from https://emojiterra.com/symbols/
4.	GeeksforGeeks. (2018, November 28). ArrayList size() method in Java with Examples. Retrieved from https://www.geeksforgeeks.org/arraylist-size-method-in-java-with-examples/
5.	GeeksforGeeks. (2020, October 16). List size() method in Java with Examples. Retrieved from https://www.geeksforgeeks.org/list-size-method-in-java-with-examples/#:~:text=The%20size()%20method%20of,present%20in%20this%20list%20container.&text=Parameters%3A%20This%20method%20does%20not,of%20elements%20in%20this%20list
6.	Hasanov, Z. (2018, February 10). How to create Telegram Bot in Java [ Tutorial ]. Retrieved from https://www.youtube.com/watch?v=xv-FYOizUSY
7.	JavaTpoint. (2018). Java StringBuilder class. Retrieved from https://www.javatpoint.com/StringBuilder-class
8.	Rungta, K. (2021, January 6). Java String replace(), replaceFirst() & replaceAll() with Examples. Java String Replace(), ReplaceFirst() & ReplaceAll() with Examples. Retrieved from  https://www.guru99.com/java-string-replace-method.html
9.	Stack Overflow. (2012, January 27). new Runnable() but no new thread?. Retrieved from https://stackoverflow.com/questions/9029795/new-runnable-but-no-new-thread
10.	Stack Overflow. (2018). How can I bold text in telepot Telegram bot? Retrieved from https://stackoverflow.com/questions/52163959/how-can-i-bold-text-in-telepot-telegram-bot
11.	Stack Overflow. (2019). What’s difference between equals and contains. Retrieved from https://stackoverflow.com/questions/54855461/what-s-difference-between-equals-and-contains
12.	Telegram. (n.d.). Bots: An introduction for developers. Retrieved from https://core.telegram.org/bots
13.	Tutorialspoint. (2021). Java.lang.StringBuilder.append() Method. Retrieved from https://www.tutorialspoint.com/java/lang/stringbuilder_append_string.htm
14.	W3Schools. (2021). CSS text-justify Property. Retrieved from https://www.w3schools.com/cssref/css3_pr_text-justify.asp
15.	W3Schools. (2021). JavaScript String replace() Method. Retrieved from https://www.w3schools.com/jsref/jsref_replace.asp#
16.	W3Schools. (2021). SQL LEFT JOIN Keyword. Retrieved from https://www.w3schools.com/sql/sql_join_left.asp
17.	Yozilkree. (2020, October 28). Extract specific data from website using java. Retrieved from https://efx.angewandted80nk.pw/extract-specific-data-from-website-using-java.html

## JavaDoc
[<img src ='https://user-images.githubusercontent.com/51124053/114991776-8eb9f280-9ecc-11eb-981d-92fa9952e813.jpg' width=100 height=100 />](https://github.com/STIW3054-A202/assignment-2-Chewteng/tree/master/JavaDoc)
