package hr.algebra.food.foodpostgetsession.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        System.out.println("Starting transaction filter!");

        HttpServletRequest req = (HttpServletRequest) request;
        LOG.info(
                "Starting a transaction for req : {}",
                req.getRequestURI());

        chain.doFilter(request, response);
        LOG.info(
                "Committing a transaction for req : {}",
                req.getRequestURI());

        System.out.println("Finishing transaction filter!");
    }

    // other methods
}

