package com.design.utils.serviceloader;

import java.util.Iterator;
import java.util.ServiceLoader;


/**
* ServiceLoader是JDK自带的一个类加载器，位于java.util包当中，作为 A simple service-provider loading facility. 具体使用方式如下：
 * 1.在META-INF/services/目录下用你的接口全路径名称命名一个文件（不加后缀），然后在该文件中一行一个添加你的接口实现类的全路径名。
 * 2.通过load方法来加载出所有的接口实现类
 *
 * 1 ServiceLoader<MyInterface> loader = ServiceLoader.load(MyInterface.class);
 *
 * 在这里load方法的返回值是一个迭代器，用这个迭代器可以遍历出所有的接口实现类。
* */
public class GeneralServiceLoader {
    private Class<?> inter;
    public GeneralServiceLoader(Class<?> inter) {
        if (inter == null) {
            throw new IllegalArgumentException("参数不能为空...");
        }
        this.inter = inter;
    }

    public Iterator<?> loadAll() {
        ServiceLoader<?> loader = ServiceLoader.load(inter);
        return loader.iterator();
    }
}
