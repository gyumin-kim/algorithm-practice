package sample.ZI;

/**
 * @author Gyumin Kim
 * @since 2019-02-18
 */
public class Q2 {

  public String solution(int U, int L, int[] C) {
    int c = C.length;
    int[][] arr = new int[2][c];

    for (int i = 0; i < c; i++) {
      if (C[i] == 2) {
        arr[0][i] = 1;
        U--;
        arr[1][i] = 1;
        L--;
        C[i] = 0;
      } else {
        arr[0][i] = 0;
        arr[1][i] = 0;
      }
    }

    for (int k = 0; k < c; k++) {
      if (arr[0][k] != 1) {
        if (U <= 0 || C[k] <= 0)  break;
        arr[0][k] = 1;
        U--;
        C[k]--;
      }
    }
    for (int k = 0; k < c; k++) {
      if (arr[1][k] != 1) {
        if (L <= 0 || C[k] <= 0)  continue;
        arr[1][k] = 1;
        L--;
        C[k]--;
      }
    }

    if (!(U == 0 && L == 0))  return "IMPOSSIBLE";
    else {
      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < c; j++) {
          if (arr[i][j] == -1)  arr[i][j] = 0;
        }
      }
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < c; j++) {
        sb.append(arr[i][j]);
      }
      sb.append(",");
    }
    sb.setLength(sb.length() - 1);

    return sb.toString();
  }

  public String solution2(int U, int L, int[] C){
    int sum=0;
    StringBuffer up = new StringBuffer();
    StringBuffer low = new StringBuffer();

    for(int i=0; i<C.length; i++)
      sum+=C[i];

    if(U+L != sum)
      return "IMPOSSIBLE";

    for(int i=0; i<C.length;i++){
      if(C[i]==2){
        up.append(1);
        low.append(1);
        U--;L--;
      }else if(C[i]==0){
        up.append(0);
        low.append(0);
      }else if(C[i]==1){
        if(U>L) {
          up.append(1);
          low.append(0);
          U--;
        }else{
          up.append(0);
          low.append(1);
          L--;
        }
      }
    }
    up.append(","+low.toString());
    return up.toString();
  }
}
