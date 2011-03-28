#!/bin/bash

for jfile in *.java; do
    diff --brief $jfile GOLDEN/$jfile
done
