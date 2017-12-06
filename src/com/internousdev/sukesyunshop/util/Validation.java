package com.internousdev.sukesyunshop.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	//空だったらtrue
	public boolean emptyValid(String target){
		if(target == null || target.equals("")){
			return true;
		}
		return false;
	}

	//以上以下の範囲外だった場合true
	public boolean overUnderValid(String target, int min, int max){
		if(target.length() < min || target.length() > max){
			return true;
		}
		return false;
	}


	//半角英数字でなかった場合true
	public boolean harfEngNumValied(String target){
		Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
		Matcher m = p.matcher(target);
		return !m.find();
	}

	//半角英数でなかった場合true
	public boolean harfEnglishValied(String target){
		Pattern p = Pattern.compile("^[a-zA-Z]*$");
		Matcher m = p.matcher(target);
		return !m.find();
	}

	//漢字でなかった場合true
	public boolean kanjiValid(String target){
		Pattern p = Pattern.compile("^[亜-龠]*$");
		Matcher m = p.matcher(target);
		return !m.find();
	}

	//ひらがなでなかった場合true
	public boolean hiraganaValid(String target){
		Pattern p = Pattern.compile("^[あ-んが-ぼぁ-ょゎっー]*$");
		Matcher m = p.matcher(target);
		return !m.find();
	}

	//カタカナでなかった場合true
	public boolean katakanaValid(String target){
		Pattern p = Pattern.compile("^[ア-ンガ-ボァ-ョヮッー]*$");
		Matcher m = p.matcher(target);
		return !m.find();
	}
}
