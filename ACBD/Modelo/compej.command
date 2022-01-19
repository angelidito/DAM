#!/bin/bash

export nombre=Archivo

DIR0=$(dirname $0)
cd $DIR0
#export PATH=/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Home/bin
%export CLASSPATH=bin
export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8



echo ----
echo $nombre
echo ----

javac -d bin -sourcepath src src/$nombre.java 

ls bin

export CLASSPATH=bin

java $nombre