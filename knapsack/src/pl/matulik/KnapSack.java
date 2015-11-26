package pl.matulik;

import com.softtechdesign.ga.GAException;
import com.softtechdesign.ga.GAStringsSeq;

/**
 * Created by matulik on 26.11.2015.
 */
public class KnapSack extends GAStringsSeq {
    // atrybuty do konstruktora
    public KnapSack() throws GAException {
        super(tasks,
                100,
                0.7,
                80,
                1000,
                0,
                20,
                0.8,
                0,
                data.split(" "),
                Crossover.ctOnePoint,
                true
        );
    }


    public static void main(String[] args) throws GAException, InterruptedException {
//        LoadData loadData = new LoadData("c:\\data.txt");
//        MainClass mainClass = new MainClass(loadData.getTasksCount(),
//                loadData.getProcessesCount(),
//                loadData.processor_genes);

        Thread t = new Thread(mainClass);
        t.start();
        t.join();
    }

}