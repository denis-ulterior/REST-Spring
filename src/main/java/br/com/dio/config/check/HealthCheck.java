package br.com.dio.config.check;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
@Component
public class HealthCheck implements HealthIndicator {
    @Override
    public Health health(){
        try{
            InetAddress address = InetAddress.getByName("localhost");
            if (address.isReachable(10000)){
                return Health.up().build();
            }
        } catch (IOException e) {
           return Health.down().withDetail("Motivo: ",e.getMessage()).build();
        }
        return Health.down().withDetail("Motivo: ","Motivo desconhecido").build();
    }
}
