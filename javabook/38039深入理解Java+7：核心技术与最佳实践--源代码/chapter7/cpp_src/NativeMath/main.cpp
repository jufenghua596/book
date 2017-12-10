#include "com_java7book_chapter7_jni_NativeMath.h"
#include <math.h>

JNIEXPORT jdouble JNICALL Java_com_java7book_chapter7_jni_NativeMath_sqrt
  (JNIEnv *env, jobject obj, jdouble value) {
  return sqrt(value);
  }

JNIEXPORT jdouble JNICALL Java_com_java7book_chapter7_jni_NativeMath_size
  (JNIEnv *env, jobject obj, jobject rectangle) {
  jclass cls = env->GetObjectClass(rectangle);
  jmethodID getWidthMid =
         env->GetMethodID(cls, "getWidth", "()D");
  double width = env->CallDoubleMethod(rectangle, getWidthMid);
  jmethodID getHeightMid = env->GetMethodID(cls, "getHeight", "()D");
  double height = env->CallDoubleMethod(rectangle, getHeightMid);
  return width * height;
}
