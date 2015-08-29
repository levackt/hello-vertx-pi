[See Vert.x blog for details](http://vertx.io/blog/vert-x3-web-easy-as-pi/)

# Run on PI to monitor CPU load, default port is 8080

Build
mvn clean package

Run
java -jar rpi-1.0-fat.jar

Open index in browser, (Export $PI or substitute it with your device's IP address)
http://$PI:8080/
