grammar MiniJava;

Goal                :	MainClass ( ClassDeclaration )* EOF;
MainClass           :	'class' Identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' Identifier ')' '{' Statement '}' '}';
ClassDeclaration	:	'class' Identifier ( 'extends' Identifier )? '{' ( VarDeclaration )* ( MethodDeclaration )* '}';
VarDeclaration      :	Type Identifier ';';
MethodDeclaration   :	'public' Type Identifier '(' ( Type Identifier ( ',' Type Identifier )* )? ')' '{' ( VarDeclaration )* ( Statement )* 'return' Expression ';' '}';

Type
:	'int' '[' ']'
|	'boolean'
|	'int'
|	Identifier;

Statement
:	'{' ( Statement )* '}'
|	'if' '(' Expression ')' Statement 'else' Statement
|	'while' '(' Expression ')' Statement
|	'System.out.println' '(' Expression ')' ';'
|	Identifier '=' Expression ';'
|	Identifier '[' Expression ']' '=' Expression ';';

Expression
:	Expression ( '&&' | '<' | '+' | '-' | '*' ) Expression
|	Expression '[' Expression ']'
|	Expression '.' 'length'
|	Expression '.' Identifier '(' ( Expression ( ',' Expression )* )? ')'
|	IntegerLiteral
|	'true'
|	'false'
|	Identifier
|	'this'
|	'new' 'int' '[' Expression ']'
|	'new' Identifier '(' ')'
|	'!' Expression
|	'(' Expression ')';

Digit				:	[0-9];
NonZeroDigit		:	[1-9];
Alphabet			:	[a-zA-Z];
Boolean				:	'true'	|	'false';
IntegerLiteral		:	Digit	|	NonZeroDigit Digit*;
Identifier			:	(Alphabet | '_')+ (Digit | Alphabet | '_')*;
