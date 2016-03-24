# Dijkstra's algorithm
## Synopsis
Implementation of Dijkstra's Algorithm using Priority Queue Java API that can compute the Shortest path from a given source node. 
## Software Specifications
+ JDK 1.8 
+ JRE 1.8 
## Hardware Specifications
+ i7 3rd Generation Quad Core Processor 
+ 16 Gb of RAM 
## Input data format requirements
n

v1    v2  ew1,2

...

v3    v9  ew3,9

...
## How to run ? 
Create a new folder in your system. 
Download this repository's files into that folder.
Make sure the following commands are running from your terminal/command-line,
Windows 
~~~~sh
javac -version
java -version
~~~~
Ubuntu Linux
~~~~sh
javac --version
java --version
~~~~
Compile the Node.java file using the below command
~~~~sh
javac Node.java
~~~~
Compile the ShortestPathAlgorithm.java file using the below command
~~~~sh
javac ShortestPathAlgorithm.java
~~~~
2 class files gets generated, now run the main file with runtime arguments
~~~~sh 
java ShortestPathAlgorithm 0 Inputs/input16.txt
~~~~
## Average Running time to Estimate Time Complexity (Number of vertices vs Time (ns))
Number Of Vertices | Average Running time (ns) | O (log n) | Running time (ns) Instance 1 | Running time (ns) Instance 2
-------------------|-------------------|-------------------|-------------------|-------------------
6|0.03333|0.025912|0.033333 | 0.03333
7 |0.03333|0.028167|0.033333 |0.03333 
8 |0.05|0.045154|0.05|0.05 
16 |0.08333|0.10033|0.083333|0.08333 
20 |0.1|0.13010|0.083333|0.1 

## Graph Plot
![Number of vertices vs Time (ms)](https://bytebucket.org/vaikunthsridharan/dijkstras-shortest-path-algorithm/raw/26f3f4786785ad3c9be3ce359852d55f20eff15a/images/Untitled%20drawing.png)

## Tabulation & Graph Plot Credits
Venkadesan Gandhirajan 

Email : venkatjee93@gmail.com 

##### Copyright © 2015 Vaikunth Sridharan