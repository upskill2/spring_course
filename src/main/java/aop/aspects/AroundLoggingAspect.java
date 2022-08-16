package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundLoggingAspect {

    @Around("execution (* returnBook(..))")
    public Object aroundReturnBookAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("aroundReturnBookAspect: Trying -->Around aspect to return the book");

        long begin = System.currentTimeMillis();

        Object targetMethod = null;
        try{
            targetMethod = proceedingJoinPoint.proceed();
        } catch(ArithmeticException e){
     //         targetMethod = "FAKE!!!";
            System.out.println("aroundReturnBookAspect: + exception " + e);
            throw e;
        }



        long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookAspect: Returned -->Around aspect to return the book");
        System.out.println("time equals = " + (end-begin));
        return targetMethod;
    }
}
