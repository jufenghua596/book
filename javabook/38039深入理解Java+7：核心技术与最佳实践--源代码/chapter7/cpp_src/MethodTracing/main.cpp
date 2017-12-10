#include <jni.h>
#include <jvmti.h>
#include <iostream>
#include <fstream>
#include <map>

using namespace std;

map<string, int> methodCountMap;

void JNICALL Method_Entry(jvmtiEnv *jvmti_env, JNIEnv* jni_env, jthread thread, jmethodID method)
{
    char *method_name;
    jclass cls;
    char *class_signature;
    jvmti_env->GetMethodName(method, &method_name, NULL, NULL);
    jvmti_env->GetMethodDeclaringClass(method, &cls);
    jvmti_env->GetClassSignature(cls, &class_signature, NULL);
    char name[256] = {0};
    strcpy(name, class_signature);
    strcat(name, method_name);
    methodCountMap[name]++;
    jvmti_env->Deallocate((unsigned char*)method_name);
    jvmti_env->Deallocate((unsigned char*)class_signature);
}

JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM *jvm, char *options, void *reserved)
{
    jvmtiEnv *jvmti;
    jvm->GetEnv((void **)&jvmti, JVMTI_VERSION_1_0);
    jvmtiCapabilities capa;
    memset(&capa, 0, sizeof(jvmtiCapabilities));
    capa.can_generate_method_entry_events = 1;
    jvmti->AddCapabilities(&capa);
    jvmtiEventCallbacks callbacks;
    callbacks.MethodEntry = &Method_Entry;
    jvmti->SetEventNotificationMode(JVMTI_ENABLE, JVMTI_EVENT_METHOD_ENTRY, NULL);
    jvmti->SetEventCallbacks(&callbacks, (jint)sizeof(callbacks));
    return JNI_OK;
}

JNIEXPORT void JNICALL Agent_OnUnload(JavaVM *vm)
{
    ofstream file;
    file.open ("C:\\method_trace.txt", ios::out);
    for( map<string, int>::iterator iter = methodCountMap.begin(); iter != methodCountMap.end(); ++iter)
    {
        file << (*iter).first << "\t" << (*iter).second << endl;
    }
    file.close();
}

