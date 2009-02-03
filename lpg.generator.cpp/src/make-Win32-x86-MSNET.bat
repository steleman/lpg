REM Build generator executable using Microsoft .Net Studio compiler for Win32-x86 platform.
REM TODO: Turn this into a proper Makefile usable by cygwin/gnu make.

cl /Zi /EHsc /DWIN32 /Felpg-win32_x86 *.cpp
move lpg-win32_x86.exe lpg-win32_x86

