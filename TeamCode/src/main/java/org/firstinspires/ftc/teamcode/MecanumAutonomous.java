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

@Autonomous(name = "autonomous", group = "test")

public class MecanumAutonomous extends OpMode {
    DcMotor back_left, front_left, back_right, front_right;
    
    public void init() {
        back_left = hardwareMap.dcMotor.get("back_left");
        int back_left_position = back_left.getCurrentPosition();
        telemetry.addData("Back Left Position", back_left_position);

        front_left = hardwareMap.dcMotor.get("front_left");
        int front_left_position = front_left.getCurrentPosition();
        telemetry.addData("Front Left Position", front_left_position);

        back_right = hardwareMap.dcMotor.get("back_right");
        int back_right_position = back_right.getCurrentPosition();
        telemetry.addData("Back Right Position", back_right_position);

        front_right = hardwareMap.dcMotor.get("front_right");
        int front_right_position = front_right.getCurrentPosition();
        telemetry.addData("Front Right Position", front_right_position);
    }

    public void loop() {
        back_left.setPower(-(double) 1);
        front_left.setPower(-(double) 1);
        back_right.setPower((double) 1);
        front_right.setPower((double) 1);
        if ( Math.abs(front_right.getCurrentPosition()) > 10 * 1000 )
            sleep(30000);

    }

    public void stop() {
        back_left.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        front_right.setPower(0);
    }

}
