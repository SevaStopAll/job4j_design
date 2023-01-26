package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Phone {
    boolean isApple;
    int weight;
    String model;
    CPU cpu;
    int[] bands;

    public boolean isApple() {
        return isApple;
    }

    public int getWeight() {
        return weight;
    }

    public String getModel() {
        return model;
    }

    public CPU getCpu() {
        return cpu;
    }

    public int[] getBands() {
        return bands;
    }

    public Phone(boolean isApple, int weight, String model, CPU cpu, int[] bands) {
        this.isApple = isApple;
        this.weight = weight;
        this.model = model;
        this.cpu = cpu;
        this.bands = bands;
    }

    @Override
    public String toString() {
        return "Phone{"
                + "isApple=" + isApple
                + ", weight=" + weight
                + ", model='" + model + '\''
                + ", cpu=" + cpu
                + ", bands=" + Arrays.toString(bands)
                + '}';
    }

    public static void main(String[] args) {

        JSONObject jsonCPU = new JSONObject("{\"cpu\":\"Dimensity 8100 Ultra\"}");

        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(29);
        JSONArray jsonBands = new JSONArray(list);

        final Phone phone = new Phone(false, 140, "Xiaomi 12T", new CPU("Dimensity 8100 Ultra"), new int[]{7, 29});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isApple", phone.isApple());
        jsonObject.put("weight", phone.getWeight());
        jsonObject.put("model", phone.getModel());
        jsonObject.put("CPU", jsonCPU);
        jsonObject.put("bands", jsonBands);

        System.out.println(jsonObject);

        System.out.println(new JSONObject(phone));
    }
}
