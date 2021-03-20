package cn.wellswang.dao;

import cn.wellswang.entity.Supplier;

import java.util.ArrayList;

public interface SupplierInfoDAO {
	// 增
	public int insertSupplierInfo(Supplier newSupplier);
	// 删
	public int deleteSupplierInfo(Supplier deleteSupplier);
	// 改
	public int updateSupplierInfo(Supplier oldSupplier, Supplier newSupplier);
	// 查询某个供应商
	public Supplier getSupplierById(Integer supplier_id);
	// 查询所有供应商
	public ArrayList<Supplier> getAll();
	// 根据供应商的名字查询到指定的编号
	public Integer getIdByName(String supplierName);


	String getNameById(Integer supplierId);

    ArrayList<Supplier> getSupplierByLike(String keyWords);

	Integer deleteSupplierById(Integer supplierId);

	Integer modifySupplierById(Integer supplierId, String supplierName);

}
