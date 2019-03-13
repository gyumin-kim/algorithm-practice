package programmers.recruitment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Gyumin Kim
 * @since 2019-03-13
 */
public class Q2 {

  public String[] solution(String[] card , String[] word) {
    String[] answer = {};
    List<String> list = new ArrayList<>();
    int wordLength = word.length;


    for(int i=0; i < wordLength ; i++) {

      // 카드가 단어를 포함하고 있으면 list에 추가해줘라
      if(isContainWord(card,word[i])) {
        list.add(word[i]);
      }
    }

    if(list.size() == 0) {
      list.add("-1");
      answer = list.toArray(new String[list.size()]);
    } else {
      answer = list.toArray(new String[list.size()]);
    }
    return answer;
  }

  public boolean isContainWord(String[] card , String word) {
    Map<Character, Integer> map = new HashMap<>();
    int wordLength = word.length();
    //System.out.println("card : " + card + "    word : " + word);

    for(int i=0 ; i < wordLength ; i++) {
      // 이미 알파벳을 가지고 있다면. 기존 value에 1추가.
      if(map.containsKey(word.charAt(i))) {
        map.put(word.charAt(i), map.get(word.charAt(i))+1);
      } else {
        // 처음 보는 알파벳은 value 1로 추가.
        map.put(word.charAt(i),1);
      }
    }
    //System.out.println(map);

    Iterator<Entry<Character,Integer>> itr = map.entrySet().iterator();
    boolean firstLineCheck = false;
    boolean secondLineCheck = false;
    boolean thirdLineCheck = false;

    while(itr.hasNext()) {
      Entry<Character, Integer> entry = itr.next();
      String key = Character.toString(entry.getKey());

      //System.out.println("card[0] : " + card[0] + "   key : " +key);

      if(card[0].contains(key)) {

        // 첫번째 줄에 key 알파벳이 있다면?
        firstLineCheck = true;

        // 알파벳 갯수도 같아야 한다.
        int counter = countAlpha(card[0],entry.getKey());
        //System.out.println("card[0] : " + card[0] + " getKey() : " + entry.getKey() + " counter : " + counter + "   getValue = " + entry.getValue());
        if(counter < entry.getValue()) {
          return false;
        }

      }else if(card[1].contains(key)) {

        // 두번째 줄에 key 알파벳이 있다면?
        secondLineCheck = true;

        // 알파벳 갯수도 같아야 한다.
        int counter = countAlpha(card[1],entry.getKey());
        //System.out.println("card[1] + " + card[1] + " getKey() : " + entry.getKey() + " counter : " + counter + "   getValue = " + entry.getValue());
        if(counter < entry.getValue()) {
          return false;
        }

      }else if(card[2].contains(key)) {

        // 세번째 줄에 key 알파벳이 있다면?
        thirdLineCheck = true;

        // 알파벳 갯수도 같아야 한다.
        int counter = countAlpha(card[2],entry.getKey());
        //System.out.println("card[2] + " + card[2] + " getKey() : " + entry.getKey() + " counter : " + counter + "   getValue = " + entry.getValue());
        if(counter < entry.getValue()) {
          return false;
        }

      } else {
        // 어느 줄에도 포함되어 있지 않다면?
        return false;
      }

    }

    if(!firstLineCheck || !secondLineCheck || !thirdLineCheck) {
      // 하나라도 false 면 안된다.
      return false;
    }

    return true;
  }

  public int countAlpha(String cardLine, Character key) {
    int length = cardLine.length();
    int counter = 0;
    for(int i=0; i < length ; i++) {
      if(cardLine.charAt(i) == key) {
        counter++;
      }
    }
    return counter;
  }
}
