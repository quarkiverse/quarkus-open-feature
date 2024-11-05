package io.quarkiverse.open.feature.runtime;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface Domain {

    String value();


    class Literal extends AnnotationLiteral<Domain> implements Domain {
        @Override
        public String value() {
            return value;
        }


        final String value;

        Literal(String value) {
            this.value = value;

        }

    }
}
