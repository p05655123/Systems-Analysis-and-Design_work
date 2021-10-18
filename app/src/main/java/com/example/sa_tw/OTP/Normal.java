package com.example.sa_tw.OTP;

public class Normal extends OTP_state {//Normal-->B
    int fail_time = 0;
    @Override
    public void check_otp(OTP otp,String enter) {//OTP -->A
        if(otp.getPassword().equals(enter)){
            otp.check_success();
        }else {
            fail_time+=1;
            otp.msg("You have only "+(3-fail_time)+" chances left!");
        }
        if (fail_time >= 3){
            otp.setOtp_state(1);
        }
    }
}
