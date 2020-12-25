package cn.wellswang.dao;

import java.util.ArrayList;

import cn.wellswang.entity.Supplier;

public interface SupplierInfoDAO {
	// 增
		public int insertSupplierInfo(Supplier newSupplier);
		// 删
		public int deleteSupplierInfo(Supplier deleteSupplier);
		// 改
		public int updateSupplierInfo(Supplier oldSupplier, Supplier newSupplier);
		// 查
		public Supplier getSupplierById(Integer supplier_id);
		public ArrayList<Supplier> getAll();
}
