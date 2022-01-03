package hello.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

  private final Object target;

  public TimeInvocationHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    log.info("타임프로ㅓㄱ시 실행 ");
    long startTime = System.currentTimeMillis();
    Object result = method.invoke(target,args);

    long endTime = System.currentTimeMillis();
    long resultTime = endTime- startTime;

    PatternMatchUtils.simpleMatch("sdf","fsd");
    log.info("result time = {}", resultTime);
    return result;
  }
}
