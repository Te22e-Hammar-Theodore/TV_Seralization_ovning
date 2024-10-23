import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class TvSeries implements Serializable {
    private String name;
    private int rating;
    private ArrayList<Integer> episodes = new ArrayList<>();

    public TvSeries(Scanner sc) {
        System.out.println("Namn på serien?");
        new TvSeries(sc.next());

    }

    public TvSeries(String name) {
        this.name = name;
    }

    public void addEpisode(int numOfEpisodes, int season) {
        if (season > episodes.size() + 1) {
            System.out.println("Du kan inte ska denna säsong då den tidigare inte existerar än");
        } else if (season == episodes.size()) {
            episodes.add(numOfEpisodes);
        } else {
            episodes.set(season - 1, numOfEpisodes + episodes.get(season - 1));
        }


    }

    public void changeRating(int newRating) {
        rating = newRating;
    }

    public void printInfo() {
        System.out.println("Det finns " + episodes.size() + " episoder i denna säsong");
        for (int i = 0; i < episodes.size(); i++) {
            System.out.println("I säsong " + i + 1 + "finns det " + episodes.get(i) + " episoder");
        }
        System.out.println(name + " är ratead " + rating);
    }
}
