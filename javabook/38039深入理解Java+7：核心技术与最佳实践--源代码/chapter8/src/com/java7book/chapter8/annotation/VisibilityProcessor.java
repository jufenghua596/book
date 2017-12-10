package com.java7book.chapter8.annotation;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import com.sun.source.util.Trees;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.Context;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("com.java7book.chapter8.annotation.Visible")
public class VisibilityProcessor extends AbstractProcessor {
    private TypeElement visibleElement;
    private Trees trees;
    private TreeMaker treeMaker;

    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        trees = Trees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        treeMaker = TreeMaker.instance(context);
        Elements elementUtils = processingEnv.getElementUtils();
        visibleElement = elementUtils.getTypeElement("com.java7book.chapter8.annotation.Visible");
    }

    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(visibleElement);
            for (Element element : elements) {
                JCTree tree = (JCTree) trees.getTree(element);
                TreeTranslator visitor = new VisibilityTranslator();
                tree.accept(visitor);
            }
        }
        return true;
    }

    private class VisibilityTranslator extends TreeTranslator {
        public void visitVarDef(JCVariableDecl def) {
            super.visitVarDef(def);
            JCVariableDecl pub = treeMaker.VarDef(treeMaker.Modifiers(1), def.name, def.vartype, def.init);
            result = pub;
        }
    }
}
