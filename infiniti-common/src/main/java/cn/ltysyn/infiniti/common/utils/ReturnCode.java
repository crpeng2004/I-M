package cn.ltysyn.infiniti.common.utils;

public enum ReturnCode {
	
	ARTIST_LIST_GOT(10001, "歌手列表获取成功"),
	ARTIST_INFO_GOT(10002, "歌手信息获取成功"),
	ALBUM_LIST_GOT(10003, "专辑列表获取成功"),
	ALBUM_INFO_GOT(10004, "专辑信息获取成功");
	
	private int code;
	
	private String message;
	
	private ReturnCode(int code, String message) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
