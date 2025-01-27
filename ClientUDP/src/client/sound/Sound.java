/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.sound;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/**
 *
 * @author xknoepff
 */
public class Sound {
    
    public static URL register;
    
    public Sound() {
        this.register = this.getClass().getClassLoader().getResource("C:\\Users\\xknoe\\Desktop\\Etudes\\RT\\2ieme_Annee\\SAE\\SAE3.02\\register.wav");
    }
    
    public static void soundregister() {
        play(register);
        try{
            File sound = new File("C:\\Users\\xknoe\\Desktop\\Etudes\\RT\\2ieme_Annee\\SAE\\SAE3.02\\register.wav");
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(sound));
            c.start();
        }catch (Exception e) {
            
        }
    }
    
    private static void play(URL url) {
        try {
        AudioInputStream audioIn=AudioSystem.getAudioInputStream(url);
        Clip clip=AudioSystem.getClip();
        clip.open();
        clip.addLineListener(new LineListener() {
            @Override
            public void update(LineEvent event) {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            }
        });
        audioIn.close();
        clip.start();
        }   catch (Exception e) {
            System.err.println(e);
    }
        
  }
    
}
