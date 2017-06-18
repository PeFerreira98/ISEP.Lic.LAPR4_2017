grammar Formula4;
@header {
    package lapr4.green.s3.lang.n1970581.formula.compiler;
}	         
expression
	: EQ comparison EOF
        | EQ for_loop EOF
        | EQ dowhile EOF
	;

block
	: L_CURLY_BRACKET comparison ( SEMI comparison )* R_CURLY_BRACKET 
	;

for_loop
        : FUNCTION L_CURLY_BRACKET comparison SEMI comparison SEMI comparison ( SEMI comparison )* R_CURLY_BRACKET
        ;

dowhile
        : FUNCTION L_CURLY_BRACKET comparison SEMI comparison ( SEMI comparison )* R_CURLY_BRACKET
        ;

comparison
	:   concatenation
		( ( EQ | NEQ | GT | LT | LTEQ | GTEQ ) concatenation )?
	;


concatenation
        : ( MINUS )? atom
        | concatenation PERCENT
        | <assoc=right> concatenation POWER concatenation
        | concatenation ( MULTI | DIV ) concatenation
        | concatenation ( PLUS | MINUS ) concatenation
        | concatenation AMP concatenation 
        ;

atom
	:	function_call
	|	reference
	|	literal
	|	LPAR comparison RPAR
	|	block
	|	assignment
        |       variable
	;

assignment
	:  LPAR reference ASSIGN comparison RPAR
        |  LPAR variable ASSIGN comparison RPAR
	;

function_call
	:	FUNCTION LPAR
		( comparison ( SEMI comparison )* )?
		RPAR
	;

reference
	:	CELL_REF
		( ( COLON ) CELL_REF )?
	;

variable
        :       TEMPORARY
        |       TEMPORARYINDEX            
        |       GLOBAL
        |       GLOBALINDEX        
        ;

literal
	:	NUMBER
	|	STRING
	;
	

fragment LETTER: ('a'..'z'|'A'..'Z') ;
  
TEMPORARY
        :       UNDSCR ( NUMBER | LETTER )+
        ;

TEMPORARYINDEX
        : UNDSCR ( NUMBER | LETTER )+ L_SQR_BRACKET INTEIRO  R_SQR_BRACKET
        ;

GLOBAL
        :       ARROBA ( NUMBER | LETTER )+
        ;

GLOBALINDEX
        :       ARROBA ( INTEIRO | LETTER )+ L_SQR_BRACKET INTEIRO  R_SQR_BRACKET
        ;

FUNCTION : 
	  ( LETTER )+ 
	;	
	 
 
CELL_REF
	:
		( ABS )? LETTER ( LETTER )?
		( ABS )? ( DIGIT )+
	;

/* String literals, i.e. anything inside the delimiters */

STRING  : QUOT ('\\"' | ~'"')* QUOT
        ;

QUOT: '"' 
	;

/* Numeric literals */
NUMBER: ( DIGIT )+ ( COMMA ( DIGIT )+ )? ;

INTEIRO: DIGIT_NON_ZERO | (DIGIT_NON_ZERO ( DIGIT )+);

fragment 
DIGIT : '0'..'9' ;
DIGIT_NON_ZERO : '1'..'9' ;

/* Comparison operators */
EQ		: '=' ;
NEQ		: '<>' ;
LTEQ            : '<=' ;
GTEQ            : '>=' ;
GT		: '>' ;
LT		: '<' ;

/* Text operators */
AMP		: '&' ;

/* Arithmetic operators */
PLUS	: '+' ;
MINUS	: '-' ;
MULTI	: '*' ;
DIV     : '/' ;
POWER	: '^' ;
PERCENT : '%' ;

/* Reference operators */
fragment ABS : '$' ;
fragment EXCL: '!' ;
COLON        : ':' ;
UNDSCR       : '_' ;
ARROBA		 : '@' ;
 
/* Miscellaneous operators */
COMMA	: ',' ;
SEMI	: ';' ;
LPAR	: '(' ;
RPAR	: ')' ; 
L_CURLY_BRACKET	: '{' ;
R_CURLY_BRACKET	: '}' ;
L_SQR_BRACKET : '[' ;
R_SQR_BRACKET : ']' ;

/* assignment operator */
ASSIGN  : ':=' ;

/* White-space (ignored) */
WS: ( ' ' | '\r' '\n' | '\n' | '\t' ) -> skip ;
	
	
 