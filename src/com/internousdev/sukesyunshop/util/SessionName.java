package com.internousdev.sukesyunshop.util;

public class SessionName {

	/*
	 *  使う場合にチームに報告しましょう。
	 *  このクラスに入れる例です。
	 *  private final static String EXAMPLE_STRING = "sessionで使う値";
	 */

	//ログイン中ならnull,ログインしてないならfalseを入れてください。
	private final static String LOGIN_FLAG = "loginFlag";
	//ログイン中ならuser_idを入れてください。ログインしてないならnull,空文字がはいっています。
	private final static String USER_ID = "userId";
	//ログイン中ならuser_idを入れてください。ログインしてないならnull,空文字がはいっています。
	private final static String TEMP_USER_ID = "tempUserId";
	//ログイン時保存するにcheckした場合trueが、してないならfalseが入ってます。
	private final static String SAVE_ID = "saveId";
	//ログイン中ならuser_idを入れてください。ログインしてないならnullがはいっています。
	private final static String USER_PASSWORD = "userPassword";

	private final static String Buying = "buying";

	private final static String TRUE = "true";
	private final static String FALSE = "false";

	/*
	 *以下にゲッターセッターをshift+alt+sからゲッターセッター入力みたいな項目から入れてください。
	 *なるべく変数順で。
	 */
	public static String getLoginFlag() {
		return LOGIN_FLAG;
	}
	public static String getUserId() {
		return USER_ID;
	}
	public static String getTempUserId() {
		return TEMP_USER_ID;
	}
	public static String getSaveId() {
		return SAVE_ID;
	}
	public static String getUserPassword() {
		return USER_PASSWORD;
	}


	public static String getBuying() {
		return Buying;
	}
	public static String getTrue() {
		return TRUE;
	}
	public static String getFalse() {
		return FALSE;
	}

}
