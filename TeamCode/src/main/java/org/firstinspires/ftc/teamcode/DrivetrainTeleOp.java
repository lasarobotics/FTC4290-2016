package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import static android.os.SystemClock.sleep;

@TeleOp(name = "drivetrain only", group = "test")
public class DrivetrainTeleOp extends OpMode {
    DcMotor back_left, front_left, back_right, front_right, shooter, intake;
    private float deadzone = 0.05f;
    /*hardware config-do not edit*/
    public void init() {
        back_left = hardwareMap.dcMotor.get("back_left");
        front_left = hardwareMap.dcMotor.get("front_left");
        back_right = hardwareMap.dcMotor.get("back_right");
        front_right = hardwareMap.dcMotor.get("front_right");
        shooter = hardwareMap.dcMotor.get("shooter");
        intake = hardwareMap.dcMotor.get("intake");
    }
    /*direct mechanum - drives like tank, joysticks are 1:1*/
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

    }
    /*sets all motor’s power to 0*/
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
