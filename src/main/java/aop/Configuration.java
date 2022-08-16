package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@org.springframework.context.annotation.Configuration
@ComponentScan("aop")
@EnableAspectJAutoProxy
public class Configuration {

}
