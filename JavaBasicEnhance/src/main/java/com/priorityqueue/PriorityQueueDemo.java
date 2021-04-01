package com.priorityqueue;

import java.util.*;

import com.google.common.collect.Lists;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        TestPriorityQueue4();
    }

    public static void TestPriorityQueue1() {
        // 默认容量为11， 且是最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(2);
        queue.remove(2); // remove时遇到一个满足的删除后就返回
        for (int num : queue) {
            System.out.println(num);
        }

    }

    public static void TestPriorityQueue2() {
        // 变为最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(10, (i1,i2) -> {
            return i2-i1;
        });
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        for (int num : queue) {
            System.out.println(num);
        }
    }

    public static void TestPriorityQueue3() {
        // 变为最大堆
        PriorityQueue<Node> queue = new PriorityQueue<>(10, (node1,node2) -> {
            return node2.value - node1.value;
        });
        Node tempNode = new Node(2, 1);
        queue.add(new Node(0, 2));
        queue.add(new Node(1, 3));
        queue.add(tempNode);
        printQueue(queue);
        queue.remove(tempNode);
        System.out.println("**********************");
        printQueue(queue);
    }


    public static void TestPriorityQueue4() {
        List<String> words = Lists.newArrayList("i","i","a","nbn","a","b");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
        }
        PriorityQueue<Node2> queue = new PriorityQueue<>(words.size(), (e1,e2)->{
            if (e1.count != e2.count) {
                return e2.count - e1.count;
            }
            return e1.value.compareTo(e2.value);
        });
        
        for (Map.Entry<String, Integer> e : map.entrySet())  {
            e.getKey();
            Node2 node = new Node2(e.getValue(), e.getKey());
            queue.offer(node);
        }

        int k = 2;
        
        for (int i = 0; i < k; i++) {
            Node2 node2 = queue.poll();
            System.out.println(node2.value + ":" + node2.count);
        }
    }

    public static void printQueue(PriorityQueue<Node> queue) {
        for (Node node : queue) {
            System.out.println(node.index + ":" + node.value);
        }
    }


}

class Node {
    public int index;
    public int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

class Node2 {
    public int count;
    public String value;
    public Node2(int count, String value) {
        this.count = count;
        this.value = value;
    }
}