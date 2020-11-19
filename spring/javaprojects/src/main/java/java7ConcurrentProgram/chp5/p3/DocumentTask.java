package java7ConcurrentProgram.chp5.p3;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * RecursiveTask: 有返回结果
 * RecursiveAction 无返回结果
 */
public class DocumentTask extends RecursiveTask<Integer> {

    private static final long serialVersionUID = 1L;

    private String document[][];

    private int start, end;

    private String word;

    public DocumentTask(String[][] document, int start, int end, String word) {
        this.document = document;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        Integer result = null;
        if (end - start < 10){
            result = processLines(document, start, end, word);
        }else {
            int mid = (start + end)/2;
            DocumentTask task1 = new DocumentTask(document, start, mid, word);
            DocumentTask task2 = new DocumentTask(document, mid, end, word);
            invokeAll(task1, task2);
            try {
                result = groupResults(task1.get(), task2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Integer processLines(String[][] document, int start, int end, String word) {
        ArrayList<LineTask> tasks = new ArrayList<>();

        for (int i = start; i < end; i++) {
            LineTask task = new LineTask(document[i], 0, document[i].length, word);
            tasks.add(task);
        }

        invokeAll(tasks);

        int result = 0;
        for (int i = 0; i < tasks.size(); i++) {
            LineTask task = tasks.get(i);
            try {
                result = result + task.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return new Integer(result);

    }

    private Integer groupResults(Integer number1, Integer number2) {

        return number1 + number2;

    }
}
