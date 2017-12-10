#include "com_java7book_chapter7_jni_MessageBox.h"
#include "Windows.h"
#include "Winuser.h"

JNIEXPORT jint JNICALL Java_com_java7book_chapter7_jni_MessageBox_show
  (JNIEnv *env, jobject obj, jstring text, jstring caption) {
    const char *text_str = env->GetStringUTFChars(text, NULL);
    const char *caption_str = env->GetStringUTFChars(caption, NULL);
    int result = MessageBox(0, text_str, caption_str, MB_OK | MB_ICONINFORMATION);
    env->ReleaseStringUTFChars(text, text_str);
    env->ReleaseStringUTFChars(caption, caption_str);
    return result;
}
