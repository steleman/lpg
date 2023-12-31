--
-- This XML parser extends an XML parser based on the document:
--
--     http://www.w3.org/TR/2004/REC-xml-20040204
--
-- with the changes specified in the document
--
--     http://www.w3.org/TR/1999/REC-xml-names-19990114/
--
%options variables=nt
%options la=15
%options fp=XmlParser
%options error-maps
%options scopes
%options single_productions
%options package=xmlparser
%options template=dtUnifiedTemplateF.gi

%Include
    XmlNSCharSubsets.gi
%End

%Import
  
  "XmlParser.g"

  %DropSymbols
      element
      Attribute
      doctypedecl
      elementdecl
      InnerMixedContent
      AttlistDecl
      AttDef

  %DropRules
      cp ::= Name
           | Name '?'
           | Name '*'
           | Name '+'
%End

%Rules
    --[1]   NSAttName ::= PrefixedAttName 
    --                  | DefaultAttName 
    --[2]   PrefixedAttName ::= 'xmlns:' NCName [  NSC: Leading "XML" ]
    --[3]   DefaultAttName ::= 'xmlns'
    --
    -- We extends the definition of NSAttName here with QName:
    --
    --      NSAttName ::= QName
    --
    NSAttName ::= 'x' 'm' 'l' 'n' 's'
                | 'x' 'm' 'l' 'n' 's' ':' NCName
                | AttNCNamePrefix
                | AttNCNamePrefix ':' NCName

    AttNCNamePrefix ::= 'x'
                      | 'x' 'm'
                      | 'x' 'm' 'l'
                      | 'x' 'm' 'l' 'n'

                      | ComplexAttNCNamePrefix

    ComplexAttNCNamePrefix ::= NameChar[^x:]
                             | 'x' NameChar[^m:]
                             | 'x' 'm' NameChar[^l:]
                             | 'x' 'm' 'l' NameChar[^n:]
                             | 'x' 'm' 'l' 'n' NameChar[^s:]
                             | 'x' 'm' 'l' 'n' 's' NameChar[^:]

                             | ComplexAttNCNamePrefix NameChar[^:]

    --[4]   NCName ::= (Letter | '_') (NCNameChar)* /*  An XML Name, minus the ":" */ 
    --[5]   NCNameChar ::= Letter | Digit | '.' | '-' | '_' | CombiningChar | Extender 
    NCName ::= Letter
            | '_'
            | NCName NameChar[^:]

    --[6]   QName ::= (Prefix ':')? LocalPart 
    --[7]   Prefix ::= NCName 
    --[8]   LocalPart ::= NCName 
    QName ::= NCName
           | NCName ':' NCName

    -- [9]   STag ::= '<' QName (S Attribute)* S? '>'  [  NSC: Prefix Declared ] 
    --[10]  ETag ::= '</' QName S? '>' [  NSC: Prefix Declared ] 
    --[11]  EmptyElemTag ::= '<' QName (S Attribute)* S? '/>' [  NSC: Prefix Declared ] 
    element ::= '<' QName Attributes '/' '>'
              | '<' QName Attributes WhiteSpaces '/' '>'

              | '<' QName$SName Attributes '>' content  '<' '/' QName$EName '>'
        /.
                    checkNames($SName, $EName);
                    setResult(new Ast());
        ./
              | '<' QName$SName Attributes WhiteSpaces '>' content  '<' '/' QName$EName '>'
        /.
                    setResult(new Ast());
        ./
              | '<' QName$SName Attributes '>' content  '<' '/' QName$EName WhiteSpaces '>' 
        /.
                    setResult(new Ast());
        ./
              | '<' QName$SName Attributes WhiteSpaces '>' content  '<' '/' QName$EName WhiteSpaces$ '>' 
        /.
                    setResult(new Ast());
        ./

    --[12]  Attribute ::= NSAttName Eq AttValue 
    --                  | QName Eq AttValue [  NSC: Prefix Declared ] 
    --
    -- NSAttName subsumes QName. See above
    --
    Attribute ::= NSAttName Eq AttValue 

    -- [13]  doctypedecl ::= '<!DOCTYPE' S QName (S ExternalID)? S? ('[' (markupdecl | PEReference | S)* ']' S?)? '>' 
    doctypedecl ::= '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName WhiteSpaces '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName '[' intSubset ']' '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName '[' intSubset ']' WhiteSpaces '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName WhiteSpaces '[' intSubset ']' '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName WhiteSpaces '[' intSubset ']' WhiteSpaces '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName WhiteSpaces ExternalID '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName WhiteSpaces ExternalID WhiteSpaces '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName WhiteSpaces ExternalID '[' intSubset ']' '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName WhiteSpaces ExternalID '[' intSubset ']' WhiteSpaces '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName WhiteSpaces ExternalID WhiteSpaces '[' intSubset ']' '>'
                  | '<' '!' 'D' 'O' 'C' 'T' 'Y' 'P' 'E' WhiteSpaces QName WhiteSpaces ExternalID WhiteSpaces '[' intSubset ']' WhiteSpaces '>'

    -- [14]  elementdecl ::= '<!ELEMENT' S QName S contentspec S? '>'
    elementdecl ::= '<' '!' 'E' 'L' 'E' 'M' 'E' 'N' 'T' WhiteSpaces QName WhiteSpaces contentspec '>'
                  | '<' '!' 'E' 'L' 'E' 'M' 'E' 'N' 'T' WhiteSpaces QName WhiteSpaces contentspec WhiteSpaces '>'

    -- [15]  cp ::= (QName | choice | seq) ('?' | '*' | '+')? 
    cp ::= QName
         | QName '?'
         | QName '*'
         | QName '+'

    -- [16]  Mixed ::= '(' S? '#PCDATA' (S? '|' S? QName)* S? ')*'  
    --               | '(' S? '#PCDATA' S? ')'  
    InnerMixedContent ::= '|' QName
                        | '|' WhiteSpaces QName
                        | WhiteSpaces '|' QName
                        | WhiteSpaces '|' WhiteSpaces QName
                        | InnerMixedContent '|' QName
                        | InnerMixedContent '|' WhiteSpaces QName
                        | InnerMixedContent WhiteSpaces '|' QName
                        | InnerMixedContent WhiteSpaces '|' WhiteSpaces QName


    -- [17]  AttlistDecl ::= '<!ATTLIST' S QName AttDef* S? '>' 
    AttlistDecl ::= '<' '!' 'A' 'T' 'T' 'L' 'I' 'S' 'T' WhiteSpaces QName AttDef* '>' 
                  | '<' '!' 'A' 'T' 'T' 'L' 'I' 'S' 'T' WhiteSpaces QName AttDef* WhiteSpaces '>' 

    -- [18]  AttDef ::= S (QName | NSAttName) S AttType S DefaultDecl 
    --
    -- NSAttName subsumes QName. See above
    --
    AttDef ::= WhiteSpaces NSAttName WhiteSpaces$ AttType WhiteSpaces$ DefaultDecl 
%End
