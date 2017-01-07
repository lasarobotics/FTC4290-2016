package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "read encoder values", group = "test")

public class ReadEncoders extends OpMode {
    DcMotor back_left, front_left, back_right, front_right, shooter, intake;
    
    public void init() {
        back_left = hardwareMap.dcMotor.get("back_left");
        back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        front_left = hardwareMap.dcMotor.get("front_left");
        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        back_right = hardwareMap.dcMotor.get("back_right");
        back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        front_right = hardwareMap.dcMotor.get("front_right");
        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        shooter = hardwareMap.dcMotor.get("shooter");
        shooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        shooter.setDirection(DcMotor.Direction.REVERSE);
        intake = hardwareMap.dcMotor.get("intake");
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void loop() {
        back_left.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        front_right.setPower(0);
        intake.setPower(0);
        shooter.setPower(0);
        telemetry.addData("Back Left", back_left.getCurrentPosition());
        telemetry.addData("Front Left", front_left.getCurrentPosition());
        telemetry.addData("Back Right", back_right.getCurrentPosition());
        telemetry.addData("Front Right", front_right.getCurrentPosition());
        telemetry.addData("Shooter", shooter.getCurrentPosition());
        telemetry.addData("Intake", intake.getCurrentPosition());
    }

    public void stop() {
        back_left.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        front_right.setPower(0);
        intake.setPower(0);
        shooter.setPower(0);
    }

}
