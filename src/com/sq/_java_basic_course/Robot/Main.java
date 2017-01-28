package com.sq._java_basic_course.Robot; // Created by SquorpikkoR on 28.01.2017.

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        Robot.moveRobot(robot, 3, 6);
        Robot.moveRobot(robot, 6, 6);
        Robot.moveRobot(robot, 0, 0);
        Robot.moveRobot(robot, -3, -5);
        Robot.moveRobot(robot, -0, -0);
    }
}
