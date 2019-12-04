grammar g;

/*parser*/

axiom: progName L_BR ((varDec SEMI_COLON)* progDesc)? R_BR EOF;
progName: 'compil' PROG_NAME L_PAREN R_PAREN;
varDec: VAR_TYPE idList;
idList: ID (COMA ID)*;
progDesc: 'start' instruction*;
instruction: (affectation | scan | print | condition) SEMI_COLON;
affectation: ID EQ expression;
expression : L_PAREN expression R_PAREN # Paren
            | MINUS expression #UnaryMinus
            | expression TIMES expression # Times
            | expression DIV expression # Div
            | expression PLUS expression # Plus
            | expression MINUS expression # Minus
            | NUMBER # Number
            | ID # Id;
condition: ifStatement thenBlock elseBlock? 'endif';
ifStatement: 'if' L_PAREN evaluation R_PAREN 'then';
thenBlock: instruction+;
elseBlock: 'else' instruction+ | 'else' ifStatement instruction+;
evaluation: expression (GT | LT) expression;
scan: 'scancompil' L_PAREN idList R_PAREN;
print: 'printcompil' L_PAREN  (idList | STR) R_PAREN;

/*lexer*/

fragment DIGIT: [0-9];
fragment LOWERCASE: [a-z];
fragment UPPERCASE: [A-Z];
fragment ANYCASE: LOWERCASE | UPPERCASE;

fragment INT: 'intcompil';
fragment FLOAT: 'floatcompil';

fragment LINE_COMMENT: '//'  (LINE_COMMENT | ~[\n\r])*;
fragment MULTI_LINE_COMMENT: '/*' (LINE_COMMENT | .)*? '*/';

PROG_NAME: UPPERCASE (ANYCASE | DIGIT | UNDERSCORE)*;
VAR_TYPE: INT | FLOAT;
NUMBER: DIGIT+ | DIGIT* [.,] DIGIT+;
ID: ANYCASE (DIGIT | ANYCASE)*;
STR: '"'(~[\n\r"]|'\\"')*'"';

SEMI_COLON: ';';
COMA: ',';
UNDERSCORE: '_';
L_PAREN: '(';
R_PAREN: ')';
TIMES: '*';
DIV: '/';
PLUS: '+';
MINUS: '-';
EQ: '=';
GT: '>';
LT: '<';
L_BR: '{';
R_BR: '}';

COMMENT: (LINE_COMMENT | MULTI_LINE_COMMENT) -> skip;
WHITESPACE: [ \t\r\n]+ -> skip;
