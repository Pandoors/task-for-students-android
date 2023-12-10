package pl.edu.agh.pm.task.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Model {
    private final Random random = new Random();

    private final List<String> arrayList = Arrays.asList(
            "Cosmic Latte: The average color of the universe is beige, and it has been named Cosmic Latte by scientists.",
            "Octopuses have three hearts: Two pump blood to the gills, while the third pumps it to the rest of the body.",
            "Honey never spoils: Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3000 years old and still preserved.",
            "Bananas are berries: Scientifically, bananas are considered berries, whereas strawberries are not.",
            "The Eiffel Tower can be 15 cm taller during the summer: When a substance is heated up, its particles move more and it takes up a larger volume.",
            "A day on Venus is longer than a year: Venus has a slow rotation on its axis, taking 243 Earth days to complete a rotation.",
            "The inventor of the Frisbee was turned into a Frisbee: Walter Morrison, the inventor of the Frisbee, was cremated and made into a Frisbee after he died.",
            "Cleopatra lived closer to the invention of the iPhone than she did to the building of the Great Pyramid.",
            "The light hitting the earth right now is 30 thousand years old: The energy in the sunlight we see today started out in the core of the sun 30,000 years ago.",
            "A single cloud can weigh more than 1 million pounds: Clouds are heavy, but the spread of their particles means they don't fall."
    );

    public String getRandomCuriosity() {

        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }
}