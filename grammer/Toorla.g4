grammar Toorla;
@header {
	import validateDataast.Program;
	import validateDataast.Tree;
	import validateDataast.declaration.classDecs.*;
	import validateDataast.declaration.classDecs.classMembersDecs.*;
	import validateDataast.declaration.localVarDecs.*;
	import validateDataast.expression.*;
	import validateDataast.expression.binaryExpression.*;
	import validateDataast.expression.unaryExpression.*;
	import validateDataast.expression.value.*;
	import validateDataast.statement.*;
	import validateDataast.statement.localVarStats.*;
	import validateDataast.statement.returnStatement.*;
	import validateDatatypes.*;
	import validateDatatypes.singleType.*;
	import validateDatatypes.arrayType.*;
	import java.util.List;
	import java.util.ArrayList;
}

@members
{
    void setNodePosition( Tree node , int line , int col )
    {
        if( node != null )
        {
            node.line = line;
            node.col = col;
        }
    }
}
program
	returns[Program mProgram]:
	{$mProgram=new Program();} (
		c1 = classDeclaration[ false ] {$mProgram.addClass($c1.mClass);}
	)* c2 = entryClassDeclaration {$mProgram.addClass($c2.mClass);
	} (c3 = classDeclaration[ false ] {$mProgram.addClass($c3.mClass);})* EOF
	;

classDeclaration[ boolean isEntry ]
	returns[ClassDeclaration mClass]:
	'class' n = ID ('inherits' p = ID)? ':'
	{
	    Identifier className = new Identifier( $n.text );
	    Identifier parentName = new Identifier(null);
	    setNodePosition( className , $n.getLine() , $n.getCharPositionInLine() );
	    if( $p != null && $p.text != null )
	    {
	        parentName = new Identifier($p.text);
	        setNodePosition( parentName , $p.getLine() , $p.getCharPositionInLine() );
	    }
	    if( isEntry )
	        $mClass=new EntryClassDeclaration( className , parentName );
        else
            $mClass=new ClassDeclaration( className , parentName );
	}
	(
		f = fieldDeclaration
		{
		    $mClass.addFieldsDeclarations($f.mFields);
		}
		| m = methodDeclaration
		{
		    $mClass.addMethodDeclaration($m.mMethod);
		}
	)* 'end'
	;

entryClassDeclaration
	returns[ClassDeclaration mClass]:
	('entry') c = classDeclaration[ true ]
	{
	    $mClass=$c.mClass;
	}
	;

fieldDeclaration
	returns[List<FieldDeclaration> mFields]
	locals[AccessModifier access]:
	{
        $mFields=new ArrayList<>();
	}
	(a = access_modifier
	{
	    $access=$a.mAccess;
	}
	)?
	'field' i = ID
	{
	    Identifier fieldName = new Identifier($i.text);
	    setNodePosition( fieldName , $i.getLine() , $i.getCharPositionInLine() );
	    FieldDeclaration fieldDecl = new FieldDeclaration( fieldName );
	    setNodePosition( fieldDecl , $i.getLine() , $i.getCharPositionInLine() );
	    $mFields.add( fieldDecl );
	}
	(
		',' ii = ID
		{
		    fieldName = new Identifier($ii.text);
            setNodePosition( fieldName , $ii.getLine() , $ii.getCharPositionInLine() );
            fieldDecl = new FieldDeclaration( fieldName );
            setNodePosition( fieldDecl , $ii.getLine() , $ii.getCharPositionInLine() );
            $mFields.add( fieldDecl );
		}
	)* t = toorlaType ';'
	{
	    for(FieldDeclaration field:$mFields)
	    {
	        field.setType($t.mType);
	        if( $access != null )
	            field.setAccessModifier($access);
	    }
	}
	;

access_modifier
	returns[AccessModifier mAccess]:
	'public'
	{
	    $mAccess=AccessModifier.ACCESS_MODIFIER_PUBLIC;
	}
	| 'private'
	{
	    $mAccess=AccessModifier.ACCESS_MODIFIER_PRIVATE;
	}
	;

