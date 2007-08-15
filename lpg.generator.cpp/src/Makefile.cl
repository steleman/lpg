# Makefile for
# jikespg 

# Makefile generated with AutoMake (Ver. 3.75 )
# Generation time: Fri Jun 11 16:29:05 2004

# No user profile.

# Command line argument to produce this makefile
# am3 -fuse LexStream.cpp base.cpp buffer.cpp c.cpp code.cpp 
# control.cpp cpp.cpp dfa.cpp diagnose.cpp dump.cpp generator.cpp xml.cpp 
# grammar.cpp JavaTable.cpp jikespg.cpp jikespg_act.cpp jikespg_init.cpp 
# jikespg_prs.cpp MlTable.cpp option.cpp parser.cpp pda.cpp PlxTable.cpp PlxasmTable.cpp produce.cpp 
# resolve.cpp scanner.cpp sp.cpp symbol.cpp tab.cpp table.cpp util.cpp 


ERASE=rm -f
GCC=cc
GCPPC=cl -O -EHsc -DWIN32
#GCPPC=cl -O -DNDEBUG -EHsc -DWIN32
#GCPPC=cl -Zi -EHsc -DTEST -DWIN32
#GCPPC=cl -Zi -EHsc -DWIN32
GPL8C=plix
GLINK=$AUTOLINKER
GSLINK=$AUTOLINKER
GLIBMAN=ar
GASM=as

GLFLAGS=-L. 

GPL8LFLAGS=-L. 

GCPPFLAGS=

GCPPLFLAGS=-L. 

all:  lpg.exe

jikespg_sym.h: jikespg.g
	lpg jikespg.g
	$(ERASE) jikespg.l

jikespg_prs.h: jikespg.g
	lpg jikespg.g
	$(ERASE) jikespg.l

jikespg_prs.cpp: jikespg.g
	lpg jikespg.g
	$(ERASE) jikespg.l

jikespg_act.h: jikespg.g
	lpg jikespg.g
	$(ERASE) jikespg.l

jikespg_act.cpp: jikespg.g
	lpg jikespg.g
	$(ERASE) jikespg.l

jikespg_init.cpp: jikespg.g
	lpg jikespg.g
	$(ERASE) jikespg.l


lpg.exe:  jikespg.obj symbol.obj code.obj util.obj grammar.obj scanner.obj tab.obj \
	  LexStream.obj parser.obj jikespg_prs.obj jikespg_act.obj table.obj base.obj \
	  resolve.obj sp.obj pda.obj produce.obj dfa.obj buffer.obj generator.obj \
	  CTable.obj CppTable.obj PlxTable.obj PlxasmTable.obj JavaTable.obj MlTable.obj XmlTable.obj \
	  control.obj option.obj jikespg_init.obj diagnose.obj dump.obj Action.obj \
	  CAction.obj CppAction.obj PlxAction.obj PlxasmAction.obj JavaAction.obj MlAction.obj XmlAction.obj
	$(GCPPC) $(GCPPFLAGS) -olpg jikespg.obj symbol.obj code.obj util.obj grammar.obj scanner.obj tab.obj \
	  LexStream.obj parser.obj jikespg_prs.obj jikespg_act.obj table.obj base.obj \
	  resolve.obj sp.obj pda.obj produce.obj dfa.obj buffer.obj generator.obj \
	  CTable.obj CppTable.obj PlxTable.obj PlxasmTable.obj JavaTable.obj MlTable.obj XmlTable.obj \
	  control.obj option.obj jikespg_init.obj diagnose.obj dump.obj Action.obj \
	  CAction.obj CppAction.obj PlxAction.obj PlxasmAction.obj JavaAction.obj MlAction.obj XmlAction.obj

jikespg.obj:  jikespg.cpp symbol.h buffer.h tuple.h code.h util.h option.h \
	  blocks.h scanner.h jikespg_sym.h LexStream.h tab.h \
	  control.h grammar.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h 
	$(GCPPC) -c $(GCPPFLAGS) jikespg.cpp 

symbol.obj:  symbol.cpp symbol.h buffer.h tuple.h code.h util.h 
	$(GCPPC) -c $(GCPPFLAGS) symbol.cpp 

code.obj:  code.cpp code.h 
	$(GCPPC) -c $(GCPPFLAGS) code.cpp 

