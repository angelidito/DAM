#!/bin/bash

#@defaults write com.apple.terminal StringEncodings -array 4

DIR0=$(dirname $0)
cd $DIR0

#export PATH=/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Home/bin
export CLASSPATH=bin
export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

java Archivo