methodDeclaration
	returns[MethodDeclaration mMethod]
	locals[AccessModifier access]:
	(
	    a = access_modifier
	    {
	        $access=$a.mAccess;
	    }
	)?
	    'function' i = ID
	    {
	        Identifier methodName = new Identifier($i.text);
	        setNodePosition( methodName , $i.getLine() , $i.getCharPositionInLine() );
	        $mMethod=new MethodDeclaration( methodName );
		}
		(
		'(' ')'
		|
		(
			'(' i1 = ID ':' t1 = toorlaType
			{
			    Identifier parameterName = new Identifier($i1.text);
			    setNodePosition( parameterName , $i1.getLine() , $i1.getCharPositionInLine() );
			    ParameterDeclaration parameterDecl = new ParameterDeclaration( parameterName , $t1.mType );
			    setNodePosition( parameterDecl , $i1.getLine() , $i1.getCharPositionInLine() );
			    $mMethod.addArg( parameterDecl );
			}
			(
				',' i2 = ID ':' t2 = toorlaType
				{
				    parameterName = new Identifier($i2.text);
                    setNodePosition( parameterName , $i2.getLine() , $i2.getCharPositionInLine() );
                    parameterDecl = new ParameterDeclaration( parameterName , $t2.mType );
                    setNodePosition( parameterDecl , $i2.getLine() , $i2.getCharPositionInLine() );
                    $mMethod.addArg( parameterDecl );
				}
			)* ')'
		)
	)
    'returns' t = toorlaType
    {
        $mMethod.setReturnType($t.mType);
    }
    ':' (s = statement
	{
	    $mMethod.addStatement($s.mStmt);
	}
	)* 'end'
	{
	    if( $access != null )
	        $mMethod.setAccessModifier($access);
	};

closedStatement returns[ Statement mStmt ]:
    s1 = statementBlock {$mStmt=$s1.mStmt;}
    | conditionalStat=closedConditional { $mStmt= $conditionalStat.mStmt; }
    | s3 = statementClosedLoop {$mStmt=$s3.mStmt;}
    | s4 = statementWrite {$mStmt=$s4.mStmt;}
    | s5 = statementAssignment {$mStmt=$s5.mStmt;}
    | s6 = statementReturn {$mStmt=$s6.mStmt;}
    | s7 = statementVarDef {$mStmt=$s7.mStmt;}
    | s8 = statementContinue {$mStmt=$s8.mStmt;}
    | s9 = statementBreak {$mStmt=$s9.mStmt;}
    | incStat=statementInc { $mStmt = $incStat.increment; }
    | decStat=statementDec { $mStmt = $decStat.decrement; }
    | ';' { $mStmt = new Skip(); }
;

closedConditional returns[ Statement mStmt ]
    locals[ List<Expression> conditions , List<Statement> statements ]:
    {
        $statements = new ArrayList<>();
        $conditions = new ArrayList<>();
    }
    'if' '(' ifExp=expression ')' ifStat=closedStatement
    {
        $conditions.add( $ifExp.expr );
        $statements.add( $ifStat.mStmt );
    }
    (
    'elif' '(' elifExp=expression ')' elifStat=closedStatement
    {
        $conditions.add( $elifExp.expr );
        $statements.add( $elifStat.mStmt );
    }
    )*
    'else' elseStmt=closedStatement
    {
        Statement lastIfStat = $statements.get( $statements.size() - 1 );
        Expression lastIfCondition = $conditions.get( $conditions.size() - 1 );
        Conditional previousConditionalStat = new Conditional( lastIfCondition , lastIfStat , $elseStmt.mStmt );
        Conditional currentConditionalStat = previousConditionalStat;
        for( int i = $statements.size() - 2 ; i >= 0 ; i-- )
        {
            previousConditionalStat = currentConditionalStat;
            Expression currentIfCondition = $conditions.get( i );
            Statement currentIfStat = $statements.get( i );
            currentConditionalStat = new Conditional( currentIfCondition , currentIfStat
                , previousConditionalStat );

        }
        $mStmt = currentConditionalStat;
    }



;

