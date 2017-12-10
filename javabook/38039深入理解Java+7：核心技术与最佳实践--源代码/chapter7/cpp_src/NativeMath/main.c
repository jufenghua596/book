#include "com_java7book_chapter7_jni_NativeMath.h"
#include <math.h>

JNIEXPORT jdouble JNICALL Java_com_java7book_chapter7_jni_NativeMath_sqrt
  (JNIEnv *env, jobject obj, jdouble value) {
  return sqrt(value);
  }
