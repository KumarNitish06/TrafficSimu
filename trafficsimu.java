import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*
<applet code="trafficsimu" >
</applet>
 */
public class trafficsimu extends Applet implements ActionListener {

	Color offred      = new Color(142, 13, 26);
	Color offyellow   = new Color(75, 78, 5);
	Color offgreen    = new Color(22, 74, 4);
	Color leftcolor   = new Color(255, 0, 255);
	Color rightcolor  = new Color(0, 0, 204);
	Color topcolor    = new Color(154, 205, 50);
	Color bottomcolor = new Color(255, 20, 20);
	
	int p, q, r, s;
	
int left[] = new int[3];

TextField tl, tr, tt, tb;
	
	Label ltimer, rtimer, ttimer, btimer, llabel, tlabel, rlabel, blabel;
	Button button = new Button("Start simulation");
	
	public void init(){
		 tl = new TextField(10);
         tr = new TextField(10);
         tb = new TextField(10);
         tt = new TextField(10);
  
         add(button);

     	 button.setBounds(100, 100, 100, 40);
         button.addActionListener(this);
     	
         add(tl);
         tl.setBounds(320, 110, 50, 20);
         
         add(tt);
         tt.setBounds(993, 110, 50, 20);
         
         add(tr);
         tr.setBounds(993, 505, 50, 20);
         
         add(tb);
         tb.setBounds(320, 505, 50, 20);
         setLayout(new BorderLayout()); 
         
  		 this.setSize(1400,650);
		 Frame c = (Frame)this.getParent().getParent();
		 c.setTitle("Intelligent traffic light simulation using swarm technology");			//Set the title of the Applet
	}
	
	public void close(){}
	
