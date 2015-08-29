# hello-vertx-pi
Testing Vertx performance on Raspbian

Build and run steps below, optionally build and run the CPU monitor, [See Vertx experiments README](vert-x3-experiments-rpi-cpuload/README.md)

To benchmark I used wrk, creating 12 threads with 400 connections over 60 seconds, warming up with several runs.
As with all benchmarks your mileage might/will vary so run your own tests.

The wrk command: (Export $RASPBERRY_PI or substitute it with your device's IP address)
wrk -t12 -c400 -d60s http://$RASPBERRY_PI/

# Maven build
cd hello-vertx-pi/vertx
mvn clean package

# Docker build
docker build -t hello/vertx-java-fat .

# Original Hypriot + NodeJS + HAProxy
[See hypriot Blog for details](http://blog.hypriot.com/post/docker-compose-nodejs-haproxy/)
My average results:

+- 350 requests/second

# Using Vert.x instead of NodeJS
To run:

docker-compose up -d

My average results:

+- 2000 requests/second

# Vert.x single Docker container
To run:

docker run -it -p 80:80 hello/vertx-java-fat

My average results:

+- 1800 requests/second

# Vert.x as a fat jar

To run:

java -jar target/hello-verticle-fatjar-3.0.0-fat.jar

My average results:

+- 2300 requests/second

