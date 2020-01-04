grammar g;

/*parser*/

axiom: importLib* MODIFIER? 'class_SJ' CLASS_NAME L_BR declaration* mainBlock? R_BR EOF;
importLib: 'import' lib SEMI_COLON+;
lib: LIBRARY | ID;
declaration: VAR_TYPE idList SEMI_COLON+;
idList: ID (COMA ID)*;
mainBlock: 'main_SJ' instBlock;
instBlock: L_BR instruction* R_BR;
instruction: (affectation | input | output) SEMI_COLON+
            | condition;
affectation: ID ASSIGN expression;
expression : L_PAREN expression R_PAREN # ExpParen
            | MINUS expression #UnaryMinus
            | expression TIMES expression # Times
            | expression DIV expression # Div
            | expression PLUS expression # Plus
            | expression MINUS expression # Minus
            | NUMBER # Number
            | STR # Str
            | ID # Id;
condition: ifStatement thenBlock elseBlock?;
thenBlock: (instBlock | instruction);
ifStatement: 'Si' L_PAREN evaluation R_PAREN 'Alors';
evaluation: L_PAREN evaluation R_PAREN # EvalParen
            | expression evalOperand expression # Comp
            | NOT evaluation # Not
            | evaluation AND evaluation # And
            | evaluation OR evaluation # Or;
evalOperand: GT | GTE | LT | LTE | EQ | NOT_EQ;
elseBlock: 'Sinon' (instBlock | instruction) | 'Sinon' ifStatement (instBlock | instruction);
input: 'In_SJ' L_PAREN FORMAT COMA idList R_PAREN;
output: 'Out_SJ' L_PAREN outputArgs R_PAREN;
outputArgs: strFormat outputIdList?;
strFormat: (FORMAT | STR);
outputIdList: COMA idList;

/*lexer*/

fragment DIGIT: [0-9];
fragment LOWERCASE: [a-z];
fragment UPPERCASE: [A-Z];
fragment ANYCASE: LOWERCASE | UPPERCASE;

fragment INT: 'int_SJ';
fragment FLOAT: 'float_SJ';
fragment STRING: 'string_SJ';
fragment INT_FORMAT: '%d';
fragment FLOAT_FORMAT: '%f';
fragment STRING_FORMAT: '%s';

fragment LINE_COMMENT: '//'  (LINE_COMMENT | ~[\n\r])*;
fragment MULTI_LINE_COMMENT: '/*' (LINE_COMMENT | .)*? '*/';
fragment POINT: '.';
fragment UNDERSCORE: '_';

QUOT: '"';
SEMI_COLON: ';';
COMA: ',';
L_PAREN: '(';
R_PAREN: ')';
TIMES: '*';
DIV: '/';
PLUS: '+';
MINUS: '-';
ASSIGN: ':=';
GT: '>';
GTE: '>=';
LT: '<';
LTE: '<=';
EQ: '=';
NOT_EQ: '!=';
AND: '&';
OR: '|';
NOT: '!';
L_BR: '{';
R_BR: '}';

CLASS_NAME: UPPERCASE (DIGIT | ANYCASE)*;
MODIFIER: 'public' | 'protected';
VAR_TYPE: INT | FLOAT | STRING;
ID: ANYCASE (DIGIT | ANYCASE)*;
LIBRARY: ANYCASE (ANYCASE | DIGIT | UNDERSCORE | POINT)*;
NUMBER: DIGIT+ | DIGIT* [.,] DIGIT+;
FORMAT: QUOT (INT_FORMAT | FLOAT_FORMAT | STRING_FORMAT | ' ')+ QUOT;
STR: QUOT (~[\n\r"]|'\\"')* QUOT;

COMMENT: (LINE_COMMENT | MULTI_LINE_COMMENT) -> skip;
WHITESPACE: [ \t\r\n]+ -> skip;
