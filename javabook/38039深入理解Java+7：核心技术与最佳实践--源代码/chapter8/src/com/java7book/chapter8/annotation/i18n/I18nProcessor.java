package com.java7book.chapter8.annotation.i18n;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
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
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;



@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("com.java7book.chapter8.annotation.i18n.*")
public class I18nProcessor extends AbstractProcessor {
    private TypeElement bundleElement;
    private TypeElement messageElement;
    private Filer filer;
    
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        Elements elementUtils = processingEnv.getElementUtils();
        bundleElement = elementUtils.getTypeElement("com.java7book.chapter8.annotation.i18n.MessageBundle");
        messageElement = elementUtils.getTypeElement("com.java7book.chapter8.annotation.i18n.Message");
        filer = processingEnv.getFiler();
        try {
            Velocity.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(bundleElement);
        for (Element element : elements) {
            try {
                processBundle(element);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void processBundle(Element element) throws IOException {
        AnnotationMirror mirror = getAnnotationMirror(element, bundleElement);
        if (mirror == null) {
            return;
        }
        Map<String, String> messages = new HashMap<>();
        String bundleName = (String) getAnnotationValue(mirror, "value"); 
        List<? extends Element> methodElements = element.getEnclosedElements();
        for (Element methodElement : methodElements) {
            AnnotationMirror keyMirror = getAnnotationMirror(methodElement, messageElement);
            if (keyMirror != null) {
                String key = (String) getAnnotationValue(keyMirror, "key");
                String value = (String) getAnnotationValue(keyMirror, "value");
                if (!"".equals(value)) {
                    messages.put(key, value);
                }
            }
        }
        String packageName = "com.java7book.chapter8.annotation.i18n";
        generateProperitesFile(packageName, bundleName, messages);
        generateBundleJavaFile(packageName, bundleName);
    }
    
    private AnnotationMirror getAnnotationMirror(Element element, Element annotationType) {
        List<? extends AnnotationMirror> annotations = element.getAnnotationMirrors();
        for (AnnotationMirror mirror : annotations) {
            if (mirror.getAnnotationType().asElement().equals(annotationType)) {
                return mirror;
            }
        }
        return null;
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
    
    private void generateProperitesFile(String packageName, String bundleName, Map<String, String> properties) throws IOException {
        FileObject fileObject = filer.createResource(StandardLocation.SOURCE_OUTPUT, packageName, bundleName + ".properties", (Element[])null);
        Writer writer = new OutputStreamWriter(fileObject.openOutputStream(), "UTF-8");
        VelocityContext context = new VelocityContext();
        context.put("properties", properties);
        outputUsingVelocity(context, "properties.vm", writer);
    }
    
    private void generateBundleJavaFile(String packageName, String bundleName) throws IOException {
        String className = packageName + "." + bundleName;
        JavaFileObject javaFile = filer.createSourceFile(className, (Element[]) null);
        Writer writer = new OutputStreamWriter(javaFile.openOutputStream(), "UTF-8");
        VelocityContext context = new VelocityContext();
        context.put("packageName", packageName);
        context.put("bundleName", bundleName);
        outputUsingVelocity(context, "bundleJavaSource.vm", writer);
    }
    
    private void outputUsingVelocity(VelocityContext context, String templateName, Writer writer) {
        try {
            Template template = Velocity.getTemplate(templateName);
            template.merge(context, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
