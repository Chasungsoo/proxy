package hello.proxy.config.v4_postprocessor.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class PackageLogTracePostProcessor implements BeanPostProcessor {

  private final String basePackage;
  private final Advisor advisor;

  public PackageLogTracePostProcessor(String basePackage, Advisor advisor) {
    this.basePackage = basePackage;
    this.advisor = advisor;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    log.info("beanName : {}, bean : {}",beanName,bean.getClass());

    //프록시 적용대상여부체크
    //프록시 적용대상이 아니면 원본율 그대로 진행
    String packageName = bean.getClass().getPackageName();

    if(!packageName.startsWith(basePackage)){
      return bean;
    } else {
      ProxyFactory proxyFactory = new ProxyFactory(bean);
      proxyFactory.addAdvisor(advisor);
      Object proxy = proxyFactory.getProxy();
      log.info("create proxy: target ={},proxy={} ", bean.getClass(), proxy.getClass());
      return proxy;
    }
  }
}
