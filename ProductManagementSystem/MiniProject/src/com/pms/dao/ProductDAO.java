package com.pms.dao;

import com.pms.util.*;
import com.pms.entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	Connection conn = DBUtil.getDBConnection();

	public int addProd(Product prod) {

		String insertQuery = "insert into Product values(?,?,?,?)";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);

			pstmt.setInt(1, prod.getPno());
			pstmt.setString(2, prod.getPname());
			pstmt.setDouble(3, prod.getPrice());
			pstmt.setString(4, prod.getDom());
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public int updateProd(Product prod) {

		String updateQuery = "update Product set pname =? , price =? ,dom=? where pno = ?";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);

			pstmt.setString(1, prod.getPname());
			pstmt.setDouble(2, prod.getPrice());
			pstmt.setInt(4, prod.getPno());
			pstmt.setString(3, prod.getDom());
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;

	}

	public Product getProdByNo(int prodNo) {

		String selectQuery = "select * from Product where pno = ?";

		Product prod = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);

			pstmt.setInt(1, prodNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int pno = rs.getInt("pno");
				String pname = rs.getString("pname");
				double price = rs.getDouble("price");
				String dom1 = rs.getString("dom");
				prod = new Product();
				prod.setPno(pno);
				prod.setPname(pname);
				prod.setPrice(price);
				prod.setDom(dom1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prod;
	}

	public int deleteProdByNo(int prodNo) {

		// delete from dept where dno = ?;

		String deleteQuery = "delete from Product where pno = ?";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);

			pstmt.setInt(1, prodNo);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;

	}

	public List<Product> getAll() {

		String selectAllQuery = "select * from Product";

		List<Product> list = new ArrayList<Product>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAllQuery);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int pno = rs.getInt("pno");
				String pname = rs.getString("pname");
				Double price = rs.getDouble("price");
				String dom = rs.getString("dom");
				Product prod = new Product();
				list.add(prod);

				prod.setPno(pno);
				prod.setPname(pname);
				prod.setPrice(price);
				prod.setDom(dom);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