openConditional returns[ Statement mStmt ]
    locals[ List<Expression> conditions , List<Statement> statements ]:
    (
    'if' '(' ifExp=expression ')' ifStat=statement
    {
        $mStmt = new Conditional( $ifExp.expr , $ifStat.mStmt );
    }
    )
    |
    (
    'if' '(' ifExp=expression ')' secondIfStat=closedStatement
    {
        $statements = new ArrayList<>();
        $conditions = new ArrayList<>();
        $conditions.add( $ifExp.expr );
        $statements.add( $secondIfStat.mStmt );
    }
    (
    'elif' '(' elifExp=expression ')' elifStat=closedStatement
    {
        $conditions.add( $elifExp.expr );
        $statements.add( $elifStat.mStmt );
    }
    )*
    'elif' '(' lastElifExp=expression ')' lastElifStmt=statement
    {
        Conditional previousConditionalStat = new Conditional( $lastElifExp.expr
        , $lastElifStmt.mStmt , new Skip() );
        Conditional currentConditionalStat = previousConditionalStat;
        for( int i = $statements.size() - 1 ; i >= 0 ; i-- )
        {
            previousConditionalStat = currentConditionalStat;
            Expression currentIfCondition = $conditions.get( i );
            Statement currentIfStat = $statements.get( i );
            currentConditionalStat = new Conditional( currentIfCondition , currentIfStat
                , previousConditionalStat );

        }
        $mStmt = currentConditionalStat;
    }
    )
    |
    (
    'if' '(' ifExp=expression ')' thirdIfStat=closedStatement
    {
        $statements = new ArrayList<>();
        $conditions = new ArrayList<>();
        $conditions.add( $ifExp.expr );
        $statements.add( $thirdIfStat.mStmt );
    }
    (
    'elif' '(' elifExp=expression ')' elifStat=closedStatement
    {
        $conditions.add( $elifExp.expr );
        $statements.add( $elifStat.mStmt );
    }
    )*
    'else' elseStmt=openStatement
    {
        Statement lastIfStat = $statements.get( $statements.size() - 1 );
        Expression lastIfCondition = $conditions.get( $conditions.size() - 1 );
        Conditional previousConditionalStat = new Conditional( lastIfCondition , lastIfStat , $elseStmt.mStmt );
        Conditional currentConditionalStat = previousConditionalStat;
        for( int i = $statements.size() - 2 ; i >= 0 ; i-- )
        {
            previousConditionalStat = currentConditionalStat;
            Expression currentIfCondition = $conditions.get( i );
            Statement currentIfStat = $statements.get( i );
            currentConditionalStat = new Conditional( currentIfCondition , currentIfStat
                , previousConditionalStat );

        }
        $mStmt = currentConditionalStat;
    }
    )





;

openStatement returns[ Statement mStmt ]:
    s1 = statementOpenLoop {$mStmt=$s1.mStmt;}
    | conditionalStat=openConditional { $mStmt= $conditionalStat.mStmt; }
    ;


statement
	returns[Statement mStmt]:
	s1 = closedStatement {$mStmt=$s1.mStmt;}
	| s2 = openStatement {$mStmt=$s2.mStmt;}
	;

statementVarDef
	returns[Statement mStmt]:
	    {
	        $mStmt=new LocalVarsDefinitions();
	    }
	    'var' i1 = ID '=' e1 = expression
	    {
	        Identifier localVarName = new Identifier( $i1.text );
	        setNodePosition( localVarName , $i1.getLine() , $i1.getCharPositionInLine() );
	        LocalVarDef localVariableDef = new LocalVarDef( localVarName , $e1.expr );
	        setNodePosition( localVariableDef , $i1.getLine() , $i1.getCharPositionInLine() );
	        ((LocalVarsDefinitions)$mStmt).addVarDefinition( localVariableDef );
		} (
		',' i2 = ID '=' e2 = expression
		{
		    localVarName = new Identifier( $i2.text );
            setNodePosition( localVarName , $i2.getLine() , $i2.getCharPositionInLine() );
            localVariableDef = new LocalVarDef( localVarName , $e2.expr );
            setNodePosition( localVariableDef , $i2.getLine() , $i2.getCharPositionInLine() );
		    ((LocalVarsDefinitions)$mStmt).addVarDefinition( localVariableDef );
		}
	)* ';';

statementBlock
	returns[Statement mStmt]:
	{$mStmt=new Block();} 'begin' (
		s = statement {((Block)$mStmt).addStatement($s.mStmt);}
	)* 'end';

statementContinue
	returns[Statement mStmt]:
	myContinue='continue' ';'
	{
	    $mStmt=new Continue();
	    setNodePosition( $mStmt , $myContinue.getLine() , $myContinue.getCharPositionInLine() );
	};

statementBreak
	returns[Statement mStmt]:
	myBreak='break' ';'
	{
	    $mStmt=new Break();
	    setNodePosition( $mStmt , $myBreak.getLine() , $myBreak.getCharPositionInLine() );
	};

