
## Run instructions:

 - Easiest way to run it is from the command line with gradle
 
1) Install gradle cli with home brew : `brew install gradle`
2) Go in the repository and run `gradle run --args=src/main/resources/lines.txt` test it with the sample file.
Additionally you can pass in any other file path as showed in the example above, however it has to be a relative path to the project scope.

In the console logs you would see the printed events once they have been inserted into the database.


## Assumptions 

 - In the building process of this program the following assumptions were made: 

1) the file will only contain json objects on each separate line of the file, hence no error handling is done if this is not met. 
2) the db will not run out of memory.
3) there will always be a FINISHED state for a START state.
4) the generated events between a pair of START - FINISHED events will cause heap errors for the hashmap.

## Improvements 

1) Tests: - In this project I only wrote a sample of unit tests for the DAO manipulation methods, however each file should be fully unit and integration tested. 

2) Multi-threading: - as the flow of the program progresses in a sequential list of activities: read line from file, process it, add it to the hashmap, check if it exists, calculate the duration, write it to the database; each of these activities can be separated in a different thread in order to increase the performance of the application. 

3) Abstraction: - as the application grows and requires more extensibility to support different databases, requires different file processing, access different file formats, more abstraction can be added in terms of interfaces and abstract classes to support this. 

4) Error handling: - only a minimum level of error handling has been done here in order to keep the application from not breaking under its own weight.
