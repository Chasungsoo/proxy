package hello.proxy.pureproxy.decorate.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component{
  @Override
  public String operation() {

    log.info("리얼컴포넌트 실행");
    return "data";
  }

}
