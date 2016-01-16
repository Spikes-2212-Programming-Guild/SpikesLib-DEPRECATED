package com.spikes2212.drive;

public interface ArcadeDrive {

    void arcade(double forwardSpeed, double turnSpeed);

    public static ArcadeDrive toArcade(TankDrive tankDrive) {//TODO: find a better way to do this
        return (forwardSpeed, turnSpeed) -> {
            double leftSpeed;
            double rightSpeed;
            forwardSpeed = limit(forwardSpeed);
            turnSpeed = limit(turnSpeed);
            if (forwardSpeed > 0.0) {
                if (turnSpeed > 0.0) {
                    leftSpeed = forwardSpeed - turnSpeed;
                    rightSpeed = Math.max(forwardSpeed, turnSpeed);
                } else {
                    leftSpeed = Math.max(forwardSpeed, -turnSpeed);
                    rightSpeed = forwardSpeed + turnSpeed;
                }
            } else if (turnSpeed > 0.0) {
                leftSpeed = -Math.max(-forwardSpeed, turnSpeed);
                rightSpeed = forwardSpeed + turnSpeed;
            } else {
                leftSpeed = forwardSpeed - turnSpeed;
                rightSpeed = -Math.max(-forwardSpeed, -turnSpeed);
            }
            tankDrive.tankSet(leftSpeed, rightSpeed);
        };

    }

    public static double limit(double num) { //TODO: find a place for limit
        if (num > 1.0) {
            return 1.0;
        }
        if (num < -1.0) {
            return -1.0;
        }
        return num;
    }
}
