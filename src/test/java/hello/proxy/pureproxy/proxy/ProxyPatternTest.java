package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.CacheProxy;
import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

  @Test
  void noProxyTest() {
    RealSubject realSubject = new RealSubject();
    ProxyPatternClient proxyPatternClient = new ProxyPatternClient(realSubject);

    proxyPatternClient.excute();
    proxyPatternClient.excute();
    proxyPatternClient.excute();
  }
  @Test
  void 캐시프록시테스트(){
    RealSubject realSubject = new RealSubject();
    CacheProxy cacheProxy = new CacheProxy(realSubject);
    ProxyPatternClient proxyPatternClient = new ProxyPatternClient(cacheProxy);
    proxyPatternClient.excute();
    proxyPatternClient.excute();
    proxyPatternClient.excute();

  }
}
