package MainPackage;

import javax.swing.SwingUtilities;

public class TimeThread extends Thread{
	private boolean run = true;
	public void run() {
		long start = System.currentTimeMillis();
        while (run)
        {
            long time = System.currentTimeMillis() - start;
            int seconds = (int)time / 1000;
            String elapsed = Integer.toString(seconds)+"."+(time-seconds*1000);
            SwingUtilities.invokeLater(new Runnable() {
                 public void run()
                 {
                       MainFrame.currentTime.setText("Time Survived: " + elapsed);
                 }
            });
            try { Thread.sleep(100); } catch(Exception e) {}
        }
	}

	public void stopThread() {
		run = false;
	}
}
