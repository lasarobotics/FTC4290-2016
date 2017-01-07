package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;
import android.os.Handler;

import static android.os.SystemClock.sleep;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "autonomous", group = "test")

public class FullAutonomous extends OpMode {
    DcMotor back_left, front_left, back_right, front_right, shooter, intake;


    final static double DIAMETER = 4;
    final static int ENCODER = 1440;
    final static double CIRCUMFERENCE = Math.PI * DIAMETER;
    
    public void init() {
        back_left = hardwareMap.dcMotor.get("back_left");
        back_left.setDirection(DcMotor.Direction.REVERSE);
        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        front_left = hardwareMap.dcMotor.get("front_left");
        front_left.setDirection(DcMotor.Direction.REVERSE);
        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        back_right = hardwareMap.dcMotor.get("back_right");
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        front_right = hardwareMap.dcMotor.get("front_right");
        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        shooter = hardwareMap.dcMotor.get("shooter");
        shooter.setDirection(DcMotor.Direction.REVERSE);
        shooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        intake = hardwareMap.dcMotor.get("intake");
        intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void start() {
        straight(65);
    }

    public void stop() {
        back_left.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        front_right.setPower(0);
        intake.setPower(0);
        shooter.setPower(0);
    }

    public void loop() {

    }

    public void straight(float distance) { // distance to move forward in inches

        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        front_right.setTargetPosition((int)((distance / CIRCUMFERENCE) * ENCODER));
        front_left.setTargetPosition((int)((distance / CIRCUMFERENCE) * ENCODER));
        back_right.setTargetPosition((int)((distance / CIRCUMFERENCE) * ENCODER));
        back_left.setTargetPosition((int)((distance / CIRCUMFERENCE) * ENCODER));

        front_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        front_right.setPower(1);
        front_left.setPower(1);
        back_right.setPower(1);
        back_left.setPower(1);

    }

    /*public void side(float distance) {

        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        front_right.setTargetPosition((int)((distance / CIRCUMFERENCE) * ENCODER));
        front_left.setTargetPosition((int)((distance / CIRCUMFERENCE) * ENCODER));
        back_right.setTargetPosition((int)((distance / CIRCUMFERENCE) * ENCODER));
        back_left.setTargetPosition((int)((distance / CIRCUMFERENCE) * ENCODER));

        front_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        front_right.setPower(1);
        front_left.setPower(1);
        back_right.setPower(1);
        back_left.setPower(1);

    }*/



}
