### To build the image

- docker build -t tracing-demo .

### Execute the container

docker run -p 9000:9000  tracing-demo --server.port=9000


### Test the endpoint

curl -X GET http://localhost:9000/checkout
