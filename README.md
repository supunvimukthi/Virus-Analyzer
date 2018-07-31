# Virus-Analyzer
Given a file as user input user checks for infected data by finding matches by querying with a md5 hash database which contains virus files. 

## How to run 

- clone the repository
- import the .sql database into mysql or php myadmin
- cd in to Virus-Analyzer/src
- include any missing libraries [commons-codec](https://drive.google.com/file/d/10eo9KJ-a6H7wLHRaaVrdEh6zqcrd8QKd/view?usp=sharing) [mysql-connector](https://drive.google.com/file/d/1z6BbLvuLFpOSS584QndLDsVBjWVOo3eY/view?usp=sharing)
- run **javac VirusAnalyzer.java**
- go to dist folder and open the jar file or run using command line by running **java -jar "VirusAnalyzer.jar"**
- enter database data when prompted. 
- select a folder to check for virus.
- program will output file data and infected status.
