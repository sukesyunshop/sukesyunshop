package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.BuyItemCompleteDAO;
import com.internousdev.sukesyunshop.dao.DestinationDAO;
import com.internousdev.sukesyunshop.dto.BuyItemDTO;
import com.internousdev.sukesyunshop.dto.DestinationDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware {

	/**
	 * 宛先情報
	 */

	private String userId;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String userAddress;

	public Map<String, Object> session;

	/**
	 * 商品情報DTO＆宛先情報DTOをインスタンス化
	 */
	private List<DestinationDTO> destDTOList = new ArrayList<DestinationDTO>();
	private List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	/**
	 * 商品情報DAO＆宛先情報DAOをインスタンス化
	 *
	 */
	private BuyItemCompleteDAO buyItemDAO = new BuyItemCompleteDAO();
	private DestinationDAO destDAO = new DestinationDAO();

	/**
	 * 登録されている宛先情報を参照する
	 *  宛先が登録されていない場合はRETURNの値は"lack"へ
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
		 * 登録されている宛先情報を参照する
		 * 宛先が登録されていない場合はRETURNの値は"lack"へ遷移
		 */
		userId = session.get(SessionName.getUserId()).toString();

		String result = ERROR;
		try {
			destDTOList = destDAO.destSelect(userId);
			if (this.userId.equals(destDTOList.get(0).getUserId())) {
				result = SUCCESS;

			} else if (!this.userId.equals(destDTOList.get(0).getUserId())) {
				//lackにエラーが出て、原因が分かりません。
				result = lack;

			} else {
				result = ERROR;

			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}



		/**
		 * カート情報を参照する
		 * 参照した情報を画面に表示
		 *
		 */

		try{
			//ここの書き方が分からない
			buyItemDTOList = buyItemDAO.itemSelect();

		}catch(SQLException e){
			e.printStackTrace();
		}

		/**
		 * 購入完了画面へ遷移する時にカート情報を削除する処理
		 */
		int itemId;

		try{
			//↓のような書き方でよかったのか？
			buyItemDTOList  = buyItemDAO.itemDelete(itemId);
			//この後の流れの書き方が分かりません。

		}catch(SQLException e){
			e.printStackTrace();

		}

	}

}