util.obj:  util.cpp util.h tuple.h 
	$(GCPPC) -c $(GCPPFLAGS) util.cpp 

grammar.obj:  grammar.cpp Action.h \
	  CAction.h CppAction.h PlxAction.h PlxasmAction.h JavaAction.h MlAction.h XmlAction.h \
	  control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h 
	$(GCPPC) -c $(GCPPFLAGS) grammar.cpp 

CAction.obj:  NTC.h CTC.h Action.h CAction.h CAction.cpp \
          control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h 
	$(GCPPC) -c $(GCPPFLAGS) CAction.cpp 

CppAction.obj:  NTC.h CTC.h Action.h CAction.h CppAction.h CppAction.cpp \
          control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h 
	$(GCPPC) -c $(GCPPFLAGS) CppAction.cpp 

PlxAction.obj:  NTC.h CTC.h Action.h PlxAction.h PlxAction.cpp \
          control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h 
	$(GCPPC) -c $(GCPPFLAGS) PlxAction.cpp 

PlxasmAction.obj:  NTC.h CTC.h Action.h PlxAction.h PlxasmAction.h PlxasmAction.cpp \
          control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h 
	$(GCPPC) -c $(GCPPFLAGS) PlxasmAction.cpp 

JavaAction.obj:  NTC.h CTC.h Action.h JavaAction.h JavaAction.cpp \
          control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h 
	$(GCPPC) -c $(GCPPFLAGS) JavaAction.cpp 

MlAction.obj:  NTC.h CTC.h Action.h MlAction.h MlAction.cpp \
          control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h 
	$(GCPPC) -c $(GCPPFLAGS) MlAction.cpp 

XmlAction.obj:  NTC.h CTC.h Action.h XmlAction.h XmlAction.cpp \
          control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h 
	$(GCPPC) -c $(GCPPFLAGS) XmlAction.cpp 

Action.obj: NTC.h CTC.h TTC.h LCA.h Action.h Action.cpp JavaAction.h JavaAction.cpp \
          control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h 
	$(GCPPC) -c $(GCPPFLAGS) Action.cpp 

scanner.obj:  scanner.cpp scanner.h code.h jikespg_sym.h \
	  option.h util.h tuple.h blocks.h symbol.h buffer.h LexStream.h \
	  tab.h 
	$(GCPPC) -c $(GCPPFLAGS) scanner.cpp 

tab.obj:  tab.cpp tab.h code.h 
	$(GCPPC) -c $(GCPPFLAGS) tab.cpp 

LexStream.obj:  LexStream.cpp LexStream.h jikespg_sym.h code.h \
	  option.h util.h tuple.h blocks.h symbol.h buffer.h tab.h 
	$(GCPPC) -c $(GCPPFLAGS) LexStream.cpp 

parser.obj:  parser.cpp parser.h jikespg_prs.h jikespg_sym.h \
	  LexStream.h code.h option.h util.h tuple.h blocks.h symbol.h buffer.h \
	  tab.h jikespg_act.h Stacks.h control.h 
	$(GCPPC) -c $(GCPPFLAGS) parser.cpp 

jikespg_prs.obj:  jikespg_prs.cpp jikespg_prs.h jikespg_sym.h \
	  LexStream.h code.h option.h util.h tuple.h blocks.h symbol.h buffer.h \
	  tab.h 
	$(GCPPC) -c $(GCPPFLAGS) jikespg_prs.cpp 

jikespg_act.obj:  jikespg_act.cpp jikespg_act.h Stacks.h jikespg_prs.h \
	  jikespg_sym.h LexStream.h code.h option.h util.h \
	  tuple.h blocks.h symbol.h buffer.h tab.h 
	$(GCPPC) -c $(GCPPFLAGS) jikespg_act.cpp 

table.obj:  table.cpp table.h tuple.h set.h pda.h control.h option.h util.h \
	  code.h blocks.h symbol.h grammar.h scanner.h \
	  jikespg_sym.h LexStream.h tab.h parser.h \
	  jikespg_prs.h jikespg_act.h Stacks.h node.h produce.h dfa.h \
	  base.h buffer.h 
	$(GCPPC) -c $(GCPPFLAGS) table.cpp 

base.obj:  base.cpp control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h base.h 
	$(GCPPC) -c $(GCPPFLAGS) base.cpp 

