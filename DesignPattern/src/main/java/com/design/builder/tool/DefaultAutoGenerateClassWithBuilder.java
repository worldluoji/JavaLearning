package com.design.builder.tool;

import com.design.utils.output.ConsoleOutputUtil;
import com.design.utils.output.OutputUtil;

import java.lang.reflect.Field;


/**
* Name.class.getCanonicalName(): testName.Name
* Name.class.getName():          testName.Name
* Name.class.getSimpleName():    Name
*  对于大部分class而言，getCanonicalName和getName这两个方法没有什么不同的， 但是对于array或内部类等就显示出来了。
*  getName()方法，以String的形式，返回Class对象的‘实体’名称；
*  getSimpleName()方法，是获取源代码中给出的‘底层类’简称；
* */
public class DefaultAutoGenerateClassWithBuilder implements AutoGenerateClassWithBuilder {

    private String templateBuildMethod = "    public {T} build() {\n" +
            "        // Add what you want to check\n" +
            "        return new {T}(this);\n" +
            "    }\n";

    private String template = "public static class Builder {\n" +
                                "{ATTRS}\n" +
                                "{BUILD}" + "\n" +
                                "{METHODS}\n" +
                             "}";

    private String templateAttribute = "    private {T} {V};\n";
    private String templateAttributeMethod = "    public Builder {V}({T} {V}) {\n" +
            "        // check the input param\n" +
            "        this.{V} = {V};\n" +
            "        return this;\n" +
            "    }\n";

    private OutputUtil outputUtil;

    public DefaultAutoGenerateClassWithBuilder() {
        this.outputUtil = new ConsoleOutputUtil();
    }

    public DefaultAutoGenerateClassWithBuilder(OutputUtil outputUtil) {
        if (outputUtil != null) {
            this.outputUtil = outputUtil;
        } else {
            this.outputUtil = new ConsoleOutputUtil();
        }
    }

    @Override
    public void generate(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("class none pointer...");
        }

        String className = clazz.getSimpleName();
        String fieldsDeclare = this.getAllFieldsDeclareString(clazz.getDeclaredFields());
        String fieldMethods = this.getFiledMethodString(clazz.getDeclaredFields());
        String buildMethods = getBuildMethodString(className);

        String result = template.replaceAll("\\{ATTRS}", fieldsDeclare)
                .replaceAll("\\{BUILD}", buildMethods)
                .replaceAll("\\{METHODS}", fieldMethods);

        outputUtil.output(result, className);
    }

    protected String getAllFieldsDeclareString(Field[] fields) {
        if (fields == null || fields.length <= 0) {
            throw new IllegalArgumentException("class no attribute...");
        }
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            String attrName = field.getName();
            String attrType = field.getType().getSimpleName();
            String oneAttr = templateAttribute.replace("{T}", attrType)
                    .replace("{V}", attrName);
            sb.append(oneAttr);
        }
        return sb.toString();
    }

    protected String getFiledMethodString(Field[] fields) {
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldType = field.getType().getSimpleName();
            String fieldMethod = templateAttributeMethod.replaceAll("\\{T}", fieldType)
                    .replaceAll("\\{V}", fieldName);
            sb.append(fieldMethod);
        }
        return sb.toString();
    }

    protected String getBuildMethodString(String className) {
        return this.templateBuildMethod.replaceAll("\\{T}", className);
    }
}
