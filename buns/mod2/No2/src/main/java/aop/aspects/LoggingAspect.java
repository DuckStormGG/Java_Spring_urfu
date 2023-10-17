package aop.aspects;


import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

    @Before("aop.aspects.MyPointCuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName = " + methodSignature.getName());

        if(methodSignature.getName().equals("addBook")){
            Object[] arguments = joinPoint.getArgs();
            for (Object object:arguments){
                if (object instanceof Book){
                    Book mybook = (Book) object;
                    System.out.println("Название - " + mybook.getName()
                            +", автор - "+ mybook.getAuthor()
                            +", год издания - " + mybook.getYearOfPublication());
                }
                else if (object instanceof String){
                    System.out.println("Книгу в библиотеку добавил "+ object);
                }
            }
        }

        System.out.println("beforeAddBookAdvice: логирование попытки получить книгу");
        System.out.println("|- - - - - - - - - - - - - - - - - - - - - - - - - - -|");
    }

}
