package com.momoiropuchoman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashSet;
import java.util.Set;

class FieldDB extends DB {



	Set<Chara> getCharas(String fieldName, Mass[][] map) {
		Set<Chara> charas = new HashSet<Chara>();
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement("select * from charas where fieldID in (select ID from fields where name = ?)");
			preparedStatement.setString(1, fieldName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				charas.add(new Chara(map, new Position(resultSet.getInt("x"), resultSet.getInt("y")), resultSet.getInt("imageNo"), resultSet.getString("name")));
			} 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return charas;
	}

	Set<AroundSprite> getCharasAsAroundSprite(String fieldName, Mass[][] map) {
		Set<AroundSprite> aroundSprites = new HashSet<AroundSprite>();
		Connection connection = this.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement("select * from charas where fieldID in (select ID from fields where name = ?)");
			preparedStatement.setString(1, fieldName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				aroundSprites.add(new Chara(map, new Position(resultSet.getInt("x"), resultSet.getInt("y")), resultSet.getInt("imageNo"), resultSet.getString("name")));
			} 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aroundSprites;
	}
}
