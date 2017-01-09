package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "full teleop", group = "test")
public class FullTeleOp extends OpMode {
    DcMotor back_left, front_left, back_right, front_right, shooter, intake;
    private float deadzone = 0.05f;    
    
    public bool direction = True;//true-beacon pusher is forward, false-intake is forward

    public void init() {
        back_left = hardwareMap.dcMotor.get("back_left");
        front_left = hardwareMap.dcMotor.get("front_left");
        back_right = hardwareMap.dcMotor.get("back_right");
        front_right = hardwareMap.dcMotor.get("front_right");
        shooter = hardwareMap.dcMotor.get("shooter");
        shooter.setDirection(DcMotor.Direction.REVERSE);
        intake = hardwareMap.dcMotor.get("intake");

    }

    public void loop() {
            if(direction){
                telemetry.addData("direction: forward")
            } else {
                telemetry.addData("direction: reverse")
            }
        if(!direction){
            back_left.setDirection(DcMotor.Direction.FORWARD);
            front_left.setDirection(DcMotor.Direction.FORWARD);
            back_right.setDirection(DcMotor.Direction.REVERSE);
            front_right.setDirection(DcMotor.Direction.REVERSE);
        } else{
            back_left.setDirection(DcMotor.Direction.REVERSE);
            front_left.setDirection(DcMotor.Direction.REVERSE);
            back_right.setDirection(DcMotor.Direction.FORWARD);
            front_right.setDirection(DcMotor.Direction.FORWARD);
        }
            
        if ((Math.abs(gamepad1.left_stick_x) < 0.7) && (Math.abs(gamepad1.right_stick_x) < 0.7)) {
            back_left.setPower((double) removeDeadzone(deadzone, gamepad1.left_stick_y));
            front_left.setPower((double) removeDeadzone(deadzone, gamepad1.left_stick_y));
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
        
        if(gamepad1.left_bumper){
            direction = !direction;//reverses robot 'changes orientation'
        }

        if (gamepad2.y) {
            intake.setPower(1);
        } else if (gamepad2.a) {
            intake.setPower(-1);
        } else if (gamepad2.x || gamepad2.b) {
            intake.setPower(0);
        }

        if (gamepad2.right_bumper) {
            shooter.setPower(1);
        } else {
            shooter.setPower(0);
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
