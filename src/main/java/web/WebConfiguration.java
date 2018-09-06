package web;

import mod2.IMod2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WebConfiguration {

    @Autowired
    IMod2Service controler;

    @PostConstruct
    public void someInit() {
        controler.execute();
    }


    @RestController
    class Mdd2Controller {

        @GetMapping("/exec")
        ResponseEntity<Void> execute() {
            controler.execute();
            return ResponseEntity.ok().build();
        }
    }
}
