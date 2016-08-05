@ECHO ON

call mvn clean install test -DbrProperties=properties/browser.properties -DsuiteXmlFile=testlist.xml

PAUSE

EXIT