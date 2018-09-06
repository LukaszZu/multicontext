package export;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExportConfig  {

    @Bean
    BeanPostProcessor exportedBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        return new ExportedBeanPostProcessor(beanFactory);
    }

}
