#include <jni.h>
#include <stdio.h>
#include "course_maven_HelloWorld.h"

JNIEXPORT void JNICALL
Java_course_maven_HelloWorld_print(JNIEnv *env, jobject obj)
{
     printf("Hello, World!\n");
     return;
}