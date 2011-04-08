#!/bin/bash

JUNIT_JAR=/Developer/junit-4.8.2.jar
TEST_CLASS_LOC=$HOME/eclipse/workspaces/lpg/lpg.test/bin

usageMsg="$0 [--help] [--junit junit4-jar-location] [--testClassLoc <test class folder/jar>]"

while [ $# != 0 ]; do
    case $1 in
        --junit)
            JUNIT_JAR=$2
            shift ;;
        --testClassLoc)
            TEST_CLASS_LOC=$2
            shift ;;
        --help)
            echo $usageMsg
            exit 0 ;;
    esac
    shift
done

if [[ ! -r "$JUNIT_JAR" ]]; then
    echo "JUnit4 jar file $JUNIT_JAR does not exist"
    echo "$usageMsg"
    echo "You can find the JUnit4 distribution at http://www.junit.org"
    exit 1
fi

if [[ ! -r "$TEST_CLASS_LOC" || ! -r "$TEST_CLASS_LOC/GeneratorTest.class" ]]; then
    echo "Couldn't find test class GeneratorTest at $TEST_CLASS_LOC"
    echo "Please specify the correct path using the -testClassLoc option"
    echo "$usageMsg"
    exit 1
fi

echo "Using JUnit4 at $JUNIT_JAR"
echo "Using test class GeneratorTest at $TEST_CLASS_LOC"

java -cp ${JUNIT_JAR}:${TEST_CLASS_LOC} org.junit.runner.JUnitCore GeneratorTest
