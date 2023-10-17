package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("aroundReturnBookLoggingAdvice : в библиотеку пытаются вернуть книгу");

        Object result = null;

//        long begin = System.currentTimeMillis();
        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            System.out.println("[AROUND] aroundReturnBookLoggingAdvice : было поймано исключение " + e);
//            result = "Неизвестное название";
            throw e;
        }

//        long end = System.currentTimeMillis();


        System.out.println("aroundReturnBookLoggingAdvice : в библиотеку успешно вернули книгу");
//        System.out.println("Время выполнения: " + (end - begin) + " мс");

        return result;
    }

}
