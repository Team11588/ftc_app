package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by kearneyg20428 on 9/21/2017.
 */

/*
PSA DXM stands for Deus Ex Machina
 */
public class HardwareDxm {
/*
I created this naming system as the letter f or b meaning front or back because
with machanum wheels all 4 wheels need to be motorized
*/

    public DcMotor fLeft = null;
    public DcMotor fRight = null;
    public DcMotor bLeft = null;
    public DcMotor bRight = null;
    public DcMotor rLift = null;
    public DcMotor lLift = null;
    public DcMotor pincer = null;

    public Servo jewelKnockDevice = null;

    HardwareMap hwMap = null;


    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        fLeft = hwMap.dcMotor.get("fLeft");
        fRight = hwMap.dcMotor.get("fRight");
        bLeft = hwMap.dcMotor.get("bLeft");
        bRight = hwMap.dcMotor.get("bRight");
        rLift = hwMap.dcMotor.get("rLift");
        lLift = hwMap.dcMotor.get("lLift");
        pincer = hwMap.dcMotor.get("pincer");

        jewelKnockDevice = hwMap.servo.get("jewelKnockDevice");
        jewelKnockDevice.setPosition(.8);

        fLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        fRight.setDirection(DcMotorSimple.Direction.FORWARD);
        bLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        bRight.setDirection(DcMotorSimple.Direction.FORWARD);
        rLift.setDirection(DcMotorSimple.Direction.REVERSE);
        lLift.setDirection(DcMotorSimple.Direction.FORWARD);
        pincer.setDirection(DcMotorSimple.Direction.REVERSE);
        //closing contraption is positive power


        fLeft.setPower(0);
        fRight.setPower(0);
        bLeft.setPower(0);
        bRight.setPower(0);
        rLift.setPower(0);
        lLift.setPower(0);
        pincer.setPower(0);


        fLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        pincer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        pincer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void driveForword(double mult , double speed) {
        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        bLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        bLeft.setTargetPosition((int) (1140 * mult));
        fLeft.setTargetPosition((int) (1140 * mult));
        bRight.setTargetPosition((int) (1140 * mult));
        fRight.setTargetPosition((int) (1140 * mult));

        move(speed,0);

        while (bLeft.isBusy()) ;

    }

    public void driveBackword(double mult , double speed) {
        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        bLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        bLeft.setTargetPosition((int)(-1140 * mult));
        fLeft.setTargetPosition((int)(-1140 * mult));
        bRight.setTargetPosition((int)(-1140 * mult));
        fRight.setTargetPosition((int)(-1140 * mult));

        move(speed, Math.PI);

        while (bLeft.isBusy()) ;

    }

    public void strafeLeft(double mult , double speed) {
        bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        bLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        bRight.setTargetPosition((int) (-1140 * mult));
        fRight.setTargetPosition((int) (1140 * mult));
        bLeft.setTargetPosition((int) (1140 * mult));
        fLeft.setTargetPosition((int) (-1140 * mult));


        fLeft.setPower(speed);
        fRight.setPower(speed);
        bLeft.setPower(speed);
        bRight.setPower(speed);

        while (bLeft.isBusy()) ;
    }

    public void strafeRight(double mult , double speed) {
        bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        bLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        bLeft.setTargetPosition((int) (-1140 * mult));
        fLeft.setTargetPosition((int) (1140 * mult));
        bRight.setTargetPosition((int) (1140 * mult));
        fRight.setTargetPosition((int) (-1140 * mult));

        fLeft.setPower(speed);
        fRight.setPower(speed);
        bLeft.setPower(speed);
        bRight.setPower(speed);

        while (bLeft.isBusy()) ;
    }

    public void move(double speed, double angle) {

        double pFL = (speed * (Math.sin((angle) + ((Math.PI) / 4))));
        double pFR = (speed * (Math.cos((angle) + ((Math.PI) / 4))));
        double pBL = (speed * (Math.cos((angle) + ((Math.PI) / 4))));
        double pBR = (speed * (Math.sin((angle) + ((Math.PI) / 4))));

        fLeft.setPower(pFL);
        fRight.setPower(pFR);
        bLeft.setPower(pBL);
        bRight.setPower(pBR);
    }
}