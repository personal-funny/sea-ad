package sea.ad.gateway.configer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sea.ad.gateway.filter.pre.SimplePreFilter;

/**
 * @author lx48475
 * @version Id: BeanFilter.java, v 0.1 2018年02月13 17:35 lx48475 Exp $
 */
@Configuration
public class BeanFilter {

    @Bean
    public SimplePreFilter simplePreFilter() {
        return new SimplePreFilter();
    }
}
