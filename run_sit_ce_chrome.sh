set -xe

docker run -t --rm -v "$(pwd)":/katalon/katalon/source katalonstudio/katalon katalon-execute.sh -browserType="Chrome" -retry=0 -statusDelay=15 -testSuitePath="Test Suites/SMOKE" -DISPLAY=:99 -DISPLAY_CONFIGURATION=1366x768x24
