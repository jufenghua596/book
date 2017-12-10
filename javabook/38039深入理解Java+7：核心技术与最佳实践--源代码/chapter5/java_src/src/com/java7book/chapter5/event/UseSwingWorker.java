/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter5.event;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.MessageFormat;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author chengfu
 */
public class UseSwingWorker {
    
    public void downloadFile() {
        JFrame frame = new JFrame();
        final JProgressBar progressBar = new JProgressBar();
        frame.add(progressBar, BorderLayout.NORTH);
        final JLabel label = new JLabel();
        frame.add(label, BorderLayout.CENTER);
        DownloadWorker worker = new DownloadWorker(label);
        worker.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if ("progress".equals(evt.getPropertyName())) {
                    progressBar.setValue((Integer) evt.getNewValue());
                }
            }
        });
        worker.execute();
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
    
    private static class DownloadWorker extends SwingWorker<String, Double> {
        private JLabel label;
        public DownloadWorker(JLabel label) {
            this.label = label;
        }

        public String doInBackground() throws Exception {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                Thread.sleep(random.nextInt(1000));
                setProgress(i + 1);
                publish(random.nextDouble() * 30);
            }
            return "<Path>";
        }

        protected void process(List<Double> chunks) {
            Double speed = chunks.get(chunks.size() - 1);
            label.setText(MessageFormat.format("下载速度：{0,number,#.##} kb/s", speed));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UseSwingWorker usw = new UseSwingWorker();
        usw.downloadFile();
    }
}
