package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "full teleop", group = "test")
public class FullTeleOp extends OpMode {
    DcMotor back_left, front_left, back_right, front_right, shooter, intake;
    private float deadzone = 0.05f;

    public void init() {
        back_left = hardwareMap.dcMotor.get("back_left");
        front_left = hardwareMap.dcMotor.get("front_left");
        back_right = hardwareMap.dcMotor.get("back_right");
        front_right = hardwareMap.dcMotor.get("front_right");
        shooter = hardwareMap.dcMotor.get("shooter");
        shooter.setDirection(DcMotor.Direction.REVERSE);
        shooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intake = hardwareMap.dcMotor.get("intake");

    }

    public void loop() {
        if ((Math.abs(gamepad1.left_stick_x) < 0.7) && (Math.abs(gamepad1.right_stick_x) < 0.7)) {
            back_left.setPower(-(double) removeDeadzone(deadzone, gamepad1.left_stick_y));
            front_left.setPower(-(double) removeDeadzone(deadzone, gamepad1.left_stick_y));
            back_right.setPower((double) removeDeadzone(deadzone, gamepad1.right_stick_y));
            front_right.setPower((double) removeDeadzone(deadzone, gamepad1.right_stick_y));
        } else if ((gamepad1.left_stick_x + gamepad1.right_stick_x)/2 < 0) { // left mecanum
            back_left.setPower(0.7);
            front_left.setPower(-0.7);
            back_right.setPower(0.7);
            front_right.setPower(-0.7);
        } else if ((gamepad1.left_stick_x + gamepad1.right_stick_x)/2 > 0) { // right mecanum
            back_left.setPower(-0.7);
            front_left.setPower(0.7);
            back_right.setPower(-0.7);
            front_right.setPower(0.7);
        }

        if (gamepad2.y) {
            intake.setPower(1);
        } else if (gamepad2.a) {
            intake.setPower(-1);
        } else if (gamepad2.x || gamepad2.b) {
            intake.setPower(0);
        }

        if (gamepad2.right_bumper) {
            shooter.setTargetPosition(1200);
            shooter.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            shooter.setPower(1);
        } else if (gamepad2.left_bumper) {
            shooter.setTargetPosition(0);
            shooter.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            shooter.setPower(1);
        }
        
    }

    public void stop() {
        back_left.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        front_right.setPower(0);
        intake.setPower(0);
        shooter.setPower(0);
    }

    private float removeDeadzone(float tol, float val) {//recalibrates x,y joysticks
        return Math.abs(val) < tol ? 0 : val;
    }
}
