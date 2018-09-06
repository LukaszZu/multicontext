package mod2;

import export.ExportConfig;
import export.Exported;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({
        ExportConfig.class
})
public class Mod2Configurtion {


    @Bean
    @Exported
    public Mod2Service ctrl() {
        return new Mod2Service();
    }
}
