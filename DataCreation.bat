@echo off

echo kill all existing running instances of katalon studio or chrome driver
TASKKILL /F /IM KATALON.EXE /T
TASKKILL /F /IM CHROMEDRIVER.EXE /T


:START
cls
echo SavCE_SIT 	(1)
echo SavEE_SIT	(2)
echo.
set /p PROFILE= Select a profile?:

if %PROFILE% == 1 (goto SavCE_SIT)
if %PROFILE% == 2 (goto SavEE_SIT)

echo Invalid profile selected
pause
goto START

#@echo on
#set currentdir=%cd::\=/%
#set currentdir=%currentdir:\=/%

:SavCE_SIT
CALL cmd /c start katalon -noSplash  -runMode=console -consoleLog -projectPath="%NGAGE_BANKING_PATH%\nGage-Banking.prj" -statusDelay=60 -retry=0 -testSuitePath="Test Suites/DataCreation/BOTH" -executionProfile="SavCE_SIT" -browserType="Chrome" -summaryReport
goto END

:SavEE_SIT
CALL cmd /c start katalon -noSplash  -runMode=console -consoleLog -projectPath="%NGAGE_BANKING_PATH%\nGage-Banking.prj" -statusDelay=60 -retry=0 -testSuitePath="Test Suites/DataCreation/BOTH" -executionProfile="SavEE_SIT" -browserType="Chrome" -summaryReport
goto END

:INVALID

:End
