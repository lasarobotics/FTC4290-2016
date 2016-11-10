package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "mecanum", group = "test")
public class MecanumTest extends OpMode {
    DcMotor back_left, front_left, back_right, front_right;
    private float deadzone = 0.05f;

    public void init() {
        back_left = hardwareMap.dcMotor.get("back_left");
        front_left = hardwareMap.dcMotor.get("front_left");
        back_right = hardwareMap.dcMotor.get("back_right");
        front_right = hardwareMap.dcMotor.get("front_right");
    }

    public void loop() {

        if ((Math.abs(gamepad1.left_stick_x) < 0.7) && (Math.abs(gamepad1.right_stick_x) < 0.7)) { // basic y value movement
            back_left.setPower(-(double) removeDeadzone(deadzone, gamepad1.left_stick_y));
            front_left.setPower(-(double) removeDeadzone(deadzone, gamepad1.left_stick_y));
            back_right.setPower((double) removeDeadzone(deadzone, gamepad1.right_stick_y));
            front_right.setPower((double) removeDeadzone(deadzone, gamepad1.right_stick_y));
        } else if ((gamepad1.left_stick_x + gamepad1.right_stick_x)/2 < 0) { //left
            back_left.setPower((double) 0.7);
            front_left.setPower(-(double) 0.7);
            back_right.setPower((double) 0.7);
            front_right.setPower(-(double) 0.7);
        } else if ((gamepad1.left_stick_x + gamepad1.right_stick_x)/2 > 0) { // right
            back_left.setPower(-(double) 0.7);
            front_left.setPower((double) 0.7);
            back_right.setPower(-(double) 0.7);
            front_right.setPower((double) 0.7);
        }
    }

    public void stop() {
        back_left.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        front_right.setPower(0);
    }

    private float removeDeadzone(float tol, float val) {//recalibrates x,y joysticks
        return Math.abs(val) < tol ? 0 : val;
    }
}
