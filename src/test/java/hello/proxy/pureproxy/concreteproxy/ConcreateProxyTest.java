package hello.proxy.pureproxy.concreteproxy;

import hello.proxy.pureproxy.concreteproxy.code.ConcreateClient;
import hello.proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import hello.proxy.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreateProxyTest {


  @Test
  void noProxy() {
    ConcreteLogic concreteLogic = new ConcreteLogic();

    ConcreateClient concreateClient = new ConcreateClient( concreteLogic);
    concreateClient.execute();
  }
  @Test
  void addProxy() {
    ConcreteLogic concreteLogic = new ConcreteLogic();
    TimeProxy timeProxy = new TimeProxy(concreteLogic);
    ConcreateClient concreateClient = new ConcreateClient(timeProxy);
    concreateClient.execute();
  }
}
