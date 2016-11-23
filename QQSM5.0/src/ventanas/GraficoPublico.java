package ventanas;

import java.awt.Color;
import java.awt.GradientPaint;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GraficoPublico  extends JFrame{

	/**
	 * Gráficos del comodín del público
	 */
	private static final long serialVersionUID = 1L;
	public static  int a;
	public static  int b;
	public static  int c;
	public static  int d;
	public static  String res1;
	public static  String res2;
	public static  String res3;
	public static  String res4;
	
   
public GraficoPublico(String title, int a,int b,int c,int d, String res1,String res2,String res3,String res4) {
	
      super(title);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      this.a=a;
      this.b=b;
      this.c=c;
      this.d=d;
      this.res1=res1;
      this.res2=res2;
      this.res3=res3;
      this.res4=res4;
      JPanel chartPanel = createDemoPanel();
      chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
      setContentPane(chartPanel);
     
   }

   public static DefaultCategoryDataset createDataset() {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();


      dataset.addValue(a, res1,  "A");
      dataset.addValue(b, res2,  "B");
      dataset.addValue(c, res3,  "C");
      dataset.addValue(d, res4,  "D");

      
      return dataset;
   }

   private static JFreeChart createBarChart(
         CategoryDataset dataset) {

      CategoryAxis categoryAxis = new CategoryAxis("");
      ValueAxis valueAxis = new NumberAxis("");

      StandardBarPainter painter = new StandardBarPainter();

      BarRenderer.setDefaultBarPainter(painter);
      BarRenderer renderer = new BarRenderer();

      // tooltips
      renderer.setShadowVisible(false);
      renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

      Color primaryColor = Color.red;
      Color secondaryColor = Color.blue;
      Color thirdColor = Color.cyan;
      Color fourthColor = Color.green;

      GradientPaint gpVertical = new GradientPaint(5, 5, primaryColor, 10, 5,
            secondaryColor, true);

      GradientPaint gpHorizontal = new GradientPaint(5, 5, primaryColor, 5,
            10, secondaryColor, true);

      GradientPaint gpUpSlant = new GradientPaint(5, 5, primaryColor, 10, 10,
            secondaryColor, true);

      renderer.setSeriesPaint(0, primaryColor);
      renderer.setSeriesPaint(1, secondaryColor);
      renderer.setSeriesPaint(2, thirdColor);
      renderer.setSeriesPaint(3, fourthColor);

      CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, valueAxis,
            renderer);
      plot.setOrientation(PlotOrientation.VERTICAL);

      JFreeChart chart = new JFreeChart(plot);

      return chart;

   }

   public static JPanel createDemoPanel() {
      JFreeChart chart = createBarChart(createDataset());
      ChartPanel chartPanel = new ChartPanel(chart);
      chartPanel.setPopupMenu(null);

      chartPanel.setDomainZoomable(true);
      chartPanel.setRangeZoomable(true);
      return chartPanel;
   }

   public static void main(String[] args) {
      GraficoPublico demo = new GraficoPublico("BarChart gradient test",1,3,4,5,res1,res2,res3,res4);
      demo.pack();
      RefineryUtilities.centerFrameOnScreen(demo);
      demo.setVisible(true);
   }

}