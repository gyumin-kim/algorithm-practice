package sample.i_scream;

/**
 * @author 김규민
 * @since 2019-04-03
 */
public class Q2 {

  public static void solution(String[] docs) {

    for (String doc : docs) {

      for (int i = 0; i < doc.length(); i++) {
        if (doc.charAt(i) == 'n') {

        }
      }

    }
  }

  public static void main(String[] args) {
    String[] docs = {"note?",
        "(note)",
        "yes, note1",
        "keynote",
        "no, anote",
        "no, a note"
    };

    solution(docs);
  }
}
