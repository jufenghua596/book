package com.java7book.chapter8.annotation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
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

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("com.java7book.chapter8.annotation.Author")
public class AuthorProcessor extends AbstractProcessor {
    private Map<String, Integer> countMap = new HashMap<>();
    private TypeElement authorElement;
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        Elements elementUtils = processingEnv.getElementUtils();
        authorElement = elementUtils.getTypeElement("com.java7book.chapter8.annotation.Author");
    }

    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(authorElement);
        for (Element element : elements) {
            processAuthor(element);
        }
        if (roundEnv.processingOver()) {
            for (Map.Entry<String, Integer> entry :  countMap.entrySet()) {
                System.out.println(entry.getKey() + " ==> " + entry.getValue());
            }
        }
        return true;
    }

    private void processAuthor(Element element) {
        List<? extends AnnotationMirror> annotations = element.getAnnotationMirrors();
        for (AnnotationMirror mirror : annotations) {
            if (mirror.getAnnotationType().asElement().equals(authorElement)) {
                String name = (String) getAnnotationValue(mirror, "name");
                if (!countMap.containsKey(name)) {
                    countMap.put(name, 1);
                }
                else {
                    countMap.put(name, countMap.get(name) + 1);
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
}
