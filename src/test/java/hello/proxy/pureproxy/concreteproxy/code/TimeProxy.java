package hello.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic{

  private ConcreteLogic concreteLogic;

  public TimeProxy(ConcreteLogic concreteLogic) {
    this.concreteLogic = concreteLogic;
  }


  @Override
  public String operation() {
    log.info("timedecorator start");
    long startTime = System.currentTimeMillis();
    long endTime = System.currentTimeMillis();

    log.info("timedecorator End : {}");
    long ressult = endTime - startTime;
    return null;
  }


}
