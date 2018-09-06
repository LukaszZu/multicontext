package mod1;

import export.ExportConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan
@Import({
        ExportConfig.class
})
public class Mod1Configuration {

    @Value("${mod1.a}")
    String a;

    @PostConstruct
    public void init() {
    }

}
