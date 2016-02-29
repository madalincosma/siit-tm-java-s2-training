package ro.tm.siit.classroom.w14d1.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Log annotation can be used to print custom messages for annotated
 * methods.
 * 
 * @author mco
 *
 */
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Log {
	
	/**
	 * the text to be printed
	 * @return
	 */
	String text();
}
