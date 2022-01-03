package hello.proxy.pureproxy.decorate.code;

public abstract class AbstractDecorator implements Component{

  private Component component;

  public AbstractDecorator(Component component) {
    this.component = component;
  }
}
