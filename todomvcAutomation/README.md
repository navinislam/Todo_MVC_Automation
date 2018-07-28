# todomvc
Exercise automating the todo mvc react application


## How To Run


#### Through Terminal 
##### Prerequisite: Must Java SDK and Maven installed on machine



1. Open terminal
2. Change Directory till you are in folder containing project
3. Run mvn clean (to clean out any old data / files)
4. Run `mvn clean verify serenity:aggregate`
5. Watch tests run
6. After tests have finished running go into "target" folder
7. Open "site" folder
8. Scroll till you find "index" file
9. Open index file in preferred browser (Chrome works best)
10. View your results

##### To run only Security or only UI tests run the following commands respectively:
`mvn clean verify -Dtags=SECURITY serenity:aggregate`

`mvn clean verify -Dtags=UI serenity:aggregate`

### Note:
Security tests are expected to fail. 
The tests are designed to insert XSS injections and 
then not able to get the text of items in the list, as an Alert popup should prevent it from doing so.





#### Through IntelliJ
##### Prerequisite: Must Java SDK installed

1. Open project in IntelliJ
2. Let IntelliJ download all dependencies (there should be a popup)
3. On toolbar at top click "Run"
4. Click "Edit Configuration"
5. Click "+" sign
6. Click "Maven"
7. Name your build run ("Run Tests" is fine)
8. In command line section type the following 
`clean verify serenity:aggregate`
9. Apply and Save
10. Click "View" in toolbar at top and go to "Tool Windows"
11. Click Maven Projects
12. In the Maven Projects tool window click "Run Configurations"
13. Click on your created build run
14. Watch tests run
15. After tests have finished running go into "target" folder
16. Open "site" folder
17. Scroll till you find "index" file
18. Open index file in preferred browser (Chrome works best)
19. View your results
