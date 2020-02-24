Echo off
Title FirefoxDriver Node on 4547

Echo Setting Project Location for Node
set projectLocation=C:\Users\sachin.nair\eclipse-workspace\inetBankingV1\Selenium 3.141.59\Selenium Server Grid 3.141.59
pushd %projectLocation%

Echo Setting FirefoxDriver path and Creating node on 4547
java -Dwebdriver.gecko.driver="C:\Users\sachin.nair\eclipse-workspace\inetBankingV1\Drivers\geckodriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://10.254.19.20:4444/grid/register -port 4547
pause