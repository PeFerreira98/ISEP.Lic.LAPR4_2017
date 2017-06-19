/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1131106.realtimeworkbook;

import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import lapr4.green.s1.ipc.n1970581.findworkbook.FileDTO;
import lapr4.green.s1.ipc.n1970581.findworkbook.controller.SearchWorkbookController;
import lapr4.green.s1.ipc.n1970581.findworkbook.ui.SearchWorkbookPanel;

/**
 *
 * @author Nuno Filipe 1131106
 */
public class RealTimeSearch implements Runnable, SelectionListener {

    private SearchWorkbookController controller;
    private SearchWorkbookPanel searchWorkbookPanel;

    protected Map<String, String> wbooks;
    private final String path;
    private final Timer timer = new Timer();

    /**
     *
     * @param controller searchWorkbookController
     * @param path the path of the folder
     * @param searchWorkbookPanel searchWorkbookPanel
     */
    public RealTimeSearch(SearchWorkbookController controller,
            String path, SearchWorkbookPanel searchWorkbookPanel) {
        this.controller = controller;
        this.path = path;
        this.searchWorkbookPanel = searchWorkbookPanel;
    }

    /**
     *
     * @param path Folder path
     */
    public RealTimeSearch(String path) {
        this.path = path;
    }

    @Override
    public void run() {

        wbooks = new HashMap<String, String>();

        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                try {
                    findWorkbook(path);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RealTimeSearch.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }, 0, 20 * 1000);

    }

    private synchronized void findWorkbook(String path) throws InterruptedException {
        File root = new File(path);
        if (root.isDirectory()) {
            //if the root have more folders inside
            if (!(root.listFiles() == null)) {
                for (File file : root.listFiles()) {
                    findWorkbook(file.getAbsolutePath()); //recursivly
                }
            }
        } else if ((root.getName().endsWith(".cls") || root.getName().
                endsWith(".csv")) && root.isFile()) {
            wbooks.put(root.getAbsolutePath(), root.getName());
            boolean flag = false;

            for (int i = 0; i < searchWorkbookPanel.showJListWorbooks().getModel().
                    getSize(); i++) {
                if (searchWorkbookPanel.showJListWorbooks().getModel().getElementAt(i).
                        equals(root)) {
                    flag = true;
                }
            }

            if (flag == false) {
                
                ((DefaultListModel) searchWorkbookPanel.showJListWorbooks().getModel()).
                        addElement(root);
            }
        }
        deleteUnexistingFiles();
    }

    @Override
    public void selectionChanged(SelectionEvent event
    ) {
    }

    /**
     * Method that cancels the timer.
     */
    public void cancelTimer() {
        timer.cancel();
    }

    /**
     * Method that returns the map
     *
     * @return the map
     */
    public Map<String, String> showWbooks() {
        return wbooks;
    }

    /**
     * Method that change the map
     *
     * @param wbooks new map
     */
    public void changeWbooks(Map<String, String> wbooks) {
        this.wbooks = wbooks;
    }

    private synchronized void deleteUnexistingFiles() {
        DefaultListModel temp = (DefaultListModel) searchWorkbookPanel.showJListWorbooks().
                getModel();
        DefaultListModel model = new DefaultListModel();

        for (int j = 0; j < temp.getSize(); j++) {
            File r = (File) temp.getElementAt(j);
            if (r.exists()) {
                model.addElement(r);
            }
        }
        searchWorkbookPanel.showJListWorbooks().setModel(model);
        searchWorkbookPanel.validate();
        searchWorkbookPanel.repaint();
    }

}
