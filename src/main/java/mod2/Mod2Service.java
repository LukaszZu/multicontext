package mod2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class Mod2Service implements IMod2Service {

    @Override
    public void execute() {
        log.info("Mod2 executed");
    }
}
