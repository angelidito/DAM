#!/bin/bash

export PATH=/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home/bin
# export PATH=/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/bin
export CLASSPATH=bin
export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

Javac -version 
java -version

xjc -p xjcCommand src/data/nombres.xsd