#!/bin/sh
LPG_BASE=../..
LPG=$LPG_BASE/lpg.generator.cpp/src/bin/lpg.exe
export LPG_TEMPLATE=$LPG_BASE/lpg.runtime.cpp/templates
export LPG_INCLUDE=$LPG_BASE/lpg.runtime.cpp/include
$LPG $*
