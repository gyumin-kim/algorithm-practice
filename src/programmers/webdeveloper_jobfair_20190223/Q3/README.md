`items[][]`를 clone하여 `attackHighToLow`에 놓고, `attackHighToLow[][]`의 0번째 요소, 
즉 공격력의 내림차순으로 정렬한다.  
`health`는 오름차순으로 정렬하고, `health`의 앞에서부터 반복하면서 각 `health`에서
`attackHighToLow`의 체력감소분을 뺀 값이 100 이상일 경우에만 공격력을 증가시킨다. 
그리고 해당 item을 사용한 것으로 체크한다(`isUsed`).