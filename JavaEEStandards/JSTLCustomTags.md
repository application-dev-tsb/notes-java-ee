# JSTL: Custom Tags

How to Implement a Custom Tag:
* Implement the Proper Interface
```java
//Classic Tag Handlers
javax.servlet.jsp.tagext.Tag
javax.servlet.jsp.tagext.BodyTag
javax.servlet.jsp.tagext.IterationTag

//Simple Tag Handlers
javax.servlet.jsp.tagext.SimpleTag

//Example:
package net.episoder.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class GoogleAnalyticsTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("Google Analytics Tag Here");
	}
}
```
* Reference the tag library in your JSP source using the JSP <taglib> directive. A tag library is a collection of JSP tags. Create a Tag Library Descriptor file (ex: GoogleAnalyticsTag.tld)
```xml
<!-- WEB-INF/GoogleAnalyticsTag.tld -->
<taglib>
  <tlib-version>1.2</tlib-version>
  <jsp-version>2.3</jsp-version>
  <short-name>Google Analytics Tag Library</short-name>
  <uri>http://www.episoder.net/taglibs/ga</uri>

  <tag>
    <name>GoogleAnalytics</name>
    <tag-class>net.episoder.web.tag.GoogleAnalyticsTag</tag-class>
    <body-content>empty</body-content>
  </tag>
	
</taglib>
```
* Reference the tag library in the JSP 
```xml
<%@ taglib uri="http://www.episoder.net/taglibs/ga" prefix="ga" %>
<html>
<body>
  <ga:GoogleAnalytics/>
</body>
</html>
```

Source:
* [Oracle: Understanding and Creating Custom JSP Tags](https://docs.oracle.com/cd/E11035_01/wls100/taglib/quickstart.html)
