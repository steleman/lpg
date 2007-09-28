TARGET = Expr
EXT = .exe
CXX = g++
CXXFLAGS = -I../../lpg.runtime.cpp -g -Wall
LPG = ./lpg.sh
LPG_LEXER_FLAGS  = -template=LexerTemplate.g -export_terminals='ExprParsersym.h'
LPG_PARSER_FLAGS = -variables=nt -ast_type=int -template=dtParserTemplate.g
SRC = $(shell ls *.cpp)
OBJ = $(SRC:.cpp=.o)

$(TARGET)$(EXT) : $(OBJ)
	$(CXX) -o $(TARGET) $(OBJ)

generate :
	$(LPG) $(LPG_LEXER_FLAGS) $(TARGET)Lexer.g
	$(LPG) $(LPG_PARSER_FLAGS) $(TARGET)Parser.g
	g++ -MM -MG $(CXXFLAGS) *.cpp >makefile.depend

clean:
	rm -f $(TARGET).exe
	rm -f *.o *.obj
	rm -f makefile.depend

.cpp.o:
	$(CXX) $(CXXFLAGS) -c $<

-include makefile.depend