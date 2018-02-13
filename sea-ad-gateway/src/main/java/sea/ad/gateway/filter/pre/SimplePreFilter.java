package sea.ad.gateway.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lx48475
 * @version Id: SimplePreFilter.java, v 0.1 2018年02月13 17:15 lx48475 Exp $
 */
public class SimplePreFilter extends ZuulFilter {
    
    private final static Logger logger = LoggerFactory.getLogger(SimplePreFilter.class);
    
    @Override
    public String filterType() {
        return "PRE";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }
}
