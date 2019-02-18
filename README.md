
# Run instructions:

 - Easiest way to run it is from the command line with gradle
 
1) Install gradle cli with home brew : `brew install gradle`
2) Go in the repository and run `gradle run --args=src/main/resources/lines.txt` test it with the sample file.
Additionally you can pass in any other file path as showed in the example above, however it has to be a relative path to the project scope.

In the console logs you would see the printed events once they have been inserted into the database.
