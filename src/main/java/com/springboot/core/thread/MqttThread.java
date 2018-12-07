package com.springboot.core.thread;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqttThread
  implements Runnable
{
  MqttClient sampleClient;
  protected Logger log = LoggerFactory.getLogger(getClass());

  public MqttThread()
  {
  }

  public MqttThread(MqttClient sampleClient) {
    this.sampleClient = sampleClient;
  }

  public void run()
  {
    System.out.println("-----run---");
    try {
      Thread.sleep(1000L);

      this.sampleClient.disconnect();
      System.out.println(this.sampleClient.isConnected());
      this.sampleClient.close();
    }
    catch (Exception e)
    {
      this.log.error("发送失败：关闭异常，" + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    MqttThread bh = new MqttThread();
    bh.run();
  }
}