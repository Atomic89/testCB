package support;

import org.flywaydb.core.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

/**
 * Накатывание миграций
 */
@WebListener
public class WebAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/test?currentSchema=records&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "1234");
        flyway.migrate();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){

    }
}

