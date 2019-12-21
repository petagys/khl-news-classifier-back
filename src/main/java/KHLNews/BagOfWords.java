package KHLNews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BagOfWords {
    private List<String> wordsFromText;
    private List<List<Integer>> bagOfWords;
    private Map<String, Integer> bagKeeper = new HashMap<String, Integer>();

    public BagOfWords(List<String> wordsFromTexts) {
        this.wordsFromText = wordsFromTexts;
    }

    public List<Integer> createBag() {
        List<Integer> bag = new ArrayList<Integer>();
        Map<String, Integer> bagCounter = new HashMap<String, Integer>();
        fillMaxBag();
        for (String word : wordsFromText) {
                bagKeeper.put(word, bagKeeper.get(word) + 1);
            bag.add(new ArrayList<Integer>());
            for (String key : bagKeeper.keySet()) {
                bag.get(bag.size() - 1).add(bagKeeper.get(key));
            }

            //empty Keeper before next file iteration
            for (String key : bagKeeper.keySet()) {
                bagKeeper.put(key, 0);
            }
        }
        return bag;
    }

    private void fillMaxBag() {
        for (String word : wordsFromText) {
            bagKeeper.put(word, 0);
        }
    }


}
