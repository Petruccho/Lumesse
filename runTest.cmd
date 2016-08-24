@ECHO ON

call mvn clean install test -DsuiteXmlFile=testlist.xml

PAUSE

EXIT