statementReturn
	returns[Statement mStmt]:
	myReturn='return'
		e = expression ';'
	{
	    $mStmt=new Return($e.expr);
	    setNodePosition( $mStmt , $myReturn.getLine() , $myReturn.getCharPositionInLine() );
	}
	;

statementClosedLoop
	returns[Statement mStmt]:
	'while' '(' e = expression ')' s = closedStatement {$mStmt=new While($e.expr,$s.mStmt);};

statementOpenLoop returns[ Statement mStmt ]:
    'while' '(' e = expression ')' s = openStatement {$mStmt=new While($e.expr,$s.mStmt);}
;

statementWrite
	returns[Statement mStmt]:
	print='print' '(' e = expression ')' ';'
	{
	    $mStmt=new PrintLine($e.expr);
	    setNodePosition( $mStmt , $print.getLine() , $print.getCharPositionInLine() );
	};

statementAssignment
	returns[Statement mStmt]:
	left=expression assignOp='=' right = expression ';'
	{
	    $mStmt=new Assign( $left.expr , $right.expr );
	    setNodePosition( $mStmt , $assignOp.getLine() , $assignOp.getCharPositionInLine() );
	};

statementInc returns[ Statement increment ]:
    lvalExpr=expression incOp='++' ';'
    {
        $increment = new IncStatement( $lvalExpr.expr );
        setNodePosition( $increment , $incOp.getLine() ,$incOp.getCharPositionInLine() );
    }
;


statementDec returns[ Statement decrement ]:
    lvalExpr=expression decOp='--' ';'
    {
        $decrement = new DecStatement( $lvalExpr.expr );
        setNodePosition( $decrement , $decOp.getLine() ,$decOp.getCharPositionInLine() );
    }

;
expression
	returns[Expression expr]:
	e = expressionOr {$expr=$e.expr;};


expressionOr
	returns[Expression expr]:
	a = expressionAnd ot = expressionOrTemp[ $a.expr ]
	{
	    $expr = $ot.expr;
	};

expressionOrTemp[ Expression leftOperand ]
	returns[Expression expr ] locals[ BinaryExpression middleExpr ]:
	orOp='||' a = expressionAnd
	{
	    $middleExpr = new Or( $leftOperand , $a.expr );
	    setNodePosition( $middleExpr , $orOp.getLine() , $orOp.getCharPositionInLine() );
	}
	ot = expressionOrTemp[ $middleExpr ]
	{
	    $expr = $ot.expr;
	}
	|
	{
	    $expr = $leftOperand;
	};

expressionAnd
	returns[Expression expr]:
	e = expressionEq at = expressionAndTemp[ $e.expr ]
	{
	    $expr = $at.expr;
	};

expressionAndTemp[ Expression leftOperand ]
	returns[Expression expr] locals[ BinaryExpression middleExpr ]:
	andOp='&&' e = expressionEq
	{
	    $middleExpr = new And( $leftOperand , $e.expr );
	    setNodePosition( $middleExpr , $andOp.getLine() , $andOp.getCharPositionInLine() );
	}
	at = expressionAndTemp[ $middleExpr ]
	{
	    $expr = $at.expr;
	}
	|
	{
        $expr = $leftOperand;
	};

expressionEq
	returns[Expression expr]:
	c = expressionCmp et = expressionEqTemp[ $c.expr ]
	{
	    $expr = $et.expr;
	};

expressionEqTemp[ Expression leftOperand ] returns[ Expression expr ] locals[ BinaryExpression middleExpr ]:
	(
		eqOp='=='
		{
		    $middleExpr=new Equals();
		    setNodePosition( $middleExpr , $eqOp.getLine() , $eqOp.getCharPositionInLine() );
		}
		| neqOp='<>'
		{
		    $middleExpr=new NotEquals();
		    setNodePosition( $middleExpr , $neqOp.getLine() , $neqOp.getCharPositionInLine() );
		}
	) c=expressionCmp
	{
	   $middleExpr.setSides( $leftOperand , $c.expr );
	}
	et=expressionEqTemp[ $middleExpr ]
	{
	    $expr = $et.expr;
	}
	|
	{
	    $expr = $leftOperand;
	}
	;

expressionCmp
	returns[Expression expr]:
	a = expressionAdd ct = expressionCmpTemp[ $a.expr ]
	{
        $expr = $ct.expr;
	};

