package zz.example.multicontext;

import mod1.Mod1Configuration;
import mod2.Mod2Configurtion;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import web.WebConfiguration;

import java.util.function.BiConsumer;

public class MultiContextApplication {

    public static void main(String[] args) {

        BiConsumer<ConfigurableApplicationContext, String> init = (ctx, name) -> {
            ((AbstractApplicationContext) ctx).setDisplayName(name);
        };

        // @formatter:off
        ConfigurableApplicationContext app = new SpringApplicationBuilder()
                .sources(MultiContextApplication.class).web(WebApplicationType.NONE)
                .initializers((ctx) -> init.accept(ctx, "root"))
                .child(Mod1Configuration.class).properties("spring.config.name:mod1")
                    .web(WebApplicationType.NONE).bannerMode(Banner.Mode.OFF)
                    .logStartupInfo(false).initializers((ctx) -> init.accept(ctx, "mod1"))
                .sibling(Mod2Configurtion.class).properties("spring.config.name:mod2")
                    .web(WebApplicationType.NONE).bannerMode(Banner.Mode.OFF)
                    .logStartupInfo(false).initializers((ctx) -> init.accept(ctx, "mod2"))
                .sibling(WebConfiguration.class).properties("spring.config.name:web")
                    .web(WebApplicationType.SERVLET).bannerMode(Banner.Mode.OFF)
                    .logStartupInfo(false).initializers((ctx) -> init.accept(ctx, "web"))
                .run(args);

        // @formatter:on
    }
}
