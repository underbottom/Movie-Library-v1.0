#!/bin/sh

rm -rf ./target/*
echo "************ UNDEPLOYING *******************"
asadmin undeploy MovieLibraryPro
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
asadmin deploy target/MovieLibraryPro.war
