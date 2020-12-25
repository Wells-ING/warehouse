package cn.wellswang.factory;

import cn.wellswang.dao.*;
import cn.wellswang.dao.impl.*;

public class DAOFactory {
	public static ManagerInfoDAO getManagerInfoDAO() {
		return new ManagerInfoDAOImpl();
	}
	public static GoodsInfoDAO getGoodsInfoDAO() {
		return new GoodsInfoDAOImpl();
	}
	public static SupplierInfoDAO getSupplierInfoDAO() {
		return new SupplierInfoDAOImpl();
	}
	public static OrderInfoDAO getOrderInfoDAO() {
		return new OrderInfoDAOImpl();
	}
	public static RecordInfoDAO getRecordInfoDAO() {
		return new RecordInfoDAOImpl();
	}
	public static BadInfoDAO getBadInfoDAO() {
		return new BadInfoDAOImpl();
	}
}