expressionCmpTemp[ Expression leftOperand ]
	returns[Expression expr] locals[ BinaryExpression middleExpr ]:
	(
		ltOp='<'
		{
		    $middleExpr=new LessThan();
		    setNodePosition( $middleExpr , $ltOp.getLine() , $ltOp.getCharPositionInLine() );
		}
		|
		gtOp='>'
		{
		    $middleExpr=new GreaterThan();
		    setNodePosition( $middleExpr , $gtOp.getLine() , $gtOp.getCharPositionInLine() );
		}
	) a = expressionAdd
	{
	    $middleExpr.setSides( $leftOperand , $a.expr );
	}
	ct = expressionCmpTemp[ $middleExpr ]
	{
        $expr = $ct.expr;
	}
	|
	{
	    $expr = $leftOperand;
	}
	;

expressionAdd
	returns[Expression expr]:
	m = expressionMultMod at = expressionAddTemp[ $m.expr ]
	{
	    $expr = $at.expr;
	}
	;

expressionAddTemp[ Expression leftOperand ]
	returns[Expression expr] locals[ BinaryExpression middleExpr ]:
	(
		addOp='+'
		{
		    $middleExpr = new Plus();
		    setNodePosition( $middleExpr , $addOp.getLine() , $addOp.getCharPositionInLine() );
		}
		| subOp='-'
		{
		    $middleExpr = new Minus();
		    setNodePosition( $middleExpr , $subOp.getLine() , $subOp.getCharPositionInLine() );
		}
	) m = expressionMultMod
	{
        $middleExpr.setSides( $leftOperand , $m.expr );
	}
	at = expressionAddTemp[ $middleExpr ]
	{
	    $expr = $at.expr;
	}
	|
	    {
	        $expr = $leftOperand;
	    }
	;

expressionMultMod
	returns[Expression expr]:
	u = expressionUnary mt = expressionMultModTemp[ $u.expr ]
	{
	    $expr = $mt.expr;
	}
	;

expressionMultModTemp[ Expression leftOperand ]
	returns[Expression expr] locals[ BinaryExpression middleExpr ] :
	(
		mulOp='*'
		{
		    $middleExpr = new Times();
		    setNodePosition( $middleExpr , $mulOp.getLine() , $mulOp.getCharPositionInLine() );
		}
		| divOp='/'
		{
            $middleExpr = new Division();
            setNodePosition( $middleExpr , $divOp.getLine() , $divOp.getCharPositionInLine() );
        }
		| modOp='%'
		{
		    $middleExpr = new Modulo();
		    setNodePosition( $middleExpr , $modOp.getLine() , $modOp.getCharPositionInLine() );
		}
	) u = expressionUnary
	{
        $middleExpr.setSides( $leftOperand , $u.expr );
	}
	mt = expressionMultModTemp[ $middleExpr ]
	{
	    $expr = $mt.expr;
	}
	|
	{
	    $expr = $leftOperand;
	}
	;

expressionUnary
	returns[Expression expr]:
	(
		notOp='!'
		{
		    $expr=new Not();
		    setNodePosition( $expr , $notOp.getLine() , $notOp.getCharPositionInLine() );
		}
		| negOp='-'
		{
		    $expr=new Neg();
		    setNodePosition( $expr , $negOp.getLine() , $negOp.getCharPositionInLine() );
		}
	) u = expressionUnary {((UnaryExpression)$expr).setExpr($u.expr);}
	| m = expressionMethods {$expr=$m.expr;};

expressionMethods
	returns[Expression expr]:
	o = expressionOther mt = expressionMethodsTemp[$o.expr]
	 {
	    $expr=$mt.expr;
	};

expressionMethodsTemp[Expression instance]
	returns[Expression expr] locals[Expression immediateExpr]:
	(
		dotOp='.' i = ID
		{
		    Identifier methodName = new Identifier($i.text);
		    setNodePosition( methodName , $i.getLine() , $i.getCharPositionInLine() );
		    $immediateExpr=new MethodCall($instance,methodName);
		    setNodePosition( $immediateExpr , $dotOp.getLine() , $dotOp.getCharPositionInLine() );
		}
		'(' (
			e1 = expression {((MethodCall)$immediateExpr).addArg($e1.expr);} (
				',' e2 = expression {((MethodCall)$immediateExpr).addArg($e2.expr);}
			)*
		)? ')'
		| dotOp='.' ii = ID
		{
		    Identifier fieldName = new Identifier( $ii.text );
		    setNodePosition( fieldName , $ii.getLine() , $ii.getCharPositionInLine() );
		    $immediateExpr=new FieldCall($instance, fieldName );
		    setNodePosition( $immediateExpr , $dotOp.getLine() , $dotOp.getCharPositionInLine() );
		}
		| leftBrace='[' e3 = expression ']'
		{
		    $immediateExpr=new ArrayCall($instance,$e3.expr);
		    setNodePosition( $immediateExpr , $leftBrace.getLine() , $leftBrace.getCharPositionInLine() );
		}
	) mt = expressionMethodsTemp[$immediateExpr]
	{
	    $expr=$mt.expr;
	}
	|
	{
	 $expr=$instance;
	}
	;
