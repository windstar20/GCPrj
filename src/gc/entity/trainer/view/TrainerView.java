package gc.entity.trainer.view;

import java.util.Date;

import gc.entity.trainer.Trainer;

public class TrainerView extends Trainer{
	private String gymAdress;
	private int resCnt;
	private int cmtCnt;
	private String license;
	private String gName;
	
	public TrainerView() {
	
	}
	
	public TrainerView(int id, String name, String gymName, String gender, String phone, String delReason, int del,
			Date regdate,String gymAdress,int resCnt,int cmtCnt,String license,String gName) {
		super(id, name, gymName, gender, phone, delReason, del, regdate);

		this.gymAdress = gymAdress;
		this.resCnt = resCnt;
		this.cmtCnt = cmtCnt;
		this.license = license;
		this.gName = gName;
	}

	public TrainerView(String gymAdress, int resCnt, int cmtCnt, String license, String gName) {
		super();
		this.gymAdress = gymAdress;
		this.resCnt = resCnt;
		this.cmtCnt = cmtCnt;
		this.license = license;
		this.gName = gName;
	}

	@Override
	public String toString() {
		return "TrainerView [gymAdress=" + gymAdress + ", resCnt=" + resCnt + ", cmtCnt=" + cmtCnt + ", license="
				+ license + ", gName=" + gName + "]";
	}

	public String getGymAdress() {
		return gymAdress;
	}

	public void setGymAdress(String gymAdress) {
		this.gymAdress = gymAdress;
	}

	public int getResCnt() {
		return resCnt;
	}

	public void setResCnt(int resCnt) {
		this.resCnt = resCnt;
	}

	public int getCmtCnt() {
		return cmtCnt;
	}

	public void setCmtCnt(int cmtCnt) {
		this.cmtCnt = cmtCnt;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}
	
}
