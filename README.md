# Virus-Analyzer
Given a file as user input user checks for infected data by finding matches by querying with a md5 hash database which contains virus files. 

## How to run 

### JAVA

- clone the repository
- import the .sql database into mysql or php myadmin
- cd in to Virus-Analyzer/src/virus_analyzer
- include any missing libraries [commons-codec](https://drive.google.com/file/d/10eo9KJ-a6H7wLHRaaVrdEh6zqcrd8QKd/view?usp=sharing) [mysql-connector](https://drive.google.com/file/d/1z6BbLvuLFpOSS584QndLDsVBjWVOo3eY/view?usp=sharing)
- run **javac Virus_Analyzer.java**
- go to dist folder and open the jar file or run using command line by running **java -jar "Virus_Analyzer.jar"**
- enter database data when prompted. 
- select a folder to check for virus.
- program will output file data and infected status.

### PYTHON

- cd into Virus-Analyzer after clone
- follow the instruction above for database import. (anyone of the two databases included in the src folder)
- if you dont have pip install follow [these](https://github.com/BurntSushi/nfldb/wiki/Python-&-pip-Windows-installation) instructions
- pip install missing libraries.
- run python file using cmd with **python virus_analyze.py**
- select a file to scan.
