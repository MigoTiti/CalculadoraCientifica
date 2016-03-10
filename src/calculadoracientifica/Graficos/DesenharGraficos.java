package calculadoracientifica.Graficos;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
 
public class DesenharGraficos extends JPanel {
    double[] pontos = {1,2,3,4,5};
    int numeroPontos = pontos.length;
 
    public DesenharGraficos(){}
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();

        g2.draw(new Line2D.Double(numeroPontos, numeroPontos, numeroPontos, h-numeroPontos));

        g2.draw(new Line2D.Double(numeroPontos, h-numeroPontos, w-numeroPontos, h-numeroPontos));

        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        LineMetrics lm = font.getLineMetrics("0", frc);
        float sh = lm.getAscent() + lm.getDescent();

        String s = "";
        float sy = numeroPontos + ((h - 2*numeroPontos) - s.length()*sh)/2 + lm.getAscent();
        for(int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            float sw = (float)font.getStringBounds(letter, frc).getWidth();
            float sx = (numeroPontos - sw)/2;
            g2.drawString(letter, sx, sy);
            sy += sh;
        }

        s = "";
        sy = h - numeroPontos + (numeroPontos - sh)/2 + lm.getAscent();
        float sw = (float)font.getStringBounds(s, frc).getWidth();
        float sx = (w - sw)/2;
        g2.drawString(s, sx, sy);

        double xInc = (double)(w - 2*numeroPontos)/(pontos.length-1);
        double scale = (double)(h - 2*numeroPontos)/getMax();
        g2.setPaint(Color.green.darker());
        for(int i = 0; i < pontos.length-1; i++) {
            double x1 = numeroPontos + i*xInc;
            double y1 = h - numeroPontos - scale*pontos[i];
            double x2 = numeroPontos + (i+1)*xInc;
            double y2 = h - numeroPontos - scale*pontos[i+1];
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
        }
        
        g2.setPaint(Color.red);
        for(int i = 0; i < pontos.length; i++) {
            double x = numeroPontos + i*xInc;
            double y = h - numeroPontos - scale*pontos[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
    }
 
    private double getMax() {
        double max = -Integer.MAX_VALUE;
        for(int i = 0; i < pontos.length; i++) {
            if(pontos[i] > max)
                max = pontos[i];
        }
        return max;
    }
}