package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.*;
import hello.proxy.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

  @Test
  void dynamicA() {
    AInterface target = new AImpl();

    TimeInvocationHandler handler = new TimeInvocationHandler(target);

    AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

    proxy.call();
    log.info("targetClass={}", target.getClass());
    log.info("proxyClass={}", proxy.getClass());
  }
  @Test
  void dynamicB() {
    BInterface target = new BImpl();

    TimeInvocationHandler handler = new TimeInvocationHandler(target);

    BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);

    proxy.call();
    log.info("targetClass={}", target.getClass());
    log.info("proxyClass={}", proxy.getClass());
  }
  @Test
  void dynamicC() {
    BImpl target = new BImpl();

    ProxyFactory proxyFactory = new ProxyFactory(target);
    Object proxy1 = proxyFactory.getProxy();
    Assertions.assertThat(AopUtils.isJdkDynamicProxy(proxy1)).isTrue();
  }
}
