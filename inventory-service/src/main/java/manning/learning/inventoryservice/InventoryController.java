package manning.learning.inventoryservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class InventoryController
{
    @RequestMapping("/createOrder")
    public String creteOrder()
    {

        Logger logger = Logger.getLogger(InventoryController.class.getName());
        logger.info("Order Created");
        try
        {
            Thread.sleep(8000 + (int)(Math.random() * 2000));
        }
        catch (Exception e)
        {
            logger.info("Exception: " + e.getMessage());
        }
        logger.info("Order Created");
        return "Order Created";

    }
}
