package com.comenie.springboot.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by 波 on 2017/2/16.
 * 切面使用语法：
 *  execution：用于匹配方法执行的连接点；
 *  within：用于匹配指定类型内的方法执行；
 *  this：用于匹配当前AOP代理对象类型的执行方法；注意是AOP代理对象的类型匹配，这样就可能包括引入接口也类型匹配；
 *  target：用于匹配当前目标对象类型的执行方法；注意是目标对象的类型匹配，这样就不包括引入接口也类型匹配；
 *  args：用于匹配当前执行的方法传入的参数为指定类型的执行方法；
 *  @within：用于匹配所以持有指定注解类型内的方法；
 *  @target：用于匹配当前目标对象类型的执行方法，其中目标对象持有指定的注解；
 *  @args：用于匹配当前执行的方法传入的参数持有指定注解的执行；
 *  @annotation：用于匹配当前执行方法持有指定注解的方法；
 *  bean：Spring AOP扩展的，AspectJ没有对于指示符，用于匹配特定名称的Bean对象的执行方法；
 *  reference pointcut：表示引用其他命名切入点，只有@ApectJ风格支持，Schema风格不支持。
 *
 *
 *  类型匹配：
 *   * ：匹配任何数量字符；
 *  .. ：（两个点）匹配任何数量字符的重复，如在类型模式中匹配任何数量子包；而在方法参数模式中匹配任何数量参数。
 *   + ：匹配指定类型的子类型；仅能作为后缀放在类型模式后边。
 *
 *  匹配表达式
 *  1 注解？ 类的全限定名字
 *    注解：可选，类型上持有的注解，如@Deprecated；
 *    类的全限定名：必填，可以是任何类全限定名。
 *    匹配方法执行：使用如下方式匹配：
 *
 *  2 注解？ 修饰符? 返回值类型 类型声明?方法名(参数列表) 异常列表？
 *  execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
 *    注解：可选，方法上持有的注解，如@Deprecated
 *    修饰符：可选，如public、protected；
 *    返回值类型：必填，可以是任何类型模式；“*”表示所有类型；
 *    类型声明：可选，可以是任何类型模式；
 *    方法名：必填，可以使用“*”进行模式匹配；
 *    参数列表：“()”表示方法没有任何参数；“(..)”表示匹配接受任意个参数的方法，“(..,java.lang.String)”表示匹配接受java.lang.String类型的参数结束，且其前边可以接受有任意个参数的方法；“(java.lang.String,..)” 表示匹配接受java.lang.String类型的参数开始，且其后边可以接受任意个参数的方法；“(*,java.lang.String)” 表示匹配接受java.lang.String类型的参数结束，且其前边接受有一个任意类型参数的方法；
 *    异常列表：可选，以“throws 异常全限定名列表”声明，异常全限定名列表如有多个以“，”分割，如throws java.lang.IllegalArgumentException, java.lang.ArrayIndexOutOfBoundsException。
 *    匹配Bean名称：可以使用Bean的id或name进行匹配，并且可使用通配符“*”；
 *
 *  切点表达式
 *  AspectJ使用 且（&&）、或（||）、非（！）来组合切入点表达式。
 *
 *   示例：
 *    com.comenie..HelloService.*(..)  com.comenie包以及所有子包下HelloService的所有方法
 *    com.comenie..HelloService.*(*)  com.comenie包以及所有子包下HelloService只有一个参数所有方法
 *    com.comenie..HelloService+.*()  com.comenie包以及所有子包下HelloService接口及其子类型无参方法
 *
 *    @java.lang.Deprecated * *(..)  任何持有@java.lang.Deprecated的方法
 *    @(java.lang.Deprecated || cn.javass..Secure)  * *(..) 任何持有java.lang.Deprecated或者cn.javass..Secure注解的方法
 *
 *
 *
 *
 *  注解类型：
 *  ①@Before    相当于BeforeAdvice，它有2个成员：
*       value    该成员用于定义切点；
*       argNames    由于无法通过反射机制获取方法入参名，所以如果在Java编译时未启用调试信息或者需要在运行期解析切点，
 *                  就必须通过这个成员指定注解所标注增强方法的参数名（注意两者名字必须完全相同），多个参数名用逗号分隔。
 *
*   ②@AfterReturning    后置增强，相当于AfterReturningAdvice，AfterReturning，它拥有4个成员：
*       value    该成员用于定义切点；
*       pointcut    表示切点的信息，如果显示指定point值，它将覆盖value的设置值，可以将pointcut成员看成是value的同义词；
*       returning    将目标对象方法的返回值绑定给增强的方法；
*       argNames   如前所述。
 *
*   ③@Around    环绕增强，相当于MethodInterceptor，它有2个成员：
*       value    该成员用于定义切点；
*       argNames   如前所述。
 *
*   ④@AfterThrowing    抛出增强，相当于ThrowsAdvice，AfterThrowing，它有4个成员：
*       value    该成员用于定义切点；
*       pointcut    表示切点的信息，如果显示指定point值，它将覆盖value的设置值，可以将pointcut成员看成是value的同义词；
*       throwing    将抛出的异常绑定到增强方法中；
*       argNames   如前所述。
 *
*   ⑤@After    Final增强，不管是抛出异常还是正常退出，该增强都会得到执行，该增强没有对应的增强接口，
 *              可以把它看成ThrowsAdvice和AfterReturningAdvice的混合物，一般用于释放资源，它有2个成员：
*       value    该成员用于定义切点；
*       argNames   如前所述。
 *
*   ⑥@DeclareParents    引介增强，相当于IntroductionInterceptor，它有2个成员：
*       value    该成员用于定义切点，它表示在哪个目标类上添加引介增强，即不需要使用函数表达式，直接指定全类名；
*       defaultImpl    默认的接口实现类。
 *
 */
@Component
@Aspect
public class ServiceMonitor {


    @AfterReturning("execution(* com.comenie..*Service.*(..))")
    public void  afterReturningService(JoinPoint joinPoint){
        System.out.println("Completed: " + joinPoint);
    }

    @Before("execution(* com.comenie..*Service.*(..))")
    public  void  beginService(JoinPoint joinPoint){
        System.out.println("Begin : " + joinPoint);
    }

    @Pointcut(value = "execution(* com.comenie..*Service.*(..)) && args(p1,p2)",argNames = "p2,p1")
    public  void beforePointcut(String pp2, String pp1){
    }

    @Before(value = "beforePointcut(p1,p2)",argNames = "p2,p1")
    public  void beforeAdvice(String param1,String param2){
        System.out.println("beforeAdvice: " + param1 + param2);
    }

}
