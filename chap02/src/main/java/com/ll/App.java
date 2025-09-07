package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("할 일 관리 앱, 시작");

        try( Scanner scanner = new Scanner(System.in) ) {
            List<Todo> todos = new ArrayList<>();
            long todosLastId = 0;

            while( true ) {
                System.out.print("명령) ");
                String cmd = scanner.nextLine().trim();

                if (cmd.equals("exit")) break;
                else if (cmd.equals("add")) {
                    long id = todosLastId + 1;
                    System.out.print("할 일 : ");
                    String content = scanner.nextLine().trim();

                    Todo todo = new Todo(id, content);
                    todos.add(todo);
                    todosLastId++;

                    System.out.println(todo.getId());

                    System.out.printf("%d번 할 일이 생성되었습니다.\n", id);
                } else if (cmd.equals("list")) {
                    System.out.println("번호 / 내용");

                    todos.forEach(todo -> System.out.printf("%d / %s\n", todo.getId(), todo.getContent()));
                }
                System.out.printf("입력한 명령 : %s\n", cmd);
            }
        }

        System.out.println("할 일 관리 앱, 끝");
    }
}
