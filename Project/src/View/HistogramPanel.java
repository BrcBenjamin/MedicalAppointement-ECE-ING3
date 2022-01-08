/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author jules
 */
import DAO.My_CNX;
import Model.UserList;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;

public class HistogramPanel extends JPanel
{
    private int histogramHeight = 200;
    private int barWidth = 50;
    private int barGap = 10;

    private JPanel barPanel;
    private JPanel labelPanel;

    private JButton retour=new JButton("Previous");
    
    private List<Bar> bars = new ArrayList<Bar>();
    private UserList UL;
    public HistogramPanel(UserList U)
    {
        UL=U;
        setBorder( new EmptyBorder(10, 10, 10, 10) );
        setLayout( new BorderLayout() );

        barPanel = new JPanel( new GridLayout(1, 0, barGap, 0) );
        Border outer = new MatteBorder(1, 1, 1, 1, Color.BLACK);
        Border inner = new EmptyBorder(10, 10, 0, 10);
        Border compound = new CompoundBorder(outer, inner);
        barPanel.setBorder( compound );

        labelPanel = new JPanel( new GridLayout(1, 0, barGap, 0) );
        labelPanel.setBorder( new EmptyBorder(5, 10, 0, 10) );
        
        add(barPanel, BorderLayout.CENTER);
        add(labelPanel, BorderLayout.PAGE_END);
    }                                       

    public void addHistogramColumn(String label, int value, Color color)
    {
        Bar bar = new Bar(label, value, color);
        bars.add( bar );
    }

    public void layoutHistogram()
    {
        barPanel.removeAll();
        labelPanel.removeAll();

        int maxValue = 0;

        for (Bar bar: bars)
            maxValue = Math.max(maxValue, bar.getValue());

        for (Bar bar: bars)
        {
            JLabel label = new JLabel(bar.getValue() + "");
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.TOP);
            label.setVerticalAlignment(JLabel.BOTTOM);
            int barHeight = (bar.getValue() * histogramHeight) / maxValue;
            Icon icon = new ColorIcon(bar.getColor(), barWidth, barHeight);
            label.setIcon( icon );
            barPanel.add( label );

            JLabel barLabel = new JLabel( bar.getLabel() );
            barLabel.setHorizontalAlignment(JLabel.CENTER);
            labelPanel.add( barLabel );
        }
    }

    private class Bar
    {
        private String label;
        private int value;
        private Color color;

        public Bar(String label, int value, Color color)
        {
            this.label = label;
            this.value = value;
            this.color = color;
        }

        public String getLabel()
        {
            return label;
        }

        public int getValue()
        {
            return value;
        }

        public Color getColor()
        {
            return color;
        }
    }

    private class ColorIcon implements Icon
    {
        private int shadow = 3;

        private Color color;
        private int width;
        private int height;

        public ColorIcon(Color color, int width, int height)
        {
            this.color = color;
            this.width = width;
            this.height = height;
        }

        public int getIconWidth()
        {
            return width;
        }

        public int getIconHeight()
        {
            return height;
        }

        public void paintIcon(Component c, Graphics g, int x, int y)
        {
            g.setColor(color);
            g.fillRect(x, y, width - shadow, height);
            g.setColor(Color.GRAY);
            g.fillRect(x + width - shadow, y + shadow, shadow, height - shadow);
        }
    }

    public void createAndShowGUI()
    {
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;
        int f=0;
        
        for(int i=0;i<UL.getAppList().size();i++){
            if(UL.getAppList().get(i).getDisponible()==1){
                if(UL.getAppList().get(i).getIdMed()==0){
                    a+=1;
                }
                if(UL.getAppList().get(i).getIdMed()==1){
                    b+=1;
                }
                if(UL.getAppList().get(i).getIdMed()==2){
                    c+=1;
                }
                if(UL.getAppList().get(i).getIdMed()==3){
                    d+=1;
                }
                if(UL.getAppList().get(i).getIdMed()==4){
                    e+=1;
                }
                if(UL.getAppList().get(i).getIdMed()==5){
                    f+=1;
                }
            }
        }
        this.addHistogramColumn("Paul POGBA",a, Color.RED);
        this.addHistogramColumn("Robert FIRMINHO",b, Color.YELLOW);
        this.addHistogramColumn("Alyson BECKER",c, Color.BLUE);
        this.addHistogramColumn("Nkolo KANTE", d, Color.ORANGE);
        this.addHistogramColumn("Divock ORIGI", e, Color.MAGENTA);
        this.addHistogramColumn("Olivier GIROUD",f, Color.CYAN);
        this.layoutHistogram();

        JFrame frame = new JFrame("Statistique Appoitement");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        a=0;
        b=0;
        c=0;
        d=0;
        e=0;
        f=0;
        
        for(int i=0;i<UL.getAppList().size();i++){
            if(UL.getAppList().get(i).getDisponible()==0){
                if(UL.getAppList().get(i).getIdMed()==0){
                    a+=1;
                }
                if(UL.getAppList().get(i).getIdMed()==1){
                    b+=1;
                }
                if(UL.getAppList().get(i).getIdMed()==2){
                    c+=1;
                }
                if(UL.getAppList().get(i).getIdMed()==3){
                    d+=1;
                }
                if(UL.getAppList().get(i).getIdMed()==4){
                    e+=1;
                }
                if(UL.getAppList().get(i).getIdMed()==5){
                    f+=1;
                }
            }
        }
        this.addHistogramColumn("Paul POGBA",a, Color.RED);
        this.addHistogramColumn("Robert FIRMINHO",b, Color.YELLOW);
        this.addHistogramColumn("Alyson BECKER",c, Color.BLUE);
        this.addHistogramColumn("Nkolo KANTE", d, Color.ORANGE);
        this.addHistogramColumn("Divock ORIGI", e, Color.MAGENTA);
        this.addHistogramColumn("Olivier GIROUD",f, Color.CYAN);
        this.layoutHistogram();
        frame.add(this);
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

}
