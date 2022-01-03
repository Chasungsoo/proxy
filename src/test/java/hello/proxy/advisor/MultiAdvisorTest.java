package hello.proxy.advisor;

import hello.proxy.common.service.ServiceImpl;
import hello.proxy.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

@Slf4j
public class MultiAdvisorTest {


  @Test
  @DisplayName("여러프록시")
  void multiAdvisorTest1(){
    ServiceInterface target = new ServiceImpl();
    ProxyFactory proxyFactory = new ProxyFactory(target);
    DefaultPointcutAdvisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
    proxyFactory.addAdvisor(advisor1);
    ServiceInterface proxy1 =(ServiceInterface) proxyFactory.getProxy();


    ProxyFactory proxyFactory2 = new ProxyFactory(proxy1);
    DefaultPointcutAdvisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());
    proxyFactory.addAdvisor(advisor2);
    ServiceInterface proxy2 =(ServiceInterface) proxyFactory.getProxy();

  }

  @Test
  @DisplayName("하나의프록시, 여러 어드바이저")
  void multiAdvisorTest2(){
    //클라이언트 -> 프록시 -> 어드바이저 2 -> 어드바이저1 -> 타겟
    DefaultPointcutAdvisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
    DefaultPointcutAdvisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());


    ServiceInterface target = new ServiceImpl();
    ProxyFactory proxyFactory = new ProxyFactory(target);

    proxyFactory.addAdvisor(advisor2);
    proxyFactory.addAdvisor(advisor1);

    ServiceInterface proxy =(ServiceInterface) proxyFactory.getProxy();
    proxy.save();

  }
  static class Advice1 implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

      log.info("advice1");
      return invocation.proceed();
    }
  }

  static class Advice2 implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

      log.info("advice2");
      return invocation.proceed();
    }
  }
}
