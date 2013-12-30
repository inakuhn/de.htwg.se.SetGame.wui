package setgame.controller;

public class PlayerComputerModus {
	private int anzahlPlayer;
	public PlayerComputerModus(int anzahlPlayer){
		this.anzahlPlayer = anzahlPlayer;
	}
	public boolean isComputerModus(){
		if(this.anzahlPlayer == 1){
			startTime();
		}
		return false;
	}
	private void startTime() {
		// TODO Auto-generated method stub
		
	}

}
