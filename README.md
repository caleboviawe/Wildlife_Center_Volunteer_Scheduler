# Wildlife_Center_Volunteer_Scheduler
Final Project for a second year object-oriented programming course. Completed with @gyurinmo, @yanisasri, and @emiko47

## Date Completed
April 2023

## Description
Being the final project of a OOP course, this project emcompasses many techniques learned over the semester. The project consists of two main components: front-end and back-end development, with the front-end being implemented using Java and graphical user interfaces (GUIs), while a MySQL database for data management was used as the back-end. 

How the program works is that users are provided a general login screen to provide information on whether they're a volunteer or manager. Depending on the role a user plays, additional user interfaces are in place to allow for the viewing and updating of specific volunteer data as the user desires. Based on the current update state of the data within the system, the program can also provide helpful prompts to the user. These prompts can be things such as requesting additional volunteers, or showing time periods where there is congestion or task overflow. When there is a change to the schedule data, the program's application logic reads the changes, connects the changes to the database, and outputs an schedule comprised of tasks for a volunteer, in a new file. 

The database in play holds information concerning the animals at the centre, tasks needed for each animal, time periods, time needed for each task, and the current state of volunteers in the centre. In an effective and easily-manageable manner, the database communicates with the front-end to make for a seamless, and effecient scheduling program.
