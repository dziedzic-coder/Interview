# Interview tasks
## Description
* Each task is located in separated package
* Every task has its own Main class to run the task.
* File with data should be created in the way, they were presented in tasks description:
   
Task 1:       
```
List of integers separated by space eg.1 10 20 20 2 5
```
Task 2:       
```
List of integers separated by space eg.1 2 10 7 5 3 6 6 13 0
```
Task 3:       
```
First line positive number n, next n lines - pairs of positive integers separated by space
eg. 
3
1 2
2 3
5 6
```

* We can run tasks on two ways:

First way:
```
1. Open project in IDE
2. Do one of a,b,c step
2a. Change file in resources to your file
2b. Set path to your file in run configuration in "Program arguments"
2c. Set your own path in Main class as PATH_TO_INPUT value
3. Run Main class
```
Second way:
```
1. mvn clean install
2. Go to target directory
3. Run 'java -cp isnova-1.0.jar com.dziedzic.interview.task{numberOfTask}.Main {pathToInputFile}'
replacing {numberOfTask} with number of task and {pathToInputFile} with path to input
eg. java -cp isnova-1.0.jar com.dziedzic.interview.task1.Main /home/mdziedzic/input1.txt
```

