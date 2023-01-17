package ru.job4j.io;

import java.io.*;
import java.util.*;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    StringBuilder text = new StringBuilder();

    List<String> answersPull;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        boolean isWorking = true;
        boolean answersOn = true;
        Scanner sc  = new Scanner(System.in);
        Random rand = new Random();
        answersPull = readPhrases();
        while (isWorking) {
            String question = sc.nextLine();
            if (STOP.equals(question)) {
                answersOn = false;
            }
            if (OUT.equals(question)) {
                 isWorking = false;
                 answersOn = false;
            }
            if (CONTINUE.equals(question)) {
                answersOn = true;
            }
            System.out.println(question);
            text.append(question).append(System.lineSeparator());
            if (answersOn) {
                String answer = answersPull.get(rand.nextInt(answersPull.size()));
                System.out.println(answer);
                text.append(answer).append(System.lineSeparator());
            }
        }
        sc.close();
        List<String> log = Arrays.stream(text.toString().split(System.lineSeparator())).toList();
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            br.lines().map(s -> s + System.lineSeparator()).forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "/home/vsevolod/IdeaProjects/job4j_design/data/logging.txt";
        String answers = "/home/vsevolod/IdeaProjects/job4j_design/data/answers.txt";
        ConsoleChat cc = new ConsoleChat(path, answers);
        cc.run();
    }
}
