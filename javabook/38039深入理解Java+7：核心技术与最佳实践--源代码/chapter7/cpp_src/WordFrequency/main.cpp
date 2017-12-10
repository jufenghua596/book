#include <jni.h>

int main()
{
    JNIEnv *env;
    JavaVM *jvm;
    JavaVMInitArgs vm_args;
    JavaVMOption options[1];
    options[0].optionString =
        "-Djava.class.path=C:\\java7\\code\\chapter7\\bin";
    vm_args.version = JNI_VERSION_1_6;
    vm_args.options = options;
    vm_args.nOptions = 1;
    vm_args.ignoreUnrecognized = 0;
    jint res;
    res = JNI_CreateJavaVM(&jvm, (void**)&env, &vm_args);
    if (res < 0)
    {
        return res;
    }
    jclass clsDownloader = env->FindClass("com/java7book/chapter7/jni/WebPageDownloader");
    jmethodID midGetContent = env->GetStaticMethodID(clsDownloader, "getContent", "(Ljava/lang/String;)Ljava/lang/String;");
    jstring content = (jstring) env->CallStaticObjectMethod(clsDownloader, midGetContent, env->NewStringUTF("http://www.baidu.com"));
    if (env->ExceptionOccurred())
    {
        printf("Error occurs when downloading content.");
        jvm->DestroyJavaVM();
        return -1;
    }
    const char *text_str = env->GetStringUTFChars(content, NULL);
    printf(text_str);
    jvm->DestroyJavaVM();
}
