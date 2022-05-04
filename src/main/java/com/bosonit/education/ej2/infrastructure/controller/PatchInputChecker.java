package com.bosonit.education.ej2.infrastructure.controller;

import com.bosonit.education.ej2.infrastructure.PatchField;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PatchInputChecker {

  public static <T> T check(Class<T> inputClass, Map<Object, Object> inputData) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

    T inputClassInstance = inputClass.getConstructor().newInstance();
    List<String> inputFieldsStr = Arrays.stream(inputClass.getDeclaredFields()).map(Field::getName).toList();

    inputData.forEach((key, value) -> {
      if (!inputFieldsStr.contains(key)) {
        throw new DataIntegrityViolationException("Field doesn't exist");
      }

      Field field = ReflectionUtils.findField(inputClass, (String) key);
      PatchField patchFieldAnnotation = field.getAnnotation(PatchField.class);

      Map<Class<? extends Annotation>, Annotation> map =
          (Map<Class<? extends Annotation>, Annotation>) inputData.get(patchFieldAnnotation);

      Annotation newAnnotation = new PatchField() {

        @Override
        public Class<? extends Annotation> annotationType() {

          return patchFieldAnnotation.annotationType();
        }

        @Override
        public boolean overrided() {

          return true;
        }
      };

      map.put(PatchField.class, newAnnotation);

      ReflectionUtils.setField(field, inputClassInstance, value);
    });

    return inputClassInstance;
  }

}
