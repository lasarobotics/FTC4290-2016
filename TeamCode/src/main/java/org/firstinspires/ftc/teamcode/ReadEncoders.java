package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "read encoder values", group = "test")

public class ReadEncoders extends OpMode {
    DcMotor back_left, front_left, back_right, front_right, shooter, intake;
    private float deadzone = 0.05f;
    
    public void init() {
        back_left = hardwareMap.dcMotor.get("back_left");
        back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        front_left = hardwareMap.dcMotor.get("front_left");
        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        back_right = hardwareMap.dcMotor.get("back_right");
        back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        front_right = hardwareMap.dcMotor.get("front_right");
        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        shooter = hardwareMap.dcMotor.get("shooter");
        shooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        shooter.setDirection(DcMotor.Direction.REVERSE);
        shooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        intake = hardwareMap.dcMotor.get("intake");
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void loop() {
        telemetry.addData("Back Left", back_left.getCurrentPosition());
        telemetry.addData("Front Left", front_left.getCurrentPosition());
        telemetry.addData("Back Right", back_right.getCurrentPosition());
        telemetry.addData("Front Right", front_right.getCurrentPosition());
        telemetry.addData("Shooter", shooter.getCurrentPosition());
        telemetry.addData("Intake", intake.getCurrentPosition());

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
