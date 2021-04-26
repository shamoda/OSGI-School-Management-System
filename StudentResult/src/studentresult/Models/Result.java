package studentresult.Models;

public class Result {
	
	private int stID;
	private int mk_DS;
	private int mk_SEPQM;
	private int AF;
	private int SA;
	
	
	public Result(int stID, int mk_DS, int mk_SEPQM, int aF, int sA) {
		super();
		this.stID = stID;
		this.mk_DS = mk_DS;
		this.mk_SEPQM = mk_SEPQM;
		AF = aF;
		SA = sA;
	}


	public int getStID() {
		return stID;
	}


	public void setStID(int stID) {
		this.stID = stID;
	}


	public int getMk_DS() {
		return mk_DS;
	}


	public void setMk_DS(int mk_DS) {
		this.mk_DS = mk_DS;
	}


	public int getMk_SEPQM() {
		return mk_SEPQM;
	}


	public void setMk_SEPQM(int mk_SEPQM) {
		this.mk_SEPQM = mk_SEPQM;
	}


	public int getAF() {
		return AF;
	}


	public void setAF(int aF) {
		AF = aF;
	}


	public int getSA() {
		return SA;
	}


	public void setSA(int sA) {
		SA = sA;
	}
	
	
		
		
	
	

}
