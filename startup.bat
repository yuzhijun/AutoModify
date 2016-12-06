@echo off
SetLocal EnableDelayedExpansion
FOR %%i IN (".\lib\*.jar") DO SET CLASSPATH=!CLASSPATH!;%%~fi
set CLASSPATH=%CLASSPATH%;.\conf;.\bin

java -Xms50m -Xmx250m com.lenovo.automodify.Main
EndLocal
pause