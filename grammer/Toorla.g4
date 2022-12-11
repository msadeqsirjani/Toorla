grammar Toorla;

program:
 (c1 = classDeclaration)*
 mainclass = entryClassDeclaration
 (c3 = classDeclaration)* EOF
	;

classDeclaration:
	'class' className= ID ('inherits' classParent= ID)? ':'
	(fieldDeclaration | methodDeclaration)*
    'end'
	;

entryClassDeclaration:
	('entry') classDeclaration;

fieldDeclaration:
	access_modifier? 'field' fieldName = ID (',' ii = ID)* fieldType = toorlaType ';'
	;

access_modifier:
	'public'| 'private'
	;

methodDeclaration:
    methodAccessModifier = access_modifier? 'function' methodName = ID
    '(' ( param1 = ID ':' typeP1 = toorlaType (',' param2 = ID ':' typeP2 = toorlaType)*)?')'
    'returns' t = toorlaType
    ':' (s = statement)* 'end'
    ;

closedStatement :
    s1 = statementBlock
    | conditionalStat=closedConditional
    | s3 = statementClosedLoop
    | s4 = statementWrite
    | s5 = statementAssignment
    | s6 = statementReturn
    | s7 = statementVarDef
    | s8 = statementContinue
    | s9 = statementBreak
    | incStat=statementInc
    | decStat=statementDec
    | ';'
;

closedConditional :
    'if' '(' ifExp=expression ')' ifStat=closedStatement
    ('elif' '(' elifExp=expression ')' elifStat=closedStatement)*
    'else' elseStmt=closedStatement
;

openConditional:
    'if' '(' ifExp=expression ')' ifStat=statement
    | (
    'if' '(' ifExp=expression ')' secondIfStat=closedStatement
    ('elif' '(' elifExp=expression ')' elifStat=closedStatement )*
    'elif' '(' lastElifExp=expression ')' lastElifStmt=statement
    )
    | (
    'if' '(' ifExp=expression ')' thirdIfStat=closedStatement
    ('elif' '(' elifExp=expression ')' elifStat=closedStatement)*
    'else' elseStmt=openStatement
    )
;

openStatement :
    s1 = statementOpenLoop
    | conditionalStat=openConditional
    ;


statement:
	s1 = closedStatement
	| s2 = openStatement
	;

statementVarDef:
	    'var' i1 = ID '=' e1 = expression (',' i2 = ID '=' e2 = expression)* ';'
	    ;

statementBlock:
	'begin' (s = statement )* 'end';

statementContinue:
	myContinue='continue' ';';

statementBreak:
	myBreak='break' ';'
	;

statementReturn:
	myReturn='return'
		e = expression ';'
	;

statementClosedLoop:
	'while' '(' e = expression ')' s = closedStatement;

statementOpenLoop:
    'while' '(' e = expression ')' s = openStatement
;

statementWrite:
	printLine='print' '(' e = expression ')' ';'
	;

statementAssignment:
	left=expression assignOp='=' right = expression ';'
;

statementInc:
    lvalExpr=expression incOp='++' ';'
;


statementDec:
    lvalExpr=expression decOp='--' ';'
;
expression:
	e = expressionOr ;

expressionOr:
	a = expressionAnd ot = expressionOrTemp
	;

expressionOrTemp:
	orOp='||' a = expressionAnd
	ot = expressionOrTemp
	|;

expressionAnd:
	e = expressionEq at = expressionAndTemp;

expressionAndTemp:
	andOp='&&' e = expressionEq
	at = expressionAndTemp
	|;

expressionEq:
	c = expressionCmp et = expressionEqTemp
	;

expressionEqTemp :
	( eqOp='==' | neqOp='<>')
	c=expressionCmp
	et=expressionEqTemp
	|;

expressionCmp:
	a = expressionAdd ct = expressionCmpTemp;

expressionCmpTemp:
	( ltOp='<' | gtOp='>')
	a = expressionAdd
	ct = expressionCmpTemp
	|;

expressionAdd:
	m = expressionMultMod at = expressionAddTemp
	;

expressionAddTemp:
	(addOp='+' | subOp='-')
	m = expressionMultMod
	at = expressionAddTemp
	|;

expressionMultMod:
	u = expressionUnary mt = expressionMultModTemp
    ;

expressionMultModTemp :
	(mulOp='*' | divOp='/' | modOp='%')
	u = expressionUnary
	mt = expressionMultModTemp
	|;

expressionUnary:
	(notOp='!' | negOp='-')
	u = expressionUnary
	| m = expressionMethods ;

expressionMethods:
	o = expressionOther mt = expressionMethodsTemp
;

expressionMethodsTemp:
	(dotOp='.' i = ID '(' ( e1 = expression  (',' e2 = expression )*)? ')'
	| dotOp='.' ii = ID
    | leftBrace='[' e3 = expression ']'
    ) mt = expressionMethodsTemp
	|;

expressionOther:
	n = CONST_NUM

	| s = CONST_STR

	| newModifier='new' st = singleType leftBrace='[' size = expression ']'

	| newModifier='new' i = ID '(' ')'

	| selfModifier='self'

	| trueModifier='true'

	| falseModifier='false'

	| i1 = ID

	| i2 = ID leftBrace='[' e = expression ']'

	| leftPara='(' ee = expression ')'

	| i3 = ID
    '(' ( e3 = expression (',' e4 = expression)*)? ')'
    ;

toorlaType:
	st = singleType ('[' ']')?
	;

singleType: (
		'int'
		| 'bool'
		| 'string'
		| i = ID
	);

CONST_NUM: [1-9][0-9]* | [0];

CONST_STR: '"' ~('\r' | '\n' | '"')* '"';

NL: '\r'? '\n' -> skip;

ID: [a-zA-Z_][a-zA-Z0-9_]*;

COMMENT: '//' (~[\r\n])* -> skip;

MULTILINE_COMMENT: '/*' (.)*? '*/' -> skip;

WS: [ \t] -> skip;