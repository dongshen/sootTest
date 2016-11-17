package com.sdong.soot.research;

import java.util.Map;

import soot.PackManager;
import soot.Scene;
import soot.SceneTransformer;
import soot.Transform;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		  PackManager.v().getPack("wjtp").add(
		      new Transform("wjtp.myTransform", new SceneTransformer() {
		        protected void internalTransform(String phaseName,
		            Map options) {
		        System.out.println("mytransform");
		        //  System.err.println(Scene.v().getApplicationClasses());
		        }
		      }));
		  soot.Main.main(args);
		}
}


