@ECHO OFF
CHCP 65001
CD /D "%~DP0"
DEL /A /F /Q .output.txt
ECHO %DATE% %TIME% > .output.txt
ECHO. >> .output.txt
ATTRIB +S .output.txt
FOR /F %%I IN ('DIR /A-S /B') DO (
	ECHO %%I
	ECHO /********** %%I **********/ >> .output.txt
	TYPE "%%I" >> .output.txt
	ECHO. >> .output.txt
	ECHO. >> .output.txt
)
PAUSE