package tn.esprit.tpfoyer.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;



@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.tpfoyer.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("method :" + joinPoint.getSignature().getName());

    }
}
