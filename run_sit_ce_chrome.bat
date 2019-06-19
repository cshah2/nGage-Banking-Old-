@echo on
::----------------------------------------------
::--------------- Set Resolution ---------------
::----------------------------------------------
set DISPLAY=:99
set DISPLAY_CONFIGURATION=1366x768x24

::----------------------------------------------
::-------------- Set Report Folder -------------
::----------------------------------------------
set dt=%DATE:~6,4%%DATE:~3,2%%DATE:~0,2%_%TIME:~0,2%%TIME:~3,2%%TIME:~6,2%
set dt=%dt: =0%
set REPORT_FOLDER=%dt%
set EXECUTION_PROFILE=SavCE_SIT

::----------------------------------------------
::----------- Set Current Directory ------------
::----------------------------------------------
:: Docker on windows can be shared c:\Users path only which needs to be mount as /c (lowercase) and /Users (U in uppercase), Otherwise mount does not works.
::set currentdir=%cd::\=/%
::set currentdir=%currentdir:\=/%
set PRJ_PATH=/c/Users/%username%/git/nGage-Banking
set REPORT_PATH=%PRJ_PATH%/Reports/%EXECUTION_PROFILE%/%REPORT_FOLDER%

::----------------------------------------------
::----------- Run Docker Command ------------
::----------------------------------------------
docker run -t --rm -e DISPLAY=:0 -e DISPLAY_CONFIGURATION=1366x768x24 -v %PRJ_PATH%:/katalon/katalon/source:ro -v %REPORT_PATH%:/katalon/katalon/report  katalonstudio/katalon katalon-execute.sh -browserType="Chrome" -retry=0 -statusDelay=15 -testSuitePath="Test Suites/SMOKE" -executionProfile="%EXECUTION_PROFILE%"