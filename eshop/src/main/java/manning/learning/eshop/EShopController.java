package manning.learning.eshop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class EShopController
{

    @Autowired
    private RestTemplate restTemplate;
    String result="";
    Logger log = Logger.getLogger(EShopController.class.getName());
    @RequestMapping("/checkout")
    public String checkout()
    {
        log.info("checkout() method invoked");
        result = restTemplate.exchange("http://inventory-service:8080/createOrder", HttpMethod.GET, null, String.class).getBody();
        result = result + "<br>" + restTemplate.exchange("http://billing-service:8080/payment", HttpMethod.GET, null, String.class).getBody();
        result = result + "<br>" + restTemplate.exchange("http://delivery-service:8080/arrangeDelivery", HttpMethod.GET, null, String.class).getBody();
        log.info("checkout() method finished");
        return result;
    }
}
