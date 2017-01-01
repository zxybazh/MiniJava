grammar MiniJava;

goal                :   mainClass classDeclaration* EOF;

mainClass           :   'class' Identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' Identifier ')' '{' statement '}' '}';
classDeclaration    :   'class' Identifier ( 'extends' Identifier )? '{' VarDeclaration* methodDeclaration* '}';
Parameter           :   Type Identifier;
VarDeclaration      :   Parameter ';';
methodDeclaration   :   'public' Type Identifier '(' ParameterList? ')' '{' VarDeclaration* statement* 'return' expression ';' '}';
ParameterList       :   Parameter (',' Parameter)*;


Digit               :   [0-9];
NonZeroDigit        :   [1-9];
Alphabet            :   [a-zA-Z];
Boolean             :   'true' | 'false';

Relation            :   '**' | '*' | '/' | '+' | '-' | '>' | '<' | '=' | '&&' | '||';
IntegerLiteral      :   '0' | NonZeroDigit Digit*;
AlphabetPlus        :   [a-zA-Z_];
AlphabetDigitPlus   :   [0-9a-zA-Z_];
Identifier          :   AlphabetPlus AlphabetDigitPlus*;
Decimal             :   IntegerLiteral? '.' Digit*;
WhiteSpace          :   [ \r\t\n]+ -> skip;
MULTILINE_COMMENT   :   '/*' .*? '*/' -> skip;
LINE_COMMENT        :   '//' .*? '\n' -> skip;
DotLength           :   '.length';

Type
:    'int' '[' ']'
|    'boolean'
|    'int'
|    Identifier;

statement
:    '{' statement* '}'
|    'if' '(' expression ')' statement 'else' statement ';'
|    'while' '(' expression ')' statement ';'
|    'System.out.println' '(' expression ')' ';'
|    Identifier '=' expression ';'
|    Identifier '[' expression ']' '=' expression ';'
;

expression
:    expression DotLength
|    expression '[' expression ']'
|    expression '.' Identifier '(' ( expression ( ',' expression )* )? ')'
|    expression Relation expression
|    'this'
|    'new' 'int' '[' expression ']'
|    'new' Identifier '(' ')'
|    '!' expression
|    '(' expression ')'
|    IntegerLiteral
|    Decimal
|    Boolean
|    Identifier
;
