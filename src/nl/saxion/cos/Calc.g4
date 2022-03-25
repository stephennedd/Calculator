grammar Calc;

start: expression EOF;

expression: '(' expression ')'                                   # ExParentheses
          | '-' expression                                       # ExNegate
          | left=expression '*' right=expression                 # ExMulOp
          | left=expression op=('+' | '-') right=expression      # ExAddOp
          | left=expression op=('<' | '<=' | '>' | '>=' | '==' | '!=' ) right=expression '?' trueVal=expression ':' falseVal=expression  # ExTernary
          | INT                                                  # ExIntLiteral
          | FLOAT                                                # ExFloatLiteral
          ;

INT: '0' | [1-9][0-9]*;
FLOAT: [1-9]+ '.' Digits |'0' '.'Digits | '.' Digits ;
WS: [\r\n\t ]+ -> skip;

fragment Digits:        [0-9] ([0-9_]* [0-9])?;