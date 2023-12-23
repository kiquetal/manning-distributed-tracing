package manning.learning.deliverservice;


import io.opentracing.Span;
import io.opentracing.SpanContext;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class DeliveryController
{
    @Autowired
    private RestTemplate restTemplate;
   // @Autowired
   // private Tracer tracer;
    Logger log = Logger.getLogger(DeliveryController.class.getName());

    @RequestMapping("/arrangeDelivery")
    public String arrangeDelivery(@RequestHeader HttpHeaders headers)
    {

     //   SpanContext parent = tracer.extract(io.opentracing.propagation.Format.Builtin.HTTP_HEADERS, new HttpHeaderCarrier(headers));
    //    Span span = tracer.buildSpan("arrangeDelivery").asChildOf(parent).start();
    //    String user = span.getBaggageItem("user");
    //    tracer.inject(span.context(), io.opentracing.propagation.Format.Builtin.HTTP_HEADERS, new HttpHeaderCarrier(headers));
        String result = "";
        log.info("Arranging delivery");
        try {
     //       result += String.format("%s's order is on the way.\n ", user);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            result += restTemplate.exchange("http://logistic-service:8080/transport", org.springframework.http.HttpMethod.GET, entity, String.class).getBody();
            Thread.sleep(800 + (int) (Math.random() * 400));
        } catch (Exception e) {
            log.info("Exception: " + e.getMessage());
        }
        log.info("Delivery arranged");
      //  span.finish();
        return result;
    }
}
