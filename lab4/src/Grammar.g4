grammar Grammar;

start : rules+ EOF;

rules : nTerm | term;
nTerm returns [NTerm ntr]: NTERM
                           {$ntr = new NTerm($NTERM.text);}
                           (ARG {$ntr.inhArg = $ARG.text;})?
                           ('returns' ARG {$ntr.synthArg = $ARG.text;})?
                           ':'
                           opts {$ntr.opts = $opts.optionals;}
                           ';';
term returns [Term tr] : TERM ':' REGEX ';' {$tr = new Term($TERM.text, $REGEX.text);};

opts returns [ArrayList<ArrayList<Opt>> optionals] : {$optionals = new ArrayList<>();}
                                                     opt {$optionals.add($opt.lst);}
                                                     ('|' opt {$optionals.add($opt.lst);})*;
opt returns [ArrayList<Opt> lst] : {$lst = new ArrayList<>();}
                                   ({Opt o;} (JAVA_CODE {o = new Opt($JAVA_CODE.text, 0);}
                                            | NTERM {o = new Opt($NTERM.text, 1);}
                                              (ARG {o.arg = $ARG.text;})?
                                            | TERM {o = new Opt($TERM.text, 2);})
                                    {$lst.add(o);})+;

ARG : '[' .+? ']';
JAVA_CODE : '{:' .+? ':}';
NTERM : [a-z][a-zA-Z0-9_]*;
TERM : [A-Z][a-zA-Z0-9_]*;
REGEX : '[[' .+? ']]';
WS : [ \t\n\r] -> skip;