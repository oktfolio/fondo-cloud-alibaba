package com.oktobro.fondo.calibur.client.messagequeue;

import java.io.IOException;

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2019/12/17
 */
public class MediaProcess {

    public void receiveMediaProcessTask(String msg) throws Exception {
        System.out.println("转码中");

        Thread.sleep(1000);

        System.out.println("转码成功");


    }
}
