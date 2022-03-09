.class public Sum
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 99
.limit locals 99

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 3
ldc 5
ldc 2
if_icmpgt then
goto else
ldc 1
iadd
invokevirtual java/io/PrintStream/println(I)V
return
.end method
