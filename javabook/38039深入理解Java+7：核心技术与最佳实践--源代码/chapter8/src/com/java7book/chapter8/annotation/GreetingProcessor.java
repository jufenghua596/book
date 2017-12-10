package com.java7book.chapter8.annotation;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.JavaFileObject;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("com.java7book.chapter8.annotation.SupportedGreetingLocales")
public class GreetingProcessor extends AbstractProcessor {
    private TypeElement greetingElement;
    private Filer filer;
    private Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        elementUtils = processingEnv.getElementUtils();
        greetingElement = elementUtils.getTypeElement("com.java7book.chapter8.annotation.SupportedGreetingLocales");
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {
        Set<String> locales = new HashSet<>();
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(greetingElement);
        for (Element element : elements) {
            processGreetingElement(element, locales);
        }
        for (String localeName : locales) {
            try {
                generateSource(localeName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    
    private void processGreetingElement(Element element, Set<String> locales) {
        List<? extends AnnotationMirror> annotations = element.getAnnotationMirrors();
        for (AnnotationMirror mirror : annotations) {
            if (mirror.getAnnotationType().asElement().equals(greetingElement)) {
                List<? extends AnnotationValue> localeNames = (List<? extends AnnotationValue>) getAnnotationValue(mirror, "value");
                for (AnnotationValue value : localeNames) {
                    locales.add(value.getValue().toString());
                }
            }
        }
    }

    private Object getAnnotationValue(AnnotationMirror mirror, String name) {
        Map<? extends ExecutableElement, ? extends AnnotationValue> values = mirror.getElementValues();
        for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : values.entrySet()) {
            ExecutableElement elem = entry.getKey();
            AnnotationValue value = entry.getValue();
            String elemName = elem.getSimpleName().toString();
            if (name.equals(elemName)) {
                return value.getValue();
            }
        }
        return null;
    }
    
    private void generateSource(String localeName) throws IOException {
        String packageName = "com.java7book.chapter8.annotation";
        String className = packageName + ".Greeting_" + localeName;
        JavaFileObject javaFile = filer.createSourceFile(className, (Element[]) null);
        Writer writer = new OutputStreamWriter(javaFile.openOutputStream(), "UTF-8");
        String source = getSourceTemplate(packageName, localeName);
        writer.write(source);
        writer.close();
    }
    
    private String getSourceTemplate(String packageName, String localeName) {
        String className = "Greeting_" + localeName;
        StringBuilder builder = new StringBuilder();
        builder.append("package ");
        builder.append(packageName);
        builder.append(";import java.util.Locale;");
        builder.append("public class ");
        builder.append(className);
        builder.append(" implements Greeting {");
        builder.append("public " + className + "() {");
        builder.append("GreetingFactory.register(new Locale(\"");
        builder.append(localeName);
        builder.append("\"), getClass());}");
        builder.append("public String greet() { return ");
        builder.append("\"" + localeName + "\";}}");
        return builder.toString();
    }
}
