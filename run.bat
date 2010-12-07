if not "%JAVA_HOME%" == "" goto USE_JAVA_HOME

set JAVA=java

echo JAVA_HOME is not set.  Unexpected results may occur.
echo Set JAVA_HOME to the directory of your local JDK to avoid this message.
goto SKIP_JAVA_HOME

:USE_JAVA_HOME

set JAVA=%JAVA_HOME%\bin\java


:SKIP_JAVA_HOME


%JAVA% -classpath "xample.jar;lib/xml-apis.jar;lib/xercesImpl.jar;lib/xmleditor.jar;lib/mdate.jar" com.fg.xample.XAmple


