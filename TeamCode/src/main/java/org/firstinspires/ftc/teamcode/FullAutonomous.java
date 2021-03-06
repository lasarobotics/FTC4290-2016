package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

import android.os.Handler;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static android.os.SystemClock.sleep;

//@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "autonomous", group = "test")

public class FullAutonomous extends OpMode {
    DcMotor back_left, front_left, back_right, front_right, shooter, intake;

    final static double DIAMETER = 4;
    final static int ENCODER = 1440;
    final static double CIRCUMFERENCE = Math.PI * DIAMETER;

    public void init() {
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
    }

    @Override
    public void loop() {

        telemetry.addData("Back Left", back_left.getCurrentPosition());
        telemetry.addData("Front Left", front_left.getCurrentPosition());
        telemetry.addData("Back Right", back_right.getCurrentPosition());
        telemetry.addData("Front Right", front_right.getCurrentPosition());

        if ((Math.abs(front_left.getCurrentPosition()) + Math.abs(front_right.getCurrentPosition()) + Math.abs(back_left.getCurrentPosition()) + Math.abs(back_right.getCurrentPosition())) / 4 >= 3500) {
            front_right.setPower(0);
            front_left.setPower(0);
            back_right.setPower(0);
            back_left.setPower(0);
            shooter.setPower(1);
            sleep(2);
        } else {
            front_right.setPower(-1);
            front_left.setPower(-1);
            back_right.setPower(-1);
            back_left.setPower(-1);
        }

    }

}
