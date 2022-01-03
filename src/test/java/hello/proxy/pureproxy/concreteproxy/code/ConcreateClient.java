package hello.proxy.pureproxy.concreteproxy.code;


public class ConcreateClient {

  private ConcreteLogic concreteLogic;

  public ConcreateClient(ConcreteLogic concreteLogic) {
    this.concreteLogic = concreteLogic;
  }

  public void execute(){
    concreteLogic.operation();
  }
}
