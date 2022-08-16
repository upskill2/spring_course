package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        if(signature.getName().equals("addBook")){

            Object[] arguments = joinPoint.getArgs();

            for (Object obj : arguments ){
                if(obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("Object Book name = " + myBook.getName() + "author " + myBook.getAuthor() + "year " + myBook.getYear());
                }
                else if ( obj instanceof String){

                    System.out.println("owner "+ obj);
                }
            }


            System.out.println("methodSignature =" + signature);
            System.out.println("methodSignature =" + signature.getMethod());
            System.out.println("methodSignature =" + signature.getReturnType());
            System.out.println("methodSignature =" + signature.getName());
        }



        System.out.println("beforeGetLoggingAdvice: University Log #1");
    }


    @Pointcut("execution (* aop.UniversityLibrary.*(..))")
    private void allMethodsFromUniversity(){

    }

    @Pointcut("execution (* aop.UniversityLibrary.get*(..))")
    private void allGetMethodsFromUniversityLib() {

    }

    @Pointcut("execution (* aop.UniversityLibrary.returnMagazine*(..))")
    private void allReturnMethodsFromUniversityLib() {

    }

    @Pointcut("allGetMethodsFromUniversityLib() || allReturnMethodsFromUniversityLib()")
    private void allGetOrReturnMethodsFromUniversityLib() {

    }

    @Pointcut("allGetMethodsFromUniversityLib() && !allReturnMethodsFromUniversityLib()")
    private void allGetWithNoReturnMethodsFromUniversityLib() {

    }

/*    @Before("allGetOrReturnMethodsFromUniversityLib()")
    public void beforeAllGetWithNoReturnMethodsFromUniversityLib() {
        System.out.println("beforeGetLoggingAdvice: University Log #4");
    }

    @Before("allGetOrReturnMethodsFromUniversityLib()")
    public void beforeAllGetOrReturnMethodsFromUniversityLib() {
        System.out.println("beforeGetLoggingAdvice: University Log #3");
    }

    @Before("allReturnMethodsFromUniversityLib()")
    public void beforeReturnLoggingAdvice() {
        System.out.println("beforeReturnLoggingAdvice: University Log #2");
    }*/



/*    @Before("execution(* aop.UniversityLibrary.return*(..))")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeReturnBookAdvice: trying to return book from University");
    }*/

}
