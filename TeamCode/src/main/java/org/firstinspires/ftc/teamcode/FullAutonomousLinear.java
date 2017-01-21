package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import static android.os.SystemClock.sleep;

@Autonomous(name = "full autonomous linear", group = "test")

public class FullAutonomousLinear extends LinearOpMode {
    DcMotor back_left, front_left, back_right, front_right, shooter, intake;
    ColorSensor sensor;

    public void runOpMode() {
        back_left = hardwareMap.dcMotor.get("back_left");
        back_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_left.setDirection(DcMotor.Direction.REVERSE);

        front_left = hardwareMap.dcMotor.get("front_left");
        front_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_left.setDirection(DcMotor.Direction.REVERSE);

        back_right = hardwareMap.dcMotor.get("back_right");
        back_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        front_right = hardwareMap.dcMotor.get("front_right");
        front_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        shooter = hardwareMap.dcMotor.get("shooter");
        shooter.setDirection(DcMotor.Direction.REVERSE);

        intake = hardwareMap.dcMotor.get("intake");
        intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        sensor = hardwareMap.colorSensor.get("sensor");
        sensor.enableLed(false);

        waitForStart();

        do {
            front_right.setPower(-1);
            front_left.setPower(-1);
            back_right.setPower(-1);
            back_left.setPower(-1);
        } while (opModeIsActive() && ((Math.abs(front_left.getCurrentPosition()) + Math.abs(front_right.getCurrentPosition()) + Math.abs(back_left.getCurrentPosition()) + Math.abs(back_right.getCurrentPosition())) / 4 < 3700));

        front_right.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        back_left.setPower(0);

        shooter.setPower(1);
        sleep(7000);
        shooter.setPower(0);

        do {
            front_right.setPower(-1);
            front_left.setPower(-1);
            back_right.setPower(-1);
            back_left.setPower(-1);
        } while (opModeIsActive() && ((Math.abs(front_left.getCurrentPosition()) + Math.abs(front_right.getCurrentPosition()) + Math.abs(back_left.getCurrentPosition()) + Math.abs(back_right.getCurrentPosition())) / 4 < 3700 + (1700)));

        back_left.setPower(-0.7);
        front_left.setPower(0.7);
        back_right.setPower(-0.7);
        front_right.setPower(0.7);
        sleep(500);

        front_right.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        back_left.setPower(0);

    }

}
