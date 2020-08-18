package Chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws Exception {
        //testCallable();
        new Main().testBrProcess();
        new Main().testCustommBrProcess();
        testExecute();
    }

    private static void testExecute() {
        //new Main().execute(()->{}); - not working
        new Main().execute((Runnable) ()->{});
    }

    public void execute(Runnable r){
        r.run();
    }

    public <T> void execute(Action<T> act){
        act.act();
    }

    private  void testCustommBrProcess() throws IOException {
        String result = customProcessFile(br -> br.readLine() + "\n" + br.readLine());
        System.out.println(result);
    }

    private String customProcessFile(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br =
                    new BufferedReader(new FileReader("E:\\Work\\export_fl.tsv"))){
            return p.process(br);
        }
    }

    private void testBrProcess() throws IOException {
        String str = processFile(bufferedReader -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "null";
        });
        System.out.println(str);
    }

    public String processFile(Function<BufferedReader, String> func) throws IOException {
        try(BufferedReader br =
                new BufferedReader(new FileReader("E:\\Work\\export_fl.tsv"))){
            return func.apply(br);
        }
    }



    private static void testCallable() throws Exception {
        Callable<String> fetch = fetch();
        System.out.println(fetch.call());
    }

    private static Callable<String> fetch() {
        return () -> "Some string";
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor{
        String process(BufferedReader br) throws IOException;
    }

    @FunctionalInterface
    public interface Action<T>{
        void act();
    }
}
