package hello.proxy.pureproxy.decorate.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator extends AbstractDecorator{


  public TimeDecorator(Component component) {
    super(component);
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
