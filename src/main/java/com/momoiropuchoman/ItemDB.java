package com.momoiropuchoman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

class ItemDB extends DB {

	Item getItem(int itemID) {
		Item item = null;	
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement("select * from items where id = ?");
			preparedStatement.setInt(1, itemID);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			item = new Item(itemID, resultSet.getString("name"), resultSet.getInt("num"));
		} catch(NullPointerException e) {
			System.err.println("Not Found Item.");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement);
		}
		return item;
	}

	List<Item> getPlayerItems() {
		List<Item> items = new ArrayList<Item>();
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement("select * from playerItems order by ID asc");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				items.add(new Item(resultSet.getInt("ID"), resultSet.getString("name"), resultSet.getInt("num")));
			} 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return items;
		
	}

	List<Item> getShopItems(int shopID) {
		List<Item> items = new ArrayList<Item>();
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement("
				select * from items 
				where ID in 
				(select itemID from shopItems where shopID = ? order by itemID asc)
				");
			preparedStatement.setInt(1, shopID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				items.add(new Item(resultSet.getInt("ID"), resultSet.getString("name"), resultSet.getInt("num")));
			} 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
}
