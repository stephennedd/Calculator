grammar Calc;

start: expression EOF;

expression: '(' expression ')'                                   # ExParentheses
          | '-' expression                                       # ExNegate
          | left=expression '*' right=expression                 # ExMulOp
          | left=expression op=('+' | '-') right=expression      # ExAddOp
          | left=expression op=('<' | '<=' | '>' | '>=' | '==' | '!=' ) right=expression '?' trueVal=expression ':' falseVal=expression  # ExTernary
          | INT                                                  # ExIntLiteral
          ;

INT: '0' | [1-9][0-9]*;
WS: [\r\n\t ]+ -> skip;
