* Don't forget to check "Include dependencies with "Provided" Scope" to run code

* if "Error running 'Feature <feature>': Command line is too long. Shorten command line for Feature: <feature> or also for Cucumber java default configuration" <br>
    Go in .idea/workspace.xml and add : <br>
		```xml
		<component name="PropertiesComponent">
			...
			<property name="dynamic.classpath" value="true" />
		</component>
		```