	public void paint(Graphics g)
	{
		createBackground(g);
		createTrafficLight(g);
		setDefaultTrafficColor(g, offyellow, offgreen);
		placeCars(g);	
		}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == button){
        Graphics g = super.getGraphics();
		
		int lc, rc, bc, tc;
		
		lc = Integer.parseInt(tl.getText());
		rc = Integer.parseInt(tr.getText());
		tc = Integer.parseInt(tt.getText());
		bc = Integer.parseInt(tb.getText());
	
		timer(g, lc, rc, tc, bc);
		
		int cl = 92;
		int sum = lc+tc+bc+rc;
		
		int a=(lc*cl)/sum;
		int b=(tc*cl)/sum;
		int c=(rc*cl)/sum;
		int d=(bc*cl)/sum;
		
        int a1 = a, b1 = b, c1 = c, d1 = d;

        a = a;
        b = 3*b/5;
        c = c - c/8;
        d = 3*d/5;
		    
        
        int al=1,at=2,ar=2,ab=1;
		int dt=7;
	
		int cycle = 1;
		
		while(cycle!=0){
			cycle--;
			while(a>=2)
        {
				
		        tl.setText(""+a);
				goAheadLeft(g);
				a--;
        
        }
			try {
				Thread.sleep(5000);
			} catch (InterruptedException v) {
				// TODO Auto-generated catch block
				v.printStackTrace();
			}
			
        while(c>=3)
        {	
        	tr.setText(""+c);
        	goAheadRight(g);
            c--;
		}

        try {
			Thread.sleep(7000);
		} catch (InterruptedException v) {
			// TODO Auto-generated catch block
			v.printStackTrace();
		}
		
        
        while(d>=2)
        {	
        	tb.setText(""+d);
        	goAheadBottom(g);    
			d--;
		}

        try {
			Thread.sleep(6000);
		} catch (InterruptedException v) {
			// TODO Auto-generated catch block
			v.printStackTrace();
		}
		
        
        
        while(b>=2)
        {	
        	tt.setText(""+b);
        	goAheadTop(g);
        	b--;
        }

        try {
			Thread.sleep(5000);
		} catch (InterruptedException v) {
			// TODO Auto-generated catch block
			v.printStackTrace();
		}
		
        
        lc = (al*92)-(dt*a)+lc;
    	tc = (at*92)-(dt*b)+tc;
    	rc = (ar*92)-(dt*c)+rc;
    	bc = (ab*92)-(dt*d)+bc;

    	sum = lc+bc+rc+tc;
    	a=(lc*cl)/sum;
		b=(tc*cl)/sum;
		c=(rc*cl)/sum;
		d=(bc*cl)/sum;
		
		a = a - a/8;
        b = 3*b/5;
        c = c-c/8;
        d = 3*d/5;
		
        
        while(a>=2)
        {
		        tl.setText(""+a);
				goAheadLeft(g);
				a--;
        
        }
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException v) {
			// TODO Auto-generated catch block
			v.printStackTrace();
		}
		
        while(c>=3)
        {	

            tr.setText(""+c);
        	goAheadRight(g);
        c--;
			
		}

        try {
			Thread.sleep(5000);
		} catch (InterruptedException v) {
			// TODO Auto-generated catch block
			v.printStackTrace();
		}
		
        
        while(d>=3)
        {	
        	tb.setText(""+d);
        	goAheadBottom(g);    
			d--;
		}

        try {
			Thread.sleep(7000);
		} catch (InterruptedException v) {
			// TODO Auto-generated catch block
			v.printStackTrace();
		}
		
        
        while(b>=3)
        {	
        	tt.setText(""+b);
        	goAheadTop(g);
        	b--;
        	}

        
}
		
		
		
		}
	}
		
		public void refreshyellow(Graphics g)
		{

			g.setColor(Color.YELLOW);
			g.fillRect(533, 180, 300, 5);
			g.fillRect(533, 485, 300, 5);
			g.fillRect(528, 185, 5, 300);
			g.fillRect(833, 185, 5, 300);	
		}
		
		public void createBackground(Graphics g)
		{
			Color roadcolor = new Color(127, 127, 127);
			
			g.setColor(roadcolor);
			g.fillRect(0, 0, 1366, 670);
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, 533, 185);
			g.fillRect(0, 485, 533, 185);
			g.fillRect(833, 0, 533, 185);
			g.fillRect(833, 485, 533, 185);
			
			g.setColor(Color.WHITE);
			
			g.fillRect(0, 330, 533, 10);
			g.fillRect(833, 330, 533, 10);
			g.fillRect(678, 0, 10, 185);
			g.fillRect(678, 485, 10, 185);
			
			refreshyellow(g);				
		}
		
		public void createTrafficLight(Graphics g)
		{
			g.setColor(Color.BLACK);
			g.fillRect(390, 110, 120, 50);
			g.fillRect(390, 505, 120, 50);
			g.fillRect(853, 110, 120, 50);
			g.fillRect(853, 505, 120, 50);
			g.setColor(Color.WHITE);
			g.fillRect(430,70,40, 40);
			g.fillRect(430,555,40, 40);
			g.fillRect(893,70,40, 40);
			g.fillRect(893,555,40, 40);
			}
		
		public void setDefaultTrafficColor(Graphics g, Color offyellow, Color offgreen)
		{
			setTrafficColorTop   (g, Color.RED, offyellow, offgreen);
			setTrafficColorRight (g, Color.RED, offyellow, offgreen);
			setTrafficColorBottom(g, Color.RED, offyellow, offgreen);
			setTrafficColorLeft  (g, Color.RED, offyellow, offgreen);
		}
		
		public void setTrafficColorLeft(Graphics g, Color re, Color ye, Color gr)
		{
			g.setColor(re);
			g.fillOval(400, 120, 30, 30); //red
			
			g.setColor(ye);
			g.fillOval(435, 120, 30, 30); //yellow
			
			g.setColor(gr);
			g.fillOval(470, 120, 30, 30); // green
			
		}

		public void setTrafficColorTop(Graphics g, Color re, Color ye, Color gr)
		{
			g.setColor(re);
			g.fillOval(863, 120, 30, 30); // red
			
			g.setColor(ye);
			g.fillOval(898, 120, 30, 30); // yellow
			
			g.setColor(gr);
			g.fillOval(933, 120, 30, 30); // green
			}
	
		public void setTrafficColorRight(Graphics g, Color re, Color ye, Color gr)
		{
			g.setColor(re);
			g.fillOval(863, 515, 30, 30); // red
			
			g.setColor(ye);
			g.fillOval(898, 515, 30, 30); // yellow
			
			g.setColor(gr);
			g.fillOval(933, 515, 30, 30); // green
			}
		
		public void setTrafficColorBottom(Graphics g, Color re, Color ye, Color gr)
		{
			g.setColor(re);
			g.fillOval(400, 515, 30, 30); // red
			
			g.setColor(ye);
			g.fillOval(435, 515, 30, 30); // yellow
			
			g.setColor(gr);
			g.fillOval(470, 515, 30, 30); // green
			}
		
		
		public void placeCars(Graphics g)
		{
			//left
			g.setColor(leftcolor);
	
			g.fillRect(458, 199, 50, 20);
			g.fillRect(458, 243, 50, 20);
			g.fillRect(458, 287, 50, 20);
			g.fillRect(388, 199, 50, 20);
			g.fillRect(388, 243, 50, 20);
			g.fillRect(388, 287, 50, 20);
			g.fillRect(318, 199, 50, 20);
			g.fillRect(318, 243, 50, 20);
			g.fillRect(318, 287, 50, 20);
			
			//right
			g.setColor(rightcolor);
			
			g.fillRect(850, 350, 50, 20);
			g.fillRect(850, 395, 50, 20);
			g.fillRect(850, 440, 50, 20);
			g.fillRect(920, 350, 50, 20);
			g.fillRect(920, 395, 50, 20);
			g.fillRect(920, 440, 50, 20);
			g.fillRect(990, 350, 50, 20);
			g.fillRect(990, 395, 50, 20);
			g.fillRect(990, 440, 50, 20);
			
			//top
			g.setColor(topcolor);
			
			g.fillRect(700, 120, 20, 50);
			g.fillRect(700, 50, 20, 50);
			g.fillRect(745, 120, 20, 50);
			g.fillRect(745, 50, 20, 50);
			g.fillRect(790, 120, 20, 50);
			g.fillRect(790, 50, 20, 50);
			
			//bottom
			g.setColor(bottomcolor);

			g.fillRect(555, 510, 20, 50);
			g.fillRect(555, 580, 20, 50);
			g.fillRect(600, 510, 20, 50);
			g.fillRect(600, 580, 20, 50);
			g.fillRect(645, 510, 20, 50);
			g.fillRect(645, 580, 20, 50);
			
		}
		
	public void timer(Graphics g, int ll,int t,int rr,int dd){
			
			int cl=92;
			
			 int al=1,at=2,ar=2,ab=1;
			int dt=7;
			 class asd extends Thread
		{ 
				 
				 
				 
		   asd()
		   {
		     start();
		   }
		   public void run()
		   {

		 for(int k=0;k<2;k++){
	     Font font = new Font ("Calibri", Font.PLAIN, 20);
	     g.setFont (font);
	    int j=cl;
	    
	     int tl = ll;
		 int tr = rr;
		 int tt = t;
		 int tb = dd;
		 
	    
	    
	     int sum=tl+tt+tr+tb;
	     int a=(tl*cl)/sum;
		 int b=(tt*cl)/sum;
		 int c=(tr*cl)/sum;
		 int d=(tb*cl)/sum;
		 
		 if(k==1)
		 {
			 tl = ll+(al*92)-(dt*a);
			 tt = t + (at*92)-(dt*b);
			 tr = rr + (ar*92)-(dt*c);
			 tb = dd + (ab*92)-(dt*d);
			 
			 
			 
			 sum = tl+tt+tr+tb;
		     
			 a = (tl*cl)/sum;
			 b = (tt*cl)/sum;
			 c = (tr*cl)/sum;
			 d = (tb*cl)/sum;
			}
		 
		 int aRed = cl-a;
		 int bRed = a+c+d;
		 int cRed1 = a;
		 int cRed2 = cl-c;
		 int dRed1 = a+c;
		 int dRed2 = cl-d;
		 
		 int flagr, flagp, flagq, flags;
		 flagr = flagp = flags = flagq = 0;
		 
	     p=a;
	     q=b;
	     r=c;
	     s=d;
	     
	     while(p>0)
	        {  
	    	 if(flagp==0)
			 {setTrafficColorLeft  (g, offred,    offyellow, Color.GREEN);
			setTrafficColorRight (g, Color.RED, offyellow,    offgreen);
			setTrafficColorTop   (g, Color.RED, offyellow,    offgreen);
			setTrafficColorBottom(g, Color.RED, offyellow,    offgreen);
			 }
	    	 flagp=1;
	        g.setColor(Color.WHITE);
			g.fillRect(430,70,40, 40);
			g.setColor(Color.BLACK);
			g.drawString(String.valueOf(p--), 440, 90);
			
	       	g.setColor(Color.WHITE);
	       	g.fillRect(893,555,40, 40);
	       	g.setColor(Color.BLACK);
	       	g.drawString(String.valueOf(cRed1--), 903,575);
			g.setColor(Color.WHITE);
    	    g.fillRect(430,555,40, 40);
    	    g.setColor(Color.BLACK);    
			g.drawString(String.valueOf(dRed1--), 440, 575);
			g.setColor(Color.WHITE);
			g.fillRect(893,70,40, 40);
    	 	g.setColor(Color.BLACK);	
			g.drawString(String.valueOf(bRed--), 903, 90);
	        	  
	        	  try {
					asd.sleep(1000);
				} catch (InterruptedException e) {
				  e.printStackTrace();
				}}
	     flagp = 0;
	        	while(r>0){
	        		if(flagr==0)
	        		{setTrafficColorLeft  (g, Color.RED, offyellow, offgreen);
	    			setTrafficColorRight (g, offred, offyellow,    Color.GREEN);
	    			setTrafficColorTop   (g, Color.RED, offyellow,    offgreen);
	    			setTrafficColorBottom(g, Color.RED, offyellow,    offgreen);
	        		}
	        		flagr = 1;
	    			g.setColor(Color.WHITE);
					g.fillRect(430,70,40, 40);
					g.setColor(Color.BLACK);
					g.drawString(String.valueOf(aRed--), 440, 90);
					g.setColor(Color.WHITE);
		        	g.fillRect(893,555,40, 40);
		        	g.setColor(Color.BLACK);
		        	g.drawString(String.valueOf(r--), 903,575);
		        	g.setColor(Color.WHITE);
		        	g.fillRect(430,555,40, 40);
		        	g.setColor(Color.BLACK);    
					g.drawString(String.valueOf(dRed1--), 440, 575);
					g.setColor(Color.WHITE);
		        	g.fillRect(893,70,40, 40);
		        	g.setColor(Color.BLACK);	
					g.drawString(String.valueOf(bRed--), 903, 90);
		        	
		        	try {
						asd.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        	flagr=1;
	        	
	        	/*
	        	 * 
	        	tl=al*(a+c)-(dt*a)+tl;
	        	tt=at*(a+c)+tt;
	        	tr=ar*(a+c)-(dt*c)+tr;
	        	tb=ab*(a+c)+tb;

	        	sum = tl+tb+tr+tt;
	        	int a2=(tl*cl)/sum;
	    		int b2=(tt*cl)/sum;
	    		int c2=(tr*cl)/sum;
	    		int d2=(tb*cl)/sum;
	    		
	    		int rr=b+a2+d;*/
	        	
	    		while(s>0){
	    			if(flags==0)
	        		{setTrafficColorLeft  (g,Color.RED ,    offyellow, offgreen);
	    			setTrafficColorRight (g, Color.RED, offyellow,    offgreen);
	    			setTrafficColorTop   (g, Color.RED, offyellow,    offgreen);
	    			setTrafficColorBottom(g, offred, offyellow,    Color.GREEN);
	        		}
	    			g.setColor(Color.WHITE);
					g.fillRect(430,70,40, 40);
					g.setColor(Color.BLACK);
					g.drawString(String.valueOf(aRed--), 440, 90);
					g.setColor(Color.WHITE);
		        	g.fillRect(893,555,40, 40);
		        	g.setColor(Color.BLACK);
		        	g.drawString(String.valueOf(cRed2--), 903,575);
		        	g.setColor(Color.WHITE);
		        	g.fillRect(430,555,40, 40);
		        	g.setColor(Color.BLACK);    
					g.drawString(String.valueOf(s--), 440, 575);
					g.setColor(Color.WHITE);
		        	g.fillRect(893,70,40, 40);
		        	g.setColor(Color.BLACK);	
					g.drawString(String.valueOf(bRed--), 903, 90);
		        	//j--;
		        	try {
						asd.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	    		flags=1;
	        	//int rb=b+a2+c2;
	        	while(q>0){
	        		if(flagq==0)
	        		{
	        		setTrafficColorLeft  (g, Color.RED,    offyellow, offgreen);
	    			setTrafficColorRight (g, Color.RED, offyellow,    offgreen);
	    			setTrafficColorTop   (g, offred, offyellow,    Color.GREEN);
	    			setTrafficColorBottom(g, Color.RED, offyellow,    offgreen);
	        		}
	    			g.setColor(Color.WHITE);
					g.fillRect(430,70,40, 40);
					g.setColor(Color.BLACK);
					g.drawString(String.valueOf(aRed--), 440, 90);
					g.setColor(Color.WHITE);
		        	g.fillRect(893,555,40, 40);
		        	g.setColor(Color.BLACK);
		        	g.drawString(String.valueOf(cRed2--), 903,575);
		        	g.setColor(Color.WHITE);
		        	g.fillRect(430,555,40, 40);
		        	g.setColor(Color.BLACK);    
					g.drawString(String.valueOf(dRed2--), 440, 575);
					g.setColor(Color.WHITE);
		        	g.fillRect(893,70,40, 40);
		        	g.setColor(Color.BLACK);	
					g.drawString(String.valueOf(q--), 903, 90);
		        	//j--;
		        	try {
						asd.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
	        	flagq=1;
	        	/*time(tl,tt,tr,tb,cycle);*/
		    }
		   }
		   
			 
			 public int getp(){
			   return p;
		   }
			 
			 public int getq(){
				   return q;
			   }
			 
			 public int getr(){
				   return r;
			   }
			 
			 public int gets(){
				   return s;
			   }
			 
		}
			 asd timerleft=new asd();
		}
//remove this2	
		public void goAheadLeft(Graphics g)
		{
			
			Color roadcolor = new Color(127, 127, 127);
			
			for(int i = 458; i<=541; i++)
			{
				
				
				g.setColor(leftcolor);
				g.fillRect(i, 199, 50, 20);
				g.fillRect(i, 243, 50, 20);
				g.fillRect(i, 287, 50, 20);
		
				if(i<=528)
				{g.fillRect(i-70, 199, 50, 20);
				g.fillRect(i-70, 243, 50, 20);
				g.fillRect(i-70, 287, 50, 20);
				
				g.fillRect(i-140, 199, 50, 20);
				g.fillRect(i-140, 243, 50, 20);
				g.fillRect(i-140, 287, 50, 20);
				
				g.setColor(roadcolor);
				g.fillRect(i-141, 198, 1, 112);
				g.fillRect(i-71, 198, 1, 112);
				
				}
				if(i>528&&i<534)
				g.setColor(Color.YELLOW);
				else
				g.setColor(roadcolor);
				g.fillRect(i-1, 198, 1, 115);
			
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int i = 541; i<=596; i++)
			{
				g.setColor(leftcolor);
				g.fillRect(i, 199, 50, 20);
				g.fillRect(i, 243, 50, 20);
				g.fillRect(i, 287, 50, 20);
				
				g.setColor(roadcolor);
				
				if(i>528&&i<534)
				g.setColor(Color.YELLOW);
				
				g.fillRect(i-1, 198, 1, 115);
			
			}
			
			g.setColor(roadcolor);
			g.fillRect(596, 199, 50, 20);
			
			for(int i=596; i<=750; i++)
			{
			g.setColor(leftcolor);
			g.fillRect(596, 169-i+596, 20, 50);
			g.fillRect(i, 243, 50, 20);
			g.fillRect(i, 287, 50, 20);
			
			g.setColor(roadcolor);
			g.fillRect(i-1, 242, 1, 70);
		
			if(i>630&&i<636)
				g.setColor(Color.YELLOW);
			
			g.fillRect(596, 169-i+50+596, 20, 1);
			
			
			
			}
			
			g.setColor(roadcolor);
			g.fillRect(750, 287, 50, 20);
			
			for(int i = 750; i<=1367; i++)
			{
				g.setColor(leftcolor);
				g.fillRect(596, 169-i+596, 20, 50);
				g.fillRect(i, 243, 50, 20);
				g.fillRect(750, 287+i-750, 20, 50);
				
				if(i<1069)
				{g.fillRect(i-750, 199, 50, 20);
				g.fillRect(i-750, 243, 50, 20);
				g.fillRect(i-750, 287, 50, 20);
				}
				if(i>833&&i<839)
				{
					g.setColor(Color.YELLOW);
					g.fillRect(i-1, 242, 1, 22);
					
					if(i<1069)
					{g.setColor(roadcolor);
						g.fillRect(i-751, 198, 1, 112);}
				}
				else
				{
					g.setColor(roadcolor);
					g.fillRect(i-1, 242, 1, 22);
					if(i<1069)
					g.fillRect(i-751, 198, 1, 112);
				}
				
				g.setColor(roadcolor);
				g.fillRect(596, 169-i+50+596, 20, 1);
				if(i>948&&i<954)
					g.setColor(Color.YELLOW);
				
				g.fillRect(750, 287+i-750-1, 20, 1);
				
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}		
		}
		
	
		public void goAheadRight(Graphics g)
		{

			
			Color roadcolor = new Color(127, 127, 127);
			
			for(int i = 850; i>=750; i--)
			{
				g.setColor(rightcolor);
				g.fillRect(i, 350, 50, 20);
				g.fillRect(i, 395, 50, 20);
				g.fillRect(i, 440, 50, 20);
				
				if(i>=780)
				{
					g.fillRect(i+70, 350, 50, 20);
					g.fillRect(i+70, 395, 50, 20);
					g.fillRect(i+70, 440, 50, 20);
					
					g.fillRect(i+140, 350, 50, 20);
					g.fillRect(i+140, 395, 50, 20);
					g.fillRect(i+140, 440, 50, 20);
					
					g.setColor(roadcolor);
					g.fillRect(i+121, 350, 1, 112);
					g.fillRect(i+191, 350, 1, 112);
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
				}
				
				g.setColor(roadcolor);
				
				if(i>781&&i<787)
				g.setColor(Color.YELLOW);
				
				g.fillRect(i+51, 350, 1, 115);
			
			
			}
			//loop for i = 606 to 760
			
			g.setColor(roadcolor);
			g.fillRect(750, 440, 60, 20);
			
			for(int i=750; i>=596; i--)
			{
			g.setColor(rightcolor);
			g.fillRect(i, 350, 50, 20);
			g.fillRect(i, 395, 50, 20);
			g.fillRect(750, 440-i+750, 20, 50);
			
			g.setColor(roadcolor);
			g.fillRect(i+50, 349, 1, 70);
		
			if(i>699&&i<705)
				g.setColor(Color.YELLOW);
			
			g.fillRect(750, 440-i+750-1, 20, 1);
			
			
			
			
			}
			
			g.setColor(roadcolor);
			g.fillRect(596, 350, 60, 20);
			
			for(int i = 596; i>=-50; i--)
			{
				g.setColor(rightcolor);
				g.fillRect(596, 350+i-596, 20, 50);
				g.fillRect(i, 395, 50, 20);
				g.fillRect(750, 440-i+750, 20, 50);
				
				if(i>=220)
				{	
				g.fillRect(i+770, 350, 50, 20);
				g.fillRect(i+770, 395, 50, 20);
				g.fillRect(i+770, 440, 50, 20);
				
				g.setColor(roadcolor);
				g.fillRect(i+820, 350, 1, 110);
			}
				
				if(i>477&&i<483)
				{
					g.setColor(Color.YELLOW);
					g.fillRect(i+50, 395, 1, 22);
				}
				else
				{
					g.setColor(roadcolor);
					g.fillRect(i+50, 395, 1, 22);
				}
				
				g.setColor(roadcolor);
				g.fillRect(750, 440-i+750-1, 20, 1);
				if(i>375&&i<381)
					g.setColor(Color.YELLOW);
				
				g.fillRect(596, 350+i-596+50, 20, 1);
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}

		public void goAheadTop(Graphics g)
		{
			
			
			Color roadcolor = new Color(127, 127, 127);
			
			for(int i=0; i<=1020; i++)
			{
				
				g.setColor(topcolor);
				
				if(i<=70)
				{
				g.fillRect(700, i+50, 20, 50);
				g.fillRect(700, i+120, 20, 50);
				
				g.fillRect(745, i+50, 20, 50);
				g.fillRect(745, i+120, 20, 50);
				
				g.fillRect(790, i+50, 20, 50);
				g.fillRect(790, i+120, 20, 50);
				
				g.setColor(roadcolor);
				g.fillRect(700, i+ 49, 110, 1);
		        
				if(i>=61&&i<66)
					g.setColor(Color.yellow);
					
				g.fillRect(700, i+119, 110, 1);
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				
				}
				else if(i<=110)
				{
					g.fillRect(700, i+120, 20, 50);
					g.fillRect(745, i+120, 20, 50);
					g.fillRect(790, i+120, 20, 50);
					
					g.setColor(roadcolor);
				
					g.fillRect(700, i+ 119, 110, 1);
				}
				else if(i<=270)
				{
					g.setColor(roadcolor);
					g.fillRect(790, i+120, 20, 50);
					
					g.setColor(topcolor);
					g.fillRect(700, i+120, 20, 50);
					g.fillRect(745, i+120, 20, 50);
					g.fillRect(680+i, 230, 50, 20);
					
					g.setColor(roadcolor);
					g.fillRect(700, i+ 119, 65, 1);
					
					if(i>=154&&i<=158)
					g.setColor(Color.yellow);
					
					g.fillRect(679+i, 230, 1, 20);
					
					
				}
				else //if(i<=770)
				{
					if(i==271)
					{	
						g.setColor(roadcolor);
						g.fillRect(700, 390, 21, 51);
					}
					
					g.setColor(topcolor);
					g.fillRect(970-i, 390, 50, 20);
					g.fillRect(745, i+120, 20, 50);
					g.fillRect(680+i, 230, 50, 20);
					
					if(i<=371)
					{
						g.fillRect(700, i-321, 20, 50);
						g.fillRect(745, i-321, 20, 50);
						g.fillRect(790, i-321, 20, 50);
					}
					
					g.setColor(roadcolor);
					g.fillRect(679+i, 230, 1, 20);
					
					if(i<371)
					{
						g.fillRect(700, i-371, 20, 50);
						g.fillRect(745, i-371, 20, 50);
						g.fillRect(790, i-371, 20, 50);
					}
					if(i>=366&&i<=370)
					g.setColor(Color.yellow);
					
					g.fillRect(745, i+119, 20, 1);
					
					g.setColor(roadcolor);
					
					if(i>=488&&i<=492)
					g.setColor(Color.YELLOW);
					
					g.fillRect(1020-i, 390, 1, 20);
					}
				
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
	
			public void goAheadBottom(Graphics g)
			{
				
				Color roadcolor = new Color(127, 127, 127);
				
				for(int i=110; i<=1120; i++)
				{
					
					g.setColor(bottomcolor);
					
					if(i<=190)
					{
					g.fillRect(555, 620-i, 20, 50);
					g.fillRect(555, 690-i, 20, 50);
					
					g.fillRect(600, 620-i, 20, 50);
					g.fillRect(600, 690-i, 20, 50);
					
					g.fillRect(645, 620-i, 20, 50);
					g.fillRect(645, 690-i, 20, 50);
					
					g.setColor(roadcolor);
					g.fillRect(555, 740-i, 110, 1);
			        
					if(i>=181&&i<=185)
					g.setColor(Color.yellow);
						
					g.fillRect(555, 670-i, 110, 1);
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
					
					}
					else if(i<=230)
					{
						g.fillRect(555, 620-i, 20, 50);
						g.fillRect(600, 620-i, 20, 50);
						g.fillRect(645, 620-i, 20, 50);
						
						g.setColor(roadcolor);
						g.fillRect(555, 670-i, 110, 1);
					}
					else if(i<=390)//380
					{
						if(i==231)
						{
							g.setColor(roadcolor);
							g.fillRect(555, 621-i, 20, 50);
						}
						
						g.setColor(bottomcolor);
						g.fillRect(645, 620-i, 20, 50);
						g.fillRect(600, 620-i, 20, 50);
						g.fillRect(736-i, 390, 50, 20);
						
						g.setColor(roadcolor);
						g.fillRect(600, 670-i, 65, 1);
						
						if(i>=254&&i<=258)
						g.setColor(Color.yellow);
						
						g.fillRect(786-i, 390, 1, 20);
						
						
					}
					else
					{
						if(i==391)
						{	
							g.setColor(roadcolor);
							g.fillRect(645, 230, 21, 51);
						}
						
						g.setColor(bottomcolor);
						g.fillRect(254+i, 230, 50, 20);
						g.fillRect(600, 620-i, 20, 50);
						g.fillRect(736-i, 390, 50, 20);
						
						if(i<=441)
						{
							g.fillRect(555, 620-i+391, 20, 50);
							g.fillRect(600, 620-i+391, 20, 50);
							g.fillRect(645, 620-i+391, 20, 50);
						}
						
						g.setColor(roadcolor);
						g.fillRect(786-i, 390, 1, 20);
						
						if(i<=441)
						{
							g.fillRect(555, 620-i+441, 20, 50);
							g.fillRect(600, 620-i+441, 20, 50);
							g.fillRect(645, 620-i+441, 20, 50);
						}
						if(i>=486&&i<=490)
						g.setColor(Color.yellow);
						
						g.fillRect(600, 670-i, 20, 1);
						
						g.setColor(roadcolor);
						
						if(i>=580&&i<=584)
						g.setColor(Color.yellow);
						
						g.fillRect(253+i, 230, 1, 20);
						
								
						}
					
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}

		
		}
}