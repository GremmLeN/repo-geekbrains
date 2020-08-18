package homework.lesson7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;
    private int stepWidth;
    private int stepHeight;
    private int fieldLen;
    private boolean init = false;

    Map () {
        setBackground(Color.DARK_GRAY);
    }

    void startNewGame(int mode, int fieldSizeX, int FiledSizeY, int winLength) {
        this.fieldLen = fieldSizeX;
        System.out.printf("mode: %d, size: %d, len: %d\n", mode, fieldSizeX, winLength);
        init = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintField(g);
    }

    private void paintField(Graphics g) {
        if (!init) return;
        setBackground(Color.WHITE);
        int wWidth = getWidth();
        int wHeight = getHeight();
        int x;
        int y;
        //g.drawLine(0, 0, wWidth, wHeight);
        stepWidth = wWidth / fieldLen;
        stepHeight = wHeight / fieldLen;

        for (int i = 0; i <= fieldLen; i++) {
            y = i * stepHeight;
            //g.drawLine(0, y, wWidth, y);
            g.drawLine(y, 0, y, wHeight);
        }

        for (int i = 0; i <= fieldLen; i++) {
            x = i * stepWidth;
            g.drawLine(0, x, wWidth, x);
        }
    }
}
