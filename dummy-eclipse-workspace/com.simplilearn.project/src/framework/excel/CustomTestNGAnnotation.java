package framework.excel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// concept of creating any custom-TestNG-annotation, referred from --> toolsqa.com
@Retention (RetentionPolicy.RUNTIME)
public @interface CustomTestNGAnnotation {
	int value() default 0;	

}
