package org.example;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.Main.transformString(..))")
    public void logTransformString(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof String) {
            String input = (String) args[0];
            System.out.println("Original input: " + input);
        }
    }

    @Before("execution(* com.example.StringChanger.convector(..)) && args(line)")
    public void logConvector(JoinPoint joinPoint, String line) {
        System.out.println("Transformed input: " + line);
    }
}

