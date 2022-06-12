# NoumenaCLI

Maven is required to build the project. Go in the project folder where pom.xml is located and run
```
mvn clean install
```
This will generate a runnable jar located in the target folder called 'translator.jar'. Files to be parsed are located in the resources folder.
Have the jar and the files in the same folder and run

```
cat ./Workbook2.csv | java -jar translator.jar csv html > csv.html.txt
cat ./Workbook2.prn | java -jar translator.jar prn html > prn.html.txt
diff csv.html.txt prn.html.txt
cat ./Workbook2.csv | java -jar translator.jar csv json > csv.json.txt
cat ./Workbook2.prn | java -jar translator.jar prn json > prn.json.txt
diff csv.json.txt prn.json.txt
```
to test the required functionality.
