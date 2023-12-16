### To build the image

- docker build -t tracing-demo .

### Execute the container

docker run -p 9000:9000  tracing-demo --server.port=9000


### Test the endpoint

curl -X GET http://localhost:9000/checkout

### Run container jaeger

docker run -d --name jaeger   -p 14268:14268   -p 16686:16686   jaegertracing/all-in-one:1.22

### Install the client in spring boot

	implementation 'io.jaegertracing:jaeger-client:1.8.1'


### For the milestone1 

    Check the file Controller.java

### For the mileston2

    Check the file ControllerV2.java

