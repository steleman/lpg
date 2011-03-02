#!/bin/bash

usageMsg="Usage: $0 <tag>"

while [ $# != 0 ]; do
  case $1 in
    --help)
	  echo "$usageMsg"
	  exit 0
	  ;;
    *)
	  tag=$1
	  ;;
  esac
  shift
done

if [ -z "$tag" ]; then
    echo "No tag specified!"
    echo "$usageMsg"
    exit 1
fi

projects="lpg.generator lpg.generator.cpp lpg.generator.feature lpg.runtime lpg.runtime.java lpg.runtime.feature lpg.update"

cvs rtag -r HEAD $tag $projects
