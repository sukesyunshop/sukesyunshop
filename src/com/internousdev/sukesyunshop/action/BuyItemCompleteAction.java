package com.internousdev.sukesyunshop.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sukesyunshop.dao.BuyItemCompleteDAO;
import com.internousdev.sukesyunshop.dao.CartDAO;
import com.internousdev.sukesyunshop.dao.DestinationDAO;
import com.internousdev.sukesyunshop.dto.BuyItemDTO;
import com.internousdev.sukesyunshop.dto.CartDTO;
import com.internousdev.sukesyunshop.dto.DestinationDTO;
import com.internousdev.sukesyunshop.util.SessionName;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware {

	private String userId;
	private int productId;

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
	public List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
	private BuyItemCompleteDAO buyItemDAO = new BuyItemCompleteDAO();
	public ArrayList<CartDTO> cartDTO;

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
	 * ------------ 実行メソッド------------
	 */
	public String execute() throws SQLException {

		// 宛先情報の参照
		userId = session.get(SessionName.getUserId()).toString();
		String result = ERROR;
		destDAO.destSelect(userId);

		if (this.userId.equals(destDTO.getUserId())) {
			destDAO.destSelect(userId);

		} else {
			result = "lack";
		}

		// HTML側から送られてきた商品情報を登録用のDTO(List)へまとめ購入履歴テーブルへ情報を登録する処理
		CartDAO cartDAO = new CartDAO();
		ArrayList<CartDTO> cartList = cartDAO.getCartList(userId, true);
		int count = cartList.size();
		List<Integer> productIdList = new ArrayList<>();
		for (int i = 0; count > i; i++) {
			productIdList.add(cartList.get(i).getProductId());
		}
		buyItemDAO.itemInsert(productIdList, userId);

		// カート情報を登録した後カート情報を削除
		//削除
		cartDAO.deleteCart(userId, productId, true);
		return result;

	}


	public ArrayList<CartDTO> getCartList() {
		return cartDTO;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		this.cartDTO = cartList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
