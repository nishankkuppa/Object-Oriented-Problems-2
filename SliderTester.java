package problem2;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Exercise 5.4. Implement a program that contains a slider and a car icon. 
 * The size of the car should increase or decrease as the slider is moved.
 * @author Nishank Kuppa
 *
 */
public class SliderTester extends JPanel 
{
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 800;
    public static final int MAXIMUM_SIZE_OF_ICON = 500;
    
    private int defaultIconWidth = MAXIMUM_SIZE_OF_ICON / 2;
    
    private CarIcon carIcon = new CarIcon(defaultIconWidth);
    private JLabel carLabel = new JLabel(carIcon);
    private JSlider sliderForResizing = new JSlider(0, MAXIMUM_SIZE_OF_ICON, defaultIconWidth);
    
    /**
     * Initialize and place slider and icon 
     */
    public SliderTester() 
    {
        sliderForResizing.setMajorTickSpacing(50);
        sliderForResizing.setMinorTickSpacing(10);
        sliderForResizing.setPaintLabels(true);
        sliderForResizing.setPaintTicks(true);
        sliderForResizing.setSnapToTicks(true);        
        sliderForResizing.addChangeListener(new SliderListener());

        setLayout(new BorderLayout());
        add(sliderForResizing, BorderLayout.SOUTH);
        add(carLabel, BorderLayout.CENTER);
    }
    
    /**
     * Look for changes in the position of the slider
     * @author Nishank Kuppa
     *
     */
    public class SliderListener implements ChangeListener
    {
        @Override
        public void stateChanged(ChangeEvent e) 
        {
            int value = sliderForResizing.getValue();
            carIcon.setWidth(value);
            carLabel.repaint();
        }
    }
    
    /**
     * Return the value inputed into the slider
     */
    @Override
    public Dimension getPreferredSize() 
    {
        if (isPreferredSizeSet()) 
        {
            return getPreferredSize();
        }
        return new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
    }
    
    /**
     * Display the frame that contains the icon and slider
     */
    public static void displayGUI()
    {
        JFrame frame = new JFrame("Change Icon Size");
        frame.getContentPane().add(new SliderTester());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) 
    {
    	displayGUI();
    }
}

