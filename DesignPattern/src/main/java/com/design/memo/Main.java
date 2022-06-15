package com.design.memo;

import java.util.Scanner;

/*
 * 备忘录模式
* 在不违背封装原则的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便之后恢复对象为先前的状态。
* 这个模式的定义主要表达了两部分内容。一部分是，存储副本以便后期恢复。
* 另一部分是，要在不违背封装原则的前提下，进行对象的备份和恢复。
* 广义的看vuex就是一个备忘录模式。
* 
* 以下代码是如下功能的实现，解释了什么是备忘录模式
>hello
>:list
hello
>world
>:list
helloworld
>:undo
>:list
hello
*/
public class Main {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotsHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
          String input = scanner.next();
          if (input.equals(":list")) {
            System.out.println(inputText.toString());
          } else if (input.equals(":undo")) {
            Snapshot snapshot = snapshotsHolder.popSnapshot();
            inputText.restoreSnapshot(snapshot);
          } else {
            snapshotsHolder.pushSnapshot(inputText.createSnapshot());
            inputText.append(input);
          }
        }
        scanner.close();
    }
}
