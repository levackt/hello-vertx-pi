# hello-vertx-pi
Testing Vertx performance on Raspbian

Build and run steps below, optionally build and run the CPU monitor, [See Vertx experiments README](vert-x3-experiments-rpi-cpuload/README.md)

To benchmark I used [wrk](https://github.com/wg/wrk), creating 12 threads with 100 to 400 connections over 60 seconds, warming up with several runs and the results were fairly consistent.

Your mileage will definitely vary so run your own tests, I used a Raspberry PI 2 B+ connected with an ethernet cable
and ran the tests with my laptop over wifi.

> $ docker info

> ...

> Kernel Version: 3.18.11-hypriotos-v7+

> Operating System: Raspbian GNU/Linux 8 (jessie)

> CPUs: 4

> Total Memory: 925.1 MiB


The wrk command: (export MY_PI or substitute it with your device's IP address)


wrk -t12 -c400 -d60s http://$MY_PI/


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

