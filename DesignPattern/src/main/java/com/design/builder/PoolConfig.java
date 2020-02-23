package com.design.builder;

/**
* Builder模式使用场景：
 * 参数过多，并且你想创建后，对象就不可变, 这时候就使用Builder模式，并且不提供setter方法即可
 *
 * 顾客走进一家餐馆点餐，我们利用工厂模式，根据用户不同的选择，来制作不同的食物，比如披萨、汉堡、沙拉。
 * 对于披萨来说，用户又有各种配料可以定制，比如奶酪、西红柿、起司，我们通过建造者模式根据用户选择的不同配料来制作披萨。
* */
public class PoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    public String getName() {
        return name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public PoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxIdle = builder.maxIdle;
        this.maxTotal = builder.maxTotal;
        this.minIdle = builder.minIdle;
    }

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;
        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public Builder name(String name) {
            if (name == null || "".equals(name)) {
                throw new IllegalArgumentException("资源池名称不能为空");
            }
            this.name = name;
            return this;
        }

        public Builder maxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("最大连接数必须大于0");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder maxIdle(int maxIdle) {
            if (maxIdle <= 0) {
                throw new IllegalArgumentException("最大空闲连接数必须大于0");
            }
            this.maxIdle = maxIdle;
            return this;
        }
        public Builder minIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("最小空闲连接数不能小于0");
            }
            this.minIdle = minIdle;
            return this;
        }

        public PoolConfig build() {
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }
            return new PoolConfig(this);
        }
    }

    @Override
    public String toString() {
        return "PoolConfig{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                '}';
    }
}
