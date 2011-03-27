LEXER_SRCS = JikesPGLexer.cpp JikesPGKWLexer.cpp JikesPGKWLexerprs.cpp JikesPGLexerprs.cpp

LEXER_OBJS = $(LEXER_SRCS:.cpp=.o)

bootstrap: $(LEXER_OBJS)

clean:
	rm $(LEXER_OBJS)

.SUFFIXES: .cpp

.cpp.o:
	g++ -I../../lpg.runtime.cpp -c $<
