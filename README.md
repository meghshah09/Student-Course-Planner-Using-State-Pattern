
Assignment 2 - Student Course Planner System is Solely done by Megh Shah (B00715432) and have tried my best to keep the code easy to understand and flexible for future use.

--------------------------------------------------------------------------

## To clean:
ant -buildfile studentCoursePlanner/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.
-----------------------------------------------------------------------
## To compile: 
ant -buildfile studentCoursePlanner/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## I used this to run my code
ant -buildfile studentCoursePlanner/src/build.xml run -Darg0=<path>/input.txt -Darg1=<path>/output.txt

Description: Will run the program with above line of code ONLY.
If files are inside studentCoursesBackup/.... (which also has src folder), then <path> = ./<fileName>
It will be fine if you do not have output.txt in the directory as long as you mention in the arguments.
(It will create with the given file name at given directory)

-----------------------------------------------------------------------

## Created tarball for submission with following command.

tar -cvf Megh_Shah_assign2.tar Megh_Shah_assign_2/
gzip Megh_Shah_assign_2.tar

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.ù"

[Date: 3/13/2018]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

1) ArrayList - Used for Storing.....
Worst Case Time Complexity - O(1) for adding a element in a list. O(n) for removal of data from array list since we go through each element.
Getting an element from Array List take O(1).
 
2) State Pattern - State Pattern is used in this Assignment.
There are 9 states used in this assignment, which are :
a) NotGraduationState - As the name defines, It is the Not Graduate State.And also the initial start state.
b) GraduationState - As the Name Suggest, this is the graduation State and will only be invoked when a student is ready for graduation.
c) CategoryOneState - As the Name Suggest, this state is for Category one which is Long Programming. ONLY courses which belong to this category will be in this state.
d) CategoryTwoState - As the Name Suggest, this state is for category two which is Data Structures and Algorithms. ONLY courses which belong to this category will be in this state.
e) CategoryThreeState - As the Name suggest, this state is for category three which is Hardware Sequence. ONLY courses which belong to this category will be in this state.
f) CategoryFourState - As the Name suggest, this state is for category four which is Data Analytics. ONLY courses which belong to this category will be in this state.
g) CategoryFiveState - As the Name Suggest, this state is for category five which is Electives. ONLY courses which belong to this category will be in this state.
h) CoursesAllocatedState - As the Name Suggest, this state is for courses which can be assigned to student.
After all the Planning policy is checked and particular course can be assigned then this state is invoked.
i) CourseWaitListState - As the Name Suggest, this state is for the courses which where not assigned at that particular moment.
					
-----------------------------------------------------------------------
Assignment 2 : Student Course Planning.
We will Discuss Planning Policy use in this assignment and also the flow of the code.

1)When the Context class Constructor is called, We set the initial state to NotGraduationState. So the Process start from NotGraduationState.
2)After setting the initial state, we process the course preference given by the student.
3)One course at a time is processed and decided that whether it can be assigned or not.
4)So, for example we start with course "D".
5)Now, Context class will do getState and invoke doAction method. Which will be NotGraduationState.
6)So here it process the course as per its category and sets state to that category state and invoke doAction method from NotGraduationState.
7)So, for our example it will CategoryOneState doAction will be be invoked.
8)Here, Planning Policy used comes into consideration. So what i check is that since this is course "D" then Is student assigned with course A or B or C before. 
If yes, then course D is moved to CourseAllocateState Else the course will be moved to CourseWaitListState.
9)NOTE :- There is no pre-requisite check in the Electives Category. So the courses are assigned in any sequence they come.
10)So, now if the course can be Allocated then CourseAllocatedState doAction method is called and it will add the course.
11)If the course could not be assigned then CourseWaitListState addCourseInWaitList method is invoked.
12)After this process is done for one course, Every time Context Class will set state to WaitListState and doAction of WaitList will be invoked.
13)It will constantly try to invoke the courses in waitList one by one as we did for given list by the student.

-----------------------------------------------------------------------
list of citations (urls, etc.) from where you have taken code