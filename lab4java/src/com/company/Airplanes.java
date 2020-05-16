package com.company;


import javafx.scene.text.Text;

import java.util.Vector;

public class Airplanes {
   final Thread thread;
   int time;

   Airplanes(FlyControlCenter center, Vector<Text> state) {
      time = (int) (1 + Math.random() * 5);
      thread = new Thread(()->run(center, state));
      thread.start();
   }

   public void run(FlyControlCenter center, Vector<Text> state) {
      {
          int i = 0;
          for (; i < state.size(); i++) {
              if(state.elementAt(i).getText().contains("Свободна")) {
                state.elementAt(i).setText("Полоса " + (i + 1) + ": Занята");
                break;
              }
          }
                   try {
                       synchronized (thread) {
                           thread.wait(time * 1000);
                       }
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
            state.elementAt(i).setText("Полоса " + (i + 1) + ": Свободна");
            time = 0;
            center.removePlane();
      }
   }

   public void  closeThread()
   {
       synchronized (thread)
       {
           thread.notify();
       }
   }
}
