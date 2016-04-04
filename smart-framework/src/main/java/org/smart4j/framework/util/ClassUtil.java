/**
 * 
 */
package org.smart4j.framework.util;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * �������������
 * 
 * Author: wangkai Edit Time: 2016��4��3�� ����1:16:57
 */
public class ClassUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

	/**
	 * ��ȡ�������
	 * 
	 * @return
	 */
	public static ClassLoader getClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

	/**
	 * ������
	 * 
	 * @param className
	 * @param isInitialized
	 * @return
	 */
	public static Class<?> loadClass(String className, boolean isInitialized) {
		Class<?> cls;
		try {
			cls = Class.forName(className, isInitialized, getClassLoader());
		} catch (ClassNotFoundException e) {
			LOGGER.error("load class failure", e);
			throw new RuntimeException(e);
		}
		return cls;
	}
	
	/**
	 * �����࣬Ĭ�ϳ�ʼ����̬��
	 * @param className
	 * @return
	 */
	public static Class<?> loadClass(String className) {
		return loadClass(className,true);
	}

	/**
	 * ��ȡ�����µ����е���
	 * 
	 * @param packageName
	 * @return
	 */
	public static Set<Class<?>> getClassSet(String packageName) {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		try {
			Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".", "/"));
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				if (url != null) {
					String protocal = url.getProtocol();
					if (protocal.equals("file")) {
						String packagePath = url.getPath().replaceAll("%20", "");
						addClass(classSet, packagePath, packageName);
					} else if (protocal.equals("jar")) {
						JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
						if (jarURLConnection != null) {
							JarFile jarFile = jarURLConnection.getJarFile();
							if (jarFile != null) {
								Enumeration<JarEntry> jarEntries = jarFile.entries();
								while (jarEntries.hasMoreElements()) {
									JarEntry jarEntry = (JarEntry) jarEntries.nextElement();
									String jarEntryName = jarEntry.getName();
									if (jarEntryName.equals(".class")) {
										String className = jarEntryName.substring(0, jarEntryName.lastIndexOf("."))
												.replaceAll("/", ".");
										doAddClass(classSet, className);
									}
								}
							}
						}
					}
				}

			}
			if (classSet.size() == 0) {
				LOGGER.error("������û���κ���,packageName=" + packageName);
			}
		} catch (Exception e) {
			LOGGER.error("get class set failure",e);
			throw new RuntimeException(e);
		}
		return classSet;
	}

	/**
	 * @param classSet
	 * @param packagePath
	 * @param packageName
	 */
	private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
		File[] files = new java.io.File(packagePath).listFiles(new FileFilter() {
			public boolean accept(File file) {
				return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
			}
		});

		for (File file : files) {
			String fileName = file.getName();
			if (file.isFile()) {
				String className = fileName.substring(0, fileName.lastIndexOf("."));
				if (StringUtil.isNotEmpty(className)) {
					className = packageName + "." + className;
				}
				doAddClass(classSet, className);
			} else {
				String subPackagePath = fileName;
				if (StringUtil.isNotEmpty(packagePath)) {
					subPackagePath = packagePath + "/" + subPackagePath;
				}
				String subPackageName = fileName;
				if (StringUtil.isNotEmpty(packageName)) {
					subPackageName = packageName + "." + subPackageName;
				}
				addClass(classSet, subPackagePath, subPackageName);
			}

		}
	}

	/**
	 * @param classSet
	 * @param className
	 */
	private static void doAddClass(Set<Class<?>> classSet, String className) {
		Class<?> cls = loadClass(className, false);
		classSet.add(cls);
	}
}
