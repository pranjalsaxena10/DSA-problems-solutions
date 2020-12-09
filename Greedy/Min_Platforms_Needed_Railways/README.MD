Type of problem where we have certain range given as input in the form of something as startTime/arrival & endTime/departure and problem is asked to find out minimum no of rooms or platforms then it can be solved by 2 classic ways.

Problem type are discussed in this doc. Approaches are explained in code

Problem can be of following type:


**Problem 1**: Meetings start time and end time are given and no of meetings are also known

and we are asked about minimum no of rooms required in order to conduct all meetings.


---



**Problem 2:** Similar type of problem can be asked in different form where use case is changed but sole heart of the problem is same. For example, at a railway station trains are scheduled to arrive and depart at specified time intervals. Arrival and departure times are given for different trains, task is to find out minimum platforms needed in order to have smooth functioning of Railway Station


---

Approach 1: Using PriorityQueue or Min Heap


* Time Complexity: O(N * logN)
* Space Complexity: O(N)

---


Approach 2: Using Merge technique which is extensively used in Merge Sort


* Time Complexity: O(N * logN)
* Space Complexity: O(1)
