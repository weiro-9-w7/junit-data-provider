if you are in work space , maybe can't get maven jar.
you can download the relative jar & install your local maven repo.

1. download jar
    download : junit4-dataprovider-2.0.jar  &  junit-dataprovider-core-2.0.jar
    download url :
    http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.tngtech.junit.dataprovider%22%20AND%20v%3A%222.0%22

2. install your local maven :
    mvn install:install-file -DgroupId=com.tngtech.junit.dataprovider -DartifactId=junit-dataprovider-core -Dversion=2.0 -Dpackaging=jar -Dfile=junit-dataprovider-core-2.0.jar
    mvn install:install-file -DgroupId=com.tngtech.junit.dataprovider -DartifactId=junit4-dataprovider -Dversion=2.0 -Dpackaging=jar -Dfile=junit4-dataprovider-2.0.jar

3.  add dependency in pom.xml
    <dependency>
        <groupId>com.tngtech.junit.dataprovider</groupId>
        <artifactId>junit-dataprovider-core</artifactId>
        <version>2.0</version>
            <scope>test</scope>
    </dependency>