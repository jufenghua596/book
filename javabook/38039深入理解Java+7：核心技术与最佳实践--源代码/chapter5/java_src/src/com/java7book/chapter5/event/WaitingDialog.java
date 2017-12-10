/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.event;


import java.awt.EventQueue;
import java.awt.SecondaryLoop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingWorker;

/**
 *
 * @author chengfu
 */
public class WaitingDialog {
    
    public void waiting() {
        final JFrame frame = new JFrame();
        JButton button = new JButton("点击执行");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame, "请等待...");
                dialog.setSize(300, 200);
                EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
                SecondaryLoop loop = queue.createSecondaryLoop();
                final WaitingWorker worker = new WaitingWorker(dialog, loop);
                worker.execute();
                JButton cancelButton = new JButton("取消");
                dialog.add(cancelButton);
                cancelButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        worker.cancel(true);
                    }
                    
                });
                dialog.setVisible(true);
                
                loop.enter();
                /*try {
                    worker.get();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                }*/
            }
        });
        frame.add(button);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
    
    private static class WaitingWorker extends SwingWorker<Integer, Integer> {
        private JDialog dialog;
        private SecondaryLoop loop;
        public WaitingWorker(JDialog dialog, SecondaryLoop loop) {
            this.dialog = dialog;
            this.loop = loop;
        }

        protected Integer doInBackground() throws Exception {
            for (int i = 0; i < 100; i++) {
                if (isCancelled()) {
                    break;
                }
                Thread.sleep(1000);
            }
            return 0;
        }

        protected void done() {
            dialog.setVisible(false);
            dialog.dispose();
            loop.exit();
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WaitingDialog wd = new WaitingDialog();
        wd.waiting();
    }
}
