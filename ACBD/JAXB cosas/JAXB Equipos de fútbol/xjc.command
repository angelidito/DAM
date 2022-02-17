#!/bin/bash
clear
# export PATH=/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home/bin
export PATH=/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/bin
export CLASSPATH=bin
export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

# Javac -version
java -version

if [ -n "$1" ]; then # If first parameter passed then print Hi
	xjc -p src.$1 $2
else
	xjc -p src.xjcClasses xdata/equipos_futbol.xsd
fi

echo
