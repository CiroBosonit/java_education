package com.bosonit.education.ej2.infrastructure;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PatchField {

  boolean overrided() default false;

}