resolve.obj:  resolve.cpp control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h resolve.h base.h pda.h produce.h dfa.h 
	$(GCPPC) -c $(GCPPFLAGS) resolve.cpp 

sp.obj:  sp.cpp sp.h control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h pda.h produce.h dfa.h base.h 
	$(GCPPC) -c $(GCPPFLAGS) sp.cpp 

pda.obj:  pda.cpp control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h base.h pda.h produce.h dfa.h resolve.h sp.h 
	$(GCPPC) -c $(GCPPFLAGS) pda.cpp 

produce.obj:  produce.cpp control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h produce.h dfa.h partition.h base.h pda.h 
	$(GCPPC) -c $(GCPPFLAGS) produce.cpp 

dfa.obj:  dfa.cpp control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h base.h dfa.h 
	$(GCPPC) -c $(GCPPFLAGS) dfa.cpp 

buffer.obj:  buffer.cpp util.h tuple.h buffer.h 
	$(GCPPC) -c $(GCPPFLAGS) buffer.cpp 

generator.obj:  generator.cpp generator.h tuple.h pda.h control.h option.h \
	  util.h code.h blocks.h symbol.h grammar.h scanner.h \
	  jikespg_sym.h LexStream.h tab.h parser.h \
	  jikespg_prs.h jikespg_act.h Stacks.h set.h node.h produce.h dfa.h \
	  base.h table.h buffer.h frequency.h partition.h 
	$(GCPPC) -c $(GCPPFLAGS) generator.cpp 

CTable.obj:  CTable.cpp control.h option.h util.h tuple.h code.h blocks.h symbol.h \
	  grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h partition.h CTable.h pda.h produce.h dfa.h base.h table.h \
	  buffer.h 
	$(GCPPC) -c $(GCPPFLAGS) CTable.cpp 

CppTable.obj:  CppTable.cpp control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h partition.h CppTable.h CTable.h pda.h produce.h dfa.h base.h \
	  table.h buffer.h 
	$(GCPPC) -c $(GCPPFLAGS) CppTable.cpp 

PlxTable.obj:  PlxTable.cpp tuple.h PlxTable.h control.h option.h util.h code.h blocks.h \
	  symbol.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h pda.h produce.h dfa.h base.h table.h buffer.h 
	$(GCPPC) -c $(GCPPFLAGS) PlxTable.cpp 

PlxasmTable.obj:  PlxasmTable.cpp tuple.h PlxasmTable.h control.h option.h util.h code.h blocks.h \
	  symbol.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h pda.h produce.h dfa.h base.h table.h buffer.h 
	$(GCPPC) -c $(GCPPFLAGS) PlxasmTable.cpp 

JavaTable.obj:  JavaTable.cpp control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h partition.h JavaTable.h table.h pda.h produce.h dfa.h \
	  base.h buffer.h 
	$(GCPPC) -c $(GCPPFLAGS) JavaTable.cpp 

XmlTable.obj:  XmlTable.cpp XmlTable.h table.h tuple.h set.h pda.h control.h \
	  option.h util.h code.h blocks.h symbol.h grammar.h \
	  scanner.h jikespg_sym.h LexStream.h tab.h parser.h \
	  jikespg_prs.h jikespg_act.h Stacks.h node.h produce.h dfa.h \
	  base.h buffer.h 
	$(GCPPC) -c $(GCPPFLAGS) XmlTable.cpp 

MlTable.obj:  MlTable.cpp control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h partition.h MlTable.h table.h pda.h produce.h dfa.h \
	  base.h buffer.h 
	$(GCPPC) -c $(GCPPFLAGS) MlTable.cpp 

control.obj:  control.cpp control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h generator.h pda.h produce.h dfa.h base.h table.h \
	  buffer.h CTable.h CppTable.h PlxTable.h PlxasmTable.h JavaTable.h XmlTable.h MlTable.h 
	$(GCPPC) -c $(GCPPFLAGS) control.cpp 

option.obj:  option.cpp control.h option.h util.h tuple.h code.h blocks.h \
	  symbol.h buffer.h grammar.h scanner.h jikespg_sym.h \
	  LexStream.h tab.h parser.h jikespg_prs.h jikespg_act.h Stacks.h \
	  set.h node.h 
	$(GCPPC) -c $(GCPPFLAGS) option.cpp 

