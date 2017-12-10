package com.java7book.chapter8.annotation;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("*")
public class HelloWorldProcessor extends AbstractProcessor {
    private Filer filer;
    
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            try {
                generateSource();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    private void generateSource() throws IOException {
        String packageName = "com.java7book.chapter8.annotation";
        String className = "HelloWorld";
        String fullName = packageName + "." + className;
        JavaFileObject javaFile = filer.createSourceFile(fullName, (Element[]) null);
        Writer writer = new OutputStreamWriter(javaFile.openOutputStream(), "UTF-8");
        String source = getSource(packageName, className);
        writer.write(source);
        writer.close();
    }

    private String getSource(String packageName, String className) {
        StringBuilder builder = new StringBuilder();
        builder.append("package " + packageName + ";");
        builder.append("public class " + className + "{}");
        return builder.toString();
    }

    
}