expressionOther
	returns[Expression expr]:
	n = CONST_NUM
	{
	    $expr=new IntValue($n.int);
	    setNodePosition( $expr , $n.getLine() , $n.getCharPositionInLine() );
	}
	| s = CONST_STR
	{
	    $expr=new StringValue($s.text);
	    setNodePosition( $expr , $s.getLine() , $s.getCharPositionInLine() );
	}
	| newModifier='new' st = singleType leftBrace='[' size = expression ']'
	{
	    $expr=new NewArray($st.sType,$size.expr);
        setNodePosition( $expr , $newModifier.getLine() , $newModifier.getCharPositionInLine() );
	}
	| newModifier='new' i = ID '(' ')'
	{
	    Identifier instanceClass = new Identifier( $i.text );
	    setNodePosition( instanceClass , $i.getLine() , $i.getCharPositionInLine() );
	    $expr=new NewClassInstance( instanceClass );
	    setNodePosition( $expr , $newModifier.getLine() , $newModifier.getCharPositionInLine() );
	}
	| selfModifier='self'
	{
	    $expr=new Self();
	    setNodePosition( $expr , $selfModifier.getLine() , $selfModifier.getCharPositionInLine() );
	}
	| trueModifier='true'
	{
	    $expr=new BoolValue(true);
	    setNodePosition( $expr , $trueModifier.getLine() , $trueModifier.getCharPositionInLine() );
	}
	| falseModifier='false'
	{
	    $expr=new BoolValue(false);
	    setNodePosition( $expr , $falseModifier.getLine() , $falseModifier.getCharPositionInLine() );
	}
	| i1 = ID
	{
	    $expr=new Identifier($i1.text);
	    setNodePosition( $expr , $i1.getLine() , $i1.getCharPositionInLine() );
	}
	| i2 = ID leftBrace='[' e = expression ']'
	{
	    Identifier instanceId = new Identifier($i2.text);
        setNodePosition( instanceId , $i2.getLine() , $i2.getCharPositionInLine() );
	    $expr = new ArrayCall( instanceId , $e.expr );
	    setNodePosition( $expr , $leftBrace.getLine() , $leftBrace.getCharPositionInLine() );
	}
	| leftPara='(' ee = expression ')'
	{
	    $expr = $ee.expr;
	}
	| i3 = ID
	{
	    Self instance = new Self();
	    setNodePosition( instance , $i3.getLine() , $i3.getCharPositionInLine() );
	    Identifier methodName = new Identifier( $i3.text );
	    setNodePosition( methodName , $i3.getLine() , $i3.getCharPositionInLine() );
	    $expr=new MethodCall( instance , methodName );
	    setNodePosition( $expr , $i3.getLine() , $i3.getCharPositionInLine() );
	} '(' (
		    e3 = expression { ((MethodCall)$expr).addArg($e3.expr); } (
			',' e4 = expression { ((MethodCall)$expr).addArg($e4.expr); }
		  )*
	)? ')';

toorlaType
	returns[Type mType]:
	st = singleType {$mType=$st.sType;} (
		'[' ']' {$mType=new ArrayType($st.sType);}
	)?;

singleType
	returns[SingleType sType]: (
		'int' {$sType=new IntType();}
		| 'bool' {$sType=new BoolType();}
		| 'string' {$sType=new StringType();}
		| i = ID {$sType=new UserDefinedType(new ClassDeclaration(new Identifier($i.text)));}
	);

CONST_NUM: [1-9][0-9]* | [0];

CONST_STR: '"' ~('\r' | '\n' | '"')* '"';

NL: '\r'? '\n' -> skip;

ID: [a-zA-Z_][a-zA-Z0-9_]*;

COMMENT: '//' (~[\r\n])* -> skip;

MULTILINE_COMMENT: '/*' (.)*? '*/' -> skip;

WS: [ \t] -> skip;