jikespg_init.obj:  jikespg_init.cpp jikespg_act.h Stacks.h jikespg_prs.h \
	  jikespg_sym.h LexStream.h code.h option.h util.h \
	  tuple.h blocks.h symbol.h buffer.h tab.h 
	$(GCPPC) -c $(GCPPFLAGS) jikespg_init.cpp 

diagnose.obj:  diagnose.h parser.h diagnose.cpp util.h tuple.h jikespg_prs.h \
	  jikespg_sym.h LexStream.h code.h option.h blocks.h \
	  symbol.h buffer.h tab.h 
	$(GCPPC) -c $(GCPPFLAGS) diagnose.cpp 

dump.obj:  dump.cpp LexStream.h jikespg_sym.h code.h option.h \
	  util.h tuple.h blocks.h symbol.h buffer.h tab.h 
	$(GCPPC) -c $(GCPPFLAGS) dump.cpp 

clean:
	$(ERASE) lpg.exe
	$(ERASE) Action.obj
	$(ERASE) CAction.obj
	$(ERASE) CppAction.obj
	$(ERASE) JavaAction.obj
	$(ERASE) MlAction.obj
	$(ERASE) PlxAction.obj
	$(ERASE) PlxasmAction.obj
	$(ERASE) XmlAction.obj
	$(ERASE) jikespg.obj
	$(ERASE) symbol.obj
	$(ERASE) code.obj
	$(ERASE) util.obj
	$(ERASE) grammar.obj
	$(ERASE) scanner.obj
	$(ERASE) tab.obj
	$(ERASE) LexStream.obj
	$(ERASE) parser.obj
	$(ERASE) jikespg_prs.obj
	$(ERASE) jikespg_act.obj
	$(ERASE) table.obj
	$(ERASE) base.obj
	$(ERASE) resolve.obj
	$(ERASE) sp.obj
	$(ERASE) pda.obj
	$(ERASE) produce.obj
	$(ERASE) dfa.obj
	$(ERASE) buffer.obj
	$(ERASE) generator.obj
	$(ERASE) CTable.obj
	$(ERASE) CppTable.obj
	$(ERASE) PlxTable.obj
	$(ERASE) PlxasmTable.obj
	$(ERASE) JavaTable.obj
	$(ERASE) XmlTable.obj
	$(ERASE) MlTable.obj
	$(ERASE) control.obj
	$(ERASE) option.obj
	$(ERASE) jikespg_init.obj
	$(ERASE) diagnose.obj
	$(ERASE) dump.obj
cleaner:
	$(ERASE) lpg.exe
	$(ERASE) Action.obj
	$(ERASE) CAction.obj
	$(ERASE) CppAction.obj
	$(ERASE) JavaAction.obj
	$(ERASE) MlAction.obj
	$(ERASE) PlxAction.obj
	$(ERASE) PlxasmAction.obj
	$(ERASE) XmlAction.obj
	$(ERASE) jikespg.obj
	$(ERASE) symbol.obj
	$(ERASE) code.obj
	$(ERASE) util.obj
	$(ERASE) grammar.obj
	$(ERASE) scanner.obj
	$(ERASE) tab.obj
	$(ERASE) LexStream.obj
	$(ERASE) parser.obj
	$(ERASE) jikespg_prs.obj
	$(ERASE) jikespg_act.obj
	$(ERASE) table.obj
	$(ERASE) base.obj
	$(ERASE) resolve.obj
	$(ERASE) sp.obj
	$(ERASE) pda.obj
	$(ERASE) produce.obj
	$(ERASE) dfa.obj
	$(ERASE) buffer.obj
	$(ERASE) generator.obj
	$(ERASE) CTable.obj
	$(ERASE) CppTable.obj
	$(ERASE) PlxTable.obj
	$(ERASE) PlxasmTable.obj
	$(ERASE) JavaTable.obj
	$(ERASE) XmlTable.obj
	$(ERASE) MlTable.obj
	$(ERASE) control.obj
	$(ERASE) option.obj
	$(ERASE) jikespg_init.obj
	$(ERASE) diagnose.obj
	$(ERASE) dump.obj
	$(ERASE) jikespg_sym.h
	$(ERASE) jikespg_def.h
	$(ERASE) jikespg_prs.h
	$(ERASE) jikespg_prs.cpp
	$(ERASE) jikespg_act.h
	$(ERASE) jikespg_act.cpp
	$(ERASE) jikespg_init.cpp
