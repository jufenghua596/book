package com.java7book.chapter8.compiler.jdt;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.Compiler;
import org.eclipse.jdt.internal.compiler.DefaultErrorHandlingPolicies;
import org.eclipse.jdt.internal.compiler.ICompilerRequestor;
import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.eclipse.jdt.internal.compiler.IProblemFactory;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.problem.DefaultProblemFactory;

public class OnlineJudge {
    
    static Map<String, Boolean> packagesCache = new HashMap<String, Boolean>();
    
    public void judge(String code) {
        ICompilerRequestor compilerRequestor = new ICompilerRequestor() {
            public void acceptResult(CompilationResult result) {
                if (result.hasErrors()) {
                    System.out.println("出现编译错误。");
                }
                ClassFile[] clazzFiles = result.getClassFiles();
                ClassFile clazzFile = clazzFiles[0];
            }
        };
        
        IErrorHandlingPolicy policy = DefaultErrorHandlingPolicies.exitOnFirstError();
        IProblemFactory problemFactory = new DefaultProblemFactory();
        
        INameEnvironment nameEnvironment = new BasicNameEnvironment();
        CompilerOptions options = new CompilerOptions();
        Compiler jdtCompiler = new Compiler(nameEnvironment, policy, options, compilerRequestor, problemFactory);

        ICompilationUnit[] compilationUnits = new ICompilationUnit[] {new StringCompilationUnit("Main", code)};
        jdtCompiler.compile(compilationUnits);
    }
    
    public static void main(String[] args) {
        OnlineJudge judge = new OnlineJudge();
        String code = "public class Main {  }";
        judge.judge(code);
    }
}
