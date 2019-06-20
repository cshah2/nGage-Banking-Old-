@echo off

::-------------------------------------------------------------------------
::---------- Kill existing running instances of Katalon Studio ------------
::-------------------------------------------------------------------------
echo kill all existing running instances of katalon studio or chrome driver
TASKKILL /F /IM KATALON.EXE /T
TASKKILL /F /IM CHROMEDRIVER.EXE /T

::-------------------------------------------------------------------------
::------------ Set up Project path and Test Suite and Browser -------------
::-------------------------------------------------------------------------
set PRJ_PATH=%NGAGE_PROJECTS%\nGage-Banking\nGage-Banking.prj
set TEST_SUITE=Test Suites/DataCreation/BOTH
set BROWSER=Chrome

::-------------------------------------------------------------------------
::------------------ Select Execution profile from User -------------------
::-------------------------------------------------------------------------
:START
cls
echo SavCE_SIT 	(1)
echo SavEE_SIT	(2)
echo.
set /p PROFILE= Select a profile?:

::-------------------------------------------------------------------------
::---------------- Execute script based on valid profile ------------------
::-------------------------------------------------------------------------
if %PROFILE% == 1 (goto SavCE_SIT)
if %PROFILE% == 2 (goto SavEE_SIT)

::-------------------------------------------------------------------------
::--- Redirect user back to profile selection screen for invalid value ----
::-------------------------------------------------------------------------
echo Invalid profile selected
pause
goto START

:SavCE_SIT
set EXECUTE_PROFILE=SavCE_SIT
goto EXECUTE_CMD

:SavEE_SIT
set EXECUTE_PROFILE=SavEE_SIT
goto EXECUTE_CMD

:EXECUTE_CMD
CALL cmd /c start katalon -noSplash  -runMode=console -consoleLog -projectPath="%PRJ_PATH%" -statusDelay=60 -retry=0 -testSuitePath="%TEST_SUITE%" -executionProfile="%EXECUTE_PROFILE%" -browserType="%BROWSER%" -summaryReport
goto END

:END