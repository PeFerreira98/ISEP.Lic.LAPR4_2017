grammar Currency;
@header {
    package lapr4.red.s2.lang.n1140388.formula.compiler;
}	  
       
expression
	: HASH currenciesName LBRA currenciesCount RBRA EOF	
	;

currenciesName
	:	NAMEEURO
	|	NAMEDOLLAR
    |   NAMEPOUND
	;

currenciesSymb
	:	EURO
	|	DOLLAR
    |	POUND
	;

currenciesCount
	:money arithmetic_basic currenciesCount
        |money arithmetic_pro NUMBER
		|money
	;

arithmetic_basic: 
        PLUS|MINUS
        ;

arithmetic_pro: 
        MULTI|DIV
        ;

money
	:NUMBER currenciesSymb 
	;

/*Symbols of the currencies*/
EURO: '€';
DOLLAR: '$';
POUND: '£';

/*Names of the currencies*/
NAMEEURO: 'euro';
NAMEDOLLAR: 'dollar';
NAMEPOUND: 'pound';

/* Monetary operators */
HASH	: '#' ;


/* Numeric literals */
NUMBER: ( DIGIT )+ ( COMMA ( DIGIT )+ )? ;

fragment 
DIGIT : '0'..'9' ;

/* Arithmetic operators */
PLUS	: '+' ;
MINUS	: '-' ;
MULTI	: '*' ;
DIV		: '/' ;
POWER	: '^' ;
PERCENT : '%' ;
 
/* Miscellaneous operators */
COMMA	: ',' ;
SEMI	: ';' ;
LPAR	: '(' ;
RPAR	: ')' ;
LBRA    : '{' ;
RBRA    : '}' ;
CEQ     : ':=';


/* White-space (ignored) */
WS: ( ' '
	| '\r' '\n'
	| '\n'
	| '\t'
	)
	;
	