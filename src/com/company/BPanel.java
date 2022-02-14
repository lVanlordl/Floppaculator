package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g) {
        Image b = null;

        try {
            b = ImageIO.read(new File("src/com/company/res/Floppa with cool glasses.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(b, 0, 0, null);
        }
    }