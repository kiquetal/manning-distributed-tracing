package manning.learning.deliverservice;


import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class DeliveryController
{
    @Autowired
    private RestTemplate restTemplate;
@Autowired
    private Tracer tracer;
    @RequestMapping("/arrangeDelivery")
    public String arrangeDelivery()
    {
        Logger log = Logger.getLogger(DeliveryController.class.getName());
        Span span = tracer.buildSpan("arrangeDelivery").start();
        String result = "";
        log.info("Arranging delivery");
        try {
            result = restTemplate.exchange("http://logistic-service:8080/transport", org.springframework.http.HttpMethod.GET, null, String.class).getBody();
            Thread.sleep(800 + (int) (Math.random() * 400));
        } catch (Exception e) {
            log.info("Exception: " + e.getMessage());
        }
        log.info("Delivery arranged");
        span.finish();
        return result;
    }
}
