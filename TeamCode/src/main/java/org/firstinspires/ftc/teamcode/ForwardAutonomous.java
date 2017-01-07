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

public class ForwardAutonomous extends OpMode {
    DcMotor back_left, front_left, back_right, front_right, shooter;
    
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

        shooter = hardwareMap.dcMotor.get("shooter");
    }
/*moves forward to knock the center ball*/
    public void loop() {
        back_left.setPower(-1.0);
        front_left.setPower(-1.0);
        back_right.setPower(1.0);
        front_right.setPower(1.0);
        //if (Math.abs(front_right.getCurrentPosition()) > 10 * 1000)
        //    sleep(30000);
        while(true) {
            shooter.setPower(1.0);
            if (Math.abs(shooter.getCurrentPosition()) < 1 * 1000) {
                shooter.setPower(0);
                break;
            }
        }
        while(true) {
            shooter.setPower(-1.0);
            if (Math.abs(shooter.getCurrentPosition()) > 0) {
                shooter.setPower(0);
                break;
            }
        }
    }

    public void stop() {//sets all motor’s power to 0
        back_left.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        front_right.setPower(0);
    }

}
