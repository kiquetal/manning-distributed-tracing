package manning.learning.eshop;


import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class EShopController
{

    @Autowired
    private RestTemplate restTemplate;
    String result="";
   // @Autowired
  //  private Tracer tracer;
    Logger log = Logger.getLogger(EShopController.class.getName());
    @RequestMapping("/checkout")
    public String checkout(@RequestHeader Map<String,String> headers)
    {
      //  Span span = tracer.buildSpan("checkout").start();
        HttpHeaders httpHeaders = new HttpHeaders();
        headers.forEach((key,value)->{
            httpHeaders.add(key,value);
        });
    //    httpHeaders.add("span-id",span.context().toSpanId());

        log.info("all headers: " + httpHeaders);
        log.info("presented headers!!");
        HttpEntity<String> entity = new HttpEntity<String>("", httpHeaders);
      //  span.setBaggageItem("user",httpHeaders.getFirst("user"));
      //  log.info( "bagga-user: " + span.getBaggageItem("user"));
       // tracer.inject(span.context(), io.opentracing.propagation.Format.Builtin.HTTP_HEADERS, new HttpHeaderCarrier(httpHeaders));
        log.info("checkout() method invoked");
        result = restTemplate.exchange("http://inventory-service:8080/createOrder", HttpMethod.GET, entity, String.class).getBody();
        result = result + "<br>" + restTemplate.exchange("http://billing-service:8080/payment", HttpMethod.GET, entity, String.class).getBody();
        result = result + "<br>" + restTemplate.exchange("http://delivery-service:8080/arrangeDelivery", HttpMethod.GET, entity, String.class).getBody();
        // modify
        log.info("checkout() method finished");
      //  span.finish();
        return result;
    }
}
