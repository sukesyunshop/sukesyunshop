package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.BuyItemCompleteDAO;
import com.internousdev.sukesyunshop.dao.DestinationDAO;
import com.internousdev.sukesyunshop.dto.BuyItemDTO;
import com.internousdev.sukesyunshop.dto.DestinationDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware {

	private String userId;
	private int itemId;

	public Map<String, Object> session;

	/**
	 * 宛先情報DAO&宛先情報DTOをインスタンス化
	 */
	private DestinationDAO destDAO = new DestinationDAO();
	private DestinationDTO destDTO = new DestinationDTO();

	/**
	 * 商品購入完了DAO＆商品情報DTOをインスタンス化
	 *
	 */
	private BuyItemCompleteDAO buyItemDAO = new BuyItemCompleteDAO();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();


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
	 *------------ 実行メソッド------------*/
	public String execute() throws SQLException {
		userId = session.get(SessionName.getUserId()).toString();
		String result = ERROR;
		 destDAO.destSelect(userId);

		if (this.userId.equals(destDTO.getUserId())) {
			 destDAO.destSelect(userId);

			 //HTML側から送られてきた商品情報を登録用のDTOへまとめます。
			buyItemDTO = setItemPrameters(buyItemDTO);


			//登録処理
			int insertCount = buyItemDAO.itemInsert(buyItemDTO);

			//登録判定
			//0==>登録失敗
			//1==>登録成功

			if(insertCount !=0){
				result = SUCCESS;
				buyItemDAO.itemDelete(itemId);
			}else{
				result = ERROR;
			}
		} else {
			result = "lack";
		}

		return result;

	}

	private BuyItemDTO setItemPrameters(BuyItemDTO buyItemDTO){
		buyItemDTO.setUserId(userId);
		buyItemDTO.setItemId(itemId);
		return buyItemDTO;
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
