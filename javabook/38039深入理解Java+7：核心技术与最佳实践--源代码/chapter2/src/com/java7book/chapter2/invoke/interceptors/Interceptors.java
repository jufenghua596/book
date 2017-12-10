/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.invoke.interceptors;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author chengfu
 */
public class Interceptors {

    public static MethodHandle before(MethodHandle target, MethodHandle before) {
        MethodType beforeType = before.type();
        if (beforeType.returnType() != void.class) {
            throw new IllegalArgumentException("before must return void " + beforeType);
        }
        MethodType targetType = target.type();
        if (beforeType.parameterCount() != targetType.parameterCount()) {
            if (beforeType.parameterCount() > targetType.parameterCount()) {
                throw new IllegalArgumentException("before has too much parameter compare to target " + beforeType + " " + targetType);
            }
            before = MethodHandles.dropArguments(before,
                    beforeType.parameterCount(),
                    targetType.parameterList().subList(beforeType.parameterCount(), targetType.parameterCount()));
        }

        if (!before.type().equals(targetType.changeReturnType(void.class))) {
           throw new IllegalArgumentException("before parameter types are not compatible with target " + beforeType + " " + targetType);
        }

        return MethodHandles.foldArguments(target, before);
    }
    
    public static MethodHandle after(MethodHandle target, MethodHandle after) {
        return MethodHandles.filterReturnValue(target, after);
    }
}
