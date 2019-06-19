package spring.util;


import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月19日 15:10:11.
 *
 * " "package spring.proxy;
 *
 */

public class ProxyUtil {

    public static Object newInstanceProxy(Object target) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        StringBuilder builder=new StringBuilder();
        // 1.包名
        String packageStr="package spring ;" ;
        builder.append(packageStr);
        Class<?> targetInfo = target.getClass().getInterfaces()[0];
        String simpleName = targetInfo.getSimpleName();
        //2. 导包 import spring.service.UserService;
        String importPackage="import "+ targetInfo.getName()+ ";";
        builder.append(importPackage);
        //3. 拼接 类名  public class LogProxy implements UserService {
        String className=" public class $Proxy  implements "+ simpleName + "{";
        builder.append(className);
        // private UserService userService; 4.拼接 私有属性
        String privateField=" private "+simpleName +" target ;" ;
        builder.append(privateField);
        // 5.构造方法
        /**
         * public LogProxy(UserService userService){
         this.userService=userService;
         }
         */
        String privateConstruct=" public $Proxy (" +simpleName+ " target)"+"{"
                +"this.target=target ;}" ;
        builder.append(privateConstruct);
        /** 6.重写抽象方法  方法很多，需要遍历实现
         * public String getUserName() {
         System.out.println("this is log");
         return userService.getUserName();
         }
         */
        String methdContent="";
        for (Method method : targetInfo.getDeclaredMethods()) {
            String methodName=method.getName();

            String returnType = method.getReturnType().getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            String argsContent="";
            String argsNames="";
            int len=parameterTypes.length;
            int i=1;
            for (Class<?> parameterType : parameterTypes) {
                String simpleName1 = parameterType.getSimpleName();
                if (i!=len){
                    argsContent+=simpleName1+" p"+i+",";
                    argsNames+="p"+i+" ," ;
                }else{
                    argsContent+=simpleName1+" p"+i;
                    argsNames+="p"+i ;
                }
                i++;
            }
            if ("void".equals(returnType)){
                methdContent+="public "+ returnType +" "+ methodName+"("+argsContent+") {"
                        +"System.out.println(\"this is log\") ;"
                        +"  target."+methodName+"("+argsNames+") ;} ;";
            }else{
                // 拼方法
                methdContent+="public "+ returnType +" "+ methodName+"("+argsContent+") {"
                        +"System.out.println(\"this is log\") ;"
                        +" return target."+methodName+"("+argsNames+") ;} ;";
            }


        }
        builder.append(methdContent);
        builder.append("}");
        String filepath="d:\\spring\\$Proxy.java";
        File file=new File(filepath);
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter writer=new FileWriter(filepath);
        writer.write(builder.toString());
        writer.flush();
        writer.close();
        // 开始编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,
                null, null);
        Iterable units = fileMgr.getJavaFileObjects(file);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null,
                units);
        t.call();
        fileMgr.close();
        URL [] urls=new URL[]{new URL("file:d:\\")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class<?> loadClass = ul.loadClass("spring.$Proxy");
        Constructor<?> constructor = loadClass.getConstructor(targetInfo);
        Object o = constructor.newInstance(target);


        return o;
    }
}
