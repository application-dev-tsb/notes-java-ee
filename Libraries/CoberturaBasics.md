# Cobertura: Basics
- add maven reporting plugin
```xml
<project>
...
  <reporting>
		<plugins>
		...
	      <plugin>
	        <groupId>org.codehaus.mojo</groupId>
	        <artifactId>cobertura-maven-plugin</artifactId>
	        <version>2.7</version>
	        <reportSets>
	          <reportSet>
	            <reports>
	              <report>cobertura</report>
	            </reports>
	          </reportSet>
	        </reportSets>
	      </plugin>
	    ...
	    </plugins>
	</reporting>
...
</project>
```

- execute the following goal
```cmd
mvn cobertura:cobertura
```

##### Resources:
[Cobertura: Usage](http://www.mojohaus.org/cobertura-maven-plugin/usage.html)
