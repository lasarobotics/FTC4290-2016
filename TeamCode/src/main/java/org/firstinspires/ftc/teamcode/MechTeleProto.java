package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Template: Linear OpMode", group="Linear Opmode")
@Disabled

public class TemplateOpMode_Linear extends LinearOpMode {

    //left-front, left-back, right-back,... etc
    private ElapsedTime runtime = new ElapsedTime();
    DcMotor LF = null; 
    DcMotor RF = null;
    DcMotor LB = null;
    DcMotor RB = null;

    @Override
    public void runOpMode() throws InterruptedException {
        //dont screw with this
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        LF = hardwareMap.dcMotor.get("left front motor");
        RF = hardwareMap.dcMotor.get("right front motor");        
        LB = hardwareMap.dcMotor.get("left back motor");
        RB = hardwareMap.dcMotor.get("right back motor");

        LF.setDirection(DcMotor.Direction.FORWARD); // Set to opposite if using AndyMark motors
        RF.setDirection(DcMotor.Direction.FORWARD);
        LB.setDirection(DcMotor.Direction.FORWARD);
        RB.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            //dont mess
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();//

            // leftMotor.setPower(-gamepad1.left_stick_y); //this is supposed to be the y-axis of the mechanum
            // rightMotor.setPower(-gamepad1.right_stick_y);

            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }
}
