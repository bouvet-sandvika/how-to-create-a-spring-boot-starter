import java.util.Collection;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Configuration
    public static class RegisterModuleAutoConfiguration {
        @Autowired
        private ObjectMapper objectMapper;
        @Autowired
        private Collection<Module> modules;

        @PostConstruct
        public void registerModules() {
            modules.forEach(objectMapper::registerModule);
        }
    }
}
