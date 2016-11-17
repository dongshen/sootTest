package com.sdong.soot.research;

import java.util.Collections;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.options.Options;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		String path = "input";
		initial(path); 
		
		SootClass appclass = Scene.v().loadClassAndSupport("TestMain");
		System.out.println("the main class is :" + appclass.getName());
		// 获取类中的相关的方法
		Iterator<SootMethod> methodIt = appclass.getMethods().iterator();
		while (methodIt.hasNext()) {
			System.out.println("the function member is : " + methodIt.next().getName());
		}
	}
	
	private static void initial(String apkPath) {  
        soot.G.reset();  
        Options.v().set_allow_phantom_refs(true);  
        Options.v().set_prepend_classpath(true);  
        Options.v().set_validate(true);  
        Options.v().set_output_format(Options.output_format_jimple);  
        Options.v().set_src_prec(Options.src_prec_java);  
        Options.v().set_process_dir(Collections.singletonList(apkPath));//路径应为文件夹  
        Options.v().set_keep_line_number(true);  
//      Options.v().set_whole_program(true);  
        Options.v().set_no_bodies_for_excluded(true);  
        Options.v().set_app(true);  
//       Scene.v().setMainClass(appclass); // how to make it work ?  
        Scene.v().addBasicClass("java.io.PrintStream", SootClass.SIGNATURES);  
        Scene.v().addBasicClass("java.lang.System", SootClass.SIGNATURES);  
        Scene.v().addBasicClass("java.lang.Thread", SootClass.SIGNATURES);  
        Scene.v().loadNecessaryClasses();  
    }  
}
