grammar Obfuscator;

program returns [String value] @init {$value = "";}
    : programParts {$value += $programParts.code;}
    ;

programParts returns [String code, String fake] @init {$code = "";}
    : (lexItem {$code += $lexItem.value;}
      )*
    ;

lexItem returns [String value] @init {$value = "";}
    : KEYWORD {$value += $KEYWORD.text;}
     | SYNTLEX {$value += $SYNTLEX.text;}
     | IDENT LEFTPAR {$value += $IDENT.text + "("; }
     | IDENT {$value += Functions.encode($IDENT.text);}
     | LEFTPAR {$value += "("; }
	 | INT {$value += $INT.text;}
	 | PLUS {$value += '+';}
     | MINUS {$value += '-';}
     | TAB2 {$value += Functions.fake(2);}
     | TAB {$value += Functions.fake(1);}
     | LFT {$value += Functions.fake(3);}
     | LF {$value += Functions.fake(0);}
    ;


PLUS : '+' ;
MINUS : '-' ;
KEYWORD : 'True' | 'False' | 'None' | 'Operator' | 'and' | 'or' | 'not' | 'in' | 'is' | 'if' | 'elif' | 'else' | 'for' | 'while' | 'break' | 'continue' | 'else' | 'def' | 'class' | 'with' | 'as' | 'pass' | 'lambda' | 'return' | 'yield' | 'import' | 'from' | 'as' | 'print';
SYNTLEX : '<' | '>' | '<=' | '>=' | '==' | '=' | '*' | '/' | ')' | ','  | ':' | ' ' ;
IDENT : [a-zA-Z_][a-zA-Z_0-9]* ;
INT : (PLUS | MINUS)?[0-9]+ ;
LEFTPAR : '(';
TAB : '\t';
TAB2 : '\t\t';
LF : '\n';
LFT : '\n\t';