package com.internousdev.sukesyunshop.util;

public class SessionName {

	/*
	 *  使う場合にチームに報告しましょう。
	 *  このクラスに入れる例です。
	 *  private final static String EXAMPLE_STRING = "sessionで使う値";
	 */

	//ログイン中ならnull,ログインしてないならfalseを入れてください。
	private final static String LOGIN_FLAG = "loginFlag";
	//ログイン中ならuser_idを入れてください。ログインしてないならnullにしてください
	private final static String USER_ID = "userId";
	//ログイン時にUserInfoDTOを入れてます。
	private final static String LOGIN_USER_DTO = "loginUserDto";

	/*
	 *以下にゲッターセッターをshift+alt+sからゲッターセッター入力的なので入れてください。
	 *なるべく変数順で。
	 */
	public static String getLoginFlag() {
		return LOGIN_FLAG;
	}
	public static String getUserId() {
		return USER_ID;
	}
	public static String getLoginUserDto() {
		return LOGIN_USER_DTO;
	}

}
