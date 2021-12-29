# Issue list

* Don't forget to check "Include dependencies with "Provided" Scope" to run code

* If "Error running 'Feature <feature>': Command line is too long. Shorten command line for Feature: <feature> or also for Cucumber java default configuration" <br>

    Go in .idea/workspace.xml and add : <br>
		```xml
		<component name="PropertiesComponent">
			...
			<property name="dynamic.classpath" value="true" />
		</component>
		```

* java.io.FileNotFoundException: HADOOP_HOME and hadoop.home.dir are unset.

	You forgot to setup Apache Hadoop on your laptop. <br>
	You can follow the installation process [here](../Sbt-Scala-Spark/Hadoop/README.md) <br>
