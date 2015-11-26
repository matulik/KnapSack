package pl.matulik;

import com.softtechdesign.ga.*;

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

    @Override
    protected double getFitness(int i) {
        ChromStrings chromosome = this.getChromosome(i);

//        double[] processorsTime = new double[LoadData.processes_count];

        double maxTime;

        for (int tasks = 0; tasks < chromosomeDim; tasks++) {

            String processor = chromosome.getGene(tasks);

            String[] temp = processor.split(" ");
            int processorId = Integer.valueOf(temp[0]) - 1;

            processorsTime[processorId] += LoadData.getProcTime(tasks, processorId + 1);
        }

        maxTime = processorsTime[0];

        for (double time : processorsTime) {

            if (maxTime < time) {
                maxTime = time;
            }
        }

        return -maxTime;
    }
}