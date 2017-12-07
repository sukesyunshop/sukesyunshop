package com.internousdev.sukesyunshop.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.BuyItemCompleteDAO;
import com.internousdev.sukesyunshop.dao.DestinationDAO;
import com.internousdev.sukesyunshop.dto.DestinationDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware {

	private String userId;
	private int itemId;

	public Map<String, Object> session;

	/**
	 * 商品情報DTO＆宛先情報DTOをインスタンス化
	 */
	private List<DestinationDTO> destDTOList = new ArrayList<DestinationDTO>();

	/**
	 * 商品情報DAO＆宛先情報DAOをインスタンス化
	 *
	 */
	private BuyItemCompleteDAO buyItemDAO = new BuyItemCompleteDAO();
	private DestinationDAO destDAO = new DestinationDAO();

	/**
	 * 登録されている宛先情報を参照する 宛先が登録されていない場合はRETURNの値は"lack"へ
	 *
	 * ↓↓次の処理内容へ
	 *
	 * カート情報を参照する 参照した情報を画面に表示
	 *
	 * ↓↓次の処理へ
	 *
	 * 購入完了画面へ遷移する時にカート情報を削除する処理
	 *
	 *
	 */
	public String execute() {
		/**
		 * 登録されている宛先情報を参照する 宛先が登録されていない場合はRETURNの値は"lack"へ遷移
		 */
		userId = session.get(SessionName.getUserId()).toString();
		String result = ERROR;
		destDTOList = destDAO.destSelect(userId);

		if (this.userId.equals(destDTOList.get(0).getUserId())) {
			destDTOList = destDAO.destSelect(userId);

			buyItemDAO.itemDelete(itemId);

			result = SUCCESS;
		} else {
			result = "lack";
		}

		return result;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
