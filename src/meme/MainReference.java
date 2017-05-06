package meme;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainReference{

    public static JLabel getTextLabel(String text){
        String style = "text-align:center; " +
                "text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;"; // border not working
        JLabel label = new JLabel("<html><body><p style=\""+ style +"\">" + text + "</p></body></html>",
                SwingConstants.CENTER);
        label.setFont(new Font(label.getFont().getName(), Font.BOLD, 40));
        label.setForeground(Color.WHITE);

        return label;
    }

    public static JLabel getMeme(String image, String northText, String southText){
        JLabel label = new JLabel(new ImageIcon(image));

        label.setLayout(new BorderLayout());
        label.add(getTextLabel(northText), BorderLayout.NORTH);
        label.add(getTextLabel(southText), BorderLayout.SOUTH);

        return label;
    }

    public static void saveImage(Container container, String outputFilename){
        BufferedImage image = new BufferedImage(container.getWidth(), container.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        container.paint(image.getGraphics());
        try{
            ImageIO.write(image, "PNG", new File(outputFilename));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void startGUI() {
        JFrame frame = new JFrame("Flex Week");

        JLabel meme = getMeme("images/Steve.jpeg", "Skips lecture all semester", 
                "\"How do I get community points?\"");
        frame.getContentPane().add(meme);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        // doesn't wrap text
        saveImage(meme, "output.png");
    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                startGUI();
            }
        });
    }
}
