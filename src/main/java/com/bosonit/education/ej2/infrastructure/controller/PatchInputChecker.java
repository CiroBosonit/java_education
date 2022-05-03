package com.bosonit.education.ej2.infrastructure.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class PatchInputChecker {

  public static <T> T check(T inputClass, Map<Object, Object> inputData) {

    inputData.forEach((key, value) -> {
      Set<String> inputFieldsStr = Set.of(Arrays.toString(inputClass.getClass().getFields()));

      if (!inputFieldsStr.contains(key)) {
        throw new DataIntegrityViolationException("Field doesn't exist");
      }

      Field field = ReflectionUtils.findField(inputClass.getClass(), (String) key);
      ReflectionUtils.setField(field, inputClass, value);
    });

    return inputClass;
  }

}
