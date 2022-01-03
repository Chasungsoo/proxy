package hello.proxy.pureproxy.decorate;

import hello.proxy.pureproxy.decorate.code.Component;
import hello.proxy.pureproxy.decorate.code.DecoratorPatternClient;
import hello.proxy.pureproxy.decorate.code.MessageDecorator;
import hello.proxy.pureproxy.decorate.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

  @Test
  void noDecorator(){
    Component component = new RealComponent();
    DecoratorPatternClient client = new DecoratorPatternClient(component);
    client.execute();
  }

  @Test
  void decorator1(){
    Component real = new RealComponent();
    Component mesaag= new MessageDecorator(real);
    DecoratorPatternClient client = new DecoratorPatternClient(mesaag);
    client.execute();
  }
}
