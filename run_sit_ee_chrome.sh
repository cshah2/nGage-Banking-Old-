#! /bin/sh

set -xe
set DISPLAY=:99
set DISPLAY_CONFIGURATION=1366x768x24

REPORT_FOLDER=$(date +%Y%m%d_%H%M%S)
EXECUTION_PROFILE="SavEE_SIT"

#mkdir -p ./Reports/${REPORT_FOLDER}

docker run -t --rm \
	-e DISPLAY=:0 \
	-e DISPLAY_CONFIGURATION=1366x768x24 \
	-v "$(pwd)"/Reports/${EXECUTION_PROFILE}/${REPORT_FOLDER}:/katalon/katalon/report \
	-v "$(pwd)":/katalon/katalon/source katalonstudio/katalon katalon-execute.sh  -browserType="Chrome" -retry=0 -statusDelay=15 -testSuitePath="Test Suites/SMOKE" -executionProfile="${EXECUTION_PROFILE}"
