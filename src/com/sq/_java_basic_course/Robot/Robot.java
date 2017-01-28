package com.sq._java_basic_course.Robot; // Created by SquorpikkoR on 28.01.2017.

/////////////////НА STEPIK'Е ПРОШЛА С ПЕРВОГО РАЗА!!!! ПО-ПОЗЖЕ НАДО БУДЕТ ПОСИДЕТЬ ПОДУМАТЬ, КАК СДЕЛАТЬ ПО-КРАСИВЕЕ.

//region Task
/*
На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
Ось X смотрит слева направо, ось Y — снизу вверх. (Помните, как рисовали графики функций в школе?)
В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит:
вверх, вниз, направо или налево. Ваша задача — привести робота в заданную точку игрового поля.
Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):

public class Robot {

    public Direction getDirection() {
        // текущее направление взгляда
    }

    public int getX() {
        // текущая координата X
    }

    public int getY() {
        // текущая координата Y
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}

Direction, направление взгляда робота,  — это перечисление:

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

Пример
В метод передано: toX == 3, toY == 0; начальное состояние робота такое:
robot.getX() == 0, robot.getY() == 0, robot.getDirection() == Direction.UP
Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:

        robot.turnRight();
        robot.stepForward();
        robot.stepForward();
        robot.stepForward();

P.S. Если вам понравилось это задание, то вам может прийтись по душе игра Robocode, в которой надо написать алгоритм управления танком. Алгоритмы, написанные разными людьми, соревнуются между собой.

    ////public static void moveRobot(Robot robot, int toX, int toY) {
    ////robot.stepForward(); // your implementation here
}
*/
//endregion

public class Robot {

    public static void moveRobot(Robot robot, int toX, int toY) {
        /////////Реализация №1. Тупая.
        int xStep = Math.abs(toX - robot.getX());
        int yStep = Math.abs(toY - robot.getY());
        if (toX > robot.getX()) {
            lookToThe(Direction.RIGHT,robot);
        }
        if (toX < robot.getX()) {
            lookToThe(Direction.LEFT,robot);
        }
        for (int i = 0; i < xStep; i++) {
            robot.stepForward();
        }
        if (toY > robot.getY()) {
            lookToThe(Direction.UP,robot);
        }
        if (toY < robot.getY()) {
            lookToThe(Direction.DOWN,robot);
        }
        for (int i = 0; i < yStep; i++) {
            robot.stepForward();
        }
         // your implementation here
        System.out.println("X: "+robot.getX() +", Y: "+robot.getY());//Для проверки
    }

    public static void lookToThe(Direction direction, Robot robot) {
        switch (direction) {
            case UP:
                switch (robot.getDirection()) {
                    case UP:robot.turnLeft();robot.turnRight();break;///////////
                    case DOWN:robot.turnLeft();robot.turnLeft();break;
                    case LEFT:robot.turnRight();break;
                    case RIGHT:robot.turnLeft();break;
                };break;
            case DOWN:
                switch (robot.getDirection()) {
                    case UP:robot.turnLeft();robot.turnLeft();break;
                    case DOWN:robot.turnLeft();robot.turnRight();break;//////////
                    case LEFT:robot.turnLeft();break;
                    case RIGHT:robot.turnRight();break;
                };break;
            case LEFT:
                switch (robot.getDirection()) {
                    case UP:robot.turnLeft();break;
                    case DOWN:robot.turnRight();break;
                    case LEFT:robot.turnLeft();robot.turnRight();break;//////////
                    case RIGHT:robot.turnLeft();robot.turnLeft();break;
                };break;
            case RIGHT:
                switch (robot.getDirection()) {
                    case UP:robot.turnRight();break;
                    case DOWN:robot.turnLeft();break;
                    case LEFT:robot.turnLeft();robot.turnLeft();break;
                    case RIGHT:robot.turnLeft();robot.turnRight();break;/////////
                };break;
        }
    }

    /*private static void goTo(Direction direction, int stepCount) {
        switch (direction) {
            case UP:switch ()
        }
    }*/

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public Direction curentDirection = Direction.UP;

    public void setCurentDirection(Direction curentDirection) {
        this.curentDirection = curentDirection;
    }

    private int X;

    private int Y;

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public Direction getDirection() {
        return curentDirection;// текущее направление взгляда
    }

    public int getX() {
        return X;// текущая координата X
    }

    public int getY() {
        return Y;// текущая координата Y
    }

    public void turnLeft() {
        switch (getDirection()) {
            case DOWN:
                setCurentDirection(Direction.RIGHT);break;
            case LEFT:
                setCurentDirection(Direction.DOWN);break;
            case RIGHT:
                setCurentDirection(Direction.UP);break;
            case UP:
                setCurentDirection(Direction.LEFT);break;
        }
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        switch (getDirection()) {
            case DOWN:
                setCurentDirection(Direction.LEFT);break;
            case LEFT:
                setCurentDirection(Direction.UP);break;
            case RIGHT:
                setCurentDirection(Direction.DOWN);break;
            case UP:
                setCurentDirection(Direction.RIGHT);break;
        }
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        switch (getDirection()) {
            case RIGHT:
                setX(getX() + 1);break;
            case UP:
                setY(getY() + 1);break;
            case LEFT:
                setX(getX() - 1);break;
            case DOWN:
                setY(getY() - 1);break;
        }
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}
