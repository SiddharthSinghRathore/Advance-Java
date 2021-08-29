
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plugin Demo</title>
    </head>
    <body>
        <h3>Applet loaded</h3>
        <jsp:plugin type="applet" code="Siddharth.class" codebase="." height="500" width="600">
            <jsp:fallback>
                Plugin Tag Not Supported By Browser
            </jsp:fallback>
        </jsp:plugin>
                <h4>
                    <font color="red">Applet is loaded using Plugin</font>
                </h4>
    </body>
</html>