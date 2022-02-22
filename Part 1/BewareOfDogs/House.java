package com.epam.rd.autotasks.house;

import com.epam.rd.autotasks.residents.cats.Cat;
import com.epam.rd.autotasks.residents.dogs.Dog;

import java.util.ArrayList;
import java.util.List;

public class House<Cat> {

    private final List<Cat> residents = new ArrayList<>();
    private final List<Dog> residents1 = new ArrayList<>();

    public void enter(Object resident) {
        residents.add((Cat) resident);
        residents1.add((Dog) resident);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("There are following residents in the house:\n");
        for (Object resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }
}
