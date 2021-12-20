import java.util.*;

class Program {

  public String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    // Write your code here.
		Map <String, Integer> teamAndScore = new HashMap<String, Integer> ();
		for (int competitionNo =0; competitionNo < results.size(); competitionNo++) {
			String teamA = competitions.get(competitionNo).get(0);
			if (!teamAndScore.containsKey(teamA)) {teamAndScore.put(teamA, 0);}
			String teamB = competitions.get(competitionNo).get(1);
			if (!teamAndScore.containsKey(teamB)) {teamAndScore.put(teamB, 0);}
			int result = results.get(competitionNo);
			if (result == 1) {
				teamAndScore.put(teamA, teamAndScore.get(teamA) + 3);
			} else {
				teamAndScore.put(teamB, teamAndScore.get(teamB) + 3);
			}
		}
		
		int max = Integer.MIN_VALUE;
		String winner = "";
			
		// for (Map.Entry entry: teamAndScore.entrySet()) {
		// 	if ((int)entry.getValue() > max) {max = (int)entry.getValue(); winner = (String)entry.getKey();}
		// }	
		
		for (String key: teamAndScore.keySet()) {
			if (teamAndScore.get(key) > max) {max = teamAndScore.get(key); winner = key;}
		}	

    return winner;
  }
}
