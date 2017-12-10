package com.java7book.chapter8.annotation;

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
@SupportedAnnotationTypes("com.java7book.chapter8.annotation.WithArrayValue")
public class ClassValueProcessor extends AbstractProcessor {
    
    private TypeElement arrayValueElement;
    
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        Elements elementUtils = processingEnv.getElementUtils();
        arrayValueElement = elementUtils.getTypeElement("com.java7book.chapter8.annotation.WithArrayValue");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(annotation);
            for (Element element : elements) {
                processArrayValue(element);
            }
        }
        return false;
    }

    private void processArrayValue(Element element) {
        List<? extends AnnotationMirror> annotations = element.getAnnotationMirrors();
        for (AnnotationMirror mirror : annotations) {
            if (mirror.getAnnotationType().asElement().equals(arrayValueElement)) {
                Map<? extends ExecutableElement, ? extends AnnotationValue> values = mirror.getElementValues();
                for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : values.entrySet()) {
                    ExecutableElement elem = entry.getKey();
                    AnnotationValue value = entry.getValue();
                    Object obj = value.getValue();
                    System.out.println(elem);
                    if (obj instanceof List) {
                        List list = (List) obj;
                        for (Object aObj : list) {
                            System.out.println(aObj.getClass());
                        }
                    }
                }
            }
        }
    }
}
