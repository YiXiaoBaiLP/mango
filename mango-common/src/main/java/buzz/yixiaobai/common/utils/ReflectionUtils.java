package buzz.yixiaobai.common.utils;

import javax.el.MethodNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射相关辅助类
 * @author yixiaobai
 * @create 2022/03/21 下午7:44
 */
public class ReflectionUtils {

    /**
     * 根据方法名调用指定对象的方法
     * @param object 要调用方法的对象
     * @param method 要调用的方法名
     * @param args 参数对象数组
     * @return
     */
    public static Object invoke(Object object, String method, Object... args){
        Object result = null;
        // 通过反射获取类的对象
        Class<? extends Object> clazz = object.getClass();
        // 获取方法的信息
        Method queryMethod = getMethod(clazz, method, args);
        if(queryMethod != null){
            try {
                result = queryMethod.invoke(object, args);
                // 非法访问异常
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                // 非法参数异常
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                // 非法调用异常
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else{
            try{
                throw new NoSuchMethodException(clazz.getName() + " 类中没有找到 " + method + " 方法。");
                // 没有这样的方法
            }catch (NoSuchMethodException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 根据方法名和参数对象查找方法
     * @param clazz 类信息
     * @param name 方法名称
     * @param args 参数实例对象
     * @return 找到的方法信息
     */
    public static Method getMethod(Class<? extends Object> clazz, String name, Object[] args){
        Method queryMethod = null;
        // 获取所有方法信息
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            // 查找我们需要的方法
            if(method.getName().equals(name)){
                // 获取方法的所有参数列表
                Class<?>[] parameterTypes = method.getParameterTypes();
                // 判断参数列表是否相等
                if(parameterTypes.length == args.length){
                    // 是否是相同的方法（默认为同一方法）
                    boolean isSameMethod = true;
                    for(int i = 0; i < parameterTypes.length; i++){
                        Object arg = args[i];
                        if(arg == null){
                            arg = "";
                        }
                        // 判断参数的类是否相等
                        if(!parameterTypes[i].equals(arg.getClass())){
                            // 不是同一方法
                            isSameMethod = false;
                        }
                    }
                    if(isSameMethod){
                        queryMethod = method;
                        break;
                    }
                }
            }
        }
        return queryMethod;
    }
}
