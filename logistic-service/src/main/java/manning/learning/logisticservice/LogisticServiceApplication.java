package manning.learning.logisticservice;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogisticServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(LogisticServiceApplication.class, args);
    }
/*
    @Bean
    public Tracer getJaegerTracer()
    {
        return Configuration.fromEnv("eshop").getTracer();
    }

 */
}
