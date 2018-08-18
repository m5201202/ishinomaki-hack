package project.utils;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Level;
import java.util.logging.Logger;

@Dependent
public class LoggerFactory {
    @Produces
    public Logger getLogger(InjectionPoint injectionPoint) {
        String name = injectionPoint.getMember().getDeclaringClass().getName();
        Logger logger = Logger.getLogger(name);
        logger.setLevel(Level.ALL);
        return logger;
    }
}
