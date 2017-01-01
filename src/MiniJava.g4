grammar MiniJava;

Goal				:	MainClass ClassDeclaration* EOF;

MainClass			:	'class' Identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' Identifier ')' '{' Statement '}' '}';
ClassDeclaration	:	'class' Identifier ( 'extends' Identifier )? '{' VarDeclaration* MethodDeclaration* '}';
Parameter			:	Type Identifier;
VarDeclaration		:	Parameter ';';
MethodDeclaration	:	'public' Type Identifier '(' ParameterList? ')' '{' VarDeclaration* Statement* 'return' Expression ';' '}';
ParameterList		:	Parameter (',' Parameter)*;


Digit				:	[0-9];
NonZeroDigit		:	[1-9];
Alphabet			:	[a-zA-Z];
Boolean				:	'true'	|	'false';

Relation			:	'**'	|	'*'	|	'/'	|	'+'	|	'-'	|	'>'	|	'<'	|	'=='	|	'&&'	|	'||';
IntegerLiteral		:	'0'	|	NonZeroDigit Digit*;
AlphabetPlus		:	[a-zA-Z_];
AlphabetDigitPlus	:	[0-9a-zA-Z_];
Identifier			:	AlphabetPlus AlphabetDigitPlus*;
Decimal				:	IntegerLiteral '.' Digit*;

WhiteSpace			:	[ \r\t\n]+ -> skip;
MULTILINE_COMMENT	:	'/*' .*? '*/' -> skip;
LINE_COMMENT		:	'//' .*? '\n' -> skip;

DotLength			:	'.' 'length';
LSB					:	'[';
RSB					:	']';

Type
:	'int' '[' ']'
|	'boolean'
|	'int'
|	Identifier;

Statement
:	'{' Statement* '}'
|	'if' '(' Expression ')' Statement 'else' Statement ';'
|	'while' '(' Expression ')' Statement ';'
|	'System.out.println' '(' Expression ')' ';'
|	Identifier '==' Expression ';'
|	Identifier '[' Expression ']' '==' Expression ';'
;

Expression
:	Expression Goal Expression RSB
|	Expression DotLength
|	Expression '.' Identifier '(' ( Expression ( ',' Expression )* )? ')'
|	Expression Relation Expression
|	'this'
|	'new' 'int' LSB Expression RSB
|	'new' Identifier '(' ')'
|	'!' Expression
|	'(' Expression ')'
|	IntegerLiteral
|   Decimal
|	Boolean
|	Identifier
;
