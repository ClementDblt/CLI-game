@echo off
javac Main.java
java Main
pause
cd src
del *.class
cd ..
del *.class
exit