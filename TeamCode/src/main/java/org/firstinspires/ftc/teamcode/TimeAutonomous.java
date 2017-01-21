package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import static android.os.SystemClock.sleep;

@Autonomous(name = "(innacurate) time autonomous", group = "test")

public class TimeAutonomous extends LinearOpMode {
    DcMotor back_left, front_left, back_right, front_right, shooter, intake;

    final static double DIAMETER = 4;
    final static int ENCODER = 1440;
    final static double CIRCUMFERENCE = Math.PI * DIAMETER;

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

        waitForStart();
        front_right.setPower(-1);
        front_left.setPower(-1);
        back_right.setPower(-1);
        back_left.setPower(-1);
        sleep(1500);
        front_right.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        back_left.setPower(0);

        for (int i = 0; i < 3; i++) {
            shooter.setPower(1);
            sleep(3000);
            shooter.setPower(0);
            sleep(1000);
        }

        front_right.setPower(-1);
        front_left.setPower(-1);
        back_right.setPower(-1);
        back_left.setPower(-1);
        sleep(1500);
        front_right.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        back_left.setPower(0);


    }
}
