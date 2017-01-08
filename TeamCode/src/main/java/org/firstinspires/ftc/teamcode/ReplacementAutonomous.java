package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "replacement autonomous", group = "test")

public class ReplacementAutonomous extends LinearOpMode {
    DcMotor back_left, front_left, back_right, front_right;
    public void runOpMode() {

        back_left = hardwareMap.dcMotor.get("back_left");
        front_left = hardwareMap.dcMotor.get("front_left");
        back_right = hardwareMap.dcMotor.get("back_right");
        front_right = hardwareMap.dcMotor.get("front_right");

        waitForStart();

        back_left.setPower(-(double) 1);
        front_left.setPower(-(double) 1);
        back_right.setPower((double) 1);
        front_right.setPower((double) 1);

        sleep(2500);

        back_left.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        front_right.setPower(0);
    }


}
