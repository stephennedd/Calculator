.class public Sum
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 50
.limit locals 50

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 3
ldc 5
ldc 2
if_icmpgt then
goto else
then:
ldc 1
goto end
else:
ldc 8
iadd
invokevirtual java/io/PrintStream/println(I)V
end:
return
.end method
